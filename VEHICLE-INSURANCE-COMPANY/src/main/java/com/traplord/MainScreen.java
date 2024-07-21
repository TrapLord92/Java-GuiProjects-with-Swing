package com.traplord;

import com.traplord.plans.*;
import com.traplord.policy.Customer;
import com.traplord.policy.Policy;
import com.traplord.policy.Vehicle;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

import static java.lang.Integer.parseInt;

public class MainScreen extends JFrame {
    //Customization

    Font myFont=new Font("SansSerif",Font.BOLD,20);
    Color myColor=Color.GRAY;

//    Panel1
JTextField subFname;
JTextField  subLName;
JTextField subCity;
JTextField subPhone;

//Panel 2

    JTextField model;
    JTextField manufacturer;
    JTextField plateNB;
    JTextField estimated;
    JRadioButton damageRadio1;
    JRadioButton damageRadio2;
    JRadioButton damageRadio3;
    JRadioButton damageRadio4;
    ButtonGroup G1;

    //Panel3
    JCheckBox obligatoryCHKBX;
    JCheckBox allRiskCHKBX;
    JCheckBox vDamageCHKBX;
    JCheckBox dDamageCHKBX;
    JCheckBox assistanceCHKBX;

    List<String> coveredRisksList=new ArrayList<>();
    List<Float> premiumRisksList=new ArrayList<>();
    List<Float> coverageRisksList=new ArrayList<>();
    List<Float> ceilingRisksList=new ArrayList<>();

    //Panel4
    JRadioButton yearRadio;
    JRadioButton yearsRadio2;
    JRadioButton yearsRadio3;
    ButtonGroup G2;
    JLabel todayLBL;
    int validityYear=0;
    SimpleDateFormat df;
    Date currentDate;

    //Panel5
    JTextArea risksTxT;
    JTextField searchTXT;
    Map<Integer, Customer> customerMap=new TreeMap<>();

    //Panel7
    JTextArea policyTXT;

    //Panel 8

     JTextArea customerTXT;

     //Panel 9
    JLabel claimingTXT;
    JLabel claimingTXT2;
    JTextField claimingCustomerField;

    //panel 10

    JLabel claimingCustomerNameLBL;
    JLabel claimStatusLBL2;
    JTextArea claimingCustomerRiskCoveredArea;
    JLabel claimingCustomerValidDateLBL;

    boolean cond1;
    boolean cond2;
    boolean cond3;


//    Panel11
JTextArea settlementArea;
float totalPremium=0f;
float totalCoverage=0f;
float totalCeiling=0f;


//Panel12

    JTextArea settlementArea2;





















//Constructor
    
    public MainScreen() {
        customizePanel1();
        customizePanel2();
        customizePanel3();
        customizePanel4();
        customizePanel5();
        customizePanel6();
        customizePanel7();
        customizePanel8();
        customizePanel9();
        customizePanel10();
        customizePanel11();
        customizePanel12();

    }




    ///Panels
    private void customizePanel1() {
        JPanel p1=new JPanel();
        TitledBorder titledBorder=BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                "Customer Information",
                TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION,
                myFont,myColor);

        p1.setBorder(titledBorder);

        JLabel fNameLBL=new JLabel("First Name ");
        JLabel lNameLBL=new JLabel("Last Name ");
        JLabel cityLBL=new JLabel("City ");
        JLabel phoneLBL=new JLabel("Phone ");

        subFname= new JTextField();   subFname.setOpaque(false);
        subLName=new JTextField();  subLName.setOpaque(false);
        subCity=new JTextField(); subCity.setOpaque(false);
        subPhone =new JTextField(); subPhone.setOpaque(false);


        p1.add(fNameLBL);
        p1.add(subFname);
        p1.add(lNameLBL);
        p1.add(subLName);
        p1.add(cityLBL);
        p1.add(subCity);
        p1.add(phoneLBL);
        p1.add(subPhone);

        p1.setBounds(15,15,300,200);
        p1.setLayout(new GridLayout(4,2));

        //Adding Panels to JFRAME

