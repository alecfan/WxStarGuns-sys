/**
 * 初始化contacts详情对话框
 */
var ContactsInfoDlg = {
    contactsInfoData : {}
};

/**
 * 清除数据
 */
ContactsInfoDlg.clearData = function() {
    this.contactsInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ContactsInfoDlg.set = function(key, val) {
    this.contactsInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ContactsInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ContactsInfoDlg.close = function() {
    parent.layer.close(window.parent.Contacts.layerIndex);
}

/**
 * 收集数据
 */
ContactsInfoDlg.collectData = function() {
    this
    .set('id')
    .set('phone')
    .set('name')
    .set('gender')
    .set('isDelete')
    .set('crtTime')
    .set('uptTime')
    .set('note');
}

/**
 * 提交添加
 */
ContactsInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/contacts/add", function(data){
        Feng.success("添加成功!");
        window.parent.Contacts.table.refresh();
        ContactsInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.contactsInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ContactsInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/contacts/update", function(data){
        Feng.success("修改成功!");
        window.parent.Contacts.table.refresh();
        ContactsInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.contactsInfoData);
    ajax.start();
}

$(function() {

});
