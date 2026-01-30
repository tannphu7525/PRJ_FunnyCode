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

        public UserDTO searchByUsername(String username){
            try {
                Connection conn = DBUtils.getConnection();
                String sql = "SELECT * FROM [dbo].[Users] WHERE username = ?";
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setString(1, username);
                ResultSet rs = stm.executeQuery();  
                while (rs.next()) {                
                    int id = rs.getInt("id");
                    String user = rs.getString("username");
                    String password = rs.getString("password");
                    UserDTO user_rs = new UserDTO(id, user, password);

                    list.add(user_rs);
                    return user_rs;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        public UserDTO login(String username, String password){
            UserDTO user = searchByUsername(username);
            if (user != null && password.equals(user.getPassword())) {
                return user;
            }
            return null;
        }
    }
