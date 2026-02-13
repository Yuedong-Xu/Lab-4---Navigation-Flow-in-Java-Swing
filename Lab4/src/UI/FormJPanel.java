/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI;

import Model.User;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.MaskFormatter;
import java.util.Date;
/**
 *
 * @author vincent
 */
public class FormJPanel extends javax.swing.JPanel {
private User currentUser;
private Image selectedPhoto;
    /**
     * Creates new form FormJPanel
     */
    public FormJPanel() {
        initComponents();
        setupComponents();
    }

private void setupComponents() {
    SpinnerNumberModel ageModel = new SpinnerNumberModel(18,0,120,1);
    AgeSpinner.setModel(ageModel);
    try{
        MaskFormatter phoneFormatter = new MaskFormatter("(###) ###-####");
        phoneFormatter.setPlaceholderCharacter('_');
        PhoneFormattedTextField.setFormatterFactory(
        new javax.swing.text.DefaultFormatterFactory(phoneFormatter)
        );
    }
    catch (ParseException e){
        e.printStackTrace();
    }
    
    String[] continents={"Select Continent", "Africa", "Asia", "Europe", "North America", "South America", "Australia", "Antarctica"};
    ContinentComboBox.setModel(new DefaultComboBoxModel<>(continents));
    
    UploadButton.addActionListener(e -> uploadPhoto());
    SubmitButton.addActionListener(e -> registerUser());
   
    
}   
    
    private void uploadPhoto(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image files","jpg","jpeg","png","gif"));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION){
            try{
                File selectedFile = fileChooser.getSelectedFile();
                BufferedImage img = ImageIO.read(selectedFile);
                Image scaledImg = img.getScaledInstance(200,200,Image.SCALE_SMOOTH);
                selectedPhoto = scaledImg;
                JOptionPane.showMessageDialog(this, "Photo uploaded successfully!");

            }catch (IOException ex){
                JOptionPane.showMessageDialog(this,"Error loading image: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void registerUser(){
        if (!validateFields()){
            return;
        }
        String firstname = FirstNameTextField.getText().trim();
        String lastname = LastNameTextField.getText().trim();
        int age =(Integer) AgeSpinner.getValue();
        String email = EmailFormattedTextField.getText().trim();
        String phone = PhoneFormattedTextField.getText().trim();
        String continent = (String) ContinentComboBox.getSelectedItem();
        Date dob = dobChooser.getDate();

        String hobby = HobbyTextArea.getText().trim();
        currentUser = new User(firstname, lastname, age, email, phone, hobby, continent, selectedPhoto, dob);

        JOptionPane.showMessageDialog(this, currentUser.toString(), "Registration Successful", JOptionPane.INFORMATION_MESSAGE);
        java.awt.Container parent = this.getParent();
        while (parent != null && !(parent instanceof MainJFrame)){
            parent = parent.getParent();
        }
        if (parent instanceof MainJFrame mainJFrame){
            mainJFrame.switchToView(currentUser);
        }
    }
    
    private boolean validateFields(){
        StringBuilder errors = new StringBuilder();
        
        if ( FirstNameTextField.getText().trim().isEmpty())
            errors.append("First Name is required\n");
        else if (!FirstNameTextField.getText().trim().matches("[a-zA-Z]+"))
                errors.append("First Name should contain only letters\n");
                if (dobChooser.getDate() == null) {
    errors.append("Date of Birth is required\n");
}

              if ( LastNameTextField.getText().trim().isEmpty())
            errors.append("Last Name is required\n");
              else if (!LastNameTextField.getText().trim().matches("[a-zA-Z]+"))
                errors.append("Last Name should contain only letters\n");  
              int age =(Integer) AgeSpinner.getValue();
          if (age<1 || age>120)
              errors.append("Age must be between 1 and 120\n");
          String email = EmailFormattedTextField.getText().trim();
          if ( email.isEmpty())
            errors.append("Email is required\n");
              else if (!isValidEmail(email))
                errors.append("Email format is invalid\n"); 
          String phone = PhoneFormattedTextField.getText().trim();

if (phone.isEmpty() || phone.contains("_")) {
    errors.append("Phone number is incomplete\n");
}
String hobby = HobbyTextArea.getText().trim();
if (hobby.isEmpty()) {
    errors.append("Hobby is required\n");
}


          if(ContinentComboBox.getSelectedIndex() == 0)
          errors.append("Please select a continent\n");
          if (selectedPhoto == null) {
    errors.append("Please upload a photo\n");
}

          if(errors.length()>0){
              JOptionPane.showMessageDialog(this,"Please fix the following errors:\n\n"+errors.toString(),"Validation Error",JOptionPane.ERROR_MESSAGE);
              return false;
          }
             return true;         
         
    }
    
    private boolean isValidEmail(String email){
        String emailRegex="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return Pattern.matches(emailRegex, email);
               
    }
    public User getCurrentUser(){
        
        return currentUser;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RegistrationLabel = new javax.swing.JLabel();
        FisrtNameLabel = new javax.swing.JLabel();
        LastNameLabel = new javax.swing.JLabel();
        AgeLabel = new javax.swing.JLabel();
        EmailLabel = new javax.swing.JLabel();
        PhoneLabel = new javax.swing.JLabel();
        HobbyLabel = new javax.swing.JLabel();
        ContinentLabel = new javax.swing.JLabel();
        FirstNameTextField = new javax.swing.JTextField();
        LastNameTextField = new javax.swing.JTextField();
        EmailFormattedTextField = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        HobbyTextArea = new javax.swing.JTextArea();
        ContinentComboBox = new javax.swing.JComboBox<>();
        AgeSpinner = new javax.swing.JSpinner();
        PhoneFormattedTextField = new javax.swing.JFormattedTextField();
        UploadButton = new javax.swing.JButton();
        SubmitButton = new javax.swing.JButton();
        DateOfBirthLabel = new javax.swing.JLabel();
        dobChooser = new com.toedter.calendar.JDateChooser();

        RegistrationLabel.setText("Student Registration");

        FisrtNameLabel.setText("Frist Name:");

        LastNameLabel.setText("Last Name:");

        AgeLabel.setText("Age:");

        EmailLabel.setText("Email:");

        PhoneLabel.setText("Phone:");

        HobbyLabel.setText("Hobby:");

        ContinentLabel.setText("Continent:");

        FirstNameTextField.addActionListener(this::FirstNameTextFieldActionPerformed);

        HobbyTextArea.setColumns(20);
        HobbyTextArea.setRows(5);
        jScrollPane1.setViewportView(HobbyTextArea);

        ContinentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "South America", "North America", "Europe", "Asian", "Africa", "Australia", "Antartica" }));

