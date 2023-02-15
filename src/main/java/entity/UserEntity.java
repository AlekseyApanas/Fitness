package entity;

import org.hibernate.annotations.GenericGenerator;
import userEnum.RoleUser;
import userEnum.Status;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "")
public class UserEntity {
    @Id
    private UUID uuid;

    private String mail;

    private String fio;

    private String password;

    private LocalDateTime dtCreate;

    private LocalDateTime dtUpdate;

    private RoleUser role;

    private Status status;

    public UserEntity() {
    }

    public UserEntity(UUID uuid, String mail, String fio, String password, LocalDateTime dtCreate, LocalDateTime dtUpdate, RoleUser role, Status status) {
        this.uuid = uuid;
        this.mail = mail;
        this.fio = fio;
        this.password = password;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.role = role;
        this.status = status;
    }
}