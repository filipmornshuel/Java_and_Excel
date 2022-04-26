import java.io.IOException;

public class Main {
    public static void main(String[] args) {

       /* ExelReader exelReader = new ExelReader();

        try {
            exelReader.openFile("C:\\Users\\filip\\Desktop\\test.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }

        */

        ExelWriter exelWriter = new ExelWriter();
        exelWriter.createEmployee();
        try {
            exelWriter.createFile("C:\\Users\\filip\\Desktop\\Angestellten_Liste.xlsx");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
