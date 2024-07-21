package com.traplord.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpFinder {

    //IP finder
    //creating label
    public static void main(String[] args){

        //Frame
        JFrame jFrame=new JFrame("Ip Finder App");
        jFrame.setBounds(100,100,1000,100);
        jFrame.setLayout(new GridLayout());
        jFrame.setVisible(true);



        JLabel label=new JLabel("Enter URL : ");
        label.setBounds(50,70,150,20);

        JTextField textField=new JTextField();
        textField.setBounds(50,100,200,20);

        JButton button=new JButton("Find IP");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url=textField.getText();


                try {
                    //func to get the Ip from the web
                    InetAddress ia =InetAddress.getByName(url);
                    String ip=ia.getHostAddress();
                    JOptionPane.showMessageDialog(jFrame,ip);




                } catch (UnknownHostException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        jFrame.add(textField);
        jFrame.add(label);
        jFrame.add(button);


    }

}
