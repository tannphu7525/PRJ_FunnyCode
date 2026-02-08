/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.DBUtils;

/**
 *
 * @author admin
 */
public class UserDAO {
    ArrayList<UserDTO> list = new ArrayList<>();
    
    public UserDTO searchById(String id){
        try {
            Connection conn = DBUtils.getConnection();
            String sql = "SELECT * FROM tblUsers WHERE userID = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            UserDTO user = null;
            while (rs.next()) {                
                String userID = rs.getString("userID");
                String fullName = rs.getString("fullName");
                String password = rs.getString("password");
                String roleID = rs.getString("roleID");
                String status = rs.getString("status");
                
                user = new UserDTO(userID, fullName, password, roleID, status);
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public UserDTO login(String username, String password){
        UserDTO user = searchById(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
