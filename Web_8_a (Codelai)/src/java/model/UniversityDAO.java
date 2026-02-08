/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ResultTreeType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.naming.spi.DirStateFactory;
import model.UniversityDTO;
import utils.DBUtils;

/**
 *
 * @author admin
 */
public class UniversityDAO {

    public ArrayList<UniversityDTO> searchByColum(String column, String value) {
        ArrayList<UniversityDTO> list = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            String sql = "SELECT * FROM tblUniversity WHERE " + column + " = ?";
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

    public ArrayList<UniversityDTO> filterByColum(String column, String value) {
        ArrayList<UniversityDTO> list = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            String sql = "SELECT * FROM tblUniversity WHERE status = 1 AND " + column + " LIKE ?";
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

    public UniversityDTO searchById(String id) {
        ArrayList<UniversityDTO> list = searchByColum("id", id);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public ArrayList<UniversityDTO> filterByName(String name) {
        return filterByColum("name", name);
    }

    public ArrayList<UniversityDTO> searchByName(String name) {
        return searchByColum("name", name);
    }

    // Xóa
    public boolean softDelete(String id) {
        int result = 0;
        try {
            Connection conn = DBUtils.getConnection();
            String sql = "UPDATE [dbo].[tblUniversity]\n"
                    + "   SET [status] = 0\n"
                    + " WHERE id = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, id);
            result = stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result > 0;
    }

    public boolean add(UniversityDTO u) {
        int result = 0;
        try {
            Connection conn = DBUtils.getConnection();
            String sql = "INSERT INTO [dbo].[tblUniversity]\n"
                    + "    ([id]\n"
                    + "    ,[name]\n"
                    + "    ,[shortName]\n"
                    + "    ,[description]\n"
                    + "    ,[foundedYear]\n"
                    + "    ,[address]\n"
                    + "    ,[city]\n"
                    + "    ,[region]\n"
                    + "    ,[type]\n"
                    + "    ,[totalStudents]\n"
                    + "    ,[totalFaculties]\n"
                    + "    ,[isDraft]\n"
                    + "    ,[status])\n"
                    + "VALUES \n"
                    + "    (?\n"
                    + "    ,?\n"
                    + "    ,?\n"
                    + "    ,?\n"
                    + "    ,?\n"
                    + "    ,?\n"
                    + "    ,?\n"
                    + "    ,?\n"
                    + "    ,?\n"
                    + "    ,?\n"
                    + "    ,?\n"
                    + "    ,?\n"
                    + "    ,?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, u.getId());
            stm.setString(2, u.getName());
            stm.setString(3, u.getShortName());
            stm.setString(4, u.getDescription());
            stm.setInt(5, u.getFoundedYear());
            stm.setString(6, u.getAddress());
            stm.setString(7, u.getCity());
            stm.setString(8, u.getRegion());
            stm.setString(9, u.getType());
            stm.setInt(10, u.getTotalStudents());
            stm.setInt(11, u.getTotalFaculties());
            stm.setBoolean(12, u.isIsDraft());
            stm.setInt(13, 1); // status = 1 (active)
            result = stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result > 0;
    }

    public UniversityDTO getUniversityById(String id) {
        UniversityDTO check = null;
        try {
            Connection conn = DBUtils.getConnection();
            String sql = "SELECT * FROM tblUniversity WHERE id = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                return new UniversityDTO(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("shortName"),
                        rs.getString("description"),
                        rs.getInt("foundedYear"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("region"),
                        rs.getString("type"),
                        rs.getInt("totalStudents"),
                        rs.getInt("totalFaculties"),
                        rs.getBoolean("isDraft")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    //Update
    // Khong can cap nhat id 
    public boolean updateUniversity(UniversityDTO u) {
        int result = 0;
        try {
            Connection conn = DBUtils.getConnection();
            String sql = "UPDATE [dbo].[tblUniversity]\n"
                    + "   SET [name] = ?\n"
                    + "      ,[shortName] = ?\n"
                    + "      ,[description] = ?\n"
                    + "      ,[foundedYear] = ?\n"
                    + "      ,[address] = ?\n"
                    + "      ,[city] = ?\n"
                    + "      ,[region] = ?\n"
                    + "      ,[type] = ?\n"
                    + "      ,[totalStudents] = ?\n"
                    + "      ,[totalFaculties] = ?\n"
                    + "      ,[isDraft] = ?\n"
                    + "      ,[status] = ?\n"
                    + " WHERE id = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, u.getName());
            stm.setString(2, u.getShortName());
            stm.setString(3, u.getDescription());
            stm.setInt(4, u.getFoundedYear());
            stm.setString(5, u.getAddress());
            stm.setString(6, u.getCity());
            stm.setString(7, u.getRegion());
            stm.setString(8, u.getType());
            stm.setInt(9, u.getTotalStudents());
            stm.setInt(10, u.getTotalFaculties());
            stm.setBoolean(11, u.isIsDraft());
            stm.setInt(12, 1);
            stm.setString(13, u.getId());
            result = stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result > 0;
    }
}
