package sample;

import sample.pojo.Apartments;
import sample.pojo.Home;
import sample.pojo.House;

import java.io.File;
import java.io.PrintStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connectionn {
    private static final String url = "jdbc:mysql://localhost:3306/Apartment";
    private static final String user = "root";
    private static final String password = "12345678";
    private static java.sql.Connection con;
    private static Statement stmt;
    private static ResultSet rs;
public Connectionn(){
    try {
        // opening database connection to MySQL server
        con = DriverManager.getConnection(url, user, password);

        // getting Statement object to execute query
        stmt = con.createStatement();
    } catch (SQLException sqlEx) {
        sqlEx.printStackTrace();
    }

        // executing SELECT query
}
   public   void OutInfo (){

       try {


           String queryy = "select id, name, street , price, square, photo, floor, color, cityCentre  from apart";
           rs = stmt.executeQuery(queryy);

           while (rs.next()) {
               int id = rs.getInt(1);
               String name = rs.getString(2);
               String street = rs.getString(3);
               Double price= rs.getDouble(4);
               System.out.printf("id" + id +  "name: " + name + " street : " +  street + " price: " + price + "%n");
           }
           String queryy1 = "select id, name, street , price, square, photo, floor, onCity, squareAroundHouse   from house";
           rs = stmt.executeQuery(queryy1);

           while (rs.next()) {
               int id = rs.getInt(1);
               String name = rs.getString(2);
               String street = rs.getString(3);
               Double price= rs.getDouble(4);
               System.out.printf("id" + id +  "name: " + name + " street : " +  street + " price: " + price + "%n");
           }


       } catch (SQLException sqlEx) {
           sqlEx.printStackTrace();
       }

   }

   public  void close(){

           try { con.close(); } catch(SQLException se) { /*can't do anything */ }
           try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
           try { rs.close(); } catch(SQLException se) { /*can't do anything */ }

   }

   public void addtoProgramm(){

       try {
           String queryy = "select id, name, street , price, square, photo, floor, color, cityCentre  from apart";

           rs = stmt.executeQuery(queryy);

           while (rs.next()) {
               listfortovar.prdd.add(new Apartments(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4), rs.getDouble(5), rs.getString(6), rs.getInt(7),rs.getString(8), rs.getBoolean(9)));
              }


           String queryy1 = "select id, name, street , price, square, photo, floor, onCity, squareAroundHouse   from house";

           rs = stmt.executeQuery(queryy1);

           while (rs.next()) {
               listfortovar.prdp.add(new House(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4), rs.getDouble(5), rs.getString(6), rs.getInt(7),rs.getBoolean(8), rs.getDouble(9)));
           }
           System.out.println(listfortovar.prdp.size());
       } catch (SQLException sqlEx) {
           sqlEx.printStackTrace();
       }

   }



}
