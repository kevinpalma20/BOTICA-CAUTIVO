/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entities.Customer;
import entities.Product; 
import Constans.Constan; 
import java.util.Objects;
import java.util.Optional; 
import javax.swing.JOptionPane;
import model.ModelCustomer;
import model.ModelProduct;
import modules.moduleCustomer;
import modules.ModuleProduct;
import modules.moduleSale;
import render.table.Entity.TableModelCart;
import render.table.Entity.TableModelProduct;
import util.Commons; 
import views.alerts.AlertErrors;
import views.alerts.AlertSuccessMessage;
import views.maintenance.category_views;
import views.maintenance.products_views; 
import views.maintenance.user_views;
import views.mydata.ChangePassword;
import views.reports.SalesProductsTop;
import views.reports.ReportSales;

/**
 *
 * @author kpalmall
 */
public class Administration extends javax.swing.JFrame {  
    private final moduleCustomer moduleCustomer;
    private final ModuleProduct modulePorduct;
    
    private final products_views products;
    private final category_views category; 
    private final user_views user; 
    
    private final ChangePassword changePassword;
    
    private final ReportSales reportSales; 
    private final SalesProductsTop reportProducts; 
    
    private moduleSale moduleSale;
    
    private ModelProduct modelproduct = new ModelProduct(); 
    private ModelProduct modelproductstock = new ModelProduct(); 
    private ModelCustomer modelcustomer = new ModelCustomer();
    
    private Integer idStock = 0;
    
    private TableModelProduct tableModelProduct;
    private TableModelCart tableModelCart;

    /**
     * Creates new form Administration
     */
    public Administration() { 
        modulePorduct = new ModuleProduct(); 
        moduleCustomer = new moduleCustomer(); 
        moduleSale = new moduleSale(0.0);
        
        tableModelProduct = new TableModelProduct();
        tableModelCart = new TableModelCart();
                
        products = new products_views();
        category = new category_views();
        user = new user_views();
        
        changePassword = new ChangePassword();
        
        reportSales = new ReportSales();
        reportProducts = new SalesProductsTop();
        
        initComponents();
        
        this.recharge_data();
    }
    
    private void recharge_data(){
        this.tableModelProduct.findAllByStockMin(tblStock);
        this.tableModelProduct.tableProductData(tblProduct);
    }

    private void SetValueProductSelected(ModelProduct model) {
        StringBuilder value = new StringBuilder();
        value.append(model.getName())
                .append(Constan.space)
                .append(model.getBrand());
        
        labelNameProduct1.setText(value.toString());
        labelPrecioProduct1.setText(String.valueOf(model.getPrice()).concat(Constan.money));  
    }

    private void SetValueCustomerSelected(ModelCustomer model) { 
        txtNombreCliente.setText(model.getFirtsname());
        txtApllidoCliente.setText(model.getLastname());
        txtEmailCliente.setText(model.getEmail());
        txtDniCliente.setText(model.getDni().toString());
        txtNumeroCliente.setText(model.getPhone());
    }
    
    private void detail_sale(){
        labelSubTotal.setText(moduleSale.viewDetails().getSubtotal()+"");
        labelTotal.setText(moduleSale.viewDetails().getTotal()+"");
        labelImpuesto.setText(moduleSale.viewDetails().getDesc()+"");
    } 
    
    private void recharge_dataCart(){
        this.detail_sale();
        this.tableModelCart.tableCartData(tblCarrito, 
                this.moduleSale.viewDetails().getCart());
    }
    
    private boolean verifyEmptyInput(){
        String fname = txtNombreCliente.getText();
        String lname = txtApllidoCliente.getText();
        String dni = txtDniCliente.getText();
        String email = txtEmailCliente.getText();
        String phone = txtNumeroCliente.getText();
        
        boolean verify = Commons.StringsIsEmpty(fname, lname, dni, email, phone);
        
        if (verify) AlertErrors.errorMessageVoidData();   
        return verify; 
    }
    
    
    private void clearSale() {
        this.moduleSale.viewDetails().clearCart();
        this.recharge_dataCart();  
        
        moduleSale = new moduleSale(0.0);
        this.clearLabelValueCustomer();
    }
    
    private void clearInputCustomer() {
        txtDniCliente.setText(Constan.empty);
        txtEmailCliente.setText(Constan.empty);
        txtNumeroCliente.setText(Constan.empty);
        txtNombreCliente.setText(Constan.empty);
        txtApllidoCliente.setText(Constan.empty);
    }  
    
    private void SetLabelValueCustomer() { 
        labelNameCliente.setText(txtNombreCliente.getText());  
        labelApellidoCliente.setText(txtApllidoCliente.getText());  
        labelDNICliente.setText(txtDniCliente.getText());  
        labelEmailCliente.setText(txtEmailCliente.getText());  
        labelNumberCliente.setText(txtNumeroCliente.getText()); 
    } 
    
