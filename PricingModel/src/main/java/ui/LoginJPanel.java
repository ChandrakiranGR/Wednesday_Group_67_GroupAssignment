/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

//import UserInterface.WorkAreas.AdminRole.AdminRoleWorkAreaJPanel;
//import UserInterface.WorkAreas.FacultyRole.FacultyWorkAreaJPanel;
//import UserInterface.WorkAreas.StudentRole.StudentWorkAreaJPanel;
//import info5100.university.UserAccounts.UserAccount;
//import info5100.university.UserAccounts.UserAccountDirectory;
//import info5100.university.example.Department.Department;
//import info5100.university.example.Persona.AdminProfile;
//import info5100.university.example.Persona.Faculty.FacultyProfile;
//import info5100.university.example.Persona.Profile;
//import info5100.university.example.Persona.StudentProfile;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Business.Business;
import model.Personnel.EmployeeProfile;
import model.Personnel.Profile;
import model.SalesManagement.SalesPersonProfile;
import model.UserAccountManagement.UserAccount;
import model.UserAccountManagement.UserAccountDirectory;
import ui.Admin.AdminWorkArea;
import ui.SalePerson.SalesPersonWorkAreaJPanel;

/**
 *
 * @author chandrakiran
 */
public class LoginJPanel extends javax.swing.JPanel {

    /**
     * Creates new form LoginJPanel
     */
    Business business;
    JPanel WorkAreaJPanel;
    public LoginJPanel(JPanel mainworkareaJPanel, Business b) {
        initComponents();
        business = b;
        WorkAreaJPanel = mainworkareaJPanel;
        
    }
    
    public LoginJPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUserName = new javax.swing.JLabel();
        txtUserNameField = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        lblApplicationLogin = new javax.swing.JLabel();
        txtPasswordField = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(204, 204, 255));

        lblUserName.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        lblUserName.setText("User Name:");

        txtUserNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameFieldActionPerformed(evt);
            }
        });

        lblPassword.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        lblPassword.setText("Password:");

        btnLogin.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginLoginButtonActionPerformed(evt);
            }
        });

        lblApplicationLogin.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblApplicationLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApplicationLogin.setText("PRICING APPLICATION LOGIN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lblApplicationLogin))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPasswordField)
                            .addComponent(txtUserNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(345, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtPasswordField, txtUserNameField});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblApplicationLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserName)
                    .addComponent(txtUserNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnLogin, lblPassword, lblUserName, txtPasswordField, txtUserNameField});

    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginLoginButtonActionPerformed
        // TODO add your handling code here:
        //      WorkAreaJPanel ura = new WorkAreaJPanel(workareajpanl);

        String un = txtUserNameField.getText();
        String pw = String.valueOf(txtPasswordField.getPassword());

        UserAccountDirectory uad = business.getUserAccountDirectory();
        UserAccount useraccount = uad.AuthenticateUser(un, pw);
        if (useraccount == null) {
            JOptionPane.showMessageDialog(null,"Enter valid UserName or Password.");
            return;
        }
        AdminWorkArea adminWorkArea;
        SalesPersonWorkAreaJPanel salesPersonWorkAreaJPanel;
        //String r = useraccount.getRole();
        Profile profile = useraccount.getAssociatedPersonProfile();

        if (profile instanceof EmployeeProfile) {

            adminWorkArea = new AdminWorkArea(WorkAreaJPanel, business);
            WorkAreaJPanel.add("AdminWorkAreaJPanel", adminWorkArea);
            ((java.awt.CardLayout) WorkAreaJPanel.getLayout()).next(WorkAreaJPanel);
        }

        if (profile instanceof SalesPersonProfile) {
            SalesPersonProfile sp = (SalesPersonProfile) profile;
            SalesPersonWorkAreaJPanel spwa = new SalesPersonWorkAreaJPanel( WorkAreaJPanel,  business,  sp);
            WorkAreaJPanel.add("SalesPersonWorkAreaJPanel", spwa);
            ((java.awt.CardLayout) WorkAreaJPanel.getLayout()).next(WorkAreaJPanel);

        }
        
        //  if (profile instanceof StudentProfile) {
//            StudentProfile spp = (StudentProfile) profile;
//            studentworkareajpanel = new StudentWorkAreaJPanel(business, spp, mainWorkArea);
//            //processStackjPanel.removeAll();
//            mainWorkArea.add("student", studentworkareajpanel);
//            ((java.awt.CardLayout) mainWorkArea.getLayout()).next(mainWorkArea);
//
//        }
        txtPasswordField.setText("");
        txtUserNameField.setText("");
        
    }//GEN-LAST:event_btnLoginLoginButtonActionPerformed

    private void txtUserNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserNameFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblApplicationLogin;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPasswordField txtPasswordField;
    private javax.swing.JTextField txtUserNameField;
    // End of variables declaration//GEN-END:variables
}