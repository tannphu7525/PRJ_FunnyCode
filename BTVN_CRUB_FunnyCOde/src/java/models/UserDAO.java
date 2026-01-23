/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author admin
 */
public class UserDAO {

    //CRUD
    //1 - Read
    public List<UserDTO> getAllUser() {
        List<UserDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[User]";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                UserDTO user = new UserDTO(
                        rs.getInt("ID"),
                        rs.getString("FullName"),
                        rs.getBoolean("Gender"),
                        rs.getDate("DOB"),
                        rs.getString("Email"),
                        rs.getString("Phone"));
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //2 - Create
    
    
    
    //Helper for update
    public UserDTO getUserById(int id) {
        String sql = "SELECT * FROM [dbo].[User] WHERE ID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return new UserDTO(
                        rs.getInt("ID"),
                        rs.getString("FullName"),
                        rs.getBoolean("Gender"),
                        rs.getDate("DOB"),
                        rs.getString("Email"),
                        rs.getString("Phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;        
    }

    
    
    public boolean updateUser(UserDTO user) {
        String sql = "UPDATE [dbo].[User]\n" +
                    "   SET [FullName] = ?\n" +
                    "      ,[Gender] = ?\n" +
                    "      ,[DOB] = ?\n" +
                    "      ,[Email] = ?\n" +
                    "      ,[Phone] = ?\n" +
                    " WHERE ID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, user.getFullName());
            stm.setBoolean(2, user.isGender());
            stm.setDate(3, user.getDOB());
            stm.setString(4, user.getEmail());
            stm.setString(5, user.getPhone());
            stm.setInt(6, user.getId());
            return stm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    
    //4- Delete
    public boolean deleteUserById(int id) {
        String sql = "SELECT * FROM [dbo].[User] WHERE ID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, id);
            return stm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
