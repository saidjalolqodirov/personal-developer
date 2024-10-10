package com.example.dynamicfilter;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.attach.ITagWorker;
import com.itextpdf.html2pdf.attach.ProcessorContext;
import com.itextpdf.html2pdf.attach.impl.DefaultTagWorkerFactory;
import com.itextpdf.html2pdf.attach.impl.tags.SpanTagWorker;
import com.itextpdf.html2pdf.css.apply.ICssApplier;
import com.itextpdf.html2pdf.css.apply.impl.BlockCssApplier;
import com.itextpdf.html2pdf.css.apply.impl.DefaultCssApplierFactory;
import com.itextpdf.styledxmlparser.node.IElementNode;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class PdfController {

    @GetMapping("/test")
    public void test() throws FileNotFoundException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("iTextHelloWorld.pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Chunk chunk = new Chunk("Hello World", font);

        document.add(chunk);
        document.close();
    }

    @GetMapping("/generate")
    public void generate(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTiltle.setSize(20);
        Paragraph paragraph1 = new Paragraph("List of the Students", fontTiltle);
        paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(paragraph1);
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setWidths(new int[]{3, 3, 3, 3});
        table.setSpacingBefore(5);
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(CMYKColor.BLUE);
        cell.setPadding(5);
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(CMYKColor.WHITE);
        cell.setPhrase(new Phrase("ID", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Student Name", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Email", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Mobile No", font));
        table.addCell(cell);

        table.addCell(String.valueOf(123));
        table.addCell("student.getStudentName()");
        table.addCell("student.getEmail()");
        table.addCell("student.getMobileNo()");

        document.add(table);
        document.close();
    }

    @GetMapping("/generate_pdf")
    public void generatePdf(HttpServletResponse response) throws IOException, DocumentException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        Font fontTittle1 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTittle1.setSize(16);
        Paragraph paragraph1 = new Paragraph("O‘ZBЕKISTON RЕSPUBLIKASI PRЕZIDЕNTI HUZURIDAGI  IJTIMOIY HIMOYA MILLIY AGЕNTLIGI 65-BOSH TIEK\n", fontTittle1);
        paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(paragraph1);

        Font fontTittle2 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTittle2.setSize(16);
        fontTittle2.setColor(BaseColor.BLUE);
        Paragraph paragraph2 = new Paragraph("\nNOGIRONLIK TO'GRISIDAGI MA'LUMOTNOMA № 1052232\n", fontTittle2);
        paragraph2.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(paragraph2);

        Font fontTittle3 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        Paragraph paragraph3 = new Paragraph("F.I.SH:                   ", fontTittle3);
        paragraph3.add("ASDF ASDF ASDF");
        paragraph3.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(paragraph3);

        document.close();
    }

    @GetMapping("/html_pdf")
    public void htmlCss() throws IOException {
        String str = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>Page Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>This is a Heading</h1>\n" +
                "<p>This is a paragraph.</p>\n" +
                "</body>\n" +
                "</html>";

        renderPdf(str);
    }

    public void renderPdf(String htmlText) throws IOException {
        java.io.File f = new java.io.File("conclusion" + ".pdf");
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setTagWorkerFactory(
                new DefaultTagWorkerFactory() {
                    @Override
                    public ITagWorker getCustomTagWorker(
                            IElementNode tag, ProcessorContext context) {
                        if ("path".equalsIgnoreCase(tag.name())) {
                            return new SpanTagWorker(tag, context);
                        }
                        if ("g".equalsIgnoreCase(tag.name())) {
                            return new SpanTagWorker(tag, context);
                        }
                        return null;
                    }
                });
        converterProperties.setCssApplierFactory(
                new DefaultCssApplierFactory() {
                    @Override
                    public ICssApplier getCustomCssApplier(IElementNode tag) {
                        if (tag.name().equals("g")) {
                            return new BlockCssApplier();
                        }
                        if (tag.name().equals("path")) {
                            return new BlockCssApplier();
                        }
                        return null;
                    }
                }
        );

        HtmlConverter.convertToPdf(htmlText, new FileOutputStream(f), converterProperties);
    }
}
