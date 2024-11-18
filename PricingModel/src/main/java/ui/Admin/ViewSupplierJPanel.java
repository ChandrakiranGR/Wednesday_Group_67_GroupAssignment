package ui.Admin;


import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.ProductManagement.Product;
import model.Supplier.Supplier;

/**
 *
 * @author vish
 */
public class ViewSupplierJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Supplier supplier;
    
    public ViewSupplierJPanel(JPanel controller, Supplier s) {
        initComponents();
        userProcessContainer = controller;
        supplier = s;
        lblSupplierName.setText(s.getName());
        refreshTable();
    }

    public void refreshTable(){
        int rowCount = productCatalog.getRowCount();
        DefaultTableModel model = (DefaultTableModel) productCatalog.getModel();
        for(int i=rowCount - 1;i>=0;i--){
            model.removeRow(i);
        }
        for(Product p: supplier.getProductcatalog().getProductList()){
            Object row[] = new Object[4];
            row[0] = p;
            row[1] = p.getFloorPrice();
            row[2] = p.getTargetPrice();
            row[3] = p.getFloorPrice();
            model.addRow(row);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSupplierName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productCatalog = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(219, 247, 255));

        lblSupplierName.setFont(new java.awt.Font("Noto Sans Batak", 0, 18)); // NOI18N
        lblSupplierName.setText("Supplier Name...");

        productCatalog.setFont(new java.awt.Font("Noto Sans Batak", 0, 12)); // NOI18N
        productCatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Product", "Model", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productCatalog);

        btnBack.setFont(new java.awt.Font("Noto Sans Batak", 0, 12)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(18, 18, 18)
                        .addComponent(lblSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnBack)
                .addGap(51, 51, 51)
                .addComponent(lblSupplierName)
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(219, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
      userProcessContainer.remove(this);
      CardLayout layout = (CardLayout) userProcessContainer.getLayout();
      layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSupplierName;
    private javax.swing.JTable productCatalog;
    // End of variables declaration//GEN-END:variables
}
