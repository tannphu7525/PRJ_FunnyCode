/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Student;

/**
 *
 * @author admin
 */
public class StudentDAO extends DBContext{
    // DAO: Data Access Object
    private final String GET_ALL_STUDENT = "SELECT * FROM Student";
    private final String GET_ALL_STUDENT_BY_ID = "SELECT * FROM Student WHERE studentID = ?";
    private final String REMOVE_STUDENT_BY_ID_SQL = "DELETE FROM [dbo].[Student]\n" +
            "                                           WHERE studentID = ?";
    
    private final String UPDATE_STUDENT_BY_ID = "UPDATE [dbo].[Student]\n" +
                                                "   SET [firstName] = ?\n" +
                                                "      ,[lastName] = ?\n" +
                                                "      ,[dateOfBirth] = ?\n" +
                                                "      ,[gender] = ?\n" +
                                                "      ,[schoolID] = ?\n" +
                                                " WHERE studentID = ?";
            
    private final String  ADD_STUDENT = "INSERT INTO [dbo].[Student]\n" +
                                        "           ([firstName]\n" +
                                        "           ,[lastName]\n" +
                                        "           ,[dateOfBirth]\n" +
                                        "           ,[gender]\n" +
                                        "           ,[schoolID])\n" +
                                        "     VALUES\n" +
                                        "           ?\n" +
                                        "           ,?\n" +
                                        "           ,?\n" +
                                        "           ,?\n" +
                                        "           ,?";      
            
    public Student getStudentById(String studentId){
        try {
            PreparedStatement stm = c.prepareStatement(GET_ALL_STUDENT_BY_ID);
            stm.setString(1, studentId);
            ResultSet rs = stm.executeQuery(); //Sau khi chay xong tra ve 1 cai bang
            
            if (rs.next()) {                
                Student std = new Student(rs.getString("studentId"),
                                          rs.getString("firstName"),
                                          rs.getString("lastName"),
                                          rs.getString("dateOfBirth"),
                                          rs.getString("gender"),
                                          rs.getString("schoolID"));
                return std;
            }
        } catch (Exception e) { 
            e.printStackTrace();
        }
        return null;
    }         
    
     // Get All Thoong tin trong bang Student 
    public List<Student> getAllStudent(){
            List<Student> listRes = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(GET_ALL_STUDENT);
            ResultSet rs = stm.executeQuery(); //Sau khi chay xong tra ve 1 cai bang
            
            while (rs.next()) {                
                listRes.add(new Student(
                        String.valueOf(rs.getString("studentID")),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("dateOfBirth"),
                        rs.getString("gender"),
                        rs.getString("schoolID")
                ));
            }           
        } catch (Exception e) { 
            e.printStackTrace();
        }
        return listRes;
    }
    
    public boolean removeStudentById(String studentId){
        try {
            PreparedStatement stm = c.prepareStatement(REMOVE_STUDENT_BY_ID_SQL);
            stm.setString(1, studentId);
            int n = stm.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
        }
        return false;
    }
    
//    private Date parseDate(String date){
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        
//    }
    
    
    public void addNewStudent(Student student){
        try {
            PreparedStatement stm = c.prepareStatement(ADD_STUDENT);
            Date date = Date.valueOf(student.getDateOfBirth());            
            
            stm.setString(1, student.getStudentID());
            stm.setString(2, student.getFirstName());
            stm.setString(3, student.getLastName());
            stm.setDate(4, date);
            stm.setString(5, student.getGender());
            stm.setString(5, student.getSchoolID());
            stm.executeUpdate();                     
        } catch (Exception e) { 
        }
    }
    
    public void updateNewStudent(Student newStudent){
        try {
            PreparedStatement stm = c.prepareStatement(UPDATE_STUDENT_BY_ID);
            stm.setString(1, newStudent.getStudentID());
            stm.setString(2, newStudent.getFirstName());
            stm.setString(3, newStudent.getLastName());
            stm.setString(4, newStudent.getDateOfBirth());
            stm.setString(5, newStudent.getGender());
            stm.setString(5, newStudent.getSchoolID());
            stm.executeUpdate();                     
        } catch (Exception e) { 
        }
    }            
    
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        dao.removeStudentById("1");
        for (Student std : dao.getAllStudent()) {
            System.out.println(std.toString());
        }
    }
}
