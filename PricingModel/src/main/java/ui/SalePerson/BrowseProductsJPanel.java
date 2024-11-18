
package ui.SalePerson;


import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.Business.Business;
import model.CustomerManagement.CustomerProfile;
import model.OrderManagement.MasterOrderList;
import model.OrderManagement.CurrentOrder;
import model.OrderManagement.OrderItem;
import model.ProductManagement.Product;
import model.SalesManagement.SalesPersonProfile;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;



/**
 *
 * @author Shivani
 */
public class BrowseProductsJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    Business business;
    CurrentOrder currentOrder;
    CustomerProfile customerProfile;
    SalesPersonProfile salesPersonProfile;
    
    /** Creates new form BrowseProducts */


    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */

    BrowseProductsJPanel(JPanel userProcessContainer, Business business, SalesPersonProfile salesPersonProfile, CustomerProfile customerProfile) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business =business;
        this.currentOrder = new CurrentOrder(customerProfile,salesPersonProfile);
        this.customerProfile =customerProfile;
        this.salesPersonProfile = salesPersonProfile;
        populateCombo();
//        populateCustCombo();
        populateProductTable();
        populateCartTable();
    }



    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        lblSupplier = new javax.swing.JLabel();
        cmbSupplier = new javax.swing.JComboBox();
        txtSearch = new javax.swing.JTextField();
        btnSearchProduct = new javax.swing.JButton();
        lblProductCatalogue = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductCatalog = new javax.swing.JTable();
        lblSalesPrice = new javax.swing.JLabel();
        txtSalesPrice = new javax.swing.JTextField();
        lblQuantity = new javax.swing.JLabel();
        spnQuantity = new javax.swing.JSpinner();
        btnAddToCart = new javax.swing.JButton();
        btnProductDetails = new javax.swing.JButton();
        lblItemsInCart = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCart = new javax.swing.JTable();
        btnViewOrderItem = new javax.swing.JButton();
        btnRemoveOrderItem = new javax.swing.JButton();
        btnCheckOut = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(219, 247, 255));
        setPreferredSize(new java.awt.Dimension(650, 600));

        btnBack.setFont(new java.awt.Font("Noto Sans Batak", 0, 12)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblSupplier.setFont(new java.awt.Font("Noto Sans Batak", 0, 12)); // NOI18N
        lblSupplier.setText("Supplier:");

        cmbSupplier.setFont(new java.awt.Font("Noto Sans Batak", 0, 12)); // NOI18N
        cmbSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSupplierActionPerformed(evt);
            }
        });

        btnSearchProduct.setFont(new java.awt.Font("Noto Sans Batak", 0, 12)); // NOI18N
        btnSearchProduct.setText("Search Product");
        btnSearchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchProductActionPerformed(evt);
            }
        });

        lblProductCatalogue.setFont(new java.awt.Font("Noto Sans Batak", 0, 12)); // NOI18N
        lblProductCatalogue.setText("Product Catalog:");

        tblProductCatalog.setFont(new java.awt.Font("Noto Sans Batak", 0, 12)); // NOI18N
        tblProductCatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Floor Price", "Target Price", "ceiling Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductCatalog.setColumnSelectionAllowed(true);
        tblProductCatalog.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblProductCatalog);
        tblProductCatalog.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        lblSalesPrice.setFont(new java.awt.Font("Noto Sans Batak", 0, 12)); // NOI18N
        lblSalesPrice.setText("Actual Price:");

        lblQuantity.setFont(new java.awt.Font("Noto Sans Batak", 0, 12)); // NOI18N
        lblQuantity.setText("Quantity:");

        spnQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        btnAddToCart.setFont(new java.awt.Font("Noto Sans Batak", 0, 12)); // NOI18N
        btnAddToCart.setText("Add to Cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });

        btnProductDetails.setFont(new java.awt.Font("Noto Sans Batak", 0, 12)); // NOI18N
        btnProductDetails.setText("View Product Details");
        btnProductDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductDetailsActionPerformed(evt);
            }
        });

        lblItemsInCart.setFont(new java.awt.Font("Noto Sans Batak", 0, 12)); // NOI18N
        lblItemsInCart.setText("Items in cart:");

        tblCart.setFont(new java.awt.Font("Noto Sans Batak", 0, 12)); // NOI18N
        tblCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item Name", "Price", "Quantity", "Total Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblCart);

        btnViewOrderItem.setFont(new java.awt.Font("Noto Sans Batak", 0, 12)); // NOI18N
        btnViewOrderItem.setText("View Item");
        btnViewOrderItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewOrderItemActionPerformed(evt);
            }
        });

        btnRemoveOrderItem.setFont(new java.awt.Font("Noto Sans Batak", 0, 12)); // NOI18N
        btnRemoveOrderItem.setText("Remove");
        btnRemoveOrderItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveOrderItemActionPerformed(evt);
            }
        });

        btnCheckOut.setFont(new java.awt.Font("Noto Sans Batak", 0, 12)); // NOI18N
        btnCheckOut.setText("Check Out");
        btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Noto Sans Batak", 1, 18)); // NOI18N
        jLabel1.setText("Add to Cart...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                        .addComponent(lblItemsInCart)
                        .addComponent(jScrollPane2)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblSalesPrice)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSalesPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblQuantity)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(btnAddToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnProductDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblProductCatalogue)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnSearchProduct)))
                            .addGap(8, 8, 8)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnViewOrderItem)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveOrderItem)
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jLabel1)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {spnQuantity, txtSalesPrice});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnBack)
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductCatalogue)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSalesPrice)
                    .addComponent(txtSalesPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuantity)
                    .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddToCart)
                    .addComponent(btnProductDetails))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblItemsInCart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewOrderItem)
                    .addComponent(btnRemoveOrderItem))
                .addGap(18, 18, 18)
                .addComponent(btnCheckOut)
                .addGap(31, 31, 31))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane1, jScrollPane2});

    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnProductDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductDetailsActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = tblProductCatalog.getSelectedRow();
        if(selectedRowIndex<0){
            JOptionPane.showMessageDialog(this,"Please select the product");
        }
        Product product = (Product) tblProductCatalog.getValueAt(selectedRowIndex, 0);
        ViewProductDetailJPanel vpdp = new ViewProductDetailJPanel(userProcessContainer, product);
        userProcessContainer.add("ViewProductDetailJPanel", vpdp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_btnProductDetailsActionPerformed

    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed
        // TODO add your handling code here:
        business.getMasterOrderList().newOrder(customerProfile,salesPersonProfile,currentOrder);
        currentOrder = new CurrentOrder(customerProfile,salesPersonProfile);
        populateCartTable();
        populateProductTable();
        populateCombo();
        txtSearch.setText("");
        txtSalesPrice.setText("");
        spnQuantity.setValue(0);
        JOptionPane.showMessageDialog(this,"Thank you for shopping! See you again!");

    }//GEN-LAST:event_btnCheckOutActionPerformed

    private void btnSearchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchProductActionPerformed
        String productName = txtSearch.getText();
        populateProductTable(productName);
        txtSearch.setText("");
    }//GEN-LAST:event_btnSearchProductActionPerformed

    private void btnRemoveOrderItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveOrderItemActionPerformed
       int selectedRowIndex = tblCart.getSelectedRow();
        if(selectedRowIndex<0){
            JOptionPane.showMessageDialog(this,"Please select the order item");
        }
        OrderItem item = (OrderItem) tblCart.getValueAt(selectedRowIndex, 0);
        int quantity = 0;
        
