package dto;

import userEnum.RoleUser;
import userEnum.Status;

import java.time.LocalDateTime;
import java.util.UUID;

public class SaveUserDTO {
    private UUID uuid;

    private LocalDateTime dtCreate;

    private LocalDateTime dtUpdate;

    private String mail;

    private String fio;

    private RoleUser role;

    private Status status;

    public SaveUserDTO(UUID uuid, LocalDateTime dtCreate, LocalDateTime dtUpdate, String mail, String fio, RoleUser role, Status status) {
        this.uuid = uuid;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.mail = mail;
        this.fio = fio;
        this.role = role;
        this.status = status;
    }

    public SaveUserDTO() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    public String getMail() {
        return mail;
    }

    public String getFio() {
        return fio;
    }

    public RoleUser getRole() {
        return role;
    }

    public Status getStatus() {
        return status;
    }
}
