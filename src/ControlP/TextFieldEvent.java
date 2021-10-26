package ControlP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;

public class TextFieldEvent {

    public JFrame window;
    public JPanel panel;
    public JTextField d0, d1, d2, d3;
    public JButton button;
    public String[] names;
    public boolean filled;


    public TextFieldEvent(){
        window = new JFrame("Welcome to Dino World");
        panel = new JPanel();
        button = new JButton("OK");
        names = new String[4];
        filled = false;

        //Size the frame
        window.setLayout(new BorderLayout());
        window.setSize(500, 500);


        //Size the panel
        panel.setSize(300, 300);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        Container content = window.getContentPane( );
        content.setLayout(new BorderLayout());

        JLabel text = new JLabel("Please insert players names: ");

         d0 = new JTextField();
         d1 = new JTextField();
         d2 = new JTextField();
         d3 = new JTextField();

        panel.add(text, BorderLayout.NORTH);
        panel.add(d0);
        panel.add(d1);
        panel.add(d2);
        panel.add(d3);
        panel.add(button, BorderLayout.PAGE_END);
        content.add(panel, BorderLayout.CENTER);


        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public String[] getDinoNames() {

        window.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                names[0] = d0.getText();

                names[1] = d1.getText();
                names[2] = d2.getText();
                names[3] = d3.getText();


                filled = true;
                window.setVisible(false);

            }
        });

        return names;
    }

}
