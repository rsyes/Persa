package modelo;
	import javax.swing.JFrame;
	import modelo.Logica;
	import vista.Gui;
	public class Faraday extends JFrame{
		Logica datos;
		Gui interfaz;
		public Faraday(){
			super("daruedar.com")
			datos= new Logica();
			Gui interfaz=new Gui();
			add(interfaz);
			setSize(350,250);
			setVisible(true);
		}
		public static void main(String[] args){
			Faraday app= new Faraday();
			app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
	}
