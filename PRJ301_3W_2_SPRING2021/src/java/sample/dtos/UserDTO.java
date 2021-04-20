package sample.dtos;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private String userID;
    private String fullName;
    private String roleID;
    private String password;

    public UserDTO(String userID, String fullName, String roleID, String password) {
        this.userID = userID;
        this.fullName = fullName;
        this.roleID = roleID;
        this.password = password;
    }

    public UserDTO() {
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getRoleID() {
        return roleID;
    }

    public String getPassword() {
        return password;
    }

}
