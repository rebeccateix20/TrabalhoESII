import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        //myGUIForm gui = new myGUIForm();
        FileManager fm = new FileManager();
        String file = fm.Reader("ola.txt");
        String  newStr= file.replaceAll("[,.!?\\-_\n,\\s]","");
        fm.Writer(newStr, "newfile.txt");
    }
}