        setLayout(null);
        add(p1);









    }

    private void customizePanel2() {

        TitledBorder titledBorder=BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray,1),
                "Vehicle Information",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION,
                myFont,myColor);

        JPanel p2=new JPanel();
        p2.setBorder(titledBorder);
        //JLabel p2

        JLabel plateNLBL=new JLabel("Plate Number ");
        JLabel modelLBL=new JLabel("Model Year");
        JLabel manufacturerLBL=new JLabel("Manufacturer ");
        JLabel estimatedLBL=new JLabel("Estimated Value ");
        JLabel spaceLBL=new JLabel(" ");
        JLabel damageLBL=new JLabel("Major Damage ");


//        JTextField

        plateNB=new JTextField();  plateNB.setOpaque(false);
        model=new JTextField();  model.setOpaque(false);
        manufacturer=new JTextField();  manufacturer.setOpaque(false);
        estimated=new JTextField();  estimated.setOpaque(false);

        //Radio Buttons

        damageRadio1=new JRadioButton();
        damageRadio1.setText("Motor");
        damageRadio2=new JRadioButton();
        damageRadio2.setText("Wheels");
        damageRadio3=new JRadioButton();
        damageRadio3.setText("Body");
        damageRadio4=new JRadioButton();
        damageRadio4.setText("None");

        G1=new ButtonGroup();
        G1.add(damageRadio1);
        G1.add(damageRadio2);
        G1.add(damageRadio3);
        G1.add(damageRadio4);

//        addingComponent to Panel2

        p2.add(plateNLBL);
        p2.add(plateNB);
        p2.add(modelLBL);
        p2.add(model);
        p2.add(manufacturerLBL);
        p2.add(manufacturer);
        p2.add(estimatedLBL);
        p2.add(estimated);
        p2.add(spaceLBL);
        p2.add(damageLBL);
        p2.add(damageRadio1);
        p2.add(damageRadio2);
        p2.add(damageRadio3);
        p2.add(damageRadio4);

//        customize panel 2

        p2.setBounds(15,250,300,500);
        p2.setLayout(new GridLayout(14,1));

        add(p2);








    }


    private void customizePanel3() {
             TitledBorder titledBorder=BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray,1),
                "Plan",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION,
                myFont,myColor);

        JPanel p3=new JPanel();
        p3.setBorder(titledBorder);
        p3.setBounds(330,15,300,200);
        p3.setLayout(new GridLayout(6,1));

        JLabel packageLBL=new JLabel("Please Select your Plan");

        //Checbox
        obligatoryCHKBX=new JCheckBox("Obligatory Coverage");
        allRiskCHKBX=new JCheckBox("All Risk Coverage");
        vDamageCHKBX=new JCheckBox("Vehicle Damage Coverage");
        dDamageCHKBX=new JCheckBox("Driver Damage Coverage");
        assistanceCHKBX=new JCheckBox("Assistance Coverage");

    //Get all risks covered by plan
        
        getRiskCoveredbyPlan();

        //Adding checkbox to panel 3

        p3.add(packageLBL);
        p3.add(obligatoryCHKBX);
        p3.add(allRiskCHKBX);
        p3.add(vDamageCHKBX);
        p3.add(dDamageCHKBX);
        p3.add(assistanceCHKBX);
        add(p3);

        //Adding button to calculate premium







    }

    private void customizePanel4() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray, 1),
                "Validity Period", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
                myFont, myColor);

        JPanel p4 = new JPanel();
        p4.setBorder(titledBorder);
        p4.setBounds(330, 250, 300, 250);
        p4.setLayout(new GridLayout(6, 1));


        //Radio Buttons

        JLabel spacer2 = new JLabel(" ");
        spacer2.setOpaque(false);

        yearRadio = new JRadioButton();
        yearRadio.setText("1 Year");
        yearsRadio2 = new JRadioButton();
        yearsRadio2.setText("2 Years");
        yearsRadio3 = new JRadioButton();
        yearsRadio3.setText("3 Years");

        yearRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYear = 1;
            }
        });

        yearsRadio2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYear = 2;
            }
        });

        yearsRadio3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYear = 3;
            }
        });

        //Button Group
        G2 = new ButtonGroup();
        G2.add(yearRadio);
        G2.add(yearsRadio2);
        G2.add(yearsRadio3);

        //Time e date
        todayLBL = new JLabel();
        df = new SimpleDateFormat("dd/MM/yyyy");
        currentDate = new Date();
        todayLBL.setText("Today's Date: " + df.format(currentDate));
        todayLBL.setOpaque(false);


        Font font = todayLBL.getFont();

        float size = font.getSize() + 3.0f;
        todayLBL.setFont(font.deriveFont(size));

