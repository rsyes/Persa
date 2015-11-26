package modelo;
	import java.beans.Statement;
	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import javax.swing.DefaultListModel;
	import javax.swing.JFrame;
	import javax.swing.JList;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	/**Sirve para ejecutar las Query que debemos implementar*/
	public class Query {
			private static BaseDeDatos base;
			Connection c;
			java.sql.Statement stmt;
			DefaultListModel modeloNombres,modeloPrecios;
			ResultSet rs;
			String nameDataBase;
			static JList lista;
			public Query(){
					nameDataBase="TonyK6.db";
					c=null;
					stmt=null;
					base= new BaseDeDatos();
					rs=null;
					modeloNombres= new DefaultListModel();
					modeloPrecios= new DefaultListModel();
					lista= new JList(getModeloPrecios());	
				}
			public static void main(String[] args) {
					JFrame ventana= new JFrame("Lida");
					Query app= new Query();
					//app.showTabla();
					app.editarInsumo("Papaya", 490.0);
					app.showTabla();
					ventana.add(lista);
					
					ventana.setSize(290,110);
					ventana.setVisible(true);
					lista= new JList();
					ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			public void crearTablaPrecios(){
					try{
						c=base.conectarA(nameDataBase);
						stmt = c.createStatement();
						String sql = "CREATE TABLE Precios " +
						"(Id INTEGER PRIMARY KEY  ," +
						" Nombre           TEXT    NOT NULL, " + 
						" Precio         REAL)"; 
						stmt.executeUpdate(sql);
						stmt.close();
						c.close();	
					}
					catch(SQLException e){
							e.printStackTrace();
						}
				}
			public  DefaultListModel getModeloNombres(){
					try	{
							c=base.conectarA(nameDataBase);
							stmt = c.createStatement();
							rs = stmt.executeQuery( "SELECT * FROM Precios;" );
							while(rs.next())
								{
									String  nombre = rs.getString("Nombre");
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
			public  DefaultListModel getModeloPrecios(){
					try	{
							c=base.conectarA(nameDataBase);
							stmt = c.createStatement();
							rs = stmt.executeQuery( "SELECT * FROM Precios;" );
							while(rs.next())
								{
									Double precio=rs.getDouble("Precio");
									modeloPrecios.addElement(precio);
								}
							stmt.close();
							c.close();
						}
					catch(SQLException e){
							e.printStackTrace();
						}
					return modeloPrecios;
				}
			public void addInsumo(String nombre, double precio){
					try{
							c=base.conectarA(nameDataBase);
							stmt = c.createStatement();
							String sql2 = "INSERT INTO Precios " +
							"VALUES (null,'" +nombre+  "',"  +precio+ ");"; 
							stmt.executeUpdate(sql2);
							modeloNombres.addElement(nombre);
							modeloPrecios.addElement(precio);
							stmt.close();
							c.close();
						}
					catch(SQLException g){
							g.printStackTrace();
						}
				}
			public void showTabla(){
				try{	c=base.conectarA(nameDataBase);
						stmt = c.createStatement();
						rs = stmt.executeQuery( "SELECT * FROM Precios;" );
							while(rs.next()){
									String  nombre = rs.getString("Nombre");
									int id= rs.getInt("Id");
									double precio= rs.getFloat("Precio");
									System.out.print(id+"\t"+nombre+"\t"+precio+"\n");
								}
						stmt.close();
						c.close();
				}
				catch(SQLException g){
						g.printStackTrace();
					}
			}
			public void editarInsumo(String nombre, double precio){
				
					try{
					c=base.conectarA(nameDataBase);
					stmt = c.createStatement();
					
					rs = stmt.executeQuery( "SELECT * FROM Precios;" );
					while(rs.next()){
							String  nombrex = rs.getString("Nombre");
							if(nombrex.equals(nombre)){
								
								String query2="UPDATE Precios SET Precio="+precio +" WHERE Nombre='"+nombre+"'";
								stmt.executeUpdate(query2);
								System.out.println("esta hecho");
							}
					
						}
					stmt.close();
					c.close();
				}
					catch(SQLException g){
					g.printStackTrace();
				}
				}
		}
			
