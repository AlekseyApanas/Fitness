package dao.api;


import entity.UserEntity;

import java.util.List;
import java.util.UUID;

public interface IUserDao {
//исправить на entity
    List<UserEntity> getUserList();

    boolean isContain(long id);

    void delete(UserEntity userEntity);

    void create(UserEntity userEntity);

    void update(UserEntity userEntity);
    UserEntity get(UUID id);
}
