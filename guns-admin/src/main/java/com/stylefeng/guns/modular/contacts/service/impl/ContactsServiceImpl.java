package com.stylefeng.guns.modular.contacts.service.impl;

import com.stylefeng.guns.modular.system.model.Contacts;
import com.stylefeng.guns.modular.system.dao.ContactsMapper;
import com.stylefeng.guns.modular.contacts.service.IContactsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 联系人 服务实现类
 * </p>
 *
 * @author stylefeng123
 * @since 2018-04-28
 */
@Service
public class ContactsServiceImpl extends ServiceImpl<ContactsMapper, Contacts> implements IContactsService {

}
