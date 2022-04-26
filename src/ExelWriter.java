import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ExelWriter {

    //Spalten der Tabelle bestimmen

    private String [] columns = {"Name", "Email", "Geburtstag", "Gehalt"}; //Spalten
    private List<Employee> employees = new ArrayList<>(); //Arraylist für Mitarbeiter

    public void createEmployee(){
        Calendar date = Calendar.getInstance(); //Das Datum erhalten
        date.set(1992, 7, 21); //datum Setzen
        employees.add(new Employee("Christian Müller", "christian@mail.com", date.getTime(), 1243.23)); //Mitarbeiter erzeugen
        date.set(1992, 7, 21);
        employees.add(new Employee("Christian Müller", "christian@mail.com", date.getTime(), 1243.23));
        date.set(1992, 7, 21);
        employees.add(new Employee("Christian Müller", "christian@mail.com", date.getTime(), 1243.23));
        date.set(1992, 7, 21);
        employees.add(new Employee("Christian Müller", "christian@mail.com", date.getTime(), 1243.23));

    }

    public void createFile(String filePath) throws IOException {
        //Exel Datei erstellen
        //HSSFWorkbook Klasse für .xls Exel Dateien
        // XssFWorkbook für .xlsx Exel Datei
        Workbook workbook = new XSSFWorkbook(); //Für xlsx Endung

        //Formatierungen für uns machen...
        CreationHelper creationHelper = workbook.getCreationHelper(); //Dient unserer Formatierung.hilft uns

        Sheet sheet = workbook.createSheet("Angestellte"); //Erste Tabelle in der Excel-Datei erstellen, die Angestellte heist

        Font headerFont = workbook.createFont(); //headerFont für die Spaltenbezeichnungen
        headerFont.setFontHeight((short)16); //Grösse
        headerFont.setColor(IndexedColors.BLACK.getIndex()); //Farbe
        headerFont.setBold(true); //Fett

        CellStyle headerCellStyle = workbook.createCellStyle(); //CellStyle ist eben das Kästchenstly in Verbindung mit dem woorkbook
        headerCellStyle.setFont(headerFont); //das font gesetzt für die Spaltenbezeichnungen gesetzt

        //Zeile/Reihe erstellen
        Row headerRow = sheet.createRow(0); //Die erste Zeile erstellt, dort wo die jeweiligen Spaltenzeichnungen sein werden

        //Durch iteriert, für alles... Kästchen Inhalt erstelllen - Hier die SPaltenüberschriften
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        //Kästchen Style fpr das Datum erstellen
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("dd-mm-yyyy"));

        //Angestellete in Tabelle schreiben
        int rowNum =1; //1 Weil es soll bei der 2 Zeile anfangen
        for (Employee employee: employees) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(employee.getName()); //Erstes Kästchen für Name
            row.createCell(1).setCellValue(employee.getEmail()); //Zweites Kästchen für Email etc...

            //Datum
            Cell dateOfBirthCell = row.createCell(2);
            dateOfBirthCell.setCellValue(employee.getDateofBirtH()); //dAtum selbst
            dateOfBirthCell.setCellStyle(dateCellStyle); //Style vom Datum feslegen

            row.createCell(3).setCellValue(employee.getSalary()); //Gehalt
        }

        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        //Datei schreiben / erstellen
        File file = new File(filePath);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);

        fileOutputStream.close();
        workbook.close();
    }
}
