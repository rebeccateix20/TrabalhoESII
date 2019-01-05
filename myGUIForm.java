import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myGUIForm extends JFrame{

    /*
    private JButton button;
    private JTextField fileSearch;
    private JTextField newFileName;
    private JFrame frame;

    public myGUIForm() {

        //Cria janela
        frame = new JFrame("Files");

        //Cria Botão
        button = new JButton("GO");
        button.setBackground(Color.CYAN);
        button.setBounds(0,300,700,40);

        //Definir textboxes
        fileSearch.setEditable(true);
        newFileName.setEditable(true);
        newFileName.setBounds(0,300,700,60);
        fileSearch.setBounds(0,300,700,60);

        //Definir janela
        frame.setLayout(null); //Passo a definir eu o tamanho da janela
        frame.add(button);
        frame.add(fileSearch);
        frame.add(newFileName);
        frame.setSize(700,600);
        frame.setLocation(700,100);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("OLA");
            }
        });
        */
    private JLabel label;
    private JButton button;
    private JTextField textfield;

    public myGUIForm(){
        setLayout(new FlowLayout());
        label = new JLabel("Introduza a query");
        add(label);

        textfield = new JTextField(15);
        add(textfield);

        button = new JButton("Pesquisar");
        add(button);
    }

        public static void main(String[] args) {
            myGUIForm janela = new myGUIForm();
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            janela.setSize(400, 200);
            janela.setVisible(true);
            janela.setTitle("Motor de Pesquisa");
        }



    }

}
