import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myGUIForm {

    private JButton button;
    private JTextField fileSearch;
    private JTextField newFileName;
    private JFrame frame;

    public myGUIForm(){

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


    }

}
