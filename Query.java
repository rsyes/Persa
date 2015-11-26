package modelo;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**Sirve para ejecutar las Query que debemos implementar*/
public class Query {
	private static BaseDeDatos base;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection c = null;
	    java.sql.Statement stmt = null;
	    base= new BaseDeDatos();
	    ResultSet rs=null;
	    
	    try {
	    	c=base.conectarA("Tony.db");
			stmt = c.createStatement();
			
			String sql = "CREATE TABLE Precios " +
	                   "(ID INT PRIMARY KEY     NOT NULL," +
	                   " NAME           TEXT    NOT NULL, " + 
	                   //" AGE            INT     NOT NULL, " + 
	                   //" ADDRESS        CHAR(50), " + 
	                   " Price         REAL)"; 
			
			String sql2 = "INSERT INTO Precios (ID,NAME,Price) " +
	                   "VALUES (1, 'Zanahoria',  3.50 );"; 
	      
			
			//stmt.executeUpdate(sql);//Una vez creada las tablas no debo crear mas
			//stmt.executeUpdate(sql2);// sentencia insert
			  
			/*Recuperando Informacion de  una tabla*/
				rs = stmt.executeQuery( "SELECT * FROM Precios;" );
				while ( rs.next() ) {
		         int id = rs.getInt("id");
		         String  name = rs.getString("name");
		         //int age  = rs.getInt("age");
		         //String  address = rs.getString("address");
		         double Price = rs.getFloat("Price");
		         System.out.println( "ID = " + id );
		         System.out.println( "NAME = " + name );
		         //System.out.println( "AGE = " + age );
		         //System.out.println( "ADDRESS = " + address );
		         System.out.println( "Price = " + Price );
		         System.out.println();
		      }
			/*Finalizacion del proceso de extraer la informacion de una Tabla*/	
		      
		      
		      stmt.close();
		      c.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
