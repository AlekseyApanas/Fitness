package dto;

import userEnum.RoleUser;
import userEnum.Status;

public class UserDTO {
    private String mail;

    private String fio;

    private String password;

    private RoleUser role;

    private Status status;

    public UserDTO(String mail, String fio, String password, RoleUser role, Status status) {
        this.mail = mail;
        this.fio = fio;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public UserDTO() {
    }

    public String getMail() {
        return mail;
    }

    public String getFio() {
        return fio;
    }

    public String getPassword() {
        return password;
    }

    public RoleUser getRole() {
        return role;
    }

    public Status getStatus() {
        return status;
    }
}

