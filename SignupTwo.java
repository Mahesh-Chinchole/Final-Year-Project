package bank.management.system;
import java.awt.Color;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener{
    
    
    JTextField pan,aadhar;
    JButton next;
    JRadioButton male,female,other,married,unmarried;
    JComboBox religion,catagory,occupation,education,income;
    String formno;
    
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
         setTitle("NEW APPLICATION FORM- PAGE 2");
        
        
        JLabel additionalDetails =new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel name=new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        String []valreligion={"Hindu","Sikh","Muslim","Christain"};
             religion=new JComboBox(valreligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
         
       
        JLabel fname=new JLabel("Catagory:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
         String []valcatagory={"General","OBC","OPEN","SC","ST"};
              catagory=new JComboBox(valcatagory);
         catagory.setBounds(300,190,400,30);
         catagory.setBackground(Color.WHITE);
         add(catagory);
        
        
        JLabel dob=new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        String []incomecatagory={"Null","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000"};
              income=new JComboBox(incomecatagory);
         income.setBounds(300,190,400,30);
         income.setBackground(Color.WHITE);
         add(income);
        
       
        
        JLabel gender=new JLabel("Educational:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        JLabel email=new JLabel("Qualification:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,315,200,30);
        add(email);
        
        String [] educationlValue={"Non-Graduation","Graduate","Post-Graduation","Doctrate","Other"};
            education=new JComboBox(educationlValue);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);
        
        
        
        JLabel marital=new JLabel("Occupation:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
        String [] occupaionlValue={"Salaried","Self-Employed","Bussiness","Student","Rectire","Other"};
             occupation=new JComboBox(occupaionlValue);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        
         
        JLabel address=new JLabel("PAN Number :");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
         pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);
       
        JLabel city=new JLabel("Adhar No :");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
         
          aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
       aadhar.setBounds(300,490,400,30);
        add(aadhar);
//       
//        JLabel state=new JLabel("State :");
//        state.setFont(new Font("Raleway",Font.BOLD,20));
//        state.setBounds(100,540,200,30);
//        add(state);
//        
//        JTextField  stateTextField=new JTextField();
//        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
//        stateTextField.setBounds(300,540,400,30);
//        add(stateTextField);
//        
//        JLabel pincode=new JLabel("Pin Code :");
//        pincode.setFont(new Font("Raleway",Font.BOLD,20));
//        pincode.setBounds(100,590,200,30);
//        add(pincode);
//        
//        JTextField  pincodeTextField=new JTextField();
//        pincodeTextField.setFont(new Font("Raleway",Font.BOLD,14));
//        pincodeTextField.setBounds(300,590,400,30);
//        add(pincodeTextField);
//       
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(300,540,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        
        String sreligion=(String)religion.getSelectedItem();
        String scatagory=(String) catagory.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String) education.getSelectedItem();
        String soccupation=(String) occupation.getSelectedItem();
      
        
       
        
        String span=pan.getText();
        String saadhar=aadhar.getText();
        
        try{

               Conn c=new Conn();
                String query="insert into signup2 values('"+formno+"','"+sreligion+"','"+scatagory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"')";
                c.s.executeUpdate(query);
            
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String []args)
    {
        new SignupTwo("");
    }
    
}

