/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata4.view;

/**
 *
 * @author Eduardo
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.LinkedList;
import kata4.model.Mail;

public class MailListReaderBD {
    
    private final List<Mail> listaCorreos = new LinkedList<>();
    
    public List<Mail> read(){
        String sql = "SELECT * FROM EMAIL";
        try  (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){
             while(rs.next()){
                if(rs.getString("direccion").contains("@")){
                    listaCorreos.add(new Mail(rs.getString("direccion")));
                }
             }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return listaCorreos;
    }

    private Connection connect(){
        String url = "jdbc:sqlite:KATA5.db";
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public void list(){
        String sqlView = "SELECT * FROM EMAIL";
        try (Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlView)){
            int i = 0;
            while (rs.next()) {
                System.out.println(rs.getString("direccion"));
                i++;
            }   
            System.out.println("Nยบ de direcciones introducidas en la base de datos: " + i);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}