    private void clearLabelValueCustomer() { 
        labelNameCliente.setText(Constan.empty);  
        labelApellidoCliente.setText(Constan.empty);  
        labelDNICliente.setText(Constan.empty);  
        labelEmailCliente.setText(Constan.empty);  
        labelNumberCliente.setText(Constan.empty); 
    } 
    
    private void setStockTable(Integer q, Boolean op) {
        for (int count = 0; count < tblProduct.getRowCount(); count++) {
            Integer idtbl = Commons.StringToInteger(tblProduct.getValueAt(count, 0).toString());
            if (modelproduct.getId().equals(idtbl)) {
                Integer stockbl = Commons.StringToInteger(tblProduct.getValueAt(count, 4).toString());
                tblProduct.setValueAt(op ? stockbl - q : stockbl + q, count, 4);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtBuscarProducto = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jButton9 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        spnCant1 = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        labelNameProduct1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        labelPrecioProduct1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel12 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        labelNameCliente = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        labelApellidoCliente = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        labelEmailCliente = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        labelNumberCliente = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        labelDNICliente = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtBuscarCliente = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jButton4 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtApllidoCliente = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtEmailCliente = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtDniCliente = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtNumeroCliente = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCarrito = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        labelSubTotal = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        labelImpuesto = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        UserId = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblStock = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        myData = new javax.swing.JMenu();
        menuItemProduct2 = new javax.swing.JMenuItem();
        menuMantenimiento = new javax.swing.JMenu();
        menuItemProduct = new javax.swing.JMenuItem();
        menuItemCategory = new javax.swing.JMenuItem();
        menuItemCategory1 = new javax.swing.JMenuItem();
        menuReportes = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("  PRODUCTOS A SELECCIONAR");
        jLabel2.setToolTipText("");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduct);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText(" Buscar por ....");
        jLabel14.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Buscar");
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton9.setText("Agregar");
        jButton9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText(" Nombre");
        jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        labelNameProduct1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelNameProduct1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText(" Precio");
        jLabel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        labelPrecioProduct1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelPrecioProduct1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText(" Cantidad");
        jLabel16.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(spnCant1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelPrecioProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNameProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(178, 178, 178))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spnCant1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNameProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPrecioProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setText("  DATOS DEL CLIENTE");
        jLabel28.setToolTipText("");
        jLabel28.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText(" Nombre:");
        jLabel29.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        labelNameCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelNameCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText(" Apellido:");
        jLabel31.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        labelApellidoCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelApellidoCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setText(" Email:");
        jLabel33.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        labelEmailCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelEmailCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel41.setText(" N??mero:");
        jLabel41.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        labelNumberCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelNumberCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setText(" DNI:");
        jLabel37.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        labelDNICliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelDNICliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNameCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelDNICliente, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelNumberCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNameCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDNICliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNumberCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText(" Buscar cliente por ....");
        jLabel15.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("Buscar");
        jButton4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtBuscarCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText(" Nombre:");
        jLabel23.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtNombreCliente.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText(" Apellido:");
        jLabel24.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtApllidoCliente.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText(" Email:");
        jLabel25.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtEmailCliente.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText(" DNI:");
        jLabel26.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtDniCliente.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText(" N??mero:");
        jLabel27.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtNumeroCliente.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setText("Registrar");
        jButton7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setText("Seleccionar");
        jButton8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtApllidoCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(txtEmailCliente, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(30, 30, 30)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumeroCliente)
                            .addComponent(txtDniCliente)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApllidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Quitar");
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText(" PRODUCTOS AGREGADOS");
        jLabel3.setToolTipText("");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCarrito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCarritoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCarrito);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("  DETALLE DE VENTA");
        jLabel4.setToolTipText("");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Sub total");
        jLabel17.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        labelSubTotal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelSubTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Total");
        jLabel19.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        labelTotal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Descuento");
        jLabel20.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        labelImpuesto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelImpuesto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labelTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(labelSubTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelImpuesto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("CONFIRMAR");
        jButton5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setText("LIMPIAR");
        jButton6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        UserId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        UserId.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText(" PRODUCTOS CON STOCK AL MENOS DEL 10%");
        jLabel5.setToolTipText("");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStockMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblStock);

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton10.setText("ACTUALIZAR STOCK");
        jButton10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton11.setText("AGREGAR DE TODAS FORMAS");
        jButton11.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N

        myData.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        menuItemProduct2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        menuItemProduct2.setText("Cambiar contrase??a");
        menuItemProduct2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemProduct2ActionPerformed(evt);
            }
        });
        myData.add(menuItemProduct2);

        jMenuBar1.add(myData);

        menuMantenimiento.setText("Mantenimientos");
        menuMantenimiento.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        menuItemProduct.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        menuItemProduct.setText("Productos");
        menuItemProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemProductActionPerformed(evt);
            }
        });
        menuMantenimiento.add(menuItemProduct);

        menuItemCategory.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        menuItemCategory.setText("Categorias");
        menuItemCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCategoryActionPerformed(evt);
            }
        });
        menuMantenimiento.add(menuItemCategory);

        menuItemCategory1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        menuItemCategory1.setText("Usuarios");
        menuItemCategory1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCategory1ActionPerformed(evt);
            }
        });
        menuMantenimiento.add(menuItemCategory1);

        jMenuBar1.add(menuMantenimiento);

        menuReportes.setText("Reportes");
        menuReportes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenuItem1.setText("Ventas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuReportes.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenuItem2.setText("Productos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuReportes.add(jMenuItem2);

        jMenuBar1.add(menuReportes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(UserId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(13, 13, 13)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UserId)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCategoryActionPerformed
        // TODO add your handling code here:
        category.setVisible(true);
    }//GEN-LAST:event_menuItemCategoryActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.tableModelProduct.tableProductDataSearch(tblProduct, txtBuscarProducto.getText());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void menuItemProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemProductActionPerformed
        // TODO add your handling code here:
        products.setVisible(true);
    }//GEN-LAST:event_menuItemProductActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        Integer id = modelproduct.getId();
        Optional<Product> productFind = modulePorduct.findById_Products(id);
        
        Integer q = Commons.StringToInteger(spnCant1.getValue().toString());
        Boolean verifyQuantity = (q != -1) && (modelproduct.getStock() > q); 
                    
        if (productFind.isPresent() && verifyQuantity) {  
            this.moduleSale.AddProductToCart(id, q); 
            this.recharge_dataCart();
            this.setStockTable(q, Boolean.TRUE);
            modelproduct.setStock(modelproduct.getStock() - q);
            
            this.moduleSale.viewDetails().getCart().forEach(System.out::println);
        } else {
            AlertSuccessMessage.alertSetMessage("Cantidad insuficiente.");
        } 
    }//GEN-LAST:event_jButton9ActionPerformed

    private void tblProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductMouseClicked
        // TODO add your handling code here:
        int row = tblProduct.getSelectedRow();
        int id = Integer.parseInt(tblProduct.getValueAt(row, 0).toString());
        String name = tblProduct.getValueAt(row, 1).toString();
        String brand = tblProduct.getValueAt(row, 2).toString();
        Double price = Double.parseDouble(tblProduct.getValueAt(row, 3).toString());
        
        int stock = Integer.parseInt(tblProduct.getValueAt(row, 4).toString());
        String cat = tblProduct.getValueAt(row, 5).toString();
        
        Boolean state = Commons.StringStateToBoolean(tblProduct.getValueAt(row, 6).toString());

        modelproduct =  ModelProduct.builder()
                .id(id)
                .name(name)
                .brand(brand)
                .price(price)
                .stock(stock)
                .category(cat)
                .state(state)
                .build();
        
        this.SetValueProductSelected(modelproduct);
    }//GEN-LAST:event_tblProductMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Customer findCustomer = moduleCustomer.searchCustomer(txtBuscarCliente.getText());
        
        boolean verifyCUstomer = Objects.nonNull(findCustomer);
        if (verifyCUstomer) {
            
            modelcustomer = ModelCustomer.builder()
                    .id(findCustomer.getId())
                    .firtsname(findCustomer.getFirtsname())
                    .lastname(findCustomer.getLastname())
                    .dni(findCustomer.getDni())
                    .email(findCustomer.getEmail())
                    .phone(findCustomer.getPhone())
                    .build();
            this.SetValueCustomerSelected(modelcustomer); 
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        boolean verify = !this.verifyEmptyInput();
        String mssg = Constan.empty;
        if (verify)  
            mssg = this.moduleCustomer.saveCustomer(0, txtNombreCliente.getText()
                    , txtApllidoCliente.getText(), Commons.StringToInteger(txtDniCliente.getText())
                    , txtEmailCliente.getText(), txtNumeroCliente.getText());  
        
        AlertSuccessMessage.alertSetMessage(mssg);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if (!this.verifyEmptyInput()) { 
            this.SetLabelValueCustomer();
            this.clearInputCustomer();
        }
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Integer id = modelproduct.getId();
        Integer q = this.moduleSale.viewDetails().getCart().stream()
                .filter(predicate -> predicate.getProduct().getId().equals(id))
                .findFirst()
                .get()
                .getQuantity();
        
        this.setStockTable(q, Boolean.FALSE);
        
        modelproduct.setStock(modelproduct.getStock() + q);
        this.moduleSale.viewDetails().removeProduct(id);
        this.recharge_dataCart(); 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Integer id = modelcustomer.getId();
        
        String message = this.moduleSale.confirmSale(Commons.StringToInteger(UserId.getText()), id); 
        AlertSuccessMessage.alertSetMessage(message);
        
        this.recharge_data();
        this.clearSale();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.clearSale();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tblCarritoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCarritoMouseClicked
        // TODO add your handling code here: 
        try {
            int row = tblCarrito.getSelectedRow();
            int id = Integer.parseInt(tblCarrito.getValueAt(row, 0).toString());
            modelproduct.setId(id); 
            
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_tblCarritoMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here: 
        reportSales.setVisible(Boolean.TRUE);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        reportProducts.setVisible(Boolean.TRUE);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void menuItemCategory1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCategory1ActionPerformed
        // TODO add your handling code here:
        user.setVisible(Boolean.TRUE);
    }//GEN-LAST:event_menuItemCategory1ActionPerformed

    private void menuItemProduct2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemProduct2ActionPerformed
        // TODO add your handling code here:
        changePassword.setVisible(Boolean.TRUE);
    }//GEN-LAST:event_menuItemProduct2ActionPerformed

    private void tblStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStockMouseClicked
        // TODO add your handling code here:
        int row = tblStock.getSelectedRow();
        this.idStock = Integer.parseInt(tblStock.getValueAt(row, 0).toString());
        String name = tblStock.getValueAt(row, 1).toString();
        Double price = Double.parseDouble(tblStock.getValueAt(row, 2).toString());
        Integer stock = Integer.parseInt(tblStock.getValueAt(row, 3).toString());
        String cat = tblStock.getValueAt(row, 4).toString();
        
        modelproductstock.setId(this.idStock);
        modelproductstock.setName(name);
        modelproductstock.setPrice(price);
        modelproductstock.setStock(stock);
        modelproductstock.setCategory(cat);
        
        this.SetValueProductSelected(modelproductstock);
    }//GEN-LAST:event_tblStockMouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        String msg;
        try {
            Integer quantity = Integer
                .parseInt(JOptionPane.showInputDialog("Ingrese al cantidad:"));
        
            msg = this.modulePorduct.addStock(this.idStock, quantity);
        } catch (Exception e) {
            msg = e.getMessage();
        }
        
        JOptionPane.showMessageDialog(null, msg);
        this.recharge_data();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here: 
        Integer id = modelproductstock.getId();
        Optional<Product> productFind = modulePorduct.findById_Products(id);
        
        Integer q = Commons.StringToInteger(spnCant1.getValue().toString());
        Boolean verifyQuantity = (q > 0) && (modelproductstock.getStock() >= q); 
                    
        if (productFind.isPresent() && verifyQuantity) {  
            this.moduleSale.AddProductToCart(id, q); 
            this.recharge_dataCart();
            this.setStockTable(q, Boolean.TRUE);
            modelproductstock.setStock(modelproductstock.getStock() - q);
            
            this.moduleSale.viewDetails().getCart().forEach(System.out::println);
        } else {
            AlertSuccessMessage.alertSetMessage("Cantidad insuficiente.");
        } 
    }//GEN-LAST:event_jButton11ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Administration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel UserId;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel labelApellidoCliente;
    private javax.swing.JLabel labelDNICliente;
    private javax.swing.JLabel labelEmailCliente;
    private javax.swing.JLabel labelImpuesto;
    private javax.swing.JLabel labelNameCliente;
    private javax.swing.JLabel labelNameProduct1;
    private javax.swing.JLabel labelNumberCliente;
    private javax.swing.JLabel labelPrecioProduct1;
    private javax.swing.JLabel labelSubTotal;
    private javax.swing.JLabel labelTotal;
    public static javax.swing.JMenuItem menuItemCategory;
    public static javax.swing.JMenuItem menuItemCategory1;
    public static javax.swing.JMenuItem menuItemProduct;
    public static javax.swing.JMenuItem menuItemProduct2;
    public static javax.swing.JMenu menuMantenimiento;
    public static javax.swing.JMenu menuReportes;
    public static javax.swing.JMenu myData;
    private javax.swing.JSpinner spnCant1;
    private javax.swing.JTable tblCarrito;
    public static javax.swing.JTable tblProduct;
    private javax.swing.JTable tblStock;
    private javax.swing.JTextField txtApllidoCliente;
    private javax.swing.JTextField txtBuscarCliente;
    private javax.swing.JTextField txtBuscarProducto;
    private javax.swing.JTextField txtDniCliente;
    private javax.swing.JTextField txtEmailCliente;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNumeroCliente;
    // End of variables declaration//GEN-END:variables
}
