package objeto;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import model.ProdutoBD;

public class GerarPDF {
	public static void geraPdf(){
		ArrayList<Produto> produtoList = ProdutoBD.listarProdutos();
		
		 Document document = new Document(PageSize.A4, 36, 36, 36, 36);
	     try {	        
	         PdfWriter.getInstance(document, new FileOutputStream("C:\\Projetos\\Pdf\\arquivo.pdf"));
	         document.open();
	         document.addTitle("Lista de Produtos");
	         document.addSubject("Cosméticos");
	         document.addAuthor("Roberto Júnior");
	         document.addCreator("Perfumadinho Cosméticos");
	         
	         Image imagem = Image.getInstance(String.format("C:\\Projetos\\PCosmeticos\\WebContent\\img\\logo_completa.png"));
	         imagem.scaleToFit(180,180);	         
	         document.add(imagem);	         
	         Chunk linebreak = new Chunk(new LineSeparator());
	         document.add(linebreak);
	         
	         document.add(new Paragraph(" "));
	         document.add(new Paragraph("Lista de Produtos",FontFactory.getFont(FontFactory.HELVETICA,16,Font.BOLD)));
	         document.add(new Paragraph(" "));
	         
	         PdfPTable table = new PdfPTable(4);
	         
	         PdfPCell c1 = new PdfPCell(new Phrase("Código"));
	         c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	         table.addCell(c1);
	         c1 = new PdfPCell(new Phrase("Descrição"));
	         c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	         table.addCell(c1);
	         c1 = new PdfPCell(new Phrase("Quantidade"));
	         c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	         table.addCell(c1);
	         c1 = new PdfPCell(new Phrase("Preço"));
	         c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	         table.addCell(c1);
			
	         table.setHeaderRows(1);
	 
	         for(Produto aux:produtoList){
	        	 table.addCell(aux.getCodigo());
	        	 table.addCell(aux.getDescricao());
	        	 table.addCell(aux.getQtd());
	        	 table.addCell(aux.getPreco());
	         }
	         
	         document.add(table);	         
	         
	     }
	     catch(DocumentException de) {
	         System.err.println(de.getMessage());
	     }
	     catch(IOException ioe) {
	         System.err.println(ioe.getMessage());
	     }
	     document.close();
	}
}