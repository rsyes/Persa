package controller;
	import javax.swing.JFrame;
	import modelo.Logica;
	import vista.Gui;
	public class Faraday extends JFrame{
			Logica datos;
			Gui interfaz;
			private static Faraday instance= new Faraday();
			private Faraday(){
					super("daruedar.com");
					datos= new Logica();
					interfaz=new Gui();
					add(interfaz);
					setSize(350,250);
					setVisible(true);
				}
			public static void main(String[] args){
					Faraday app=null;
					app.getInstance().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			public static Faraday getInstance() {
				return instance;
			}
		}
