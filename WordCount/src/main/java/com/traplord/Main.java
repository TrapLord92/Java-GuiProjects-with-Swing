package com.traplord;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Frame

        JFrame jFrame =new JFrame("Word Counter");
        jFrame.setLayout(null);
        jFrame.setBounds(100,100,500,500);
        jFrame.setVisible(true);

        JTextArea textArea =new JTextArea();
        textArea.setBounds(50,50,300,200);


        JButton button =new JButton("Check");
        button.setBounds(180,300,100,30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //1-Get Text from Text Area
                String text =textArea.getText();


                //spliting up the string and storing into []
                if(!text.equals("")){
                    String[] word=text.split("\\s");

                    //displaying the result of words

                    JOptionPane.showMessageDialog(jFrame,"Total words : " + word.length);


                }

            }
        });
        jFrame.add(textArea);
        jFrame.add(button);





    }
}