        UploadButton.setText("Upload");

        SubmitButton.setText("Submit");

        DateOfBirthLabel.setText("Date of Birth:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(337, 337, 337)
                        .addComponent(RegistrationLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EmailLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(HobbyLabel)
                                .addGap(89, 89, 89)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LastNameLabel)
                                            .addComponent(AgeLabel))
                                        .addComponent(FisrtNameLabel))
                                    .addComponent(PhoneLabel)
                                    .addComponent(ContinentLabel)
                                    .addComponent(DateOfBirthLabel))
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ContinentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(PhoneFormattedTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                        .addComponent(EmailFormattedTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(LastNameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(FirstNameTextField, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(dobChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AgeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(333, 333, 333)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SubmitButton)
                            .addComponent(UploadButton))))
                .addContainerGap(314, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(RegistrationLabel)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FisrtNameLabel)
                            .addComponent(FirstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LastNameLabel)
                            .addComponent(LastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AgeLabel)
                            .addComponent(AgeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(DateOfBirthLabel))
                    .addComponent(dobChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmailLabel)
                    .addComponent(EmailFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PhoneLabel)
                    .addComponent(PhoneFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ContinentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ContinentLabel))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HobbyLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(UploadButton)
                .addGap(18, 18, 18)
                .addComponent(SubmitButton)
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void FirstNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FirstNameTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AgeLabel;
    private javax.swing.JSpinner AgeSpinner;
    private javax.swing.JComboBox<String> ContinentComboBox;
    private javax.swing.JLabel ContinentLabel;
    private javax.swing.JLabel DateOfBirthLabel;
    private javax.swing.JFormattedTextField EmailFormattedTextField;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JTextField FirstNameTextField;
    private javax.swing.JLabel FisrtNameLabel;
    private javax.swing.JLabel HobbyLabel;
    private javax.swing.JTextArea HobbyTextArea;
    private javax.swing.JLabel LastNameLabel;
    private javax.swing.JTextField LastNameTextField;
    private javax.swing.JFormattedTextField PhoneFormattedTextField;
    private javax.swing.JLabel PhoneLabel;
    private javax.swing.JLabel RegistrationLabel;
    private javax.swing.JButton SubmitButton;
    private javax.swing.JButton UploadButton;
    private com.toedter.calendar.JDateChooser dobChooser;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
