package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.DefaultListModel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.text.View;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Alo implements ActionListener {
	public static void main(String[] args) throws Exception{
		Document document = new Document();
		ByteArrayOutputStream baos
		= new ByteArrayOutputStream();
		PdfWriter.getInstance(document, baos);
		document.open();
		document.add(new Paragraph("Hello World!isdjfojsdfkhjsdihisdf"));
		document.close();

		FileOutputStream fos = new FileOutputStream( new File("Salida.pdf") );
		fos.write(baos.toByteArray());
		fos.close();
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
