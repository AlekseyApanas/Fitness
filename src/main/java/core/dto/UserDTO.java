package core.dto;

import userEnum.RoleUser;
import userEnum.Status;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(mail, userDTO.mail) && Objects.equals(fio, userDTO.fio) && Objects.equals(password, userDTO.password) && role == userDTO.role && status == userDTO.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail, fio, password, role, status);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "mail='" + mail + '\'' +
                ", fio='" + fio + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", status=" + status +
                '}';
    }
}

