
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class oilprice extends javax.swing.JFrame {

    /**
     * Creates new form oilprice
     */
    Connection conn=null;
    Statement st=null;
    ResultSet rs=null;
    String pass=null;
     double current_reading;
    double old_reading;
    double sum_reading;
     double starting_id;
     double ending_id;
     double sales_reading;
     double not_bill_reading;
     double current_amount;
     double old_amount,sales_amount;
     int b;
      String o="0";
    public oilprice() {
        conn=DBconnect.connect();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("OIL PRICE");
        setBounds(new java.awt.Rectangle(500, 300, 400, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 204));
        jLabel2.setText("OIL PRICE  :");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Rs/ltr.");

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 204));
        jButton1.setText("UPDATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(185, 185, 185))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(49, 49, 49)
                .addComponent(jButton1)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         String qry150="update check_status set oil='"+o+"' ";
         PreparedStatement pst;
            try {
                pst = conn.prepareStatement(qry150);
                 pst.executeUpdate();
                 
            } catch (SQLException ex) {
              Logger.getLogger(shift_open.class.getName()).log(Level.SEVERE, null, ex);
          }
         String qry="update prices set oil='"+(jTextField1.getText())+"'";
         
         try { 
              pst=conn.prepareStatement(qry);
             pst.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(userremove.class.getName()).log(Level.SEVERE, null, ex);
        }
         
          this.create();
         
         JOptionPane.showMessageDialog(null,"Updated Successfully");
          this.setVisible(false);
          new home().setVisible(true);
                               
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
         new home().setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    public void create(){
          String qry24="select shift_id from shift order by shift_id desc limit 1";
        try {
            st=conn.createStatement();
             rs=st.executeQuery(qry24);
            rs.next();
            b=rs.getInt("shift_id");
        } catch (SQLException ex) {
            Logger.getLogger(petrolprice.class.getName()).log(Level.SEVERE, null, ex);
        }
       String qry="Select sum(current_reading) as oil_sum from oil_updation";
        String qry1="Select sum(current_reading) as oil_sum from reading_oil";
        try {
            st=conn.createStatement();
            rs=st.executeQuery(qry);
            rs.next();
           String s= ""+rs.getString("oil_sum");
            current_reading =Double.parseDouble(s);
            System.out.println(current_reading);
            
            String qry10="update shift set old_reading_oil='"+current_reading+"' where shift_id='"+b+"' ";
             PreparedStatement pst=conn.prepareStatement(qry10);
             pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(petrolprice.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            st=conn.createStatement();
            rs=st.executeQuery(qry1);
            rs.next();
           String s= ""+rs.getString("oil_sum");
            old_reading =Double.parseDouble(s);
            System.out.println(old_reading);
           
        } catch (SQLException ex) {
            Logger.getLogger(petrolprice.class.getName()).log(Level.SEVERE, null, ex);
        }
       sum_reading=(current_reading-old_reading);
       System.out.println(sum_reading);
       String qry18="update shift set starting_oil='"+(old_reading)+"' where shift_id='"+b+"'";
          try { 
             PreparedStatement pst=conn.prepareStatement(qry18);
             pst.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(userremove.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         String qry2="select starting_sales_id from shift order by starting_sales_id desc limit 1";
          try {
              st=conn.createStatement();
              rs=st.executeQuery(qry2);
              
              if(!rs.next()){
                   starting_id=0;
                   System.out.println("No data");
              }else 
              {
                                                
                starting_id=rs.getDouble("starting_sales_id");
                
                  System.out.println(starting_id);
                  String qry3="select bill_id from sales order by bill_id desc limit 1";
                   st=conn.createStatement();
              rs=st.executeQuery(qry3);
              rs.next();
              ending_id=rs.getDouble("bill_id");
              System.out.println(ending_id);
                  String qry4="select sum(volume) as sum_volume  from sales where bill_id between '"+starting_id+"' and '"+ending_id+"' and item='oil'";                
             rs=st.executeQuery(qry4);
              rs.next();
              sales_reading=rs.getDouble("sum_volume");
              System.out.println(sales_reading);
             String qry31="select sum(amount) as sum_amount  from sales where bill_id between '"+starting_id+"' and '"+ending_id+"' and item='oil'";                
             rs=st.executeQuery(qry31);
              rs.next();
              sales_amount=rs.getDouble("sum_amount");
              System.out.println(sales_amount);
              not_bill_reading=(sum_reading-sales_reading);
              System.out.println(not_bill_reading);
              String qry5="select oil from temp_prices ";
               st=conn.createStatement();
              rs=st.executeQuery(qry5);
              rs.next();
              old_amount=rs.getDouble("oil");
              current_amount=(not_bill_reading*old_amount);
              System.out.println(current_amount);
               String qry29="update shift set bill_reading_oil='"+(sales_reading)+"' where shift_id='"+b+"'";
              PreparedStatement pst=conn.prepareStatement(qry29);
             pst.executeUpdate();
              String qry30="update shift set not_bill_reading_oil='"+(not_bill_reading)+"' where shift_id='"+b+"'";
               pst=conn.prepareStatement(qry30);
             pst.executeUpdate();
              String qry32="update shift set bill_oil_amount='"+(sales_amount)+"' where shift_id='"+b+"'";
               pst=conn.prepareStatement(qry32);
             pst.executeUpdate();
              String qry33="update shift set not_bill_oil_amount='"+(current_amount)+"' where shift_id='"+b+"'";
               pst=conn.prepareStatement(qry33);
             pst.executeUpdate();
              
              }
          } catch (SQLException ex) {
              Logger.getLogger(shift_open.class.getName()).log(Level.SEVERE, null, ex);
          }
          
        
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(oilprice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(oilprice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(oilprice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(oilprice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              // new oilprice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
