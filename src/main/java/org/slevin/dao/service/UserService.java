package org.slevin.dao.service;

import org.slevin.common.User;
import org.slevin.dao.UsersDao;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
public class UserService extends EntityService<User> implements UsersDao {

}
