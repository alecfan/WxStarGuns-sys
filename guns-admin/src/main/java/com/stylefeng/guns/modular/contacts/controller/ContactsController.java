package com.stylefeng.guns.modular.contacts.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.Contacts;
import com.stylefeng.guns.modular.contacts.service.IContactsService;

/**
 * contacts控制器
 *
 * @author fengshuonan
 * @Date 2018-04-28 22:22:15
 */
@Controller
@RequestMapping("/contacts")
public class ContactsController extends BaseController {

    private String PREFIX = "/contacts/contacts/";

    @Autowired
    private IContactsService contactsService;

    /**
     * 跳转到contacts首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "contacts.html";
    }

    /**
     * 跳转到添加contacts
     */
    @RequestMapping("/contacts_add")
    public String contactsAdd() {
        return PREFIX + "contacts_add.html";
    }

    /**
     * 跳转到修改contacts
     */
    @RequestMapping("/contacts_update/{contactsId}")
    public String contactsUpdate(@PathVariable Integer contactsId, Model model) {
        Contacts contacts = contactsService.selectById(contactsId);
        model.addAttribute("item",contacts);
        LogObjectHolder.me().set(contacts);
        return PREFIX + "contacts_edit.html";
    }

    /**
     * 获取contacts列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return contactsService.selectList(null);
    }

    /**
     * 新增contacts
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Contacts contacts) {
        contactsService.insert(contacts);
        return SUCCESS_TIP;
    }

    /**
     * 删除contacts
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer contactsId) {
        contactsService.deleteById(contactsId);
        return SUCCESS_TIP;
    }

    /**
     * 修改contacts
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Contacts contacts) {
        contactsService.updateById(contacts);
        return SUCCESS_TIP;
    }

    /**
     * contacts详情
     */
    @RequestMapping(value = "/detail/{contactsId}")
    @ResponseBody
    public Object detail(@PathVariable("contactsId") Integer contactsId) {
        return contactsService.selectById(contactsId);
    }
}