//               adding compnents to pane;4

        p4.add(spacer2);
        p4.add(spacer2);
        p4.add(todayLBL);
        p4.add(spacer2);
        p4.add(yearRadio);
        p4.add(yearsRadio2);
        p4.add(yearsRadio3);


//adding to jframe
        add(p4);

    }
    private void customizePanel5() {
           TitledBorder titledBorder=BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray,1),
                "Actions",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION,
                myFont,myColor);

        JPanel p5 =new JPanel();
        p5.setBorder(titledBorder);
        p5.setBounds(330,520,300,230);
        p5.setLayout(new GridLayout(7,1));

        JButton saveBTN=new JButton("Save Customer");
        JButton showBTN=new JButton("Show Plan Details");
        JButton loadBTN=new JButton("Load Customer");
        JButton newBtn=new JButton("New Customer");

        searchTXT=new JTextField("ENTER CAR PLATE NUMBER");
        searchTXT.setOpaque(false);



        showBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
                String str="";

                for (int i =0; i<coverageRisksList.size();i++){

                    str +=coveredRisksList.get(i)+ "\n";
                }
                risksTxT.setText(str);
                try {
                    policyTXT.setText(getPolicyData().toString());
                    displayPaymentofPolicy();
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });

        saveBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //save Customer
                try {
                    saveCustomerMapTodisk();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        JLabel spacer3 = new JLabel(" ");
        spacer3.setOpaque(false);

         loadBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SearchCustomerByMobileNumber();


            }
        });

        JLabel spacer4 = new JLabel(" ");
        spacer4.setOpaque(false);
        JLabel spacer5 = new JLabel(" ");
        spacer5.setOpaque(false);
        JLabel spacer6 = new JLabel(" ");
        spacer6.setOpaque(false);

        newBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                newCustomer();

            }
        });

        p5.add(spacer6);
        p5.add(showBTN);
        p5.add(saveBTN);
        p5.add(newBtn);
        p5.add(spacer5);
        p5.add(searchTXT);
        p5.add(loadBTN);
        add(p5);




    }

    private void customizePanel6() {
             TitledBorder titledBorder=BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray,1),
                "Covered Risks",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION,
                myFont,myColor);


             JPanel p6=new JPanel();
             p6.setBorder(titledBorder);
             p6.setBounds(645,15,300,200);

             risksTxT=new JTextArea(7,1);
             risksTxT.setEditable(false);
             risksTxT.setOpaque(false);
             risksTxT.setLineWrap(true);

             Font font =risksTxT.getFont();
             float size = font.getSize() + 3.0f;
             risksTxT.setFont(font.deriveFont(size));

             p6.add(risksTxT);
             p6.setLayout(new GridLayout(1,1));
             add(p6); //adding p6 to jframe



    }


    private void customizePanel7(){
                 TitledBorder titledBorder=BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray,1),
                "Policy Details",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION,
                myFont,myColor);


                 JPanel p7=new JPanel();
                 p7.setBorder(titledBorder);
                 p7.setBounds(645,250,300,250);
                 p7.setLayout(new GridLayout(6,1));
                 policyTXT=new JTextArea(20,1);
                 policyTXT.setEditable(false);
                 policyTXT.setOpaque(false);
                 policyTXT.setLineWrap(true);

                 p7.add(policyTXT);
                 p7.setLayout(new GridLayout(1,1));
                 add(p7); //adding p7 to jframe




    }

    private  void customizePanel8(){
                 TitledBorder titledBorder=BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray,1),
                "Customer Details",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION,
                myFont,myColor);

                 JPanel p8=new JPanel();
                 p8.setBorder(titledBorder);
                 p8.setBounds(645,520,300,230);
                 p8.setLayout(new GridLayout(6,1));


                 customerTXT=new JTextArea(10,1);
                 customerTXT.setEditable(false);
                 customerTXT.setOpaque(false);
                 customerTXT.setLineWrap(true);

                 //Increase the size of font for jtext area;

        Font font = customerTXT.getFont();
        float size = font.getSize() + 3.0f;
        customerTXT.setFont(font.deriveFont(size));

        p8.add(customerTXT);
        p8.setLayout(new GridLayout(1,1));
        add(p8); //adding p8 to jframe





    }

    private void customizePanel9() {


                 TitledBorder titledBorder=BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray,1),
                " Claims ",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION,
                myFont,myColor);



                 JPanel p9 =new JPanel();
                 p9.setBorder(titledBorder);
                 p9.setBounds(960,15,300,485);

                 claimingTXT =new JLabel("Enter plate number  for the claiming Customer");
                 JLabel spacer99=new JLabel("                                   ");
                 claimingTXT2=new JLabel("Select the Type of Demage or Assistence needed");


                 claimingCustomerField=new JTextField();
                 claimingCustomerField.setPreferredSize(new Dimension(250,30));
                 claimingCustomerField.setOpaque(false);


                  String [] items={
                          "Driver Damage",
                 "Property Damage",
                 "Liability",
                 "Medical Expenses",
                 "Work Compensation",
                 "Uninsured Motorists",
                 "Personal Injury",
                 "Environmental Factors",
                 "Environmental Contamination",
                 "Environmental Damage",
                 "Environmental Liability",
                 "Environmental Contamination Liability",
                 "Environmental Damage Liability",
                 "Environmental Contamination Damage Liability",
                 "Environmental Liability Damage Liability",
                 "Environmental Contamination Liability Damage Liability",
                 "Environmental Contamination Damage Liability Damage Liability",
                 "Environmental Liability Damage Liability Damage Liability",
                 "Environmental Contamination Liability Damage Liability Damage Liability",
                 "Environmental Contamination Damage Liability Damage Liability Damage Liability",
                 "Environmental Liability Damage Liability Damage Liability Damage Liability",
                 "Environmental Contamination Li"
                  };


                  final JList claimList=new JList(items);

                  claimList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                  claimList.setOpaque(false);
                  claimList.setPreferredSize(new Dimension(250,150));

                 JButton searchClaimer=new JButton("Search Customer");
                 List<String> coveredRisksByUserList=new ArrayList<>();


                 searchClaimer.addActionListener(new ActionListener() {

                     @Override
                     public void actionPerformed(ActionEvent e) {
                         cond1=false;
                         cond2=false;
                         cond3=false;

                         try {
                             coveredRisksByUserList.clear();
                             Customer c =claimSearchCustomerByMobileNb();
                             claimingCustomerNameLBL.setText("Claiming Customer : " + c.getFname()+ " "+ c.getLname());
                             cond1=true;


                             String str7= " ";
                             for (int i =0; i<c.getPolicy().getRiskCoveredLIST().size();i++){
                                 str7 += c.getPolicy().getRiskCoveredLIST().get(i) + " \n ";
                                 coveredRisksByUserList.add(c.getPolicy().getRiskCoveredLIST().get(i));


                             }

                             LocalDate v_validityOfPolicy= c.getPolicy().getPolicyDate();
                              int v_policyValidityYears=c.getPolicy().getValidityYear();
                              v_validityOfPolicy=v_validityOfPolicy.plusYears(v_policyValidityYears);
                              checkPolicyValidity(v_validityOfPolicy);

                              claimingCustomerRiskCoveredArea.setText("Covered Risk by Customer Plan:\n"+str7);
                              claimingCustomerValidDateLBL.setText("Date Validity of Policy : " +v_validityOfPolicy +" || " +checkPolicyValidity(v_validityOfPolicy));


                              if(c.getPolicy().getRiskCoveredLIST().size() >=5){
                                  //if user has a all risk plan
                                  cond2=true;
                              }




                         } catch (Exception re) {
                             claimingCustomerNameLBL.setText("Claiming customer:" +
                                     " Not found");

                         }


                     }
                 });

        JButton confirmClaimBTN=new JButton("Confirm Claim");
        confirmClaimBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Get the index of all selected items

                int[] selectedIx =claimList.getSelectedIndices();
                List<String> claimed_list= new ArrayList<>();

                if(claimList.getSelectedIndex() !=1){
                    for (int i =0;i<selectedIx.length; i++) {

                        String k =" " + claimList.getModel().getElementAt(selectedIx[i]);
                        claimed_list.add("" +claimList.getModel().getElementAt(selectedIx[i]));
                        System.out.println("" + k);


                    }
                }


                //check for included Risks

                if(cond2==false){
                    cond2=claimed_list.containsAll(coveredRisksByUserList);
                }

                claimIsValid();

