package com.traplord;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

public class AccountFrame extends JFrame {

    //Create GUI components and layout
    JLabel accnNoLBL,ownerLBL,cityLBL,genderLBL,amountLBL,balanceLBL;
    JTextField accNoTXT, ownerTXT, balanceTXT, amountTXT;
    JComboBox<City> citiesCMB;
    JButton newBTN,saveBTN,showBTN,quitBTN,depositBTN,withdrawBTN;
    JRadioButton maleRB, femaleRB;

    ButtonGroup genderBTNGRP;

    JList<Account> accountList;
    JPanel p1,p2,p3,p4,p5;


    public Set<Account> accountSet=new HashSet<>();

    Account acc,x;
    boolean newRec =true;

    //COmbox Data

    DefaultComboBoxModel<City> citiesCMBDL;
    DefaultListModel<Account> accountsLSTMDL;


    //Table Data

    JTable table;
    DefaultTableModel tableModel;
    ArrayList<Transaction> transList=new ArrayList<>();

    public AccountFrame() {
        super("Account Operations");
        setLayout(null);
        setSize(600, 400);

        //Adding Components to the Frame
        //1-laabels
        accnNoLBL = new JLabel("Account No ");
        ownerLBL= new JLabel("Owner ");
        balanceLBL= new JLabel("Balance ");
        cityLBL= new JLabel("City ");
        genderLBL= new JLabel("Gender");
        amountLBL= new JLabel("Amount");

        //2-textfields

        accNoTXT=new JTextField();accNoTXT.setEnabled(false);
        ownerTXT=new JTextField();
        balanceTXT=new JTextField();balanceTXT.setEnabled(false);
        amountTXT=new JTextField();
        amountTXT.setPreferredSize(new Dimension(150,25));

        //3-combobox

        citiesCMBDL=new DefaultComboBoxModel<>();
        citiesCMBDL.addElement(null);
        citiesCMBDL.addElement(new City("Ufa","Baskiria"));
        citiesCMBDL.addElement(new City("Moscow","Sakolova"));
        citiesCMBDL.addElement(new City("Salavat","Kalinsk"));
        citiesCMBDL.addElement(new City("Ufa","Leninsk"));

        //adding data to JComboBox

        citiesCMB =new JComboBox<>(citiesCMBDL);

        //4-Radio buttons

        maleRB=new JRadioButton("Male",true);
        femaleRB=new JRadioButton("Female");
        genderBTNGRP=new ButtonGroup();
        genderBTNGRP.add(maleRB);
        genderBTNGRP.add(femaleRB);



        //5-buttons

        newBTN=new JButton("New");
        saveBTN=new JButton("Save");
        showBTN=new JButton("Show All");
        quitBTN=new JButton("Quit");
        depositBTN=new JButton("Deposit");
        withdrawBTN=new JButton("Withdraw");

        //6-Table

        accountsLSTMDL=new DefaultListModel<>();
        accountList=new JList<>(accountsLSTMDL);


        //7 Panels

        p1=new JPanel(); p1.setBounds(5,5,300,150);
        p1.setLayout(new GridLayout(5,2));

        p2=new JPanel(); p2.setBounds(5,155,300,40);
        p2.setLayout(new FlowLayout());

        p3=new JPanel(); p3.setBounds(5,195,600,40);
        p3.setLayout(new FlowLayout());

        p4=new JPanel(); p4.setBounds(305,5,300,190);
        p4.setLayout(new BorderLayout());

        p5=new JPanel(); p5.setBounds(5,240,580,120);
        p5.setLayout(new BorderLayout());

        //adidng components to Panel

        p1.add(accnNoLBL);
        p1.add(accNoTXT);
        p1.add(ownerLBL);
        p1.add(ownerTXT);
        p1.add(balanceLBL);
        p1.add(balanceTXT);
        p1.add(cityLBL);
        p1.add(citiesCMB);
        p1.add(maleRB);
        p1.add(femaleRB);


        p2.add(newBTN);
        p2.add(saveBTN);
        p2.add(showBTN);
        p2.add(quitBTN);

        p3.add(amountLBL);
        p3.add(amountTXT);
        p3.add(depositBTN);
        p3.add(withdrawBTN);

        p4.add(accountList);








        //adding panel to the frame


        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);

        //table creation

        tableModel =new DefaultTableModel();

        table=new JTable(tableModel);
        tableModel.addColumn("Transaction No");
        tableModel.addColumn("Transantion Date");
        tableModel.addColumn("Transaction Type");
        tableModel.addColumn("Transation Amount");


