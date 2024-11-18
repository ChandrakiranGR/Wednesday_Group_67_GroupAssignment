/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Admin;

import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.ProductManagement.Product;
import model.ProductManagement.ProductCatalog;
import model.Supplier.Supplier;


/**
 *
 * @author vish
 */
public class AddProductJPanel extends javax.swing.JPanel {
    
JPanel userProcessContainer;
    Product product;
    Supplier supplier;
    /**
     * Creates new form AddProductJPanel
     */
    public AddProductJPanel(JPanel upc, Supplier s) {
        initComponents();
         this.userProcessContainer = upc;
        this.supplier = s;
    }

   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        txtTargetPrice = new javax.swing.JTextField();
        lblTargetPrice = new javax.swing.JLabel();
        txtProdName = new javax.swing.JTextField();
        lblProdName = new javax.swing.JLabel();
        txtCeilingPrice = new javax.swing.JTextField();
        lblCeilingPrice = new javax.swing.JLabel();
        lblFloorPrice = new javax.swing.JLabel();
        txtFloorPrice = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(219, 247, 255));

        jLabel1.setFont(new java.awt.Font("Noto Sans Batak", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NEW PRODUCT INFORMATION");

        btnAdd.setBackground(java.awt.Color.lightGray);
        btnAdd.setForeground(java.awt.Color.darkGray);
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblTargetPrice.setFont(new java.awt.Font("Noto Sans Batak", 0, 13)); // NOI18N
        lblTargetPrice.setText("Target Price");

        lblProdName.setFont(new java.awt.Font("Noto Sans Batak", 0, 13)); // NOI18N
        lblProdName.setText("Product Name");

        lblCeilingPrice.setFont(new java.awt.Font("Noto Sans Batak", 0, 13)); // NOI18N
        lblCeilingPrice.setText("Ceiling Price");

        lblFloorPrice.setFont(new java.awt.Font("Noto Sans Batak", 0, 13)); // NOI18N
        lblFloorPrice.setText("Floor Price");

        btnBack.setBackground(java.awt.Color.lightGray);
        btnBack.setForeground(java.awt.Color.darkGray);
        btnBack.setText("< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProdName)
                            .addComponent(lblFloorPrice)
                            .addComponent(lblTargetPrice)
                            .addComponent(lblCeilingPrice))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFloorPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProdName, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTargetPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCeilingPrice)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(223, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnBack)
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProdName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProdName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFloorPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFloorPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTargetPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTargetPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCeilingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCeilingPrice))
                .addGap(30, 30, 30)
                .addComponent(btnAdd)
                .addContainerGap(151, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        int FloorPrice = 0;
        int TargetPrice = 0;
        int Ceilingprice = 0;
        String ProductName;
        ProductCatalog productcatalog = supplier.getProductcatalog();
        try{
           ProductName = txtProdName.getText();
            FloorPrice = Integer.parseInt(txtFloorPrice.getText());
            TargetPrice = Integer.parseInt(txtTargetPrice.getText());
            Ceilingprice = Integer.parseInt(txtCeilingPrice.getText());
            if ((Ceilingprice < FloorPrice)||(FloorPrice>TargetPrice)||(Ceilingprice<TargetPrice)) {
                JOptionPane.showMessageDialog(null, "Please Check Price range", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Please check the format!", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        Product p = productcatalog.newProduct(ProductName, FloorPrice, TargetPrice, Ceilingprice);
        

        JOptionPane.showMessageDialog(null, "Product added successfully!!", "Info", JOptionPane.INFORMATION_MESSAGE);
 
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
          userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ManageProductsJPanel manageProductsJPanel = (ManageProductsJPanel) component;
        manageProductsJPanel.refreshTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCeilingPrice;
    private javax.swing.JLabel lblFloorPrice;
    private javax.swing.JLabel lblProdName;
    private javax.swing.JLabel lblTargetPrice;
    private javax.swing.JTextField txtCeilingPrice;
    private javax.swing.JTextField txtFloorPrice;
    private javax.swing.JTextField txtProdName;
    private javax.swing.JTextField txtTargetPrice;
    // End of variables declaration//GEN-END:variables
}