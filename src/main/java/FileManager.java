import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public FileManager(){
        JFrame frame = new JFrame("File Reader");
        JLabel label = new JLabel("Pesquisa");
        JButton button = new JButton("Pesquisar");
        JTextField text = new JTextField();

        frame.setSize(200,200);
        frame.setLayout(null);
        button.setBounds(50,50,100,50);
        label.setSize(100,50);
        text.setBounds(60,10,100,25);
        frame.add(label);
        frame.add(text);
        frame.add(button);
        frame.setLocation(500,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String stringFinal = text.getText().replaceAll("[0-9,.!?#$%&/()=\\-_\n,\\s]","");
                System.out.println(stringFinal);
            }
        });

    }

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
