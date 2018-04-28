/**
 * contacts管理初始化
 */
var Contacts = {
    id: "ContactsTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Contacts.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '自增ID', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '手机号', field: 'phone', visible: true, align: 'center', valign: 'middle'},
            {title: '姓名', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '性别', field: 'gender', visible: true, align: 'center', valign: 'middle'},
            {title: '是否删除', field: 'isDelete', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'crtTime', visible: true, align: 'center', valign: 'middle'},
            {title: '修改时间', field: 'uptTime', visible: true, align: 'center', valign: 'middle'},
            {title: '备注', field: 'note', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Contacts.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Contacts.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加contacts
 */
Contacts.openAddContacts = function () {
    var index = layer.open({
        type: 2,
        title: '添加contacts',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/contacts/contacts_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看contacts详情
 */
Contacts.openContactsDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: 'contacts详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/contacts/contacts_update/' + Contacts.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除contacts
 */
Contacts.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/contacts/delete", function (data) {
            Feng.success("删除成功!");
            Contacts.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("contactsId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询contacts列表
 */
Contacts.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Contacts.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Contacts.initColumn();
    var table = new BSTable(Contacts.id, "/contacts/list", defaultColunms);
    table.setPaginationType("client");
    Contacts.table = table.init();
});
