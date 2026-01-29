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
public class UniversityDAO {
    
    public UniversityDAO(){
    }
    
    public ArrayList<UniversityDTO> searchByColum(String column, String value){
        ArrayList<UniversityDTO> list = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            String sql = "SELECT * FROM tblUniversity WHERE " + column + "=?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, value);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                String id = rs.getString("id");
                String name = rs.getString("name");
                String shortName = rs.getString("shortName");
                String description = rs.getString("description");
                int foundedYear = rs.getInt("foundedYear");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String region = rs.getString("region");
                String type = rs.getString("type");
                int totalStudents = rs.getInt("totalStudents");
                int totalFaculties = rs.getInt("totalFaculties");
                boolean isDraft = rs.getBoolean("isDraft");
                
                UniversityDTO user = new UniversityDTO(id, name, shortName, description, foundedYear, 
                        address, city, region, type, totalStudents, totalFaculties, isDraft);
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<UniversityDTO> filterByColum(String column, String value){
        ArrayList<UniversityDTO> list = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            String sql = "SELECT * FROM tblUniversity WHERE " + column + " LIKE ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, "%" + value + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                String id = rs.getString("id");
                String name = rs.getString("name");
                String shortName = rs.getString("shortName");
                String description = rs.getString("description");
                int foundedYear = rs.getInt("foundedYear");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String region = rs.getString("region");
                String type = rs.getString("type");
                int totalStudents = rs.getInt("totalStudents");
                int totalFaculties = rs.getInt("totalFaculties");
                boolean isDraft = rs.getBoolean("isDraft");
                
                UniversityDTO user = new UniversityDTO(id, name, shortName, description, foundedYear, 
                        address, city, region, type, totalStudents, totalFaculties, isDraft);
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<UniversityDTO> searchById(String id){
        return searchByColum("id", id);
    }
    
    public ArrayList<UniversityDTO> filterByName(String name){
        return filterByColum("name", name);
    }
    
        public ArrayList<UniversityDTO> searchByName(String name){
        return searchByColum("name", name);
    }
}
