import org.apache.poi.ss.usermodel.*;
//Die obigen Importe sind von apache, die Helfen mir Excell tabellen zu lesene etc...

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExelReader {
    private Workbook workbook; //Excel Datei repräsentieren
    private Sheet sheet; //Repräsentiert die Tabelle in Exel
    private Row row; //Repräsentiert eine Zeile in der Tabelle
    private Cell cell; //Zelle in der Tabelle, ein Kästchen

    private FileInputStream fileInputStream;

    public void openFile(String filePath) throws IOException {
        File file = new File(filePath);
        fileInputStream = new FileInputStream(file);

        // Excel Datei lesen / erstellen
        workbook = WorkbookFactory.create(fileInputStream);


        // Tabelle laden - Tabellename eingeben
        //sheet = workbook.getSheet("Tabelle1");
        sheet = workbook.getSheetAt(0);

        int lastRowNum = sheet.getLastRowNum();
        System.out.println(lastRowNum); //Keine 4, sondern, 3 weil, 0,1,2,3

        for (int i = 0; i <= lastRowNum ; i++) {
            System.out.print(sheet.getRow(i).getCell(0));
            System.out.print(sheet.getRow(i).getCell(1));
            System.out.print(sheet.getRow(i).getCell(2));
            System.out.println();
        }

        fileInputStream.close();
        workbook.close();

    }

}
