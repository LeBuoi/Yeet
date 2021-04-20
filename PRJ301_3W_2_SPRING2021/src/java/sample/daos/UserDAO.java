package sample.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.dtos.UserDTO;
import sample.utils.DBUtils;

public class UserDAO {

    public UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "Select userID, fullName, roleID "
                        + "FROM tblUser "
                        + "Where userID=\'" + userID + "' AND password=\'" + password + "'";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    user = new UserDTO(userID, fullName, roleID, "");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return user;
    }

    public List<UserDTO> getListUser(String search) throws SQLException {
        List<UserDTO> listUser = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "Select userID, fullName, roleID "
                        + "from tblUser "
                        + "WHERE fullName like ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("UserID");
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    String password = "***";
                    if (listUser == null) {
                        listUser = new ArrayList<>();
                    }
                    listUser.add(new UserDTO(userID, fullName, roleID, password));

                }
            }

        } catch (ClassNotFoundException | SQLException e) {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return listUser;
    }

    public boolean delete(String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "DELETE tblUser where userID='" + userID + "'";
                stm = conn.prepareStatement(sql);
                check = stm.executeUpdate() == 0 ? false : true;
            }
        } catch (Exception e) {

        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                stm.close();
            }
        }

        return check;
    }

    public boolean update(UserDTO user) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "update tblUser set fullName=? , roleID=? where userID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, user.getFullName());
                stm.setString(2, user.getRoleID());
                stm.setString(3, user.getUserID());
                check = stm.executeUpdate() == 0 ? false : true;
            }

        } catch (Exception e) {

        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }

        return check;
    }
    
    public boolean checkDuplicate(String userID) throws SQLException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!= null){
                String sql ="SELECT userID"
                        + "FROM tblUser"
                        + "WHERE userID = ?";
                stm=conn.prepareStatement(sql);
                stm.setString(1, userID);
                rs= stm.executeQuery();
                if(rs.next()){
                    check = true;
                }
            }
        } catch (Exception e) {
        }finally{
            if(stm!= null) stm.close();
            if(rs!= null) rs.close();
            if(conn!= null) conn.close();
        }
        return check;
    } 
    
   public void insert(UserDTO user) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblUser(userID, fullName, roleID, password) "
                        + " VALUES(?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, user.getUserID());
                stm.setString(2, user.getFullName());
                stm.setString(3, user.getRoleID());
                stm.setString(4, user.getPassword());
                stm.executeUpdate();

            }
        } catch (Exception e) {

        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
