package task2;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;
import java.util.HashMap;

public class Converter {
    HashMap<Integer, String> files = new HashMap<>();

    void pdfToFile(File pdfFile) {
        try {
            PDFParser parser = new PDFParser(new RandomAccessFile(pdfFile, "r"));
            parser.parse();
            COSDocument cosDoc = parser.getDocument();
            PDFTextStripper pdfTextStripper = new PDFTextStripper();

            PDDocument pdDocument = new PDDocument(cosDoc);
            String parsedText = pdfTextStripper.getText(pdDocument);

            File newFile=new File(pdfFile.getPath()+pdfFile.getName().substring(0,pdfFile.getName().indexOf("."))+".txt");
            System.out.println(pdfFile.getParent()+"/"+pdfFile.getName().substring(0,pdfFile.getName().indexOf("."))+".txt");

            PrintWriter pw = new PrintWriter(newFile.getPath());
            //PrintWriter pw = new PrintWriter(folderPath+file.getName().substring(0,file.getName().indexOf('.')));
            pw.print(parsedText.toLowerCase());


            files.put(files.size() + 1, newFile.getName());
            System.out.println(files.values());

            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
