import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManager {


    private String[] fileName;
    private String[] fileContent;
    private String[] query;
    private int[][] nOcorrencias;
    private static int DEFAULT_SIZE = 5;


    public String[] getFileName() {
        return fileName;
    }

    public String[] getFileContent() {
        return fileContent;
    }



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
                //Retira da query
                String aux = tratamentoString(text.getText());
                query = aux.split(" ");
                //printQuery(query);
            }
        });

    }

    private String tratamentoString(String s){
        String aux;
        aux = s.replaceAll("[0-9,.!?#$%&/()=\\-_\n]","");
        return aux;
    }



    public String[] readFiles(String directoryName) throws EmptyDirectoryException, NotFoundDirectory, IOException {

        File directory = new File(directoryName);

        if (!directory.exists()) {
            throw new NotFoundDirectory();
        } else {
            File[] filesList = directory.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String filename) {
                    return filename.endsWith(".txt");
                }
            });


            //Caso a pasta esteja vazia
            if (filesList.length == 0) {
                throw new EmptyDirectoryException();
            }


            fileContent = new String[filesList.length];
            fileName = new String[filesList.length];


            //Cria um vetor apenas com o nome dos ficheiros
            for (int i = 0; i < filesList.length; i++) {
                fileName[i] = filesList[i].getName();
            }


            //Adiciona o conteudo dos ficheiros a um vetor de string
            for (int i = 0; i < fileName.length; i++) {
                String aux = "";
                aux = ReadFile(fileName[i]);
                aux = tratamentoString(aux);
                fileContent[i] = aux;
            }
            return this.fileContent;
        }
    }

    public void printStrings(String[] fileCont, String[] filesnames){
        for(int i = 0; i<fileCont.length; i++){
                System.out.print(fileCont[i]);
            System.out.println("\n");
        }

        for(int j = 0; j<filesnames.length; j++){
            System.out.print(filesnames[j]);
            System.out.println("\n");
        }

    }

    public void printQuery(String[] query){
        for(int i = 0; i<query.length; i++){
            System.out.print(query[i]);
            System.out.println("\n");
        }
    }


    public static String ReadFile(String filename) throws IOException{
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




    }

