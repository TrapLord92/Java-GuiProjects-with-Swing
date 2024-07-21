package com.traplord;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainScreen extends JFrame {
    //Pane1 :User Registraction
    //variables
    JPanel subscriberPanel;
    JTextField subName;
    JTextField subLastName;
    JTextField subMobil;
    JTextField subCity;

    JLabel nameLBL;
    JLabel lastLBL;
    JLabel mobileLBL;
    JLabel cityLBL;

    //Panel2 : cycle

    JTextField startCycleFLD;
    JTextField endCycleFLD;
    JTextField numberTVFLD;
    JLabel todayLBL;
    JLabel cyclePanel;
    JLabel startCycleLBL;
    JLabel endCycleLBL;
    JLabel numberTVLBL;
    SimpleDateFormat df;
    Date currentDate;
    //panel3 packages
    JCheckBox sportCHKBX;
    JCheckBox movieCHKBX;
    JCheckBox docCHKBX;
    JPanel packagesPanel;


    //Panel 4: Package details

    JTextArea channelsAreaS;
    JTextArea channelsAreaM;
    JTextArea channelsAreaD;
    JPanel detailsPanel;

    //Panel 5 : check and payments

    JLabel installFeeLBL;
    JPanel feePanel;
    JLabel packageFeeLBL;
    JLabel totalFeeLBL;

    //Panel 6: Table(Data of subscription)
    JTable table;
    DefaultTableModel tableModel;
    JPanel p6Panel;

    //Panel7: action Panel
    JButton saveBTN;
    JButton loadBTN;
    JButton newBTN;
    JPanel p7ActionsPanel;

    //classes and objects
    Subscriber subscriber;
    Subscription subscription;
    int packageSelectedPrice=0;
    int totalPrice;

//    saving data to disc field
ArrayList<Subscription>listToSave=new ArrayList<>();
File file;





    //constructor

    public MainScreen()   {
        /************************PANEL 1*******************/
//        Subscriber Panel
        subscriberPanel =new JPanel();
        Border panel1Title=BorderFactory.createTitledBorder("Subscriber Details");
        subscriberPanel.setBorder(panel1Title);
        subscriberPanel.setBounds(15,15,300,200);
        subscriberPanel.setLayout(new GridLayout(4,2));


        //JLabel

        nameLBL=new JLabel("Name : ");
        lastLBL=new JLabel("Last Name : ");
        mobileLBL= new JLabel("Mobile");
        cityLBL=new JLabel("City");

        //Textfields

        subName=new JTextField();
        subName.setOpaque(false);

        subLastName =new JTextField();
        subLastName.setOpaque(false);
        subMobil=new JTextField();
        subMobil.setOpaque(false);
        subCity=new JTextField();
        subCity.setOpaque(false);
        //addind components to panel1


        subscriberPanel.add(nameLBL);
        subscriberPanel.add(subName);
        subscriberPanel.add(lastLBL);
        subscriberPanel.add(subLastName);
        subscriberPanel.add(mobileLBL);
        subscriberPanel.add(subMobil);
        subscriberPanel.add(cityLBL);
        subscriberPanel.add(subCity);


        /***********PANEL2****************************/
//        Cycle Panel
        cyclePanel=new JLabel();
        cyclePanel.setBounds(15,230,300,500);
        cyclePanel.setLayout(new GridLayout(14,1));

        Border cycleBorder=BorderFactory.createTitledBorder("Cycle Details");
        cyclePanel.setBorder(cycleBorder);
        todayLBL=new JLabel();

        df =new SimpleDateFormat("dd/MM/yyyy");
        currentDate=new Date();
        todayLBL.setText("Today : " + df.format(currentDate));

        //Start cycle date
        startCycleLBL =new JLabel("Start Cyle Date (DD/MM/YYYY)");
        startCycleFLD= new JTextField();

        //end cycle date
        endCycleLBL = new JLabel("End Cycle Date (DD/MM/YYYY) ");
        endCycleFLD=new JTextField();

        numberTVLBL=new JLabel("Number of TV: ");
        numberTVFLD=new JTextField();

        cyclePanel.add(todayLBL);
        cyclePanel.add(startCycleLBL);
        cyclePanel.add(startCycleFLD);
        cyclePanel.add(endCycleLBL);
        cyclePanel.add(endCycleFLD);
        cyclePanel.add(numberTVLBL);
        cyclePanel.add(numberTVFLD);

        //make opacity for fields

        startCycleFLD.setOpaque(false);
        endCycleFLD.setOpaque(false);
        numberTVFLD.setOpaque(false);

        /**************PANEL 3 ***************/

        packagesPanel =new JPanel();
        packagesPanel.setBounds(330,15,300,200);
        packagesPanel.setLayout(new GridLayout(5,1));
        Border packBorder=BorderFactory.createTitledBorder("Avaible Package");
        packagesPanel.setBorder(packBorder);

        JLabel packagesLBL=new JLabel("Please select your Package");

        sportCHKBX=new JCheckBox("Sports Package");
        movieCHKBX=new JCheckBox("Movies Package");
        docCHKBX=new JCheckBox("Documentary Package");

        JButton subscriberBTN=new JButton("Subscribe");

        packagesPanel.add(packagesLBL);
        packagesPanel.add(sportCHKBX);
        packagesPanel.add(movieCHKBX);
        packagesPanel.add(docCHKBX);
        packagesPanel.add(subscriberBTN);


        //CheckBox Item Listeners

        sportCHKBX.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (sportCHKBX.isSelected()){
                    displaySportChannels();
                    //will make price change
                }else{
                    channelsAreaS.setText("");
                };
                
            }
        });
        
        movieCHKBX.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(movieCHKBX.isSelected()){
                    displayMovieChannels();
                }else{
                    channelsAreaM.setText("");
                    
                }

            }
        });
        
        docCHKBX.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(docCHKBX.isSelected()){
                    displayDocumentaryChannels();
                }else{
                   channelsAreaD.setText("");
                }
            }
        });


        subscriberBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    getSubscriberData();
                }catch (Exception ee){

                }
            }
        });

        /********************************Panel 4***********************/

        detailsPanel=new JPanel();
        detailsPanel.setBounds(330,230,300,500);
        detailsPanel.setLayout(new GridLayout(3,1));

        Border p4Border = BorderFactory.createTitledBorder("Available Channels");

        detailsPanel.setBorder(p4Border);

        channelsAreaS = new JTextArea(5, 1);
        channelsAreaS.setEditable(false);
        channelsAreaS.setOpaque(false);
        channelsAreaS.setLineWrap(true);

        channelsAreaM = new JTextArea(5, 1);
        channelsAreaM.setEditable(false);
        channelsAreaM.setOpaque(false);
        channelsAreaM.setLineWrap(true);

        channelsAreaD = new JTextArea(5, 1);
        channelsAreaD.setEditable(false);
        channelsAreaD.setOpaque(false);
        channelsAreaD.setLineWrap(true);

        detailsPanel.add(channelsAreaS);
        detailsPanel.add(channelsAreaM);
        detailsPanel.add(channelsAreaD);



