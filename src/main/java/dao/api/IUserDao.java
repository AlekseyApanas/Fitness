package dao.api;


import entity.UserEntity;

import java.util.List;
import java.util.UUID;

public interface IUserDao {

    List<UserEntity> getUserList();

    boolean isContain(UUID uuid);

    void create(UserEntity userEntity);

    void update(UserEntity userEntity);

    UserEntity get(UUID uuid);
}
