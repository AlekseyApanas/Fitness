package dto;

public class UserLogInDTO {
    private String mail;
    private String password;

    public UserLogInDTO(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public UserLogInDTO() {
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }
}