/*********************************PANEL5**********************************/
    feePanel =new JPanel();
    feePanel.setBounds(645,15,200,200);
    feePanel.setLayout(new GridLayout(3,1));

    Border blackLine5=BorderFactory.createTitledBorder("Fee & Check");
    feePanel.setBorder(blackLine5);

    installFeeLBL=new JLabel("Installation Fee : ");
    packageFeeLBL=new JLabel("Total Amount to Pay : ");
    totalFeeLBL=new JLabel("Total Amount to Pay : ");

    feePanel.add(installFeeLBL);
    feePanel.add(packageFeeLBL);
    feePanel.add(totalFeeLBL);

    /********************Panel6*****************************************************/

    p6Panel=new JPanel();
    p6Panel.setBounds(645,230,515,500);
    p6Panel.setLayout(new GridLayout(3,1));

    Border border6=BorderFactory.createTitledBorder("Our Customer ");
    p6Panel.setBorder(border6);

    //CreatingTable
        //step1 table Model
        tableModel =new DefaultTableModel();
        //step 2 Columns

        table=new JTable(tableModel);
        tableModel.addColumn("First Name");
        tableModel.addColumn("Last Name");
        tableModel.addColumn("Phone Number");
        tableModel.addColumn("Start Cycle");
        tableModel.addColumn("End Cycle");
        tableModel.addColumn("Total Fee");
        //Step 3 Scroll pane

        JScrollPane scrollPane=new JScrollPane(table);
        p6Panel.add(scrollPane);


        /**********************Pane7**********************/
        p7ActionsPanel=new JPanel();
        p7ActionsPanel.setBounds(860,15,300,200);
        Border border7= BorderFactory.createTitledBorder("Action Tab");
        p7ActionsPanel.setBorder(border7);
        p7ActionsPanel.setLayout(new GridLayout(4,1));



        saveBTN=new JButton("Save Subscription");
        loadBTN=new JButton("Load Subscription");
        newBTN=new JButton("New Subscription");


        p7ActionsPanel.add(newBTN);
        p7ActionsPanel.add(saveBTN);
        p7ActionsPanel.add(loadBTN);
        
        saveBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveSubscriptionToDisk();
            }
        });

        newBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newSubscription();
            }
        });
        loadBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               ArrayList<Subscription> k=loadDataFromDisk();

            }
        });
















        //Components of cycle panel







        //adding Panels to JFRAme
        setLayout(null);
        add(subscriberPanel);//panel 1
        add(cyclePanel);//panel2
        add(packagesPanel);//panel3
        add(detailsPanel);//panel4
        add(feePanel);
        add(p6Panel);
        add(p7ActionsPanel);


