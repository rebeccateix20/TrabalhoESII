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
    private int[][] matrizM;
    private int contaDocs;
    private static int DEFAULT_SIZE = 5;


    public String[] getFileName() {
        return fileName;
    }

    public String[] getFileContent() {
        return fileContent;
    }


    public FileManager() {
        JFrame frame = new JFrame("File Reader");
        JLabel label = new JLabel("Pesquisa");
        JButton button = new JButton("Pesquisar");
        JTextField text = new JTextField();

        frame.setSize(200, 200);
        frame.setLayout(null);
        button.setBounds(50, 50, 100, 50);
        label.setSize(100, 50);
        text.setBounds(60, 10, 100, 25);
        frame.add(label);
        frame.add(text);
        frame.add(button);
        frame.setLocation(500, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Retira da query
                if (text.getText().compareTo("") == 0) {
                    JOptionPane.showMessageDialog(null, "Termo Invalido");
                } else {
                    String aux = tratamentoString(text.getText());
                    query = aux.split(" ");
                    matrizM();
                    matrizQ();
                    UpdateMatrizM(matrizM());
                    UpdateMatrizQ(matrizQ());
                }
                //printQuery(query);
            }
        });

    }

    private String tratamentoString(String s) {
        String aux;
        aux = s.replaceAll("[0-9,.!?#$%&/()=\\-_\n]", "");
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

    /**
     * Método de criação da Matriz M
     *
     * @return matrizM
     */
    public int[][] matrizM() {
        matrizM = new int[fileName.length][fileContent.length];
        String[] aux;
        int count = 0, h;

        for (int i = 0; i < fileName.length; i++) {
            aux = fileContent[i].split(" ");
            for (int j = 0; j < query.length; j++) {
                count = 0;
                h = 0;
                while (h < aux.length) {
                    if (query[j].compareTo(aux[h]) == 0) {
                        count++;
                    }

                    h++;
                }
                matrizM[i][j] = count;
            }
        }

        return matrizM;
    }

    public int[] matrizQ() {
        int count, h;
        int[] matrizQ = new int[fileContent.length];
        String[] queryAux = query;
        //System.out.println("FCL: " + fileContent.length);
        for (int i = 0; i < fileContent.length; i++) {
            count = 0;
            h = 0;
            while (h < queryAux.length) {
                if (fileContent[i].compareTo(queryAux[h]) == 0) {
                    count++;
                }
                h++;
            }
            matrizQ[i] = count;
        }
        //printQuery(matrizQ);
        return matrizQ;
    }

    public double[][] UpdateMatrizM(int[][] matriz) {
        double[][] matrizOut = new double[fileName.length][fileContent.length];
        for (int i = 0; i < fileName.length; i++) {
            for (int j = 0; j < fileContent.length; j++) {
                contaDocs = 0;
                for (int h = 0; h < fileName.length; h++) {
                    if (matrizM[h][j] > 0) contaDocs++;
                }
                if (contaDocs == 0) {
                    matrizOut[i][j] = 0;
                } else {
                    matrizOut[i][j] = matriz[i][j] * (1 + Math.log10((fileName.length / contaDocs)));
                }
            }
        }

        return matrizOut;

    }


    public double[] UpdateMatrizQ(int[] matriz) {

        double[] matrizOut = new double[fileContent.length];
        for (int i = 0; i < fileContent.length; i++) {

            //System.out.println("I = " + i);
            //printMatriz(matrizM);
            for (int h = 0; h < fileName.length; h++) {
                if (matrizM[h][i] > 0) contaDocs++;
                    //System.out.println("Conta Docs: " + contaDocs);}
            }
            //System.out.println("CONTA FOC: " + contaDocs);
            if (contaDocs == 0) {
                matrizOut[i] = 0;
            } else {
                //System.out.println("CONTA FOC: " + contaDocs);
                //System.out.println("FILENAMELENGHT " + fileName.length );
                matrizOut[i] = matriz[i] * (1 + Math.log10((fileName.length / contaDocs)));
                //System.out.println("MO[i] " + matrizOut[i]);
            }
            //System.out.println("FILECONTENT: " + fileContent.length);
        }
        //printQuery(matrizOut);
        return matrizOut;
    }

    public void printStrings(String[] fileCont, String[] filesnames) {
        for (int i = 0; i < fileCont.length; i++) {
            System.out.print(fileCont[i]);
            System.out.println("\n");
        }

        for (int j = 0; j < filesnames.length; j++) {
            System.out.print(filesnames[j]);
            System.out.println("\n");
        }

    }

    public void printMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("Valor: " + matriz[i][j]);
            }
        }
    }

    public void printQuery(double[] query) {
        for (int i = 0; i < query.length; i++) {
            System.out.println("Valor: " + query[i]);
        }
    }

    public static String ReadFile(String filename) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return contentBuilder.toString();
    }


}