        JScrollPane scrollPane=new JScrollPane(table);
        p5.add(scrollPane);

        /********************************Functionality************************************/


        newBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accNoTXT.setText("");
                ownerTXT.setText("");
                citiesCMB.setSelectedIndex(0);
                maleRB.setSelected(true);
                balanceTXT.setText("");
                amountTXT.setText("");
                newRec=true;
            }
        });

        saveBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(newRec){
                    //Insertion (new record)
                    if(ownerTXT.getText().length() !=0){
                        acc=new Account(
                                ownerTXT.getText(),
                                (City)citiesCMB.getSelectedItem(),
                                maleRB.isSelected()?'M':'F');

                                accNoTXT.setText(String.valueOf(acc.accountNo));
                                accountSet.add(acc);
                                accountsLSTMDL.addElement(acc);
                                newRec=false;


                    }else {
                        JOptionPane.showMessageDialog(null,"Please fill all fields!");

                    }
                }else{

//                    updating
                    accountSet.remove(acc);

                    int a=Integer.parseInt(accNoTXT.getText());
                    String o =ownerTXT.getText();
                    City c =(City) citiesCMB.getSelectedItem();
                    char g =maleRB.isSelected()?'M':'F';
                    double b=Double.parseDouble(balanceTXT.getText());
                    acc=new Account(a,o,c,g,b);
                    accountSet.add(acc);
                    accountsLSTMDL.setElementAt(acc,accountList.getSelectedIndex());
                    newRec=false;





                }

            }
        });

        //ShowBTN
        showBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s="";
                Iterator<Account> it=accountSet.iterator();
                while(it.hasNext()){
                    s+= it.next().toString()+"\n";
                    JOptionPane.showMessageDialog(null,s);

                }
            }
        });


        depositBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!newRec && amountTXT.getText().length() !=0){
                    //Adding Transaction to table

                    Transaction t = new Transaction('D', LocalDate.now(), acc,Double.parseDouble(amountTXT.getText()));

                    displayTransationInTable(t);

                    //Perform deposit from account

                    acc.deposit(Double.parseDouble(amountTXT.getText()));
                    balanceTXT.setText(String.valueOf(acc.balance));

                }

            }
        });




        withdrawBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!newRec && amountTXT.getText().length() !=0){
                    //Transation to table

                    Transaction t=new Transaction(
                            'W',LocalDate.now(),
                            acc,Double.parseDouble(amountTXT.getText()));

                    displayTransationInTable(t);

                //performing withdrawal on account
                    acc.withdraw(Double.parseDouble(amountTXT.getText()));
                    balanceTXT.setText(String.valueOf(acc.balance));

                }
            }
        });

        accountList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                acc =x=accountList.getSelectedValue();

                accNoTXT.setText(String.valueOf(acc.accountNo));
                ownerTXT.setText(acc.owner);
                citiesCMB.setSelectedItem(acc.city);


                if(acc.gender=='M') maleRB.setSelected(true);
                else femaleRB.setSelected(true);

                balanceTXT.setText(String.valueOf(acc.balance));
                amountTXT.setEnabled(true);
                depositBTN.setEnabled(true);
                newRec=false;


                //Clear Table:

                for (int i=tableModel.getRowCount()-1; i>=0; i--) {
                    tableModel.removeRow(i);

                }

                //Get Transactions to selected Account
                
                searchTransactionList(acc.accountNo);

                


            }
        });









    }

    private void searchTransactionList(int accountNo) {

        List<Transaction> filteredList=new ArrayList<>();

        //iterate through the list

        for (Transaction t:transList){

            //filter values contain transantio no

            if (t.getAcc().accountNo==accountNo){
                filteredList.add(t);
            }
        }

        //Display the filtered List

        for(int i =0; i<filteredList.size(); i++){

            //Displaying data into table

            tableModel.addRow(new Object[]{
               filteredList.get(i).getTrsNo(),
                filteredList.get(i).getDate(),
                filteredList.get(i).getOperation(),
                filteredList.get(i).getAmount()



            });
        }


    }

    private void displayTransationInTable(Transaction t) {


        //displaying data into table

        tableModel.addRow(new Object[]{
                t.getTrsNo(),
                t.getDate(),
                t.getOperation(),
                t.getAmount()


        });

        //Adding object to ArrayList

        transList.add(t);



    }

    public static void main(String[] args){
        AccountFrame af=new AccountFrame();
        af.setVisible(true);
        af.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