//                Display Setlements


                Customer c =claimSearchCustomerByMobileNb();
                if (claimIsValid()){
                    int claims_nb=claimed_list.size();
                    if(claimed_list.contains("Fire")){
                        settlementArea2.setText("Fire Departament:" +
                                c.getPolicy().getVehicle().getEstimatedValue()*0.25+ "$");}
                    else if ( claimed_list.contains("Theft")){
                        settlementArea2.setText("Theft Department:" +
                                c.getPolicy().getVehicle().getEstimatedValue()*0.15+ "$");
                    } else if (claimed_list.contains("Collision")) {
                        settlementArea2.setText("Collision Department:" +
                                c.getPolicy().getVehicle().getEstimatedValue()*0.10+ "$");

                    }else if (claimed_list.contains("Vandalism")) {
                        settlementArea2.setText("Vandalism Department:" +
                                c.getPolicy().getVehicle().getEstimatedValue()*0.05+ "$");
                    }else if (claimed_list.contains("Water Damage")) {
                        settlementArea2.setText("Water Damage Department:" +
                                c.getPolicy().getVehicle().getEstimatedValue()*0.05+ "$");
                    }else if (claimed_list.contains("Liability")) {
                        settlementArea2.setText("Liability Department:" +
                                c.getPolicy().getVehicle().getEstimatedValue()*0.05+ "$");
                    }else if(claims_nb>2){
                        settlementArea2.setText("Driver" +
                                c.getPolicy().getVehicle().getEstimatedValue()*4+ "$" +
                                "Hospital" + c.getPolicy().getVehicle().getEstimatedValue()*4+ "$" +
                                "Car Rental Company" + c.getPolicy().getVehicle().getEstimatedValue()*0.2+ "$"+
                                "Third Party Driver" + c.getPolicy().getVehicle().getEstimatedValue()*0.2);
                    }else{

                    }


                }





            }
        });

        p9.add(claimingTXT);
        p9.add(claimingCustomerField);
        p9.add(searchClaimer);
        p9.add(spacer99);
        p9.add(claimingTXT2);
        p9.add(claimList);
        p9.add(confirmClaimBTN);
        add(p9); //adding p9 to jframe








    }

    private void customizePanel10() {
            TitledBorder titledBorder=BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray,1),
                " Claim Status ",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION,
                myFont,myColor);


            JPanel p10=new JPanel();
            p10.setBorder(titledBorder);
            p10.setBounds(960,520,300,230);
            p10.setLayout(new GridLayout(4,1));

