package controller;
	import java.util.ArrayList;
	import javax.swing.DefaultListModel;
	import javax.swing.JFrame;
	import javax.swing.ListModel;
	import modelo.Logica;
	import modelo.Query;
	import vista.Gui;
	public class Faraday extends JFrame{		
			Gui interfaz=new Gui();
			Logica datos= new Logica();
			private static Faraday instance;
			/**Constructor Principal*/
			private Faraday(){
					super("daruedar.com");
					interfaz=new Gui();
					add(interfaz);
					ArrayList<String> t=Query.getNombres();
					ArrayList<Double> u=Query.getPrecios();
					ArrayList<String> v=Query.getPlatos();
					for(String s:t){
						interfaz.addtoModelNombres(s);
						}
					for(Double d:u){
						interfaz.addtoModelPrecios(d);
						}
						//for(String s:v){
						//interfaz.addtoModelPlatos(s);
						//}
					setSize(350,250);
					setVisible(true);
				}
			public Gui getInterfaz() {
					return interfaz;
				}
			public static void main(String[] args){
					Faraday app=Faraday.getInstance();
					app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			public static Faraday getInstance() {
					if(instance==null){instance= new Faraday();}
					return instance;
				}
			public void tome(ArrayList<String> nombres) {
				for(String s:nombres){
					
				}
			}
		
		}
