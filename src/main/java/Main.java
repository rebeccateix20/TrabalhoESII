import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, EmptyDirectoryException, NotFoundDirectory {

        FileManager file = new FileManager();
        final String dir = System.getProperty("user.dir");
        file.readFiles(dir);
        file.printStrings(file.getFileContent(), file.getFileName());


    }
}