//            label


        claimingCustomerNameLBL=new JLabel("Claiming Customer : ");
        claimingCustomerValidDateLBL=new JLabel(" Date Validity of Policy : ");
        claimStatusLBL2=new JLabel("Claiming Status : ");


//        JtextArea


        claimingCustomerRiskCoveredArea=new JTextArea();
        JScrollPane pictureScropPane=new JScrollPane(claimingCustomerRiskCoveredArea);
        claimingCustomerRiskCoveredArea.setOpaque(false);

        p10.add(claimingCustomerNameLBL);
        p10.add(claimingCustomerValidDateLBL);
        p10.add(pictureScropPane);
        p10.add(claimStatusLBL2);
        add(p10); //adding p10 to jframe

    }

    private void customizePanel11() {
            TitledBorder titledBorder=BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray,1),
                " Payments ",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION,
                myFont,myColor);

            JPanel p11=new JPanel();
            p11.setBorder(titledBorder);
            p11.setBounds(1275,15,250,230);
            p11.setLayout(new GridLayout(2,1));

            settlementArea=new JTextArea();
            settlementArea.setOpaque(false);

            //increasing the size of jtextarea;

        Font font=settlementArea.getFont();
        float size=font.getSize() + 4.0f;
        settlementArea.setFont(font.deriveFont(size));
        p11.add(settlementArea);
        add(p11); //adding p11 to jframe




    }

    private void customizePanel12() {

            TitledBorder titledBorder=BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray,1),
                " Settlements",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION,
                myFont,myColor);


            JPanel p12=new JPanel();
            p12.setBorder(titledBorder);
            p12.setBounds(1275,250,250,500);
            p12.setLayout(new GridLayout());


            settlementArea2 =new JTextArea();
            settlementArea2.setOpaque(false);
        p12.add(settlementArea2);

         Font font=settlementArea.getFont();
        float size=font.getSize() + 4.0f;
        settlementArea.setFont(font.deriveFont(size));
        p12.add(settlementArea);
        add(p12); //adding p12 to jf



    }

