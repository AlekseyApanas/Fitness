package dao;

import dao.api.IUserDao;
import dao.orm.api.IManager;
import entity.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import java.util.List;
import java.util.UUID;

public class UserDAO implements IUserDao {
    private IManager manager;

    public UserDAO(IManager manager) {
        this.manager = manager;
    }

    public List<UserEntity> getUserList() {
        EntityManager entityManager = null;
        List<UserEntity> resultList;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();
            resultList = entityManager.createQuery("from GenreEntity", UserEntity.class).getResultList();
            entityManager.getTransaction().commit();

        } catch (RuntimeException e) {
            throw new RuntimeException("DataBase error", e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return resultList;
    }

    public boolean isContain(long id) {
        boolean result = false;
        EntityManager entityManager = null;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();
            UserEntity userEntity = entityManager.find(UserEntity.class, id);
            entityManager.getTransaction().commit();

            if (userEntity != null) {
                result = true;
            }

        } catch (RuntimeException e) {
            throw new RuntimeException("DataBase error", e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }

        return result;
    }

    public void delete(UserEntity userEntity) {
        UUID id = userEntity.getUuid();
        EntityManager entityManager = null;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();
            userEntity = entityManager.find(UserEntity.class, id, LockModeType.OPTIMISTIC);
            if (userEntity != null) {
                entityManager.remove(userEntity);
                entityManager.getTransaction().commit();
            } else {
                entityManager.getTransaction().commit();
                throw new NullPointerException("Delete is not possible. The singer wasn't found in the database");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("DataBase error", e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void create(UserEntity userEntity) {
        EntityManager entityManager = null;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(userEntity);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            throw new RuntimeException("DataBase error", e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }

    }

    public void update(UserEntity userEntity) {
        UUID id = userEntity.getUuid();
        EntityManager entityManager = null;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();

            UserEntity genreEntityDB = entityManager.find(UserEntity.class, id, LockModeType.OPTIMISTIC);

            if (genreEntityDB != null) {
                entityManager.merge(userEntity);
                entityManager.getTransaction().commit();
            } else {
                entityManager.getTransaction().commit();
                throw new NullPointerException("Update is not possible. The genre wasn't found in the database");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("DataBase error", e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public UserEntity get(UUID uuid) {
        EntityManager entityManager = null;
        UserEntity userEntity;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();
            userEntity = entityManager.find(UserEntity.class, uuid);
            entityManager.getTransaction().commit();

            if (userEntity == null) {
                throw new NullPointerException("The genre wasn't found in the database");
            }

        } catch (RuntimeException e) {
            throw new RuntimeException("DataBase error", e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return userEntity;
    }
}