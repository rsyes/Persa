package controller;
	//http://api.itextpdf.com/itext/
	import java.io.File;
	import java.io.FileOutputStream;
	import com.itextpdf.text.Document;
	import com.itextpdf.text.DocumentException;
	import com.itextpdf.text.Paragraph;
	import com.itextpdf.text.pdf.PdfWriter;

	public class Alo  {
		public static void main(String[] args) throws Exception{
			Document document = new Document();//PASO 1 CREAR EL DOCUMENTO
			ByteArrayOutputStream baos= new ByteArrayOutputStream();
			PdfWriter.getInstance(document, baos);//Obtener una instancia de PdfWriter
			document.open();//Abrir el documento
			document.add(new Paragraph("Hello World!isdjfojsdfkhjsdihisdf"));//Agregar el contenido
			document.close();//Cerrar el documento
			FileOutputStream fos = new FileOutputStream( new File("Salida.pdf") );
			fos.write(baos.toByteArray());
			fos.close();
		}
	}