/************************************** Methods*****************************************************/

//Get Customer Data

public Customer getCustomerData() throws ParseException {


    Customer customer = new Customer(

            subFname.getText(), subLName.getText(), subCity.getText(), parseInt(subPhone.getText()),

            getPolicyData()


    );
    return customer;

    
    
}

//Vehicle Data

    public Vehicle getVehicleData() throws ParseException{
    Vehicle vehicle=new Vehicle(
      parseInt(plateNB.getText()), parseInt(model.getText())
            ,manufacturer.getText(), parseInt(estimated.getText()),
            getDamageState()





    );
    return  vehicle;

    }

    //Getting Damage Data
    private int getDamageState() {

    if(damageRadio1.isSelected()){
        return 1;
    } else if (damageRadio2.isSelected()) {
        return 2;

    } else if (damageRadio3.isSelected()) {
        return 3;
    }else return 0;


    }


    //Get plan Details

    public void getRisksCoveredByPlans(){

        AllRisks allRisk=new AllRisks();
        ObligatoryRisk obligatoryRisk= new ObligatoryRisk();

        allRiskCHKBX.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                dDamageCHKBX.setEnabled(false);
                vDamageCHKBX.setEnabled(false);
                assistanceCHKBX.setEnabled(false);
                obligatoryCHKBX.setEnabled(false);


                //adding Risk Details to array

                for (int i=0; i< allRisk.allRiskCovered.length; i++){

                    coveredRisksList.add(allRisk.allRiskCovered[i]);



                }


                  premiumRisksList.add(allRisk.getPremium());
               coverageRisksList.add(allRisk.getCovarege());
                ceilingRisksList.add(allRisk.getCeiling());














            }
        });

        obligatoryCHKBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Adding Risk Details to an array

                coveredRisksList.add(obligatoryRisk.obligatoryRiskCovered[0]);
                premiumRisksList.add(obligatoryRisk.getPremium());
              coverageRisksList.add(obligatoryRisk.getCovarege());
                ceilingRisksList.add(obligatoryRisk.getCeiling());


            }
        });


        vDamageCHKBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VehicleRisk vehicleRisk=new VehicleRisk();

                //Adding Risk Details to an array

                coveredRisksList.add(vehicleRisk.VehicleRiskCovered[0]);
                premiumRisksList.add(vehicleRisk.getPremium());
                coverageRisksList.add(vehicleRisk.getCovarege());
                ceilingRisksList.add(vehicleRisk.getCeiling());


            }



        });

        dDamageCHKBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DriverRisk driverRisk=new DriverRisk();
                coveredRisksList.add(driverRisk.driverRiskCovered[0]);
                premiumRisksList.add(driverRisk.getPremium());
               coverageRisksList.add((driverRisk.getCovarege()));
                ceilingRisksList.add(driverRisk.getCeiling());

            }
        });

        assistanceCHKBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AssistenceRisk assistenceRisk=new AssistenceRisk();
                //Adding Risk details to an array

                for (int i=0;i<assistenceRisk.assistanceRiskCovered.length; i++){

                    coveredRisksList.add(assistenceRisk.assistanceRiskCovered[i]);

                }

                premiumRisksList.add(assistenceRisk.getPremium());
                coverageRisksList.add(assistenceRisk.getCovarege());
                ceilingRisksList.add(assistenceRisk.getCeiling());




            }
        });









    }


    ///Getting Policy Data
    public Policy getPolicyData() throws ParseException {

    currentDate =new Date();

    LocalDate now=LocalDate.now();
    Policy policy=new Policy(

            getVehicleData(),
            coveredRisksList,
            premiumRisksList,
            coverageRisksList,
            ceilingRisksList,
            validityYear,
            now);
    return policy;

    }

    //Resetting Fields to empty

    private void newCustomer(){

    coverageRisksList.clear();
    coveredRisksList.clear();
    premiumRisksList.clear();
    ceilingRisksList.clear();
    cond1=false;
    cond2=false;
    cond3=false;

//    setTextField to empty
    subFname.setText("");
    subLName.setText("");
    subCity.setText("");
    subPhone.setText("");
    plateNB.setText("");
    model.setText("");
    manufacturer.setText("");
    estimated.setText("");

//    Set radio button selection to none
        G1.clearSelection();
        G2.clearSelection();

        //Reset checkboxes

        obligatoryCHKBX.setSelected(false);
        allRiskCHKBX.setSelected(false);
        dDamageCHKBX.setSelected(false);
        vDamageCHKBX.setSelected(false);
        assistanceCHKBX.setSelected(false);


        dDamageCHKBX.setEnabled(true);
        vDamageCHKBX.setEnabled(true);
        assistanceCHKBX.setEnabled(true);
        obligatoryCHKBX.setEnabled(true);


















    }



    //Search customer By mobil number

    private void SearchCustomerByMobileNumber(){


     File file =new File("E:\\##Java\\###THINGSDONE#\\JAVAMASTERCLASS\\Recap1\\MasterJava001\\" +
            "VEHICLE-INSURANCE-COMPANY\\" +
            "src\\main\\resources\\customerData.dat");


     try {
         InputStream is =new FileInputStream(file);
         ObjectInputStream ois = new ObjectInputStream(is);
         TreeMap <Integer,Customer>mapInFile  =  (TreeMap<Integer,Customer>)ois.readObject();

            ois.close();
            is.close();




              Customer c_finder=mapInFile.get(parseInt(searchTXT.getText()));
              customerTXT.setText(c_finder.toString());






     } catch (FileNotFoundException e) {
         throw new RuntimeException(e);
     } catch (IOException e) {
         throw new RuntimeException(e);
     } catch (ClassNotFoundException e) {
         throw new RuntimeException(e);
     }
     //Search by mobile number




    }

    private Customer claimSearchCustomerByMobileNb(){
    Customer customer =new Customer();

     File file =new File("E:\\##Java\\###THINGSDONE#\\JAVAMASTERCLASS\\Recap1\\MasterJava001\\" +
            "VEHICLE-INSURANCE-COMPANY\\" +
            "src\\main\\resources\\customerData.dat");

     try {
         InputStream is = new FileInputStream(file);
         ObjectInputStream ois = new ObjectInputStream(is);
         TreeMap <Integer,Customer>mapInFile  =  (TreeMap<Integer,Customer>)ois.readObject();

         ois.close();
         is.close();

         customer=mapInFile.get(parseInt(claimingCustomerField.getText()));

     } catch (FileNotFoundException e) {
         throw new RuntimeException(e);
     } catch (IOException e) {
         throw new RuntimeException(e);
     } catch (ClassNotFoundException e) {
         throw new RuntimeException(e);


     }

        return  customer;
    }

    //displayCalculation

    private boolean checkPolicyValidity(LocalDate v_ValidityofPolicy) {

        LocalDate now = LocalDate.now();

        if (now.isBefore(v_ValidityofPolicy)) {
            cond3 = true;
            return true;
        } else {
            cond3 = false;
            return false;
        }

    }

    private boolean claimIsValid(){

        if (cond1==true && cond2==true && cond3==true){


            claimStatusLBL2.setText("Claiming status : You can register your claim ");
            return true;

        }else {
            claimStatusLBL2.setText("Claiming status : You can't register your claim please update your policy ");
            return false;
        }


        }



     private void displayPaymentofPolicy(){
    for (int i=0; i<premiumRisksList.size(); i++){

        totalPremium+=premiumRisksList.get(i);
        totalCoverage+=coverageRisksList.get(i);
        totalCeiling+=ceilingRisksList.get(i);

    }

    settlementArea.setText(
            "Total Premium :" +totalPremium* parseInt(estimated.getText())+ "$ \n"
            + "Risks Coverage :" + totalCoverage* parseInt(estimated.getText())*10 + "$ \n"
            + "Max Ceiling :" + totalCeiling* parseInt(estimated.getText())+100000 + "$ \n");


        }






    //plans

    private void getRiskCoveredbyPlan() {
    }


