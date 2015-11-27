package controller;

	import java.io.File;
	import java.io.FileOutputStream;
	import com.itextpdf.text.Document;
	import com.itextpdf.text.DocumentException;
	import com.itextpdf.text.Paragraph;
	import com.itextpdf.text.pdf.PdfWriter;

	public class Alo  {
		public static void main(String[] args) throws Exception{
			Document document = new Document();
			ByteArrayOutputStream baos= new ByteArrayOutputStream();
			PdfWriter.getInstance(document, baos);
			document.open();
			document.add(new Paragraph("Hello World!isdjfojsdfkhjsdihisdf"));
			document.close();
			FileOutputStream fos = new FileOutputStream( new File("Salida.pdf") );
			fos.write(baos.toByteArray());
			fos.close();
		}
	}
