package com.stylefeng.guns.modular.appapi;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.core.base.bean.JsonResult;
import com.stylefeng.guns.core.base.controller.BaseApiController;
import com.stylefeng.guns.modular.contacts.service.IContactsService;
import com.stylefeng.guns.modular.system.model.Contacts;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author haiyangp
 * date:  2018/4/28
 * desc:
 */
@RestController
@RequestMapping(value = "/api/contacts")
@Api("联系人")
public class ContactsApiController extends BaseApiController {

    @Autowired
    private IContactsService contactsService;

    @ApiOperation("待导入联系人列表")
    @GetMapping(value = "imporstList")
    public JsonResult importList() {
        Contacts contacts = new Contacts();
        Wrapper<Contacts> contactsWrapper = new EntityWrapper<>(contacts);
        List<Contacts> contactsList = contactsService.selectList(contactsWrapper);
        return JsonResult.ok(contactsList);
    }

}