//        item.getSelectedProduct().setAvail(item.getSelectedProduct().getAvail()+item.getQuantity());
        currentOrder.deleteItem(item);
       populateCartTable();
       populateProductTable();
    }//GEN-LAST:event_btnRemoveOrderItemActionPerformed

    private void btnViewOrderItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewOrderItemActionPerformed
        int selectedRowIndex = tblCart.getSelectedRow();
        if(selectedRowIndex<0){
            JOptionPane.showMessageDialog(this,"Please select the order item");
        }
        OrderItem item = (OrderItem) tblCart.getValueAt(selectedRowIndex, 0);
        ViewOrderItemDetailJPanel voip = new ViewOrderItemDetailJPanel(userProcessContainer, item);
        userProcessContainer.add("BrowseProductsJPanel", voip);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewOrderItemActionPerformed

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        // TODO add your handling code here:
        try{
            int selectedRowIndex = tblProductCatalog.getSelectedRow();
            if(selectedRowIndex<0){
                JOptionPane.showMessageDialog(this,"Please select the product");
            }

            Product product = (Product) tblProductCatalog.getValueAt(selectedRowIndex, 0);
            System.out.println("product name: "+product);
            int actualPrice =0;
            int quantity = 0;
            try{ 
                actualPrice = Integer.parseInt(txtSalesPrice.getText());
                quantity =(Integer) spnQuantity.getValue();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,"Please check the price and quantity fields");
                return;
            }
            if(actualPrice<product.getFloorPrice()){
                JOptionPane.showMessageDialog(this, "price should be more than floor price. ");
                return;
            }
            OrderItem item = currentOrder.findProduct(product);
            if(item == null){
                    currentOrder.newOrderItem(product,actualPrice, quantity);
            }else{
                int oldQuantity =item.getQuantity();
                item.setQuantity(quantity+oldQuantity);
            }

            populateProductTable();
            populateCartTable();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error occured: Please check your fields first");
        }
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void cmbSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSupplierActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cmbSupplierActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JButton btnProductDetails;
    private javax.swing.JButton btnRemoveOrderItem;
    private javax.swing.JButton btnSearchProduct;
    private javax.swing.JButton btnViewOrderItem;
    private javax.swing.JComboBox cmbSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblItemsInCart;
    private javax.swing.JLabel lblProductCatalogue;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblSalesPrice;
    private javax.swing.JLabel lblSupplier;
    private javax.swing.JSpinner spnQuantity;
    private javax.swing.JTable tblCart;
    private javax.swing.JTable tblProductCatalog;
    private javax.swing.JTextField txtSalesPrice;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void populateCombo() {
        cmbSupplier.removeAllItems();
        for (Supplier s: business.getSupplierDirectory().getSuplierList()){
            cmbSupplier.addItem(s);
        }
    }
    private void populateProductTable() {
        Supplier SelectedSupplier =(Supplier) cmbSupplier.getSelectedItem();
        if(SelectedSupplier ==null){
            return;
        }
        
        DefaultTableModel model = (DefaultTableModel) tblProductCatalog.getModel();
        model.setRowCount(0);

        for (Product p : SelectedSupplier.getProductcatalog().getProductList()) {
            Object row[] = new Object[4];
            row[0] = p;
            row[1] = p.getFloorPrice();
            row[2] = p.getTargetPrice();
            row[3] = p.getCeilingPrice();
            model.addRow(row);
        }
    }

    private void populateProductTable(String keyword) {
        
        
        DefaultTableModel model = (DefaultTableModel) tblProductCatalog.getModel();
        model.setRowCount(0);
        for (Supplier s:business.getSupplierDirectory().getSuplierList()){
            for (Product p : s.getProductcatalog().getProductList()) {
                if(p.getName().equalsIgnoreCase(keyword)){
                    Object row[] = new Object[4];
                    row[0] = p;
                    row[1] = p.getFloorPrice();
                    row[2] = p.getTargetPrice();
                    row[3] = p.getCeilingPrice();
                    model.addRow(row);
                }
            }
        }
    }

    private void populateCartTable() {
        
        DefaultTableModel model = (DefaultTableModel) tblCart.getModel();
        model.setRowCount(0);

        for (OrderItem oi : currentOrder.getOrderitems()) {
            Object row[] = new Object[4];
            row[0] = oi;
            row[1] = oi.getActualPrice();
            row[2] = oi.getQuantity();
            row[3] = oi.getQuantity()*oi.getActualPrice();
            model.addRow(row);
        }
    }

   
}
