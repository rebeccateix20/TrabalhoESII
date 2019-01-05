import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        //myGUIForm gui = new myGUIForm();

        /*
        FileManager fm = new FileManager();
        String file = fm.Reader("ola.txt");
        String  newStr= file.replaceAll("[0-9,.!?\\-_\n,\\s]","");
        fm.Writer(newStr, "newfile.txt");
        */

        String newString;
        Scanner entrada = new Scanner(System.in);
        System.out.println("String: ");
        newString = entrada.next();
        System.out.println(newString);
        String stringFinal = newString.replaceAll("[0-9,.!?#$%&/()=\\-_\n,\\s]","");

        System.out.println(stringFinal);

    }
}