//Saving and Load data

    //Save Data to disk

    public void saveCustomerMapTodisk() throws IOException, ParseException, ClassNotFoundException {

    File file =new File("E:\\##Java\\###THINGSDONE#\\JAVAMASTERCLASS\\Recap1\\MasterJava001\\" +
            "VEHICLE-INSURANCE-COMPANY\\" +
            "src\\main\\resources\\customerData.dat");

    int platenumber= parseInt(plateNB.getText());

    if (!file.exists()) {
        //creating new File
        System.out.println("File don't exits");
        System.out.println("********************************************************************************************");
        System.out.println(" ");
        System.out.println( "Creating new File now");

        file.createNewFile();
        System.out.println("File Created");

        saveCustomerMapTonewFile(platenumber,file);
    }else{
        TreeMap<Integer,Customer> newMapTosave= new TreeMap<>();
        InputStream is = new FileInputStream(file);
        ObjectInputStream ois=new ObjectInputStream(is);

        TreeMap<Integer,Customer> mapInFile=(TreeMap<Integer, Customer>)ois.readObject();
        ois.close();
        is.close();

        //Get old map

        for (Map.Entry<Integer, Customer> entry : mapInFile.entrySet()) {


            newMapTosave.put(entry.getKey(),entry.getValue());
        }

        //UPDATING THE MAP :ADDING NEW CUSTOMER TO MAP

        try {
            newMapTosave.put(platenumber,getCustomerData());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

//        saving the updates to file

        OutputStream os=new FileOutputStream(file);
        ObjectOutputStream oos= new ObjectOutputStream(os);

        oos.writeObject(newMapTosave);
        oos.flush();
        oos.close();



    }






    }

    private void saveCustomerMapTonewFile(int platenumber, File file) throws ParseException, IOException {

    TreeMap<Integer,Customer> newMapTosave= new TreeMap<>();

    //adding new customer to map

        newMapTosave.put(platenumber,getCustomerData());

        OutputStream os =new FileOutputStream(file);
        ObjectOutputStream oos= new ObjectOutputStream(os);

        oos.writeObject(newMapTosave);
        oos.flush();
        oos.close();












    }


    public static void main (String[] args){
        MainScreen mainScreen=new MainScreen();
        mainScreen.setVisible(true);
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainScreen.setTitle("Insurance Company System");
        mainScreen.setBounds(0,0,1920,1890);
        System.out.println("Program sucessfully launched!  :). ");
    }


}//End class
