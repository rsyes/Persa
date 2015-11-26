package modelo;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

/**Sirve para ejecutar las Query que debemos implementar*/
public class Query {
	
	private static BaseDeDatos base;
	Connection c;
	java.sql.Statement stmt;
	DefaultListModel modeloNombres;
	ResultSet rs;
	
	static JList lista;
	
	public Query(){
		c=null;
		stmt=null;
		base= new BaseDeDatos();
		
		rs=null;
		modeloNombres= new DefaultListModel();
		//modeloNombres=getModeloNombres();
		lista= new JList(getModeloNombres());
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame ventana= new JFrame("Lida");
		Query app= new Query();
		ventana.add(lista);
		//app.crearTablaPrecios();
		//app.getModeloNombres();
		
		ventana.setSize(290,110);
		ventana.setVisible(true);
		lista= new JList();
		//ventana.add(new JPanel().add(lista));
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
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
			  
			//Recuperando Informacion de  una tabla
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
			//Finalizacion del proceso de extraer la informacion de una Tabla	
		      
		      
		      stmt.close();
		      c.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
	}
	
	public void crearTablaPrecios(){
		try{
				c=base.conectarA("TonyK6.db");
				stmt = c.createStatement();
				String sql = "CREATE TABLE Precios " +
                   "(Id INTEGER PRIMARY KEY  ," +
                   " Nombre           TEXT    NOT NULL, " + 
                   //" AGE            INT     NOT NULL, " + 
                   //" ADDRESS        CHAR(50), " + 
                   " Precio         REAL)"; 
				String sql2 = "INSERT INTO Precios " +
                   "VALUES (null,'Zanahoria',  3.50 );"; 
				stmt.executeUpdate(sql2);
				//stmt.executeUpdate("select * from sqlite_master");
				//rs=stmt.executeUpdate("select  sqlite_master");
				//rs = stmt.executeQuery( "select * from sqlite_master" );
				for(int i=0;i<150;i++){
					stmt.executeUpdate(sql2);
				}
				stmt.close();
				c.close();
				
			}
		catch(SQLException e){
				e.printStackTrace();
			}
	}
	
	public  DefaultListModel getModeloNombres(){
		try	{
				c=base.conectarA("TonyK6.db");
				stmt = c.createStatement();
				
				
				rs = stmt.executeQuery( "SELECT * FROM Precios;" );
				while(rs.next())
					{
						String  nombre = rs.getString("Nombre");
						//System.out.print(nombre+"\t\t\t");
						//int id = rs.getInt("id");
						//System.out.println(id);
						modeloNombres.addElement(nombre);
					}
				stmt.close();
				c.close();
			}
		catch(SQLException e){
				e.printStackTrace();
			}
		return modeloNombres;
	}
		
	
	

}