/*****************METHODS********************/


    }

    private ArrayList<Subscription> loadDataFromDisk() {
        //loading data from disk
        ArrayList<Subscription>  s=new ArrayList<>();
        file= new File("E:\\##Java\\###THINGSDONE#\\J" +
                "AVAMASTERCLASS\\Recap1\\MasterJava001\\" +
                "TV-MANAGEMENT-SYSTEM\\src\\main\\" +
                "resources\\myfile.dat");

        try {
            InputStream is =new FileInputStream(file);
            ObjectInputStream ois =new ObjectInputStream(is);

            s=(ArrayList) ois.readObject();
            ois.close();
            is.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (Subscription sub:s){
            displaySubscritionInTable(sub);
        }
        System.out.println("Data loaded successfully");
        return s;

    }

    private void displaySubscritionInTable(Subscription sub) {
        //Displaying data from disk into table

        tableModel.addRow(new Object[]{
                sub.getSubscriber().getfName(),
                sub.getSubscriber().getlName(),
                sub.getSubscriber().getPhone(),
                sub.getCycle().getStartDate(),
                sub.getCycle().getEndDate(),
                sub.getTotalFee()







        });

    }

    private void newSubscription() {
        //set all fields to null
        subName.setText("");
        subLastName.setText("");
        subCity.setText("");
        subMobil.setText("");
        startCycleFLD.setText("");
        endCycleFLD.setText("");
        numberTVFLD.setText("");

        //packages
        sportCHKBX.setSelected(false);
        movieCHKBX.setSelected(false);
        docCHKBX.setSelected(false);

        //fee
        installFeeLBL.setText("Installation Fee : 0$");
        packageFeeLBL.setText("Total Amount to Pay : 0$");
        totalFeeLBL.setText("Total Amount to Pay : 0$");

    }

    private void saveSubscriptionToDisk() {
        //Saving data into disc
    listToSave.add(subscription);

         file= new File("E:\\##Java\\###THINGSDONE#\\J" +
                "AVAMASTERCLASS\\Recap1\\MasterJava001\\" +
                "TV-MANAGEMENT-SYSTEM\\src\\main\\" +
                "resources\\myfile.dat");

    try {
        OutputStream os=new FileOutputStream(file);
        ObjectOutputStream oos =new ObjectOutputStream(os);
        //saving the list of subscription

        oos.writeObject(listToSave);
        oos.flush();
        oos.close();
        os.close();
        System.out.println("Data Saved Sucessfully");



    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }


    }

    private void getSubscriberData() throws ParseException {
        Date currentDate=new Date();

        //subscriber data
        subscriber =new Subscriber(
                subName.getText(),subLastName.getText(),
                subCity.getText(),
                Integer.parseInt(subMobil.getText())
        );

        //cycle
        Date startCycle=df.parse(startCycleFLD.getText());
        Date endCycle=df.parse(endCycleFLD.getText());

        SubscriptionCycle cycle=new SubscriptionCycle(
                df.format(startCycle),df.format(endCycle)
        );

        //Subscription
        subscription=new Subscription(
                Integer.parseInt(numberTVFLD.getText()),subscriber,cycle,df.format(currentDate)
        );

        installFeeLBL.setText("Installation Fee : "+subscription.getTotalFee()+"$");

        ShowPrice();

    }

    private void ShowPrice() {
        if (docCHKBX.isSelected())
            packageSelectedPrice +=displayDocumentaryChannels();
        else if (movieCHKBX.isSelected()) {
            packageSelectedPrice += displayMovieChannels();

        } else if (sportCHKBX.isSelected()) {
            packageSelectedPrice += displaySportChannels();}

            totalPrice =subscription.getTotalFee()+packageSelectedPrice;
            totalFeeLBL.setText("Total Amount to Pay : "+totalPrice+"$");





        packageFeeLBL.setText("Package Fee : "+ packageSelectedPrice + " $ ");


    }

    private int displayDocumentaryChannels() {
        DocumentaryChannel m1=new DocumentaryChannel("NAT GEO","SP","DOC",5);
        DocumentaryChannel m2=new DocumentaryChannel("CNN","US","DOC",7);
        DocumentaryChannel m3=new DocumentaryChannel("BBC","UK","DOC",3);
        DocumentaryChannel m4=new DocumentaryChannel("All Jazeera","EN","DOC",10);
        DocumentaryChannel m5=new DocumentaryChannel("Sky News","EN","DOC",8);
        DocumentaryChannel m6=new DocumentaryChannel("1CHANNEL","RU","DOC",20);


        ArrayList<DocumentaryChannel> documentaryChannels=new ArrayList<>();
        documentaryChannels.add(m1);
        documentaryChannels.add(m2);
        documentaryChannels.add(m3);
        documentaryChannels.add(m4);
        documentaryChannels.add(m5);
        documentaryChannels.add(m6);


        String docChannelString="";
        int packagePrice=0;

        for (int i=0;i<documentaryChannels.size(); i++){
            docChannelString +=
                    "   " + documentaryChannels.get(i).getChannelName()
                            +"   "+ documentaryChannels.get(i).getLanguage()
                            +"   "+documentaryChannels.get(i).getPrice() + "$"
                            +"   "+"\n";
            packagePrice+=documentaryChannels.get(i).getPrice();
        }
        channelsAreaD.setText(docChannelString);
        return packagePrice;


    }

    private int displayMovieChannels() {
        MovieChannel m1=new MovieChannel("Star Wars","SP","MOVIE",8);
        MovieChannel m2=new MovieChannel("The Matrix","EN","MOVIE",10);
        MovieChannel m3=new MovieChannel("Inception","EN","MOVIE",12);
        MovieChannel m4=new MovieChannel("The Godfather","IT","MOVIE",14);
        MovieChannel m5=new MovieChannel("Pulp Fiction","EN","MOVIE",16);
        MovieChannel m6=new MovieChannel("Avatar","EN","MOVIE",18);


        ArrayList<MovieChannel> movieChannels=new ArrayList<>();
        movieChannels.add(m1);
        movieChannels.add(m2);
        movieChannels.add(m3);
        movieChannels.add(m4);
        movieChannels.add(m5);
        movieChannels.add(m6);


        String movieChannelString="";
        int packagePrice=0;
        for (int i=0;i<movieChannels.size(); i++){
            movieChannelString +=
                    "   " + movieChannels.get(i).getChannelName()
                            +"   "+ movieChannels.get(i).getLanguage()
                            +"   "+movieChannels.get(i).getPrice() + "$"
                            +"   "+"\n";
            packagePrice+=movieChannels.get(i).getPrice();
        }

        channelsAreaM.setText(movieChannelString);
        return packagePrice;
    }

    private int displaySportChannels() {
        SportChannel s1=new SportChannel("Football","SP","SPORT",6);
        SportChannel s2=new SportChannel("Basketball","EN","SPORT",8);
        SportChannel s3=new SportChannel("Hockey","EN","SPORT",10);
        SportChannel s4=new SportChannel("Rugby","IT","SPORT",12);
        SportChannel s5=new SportChannel("Volleyball","EN","SPORT",14);
        SportChannel s6=new SportChannel("Tennis","EN","SPORT",16);


        ArrayList<SportChannel> sportChannels=new ArrayList<>();
        sportChannels.add(s1);
        sportChannels.add(s2);
        sportChannels.add(s3);
        sportChannels.add(s4);
        sportChannels.add(s5);
        sportChannels.add(s6);

        String sportChannelString="";

        int packagePrice=0;

        for (int i=0;i<sportChannels.size(); i++){
            sportChannelString +=
                    "   " + sportChannels.get(i).getChannelName()
                            +"   "+ sportChannels.get(i).getLanguage()
                            +"   "+sportChannels.get(i).getPrice() + "$"
                            +"   "+"\n";
            packagePrice+=sportChannels.get(i).getPrice();
        }

        channelsAreaS.setText(sportChannelString);
        return packagePrice;
    }

    public static void main(String[] args){

        //Creating the View container (Frame)
        MainScreen mainScreen=new MainScreen();
        mainScreen.setVisible(true);
        mainScreen.setBounds(20,10,1000,8000);

    }
}
