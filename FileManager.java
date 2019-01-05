import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManager {


    private String[] files;
    private static int DEFAULT_SIZE = 5;

    /* LEITURA SIMPLES DE FICHEIRO COM ESPAÇOS
    public FileManager() {
        files = new String[DEFAULT_SIZE];
    }

    public FileManager(int files_size){
        files = new String[files_size];
    }

    public String readFile(String filePath) throws IOException {

        String file = "";

        file = new String(Files.readAllBytes(Paths.get(filePath)));

        return file;
    }
*/

    public static String Reader(String filename) throws IOException{
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename)))
        {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
        return contentBuilder.toString();
    }


    public static Boolean Writer(String str, String filename)throws FileNotFoundException{
        try (PrintWriter out = new PrintWriter(filename)) {
            out.println(str);
        return true;}

    }
}
