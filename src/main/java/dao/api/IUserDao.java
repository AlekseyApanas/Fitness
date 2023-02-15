package dao.api;


import entity.UserEntity;

import java.util.List;

public interface IUserDao {
//исправить на entity
    List<UserEntity> getUserList();

    boolean isContain(long id);

    void delete(UserEntity userEntity);

    void create(UserEntity userEntity);

    void update(UserEntity userEntity);
    UserEntity get(long id);
}
