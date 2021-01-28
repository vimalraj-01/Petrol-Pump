
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hp
 */
public class vimal_update extends javax.swing.JFrame {

    /**
     * Creates new form vimal_update
     */
     Connection conn=null;
    Statement st=null;
    ResultSet rs=null;
    String pass=null,o,o1,o2,o3,o4,o5,o6,o7,o8,o9,o10,o11,o12,o13;
   String v0,v1,v2,i0,i1,i2;
    double m0,m1,m2,m3,m4,m5,total_amount;
    double l;
    double l1,l2;
    String s11,b2;
    int b;
    int ending_id,starting_id;
    double sales_reading,sum_reading,not_bill_reading,current_reading,total_reading,old_amount,old_amount1,old_amount2,current_amount,starting_petrol,petrol_sales,starting_diesel,diesel_sales,starting_oil,oil_sales,bill_reading_petrol,sales_amount1,sales_amount2,sales_amount3,not_bill_reading_petrol,bill_petrol_amount,not_bill_petrol_amount;
    double bill_reading_diesel,not_bill_reading_diesel, bill_diesel_amount,not_bill_diesel_amount,bill_reading_oil, not_bill_reading_oil,bill_oil_amount,not_bill_oil_amount,total_petrol_amount,total_diesel_amount,total_oil_amount;
    String r="0";
    public vimal_update() {
        conn=DBconnect.connect();
        initComponents();
       jPanel2.setVisible(false);
           jLabel2.setVisible(false);
                  jLabel3.setVisible(false);
                   jLabel4.setVisible(false);
                  jLabel5.setVisible(false);
                   jLabel6.setVisible(false);
                  jLabel7.setVisible(false);
                   jLabel8.setVisible(false);
                  jLabel9.setVisible(false);
          jLabel10.setVisible(false);
                  jLabel11.setVisible(false);
                  jLabel12.setVisible(false);
                  jLabel13.setVisible(false);
                   jLabel14.setVisible(false);
                  jLabel15.setVisible(false);
         String qry0="select ending_sales_id from shift order by ending_sales_id desc limit 1";
         try {
             st=conn.createStatement();
             rs=st.executeQuery(qry0);
            rs.next();
            starting_id=(rs.getInt("ending_sales_id")+1);
        System.out.println("starting_id"+starting_id);
         } catch (SQLException ex) {
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         } 
              
            String qry24="select shift_id from shift order by shift_id desc limit 1";
        try {
            st=conn.createStatement();
             rs=st.executeQuery(qry24);
            rs.next();
            b=rs.getInt("shift_id");
        } catch (SQLException ex) {
            Logger.getLogger(petrolprice.class.getName()).log(Level.SEVERE, null, ex);
        }
         String qry="select * from temp_sales";
         try {
             st=conn.createStatement();
             rs=st.executeQuery(qry);
             rs.next();
              v0=""+rs.getString("petrol");
              v1=""+rs.getString("diesel");
              
              v2=""+rs.getString("oil");
            
               
         } catch (SQLException ex) {
             Logger.getLogger(Billing.class.getName()).log(Level.SEVERE, null, ex);
         }
         String qry10="select * from temp_purchases";
         try {
             st=conn.createStatement();
              rs=st.executeQuery(qry10);
              rs.next();
              i0=""+(rs.getString("petrol"));
              i1=""+(rs.getString("diesel"));
              i2=""+(rs.getString("oil"));
              
         } catch (SQLException ex) {
             Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
         }
           m0=Double.parseDouble(i0);
          m1=Double.parseDouble(i1);
          m2=Double.parseDouble(i2);
           m3=Double.parseDouble(v0);
         m4=Double.parseDouble(v1);
          m5=Double.parseDouble(v2);
        
        this.updation();
         this.updation1();
          this.updation2();
          this.update();
           jTable1.setFont(new Font("Times New Roman",Font.PLAIN,14));
         
         this.update1();
         JTableHeader thd=jTable1.getTableHeader();
        // thd.setBackground(Color.black);
         thd.setForeground(Color.BLUE);
         thd.setFont(new Font("Times New Roman",Font.BOLD,13));
          
         String qry100="select petrol,petrol_amount from  petrol_purchases where id='"+b+"'";
          
         try {
             st=conn.createStatement();
              rs=st.executeQuery(qry100);
              if(!rs.next()){
                
              }
              else{
                   jPanel2.setVisible(true);
                   jLabel2.setVisible(true);
                  jLabel3.setVisible(true);
                 o="petrol";
                 o1=rs.getString("petrol_amount");
                 jLabel2.setText(o);
                  jLabel3.setText(o1);
              }
              
         } catch (SQLException ex) {
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         } 
          String qry101="select diesel,diesel_amount from  diesel_purchases where id='"+b+"'";
          
         try {
             st=conn.createStatement();
              rs=st.executeQuery(qry101);
              if(!rs.next()){
                 
              }
              else{
                  jPanel2.setVisible(true);
                  jLabel4.setVisible(true);
                  jLabel5.setVisible(true);
                 o2="diesel";
                 o3=rs.getString("diesel_amount");
                  jLabel4.setText(o2);
                   jLabel5.setText(o3);
              }
              
         } catch (SQLException ex) {
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         } 
         String qry102="select oil,oil_amount from  oil_purchases where id='"+b+"'";
          
         try {
             st=conn.createStatement();
              rs=st.executeQuery(qry102);
              if(!rs.next()){
                 
              }
              else{
                  jPanel2.setVisible(true);
                  jLabel6.setVisible(true);
                  jLabel7.setVisible(true);
                 o4="oil";
                 o5=rs.getString("oil_amount");
                  jLabel6.setText(o4);
                   jLabel7.setText(o5);
              }
              
         } catch (SQLException ex) {
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         } 
         String qry103="select distilledwater,distilledwater_amount from  distilledwater_purchases where id='"+b+"'";
          
         try {
             st=conn.createStatement();
              rs=st.executeQuery(qry103);
              if(!rs.next()){
                 
              }
              else{
                  jPanel2.setVisible(true);
                  jLabel8.setVisible(true);
                  jLabel9.setVisible(true);
                 o6="distilledwater";
                 o7=rs.getString("distilledwater_amount");
                  jLabel8.setText(o6);
                   jLabel9.setText(o7);
              }
              
         } catch (SQLException ex) {
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         } 
         String qry104="select acid,acid_amount from  acid where id='"+b+"'";
          
         try {
             st=conn.createStatement();
              rs=st.executeQuery(qry104);
              if(!rs.next()){
                 
              }
              else{
                  jPanel2.setVisible(true);
                  jLabel10.setVisible(true);
                  jLabel11.setVisible(true);
                 o8="acid";
                 o9=rs.getString("acid_amount");
                  jLabel10.setText(o8);
                   jLabel11.setText(o9);
              }
              
         } catch (SQLException ex) {
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         } 
         String qry105="select bluecloth,bluecloth_amount from  bluecloth where id='"+b+"'";
          
         try {
             st=conn.createStatement();
              rs=st.executeQuery(qry105);
              if(!rs.next()){
                   
              }
              else{
                  jPanel2.setVisible(true);
                   jLabel12.setVisible(true);
                  jLabel13.setVisible(true);
                 o10="bluecloth";
                 o11=rs.getString("bluecloth_amount");
                  jLabel12.setText(o10);
                   jLabel13.setText(o11);
              }
              
         } catch (SQLException ex) {
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         } 
              String qry106="select yellowcloth,yellowcloth_amount from  yellowcloth where id='"+b+"'";
          
         try {
             st=conn.createStatement();
              rs=st.executeQuery(qry106);
              if(!rs.next()){
                  
              }
              else{
                  jPanel2.setVisible(true);
                   jLabel14.setVisible(true);
                  jLabel15.setVisible(true);
                 o12="yellowcloth";
                 o13=rs.getString("yellowcloth_amount");
                  jLabel14.setText(o12);
                   jLabel15.setText(o13);
              }
              
         } catch (SQLException ex) {
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 204));
        jButton1.setText("CLOSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 153, 153));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 204));
        jButton2.setText("EXIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 204));
        jLabel16.setText("TOTAL AMOUNT  :");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Purchases", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 204));
        jLabel2.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("jLabel3");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 204));
        jLabel4.setText("jLabel4");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("jLabel5");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("jLabel6");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("jLabel7");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("jLabel8");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("jLabel9");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 204));
        jLabel10.setText("jLabel10");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setText("jLabel11");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 204));
        jLabel12.setText("jLabel12");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setText("jLabel13");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 204));
        jLabel14.setText("jLabel14");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setText("jLabel15");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)
                        .addGap(23, 23, 23)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(102, 102, 102))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:S
 String qry150="update check_status set status='"+r+"' ";
          PreparedStatement pst;
            try {
                pst = conn.prepareStatement(qry150);
                 pst.executeUpdate();
                 
            } catch (SQLException ex) {
              Logger.getLogger(shift_open.class.getName()).log(Level.SEVERE, null, ex);
          }
        String qry15="update shift set shift_status='close' where shift_id='"+b+"'";
       
        try {
            pst = conn.prepareStatement(qry15);
            pst.executeUpdate();
        } catch (SQLException ex) { 
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         } 
        String qry16="update temp_prices set petrol='"+old_amount+"'";

        try {
            pst = conn.prepareStatement(qry16);
            pst.executeUpdate();
        } catch (SQLException ex) { 
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         } 
        String qry17="update temp_prices set diesel='"+old_amount1+"'";
       
         try {
             pst = conn.prepareStatement(qry17);
             pst.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         } 
           String qry18="update temp_prices set oil='"+old_amount2+"'";
       
         try {
             pst = conn.prepareStatement(qry18);
             pst.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         } 
       
        this.setVisible(false);
        new home().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new home().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
public void updation(){
         String qry11="select petrol from prices";
         try {
             st=conn.createStatement();
              rs=st.executeQuery(qry11);
            rs.next();
            old_amount=rs.getDouble("petrol");
             System.out.println("amount"+old_amount);
         } catch (SQLException ex) {
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         } 
           
        String qry9="Select sum(current_reading) as petrol_sum from reading_petrol";
        try {
            st=conn.createStatement();
            rs=st.executeQuery(qry9);
            rs.next();
           String s1= ""+rs.getString("petrol_sum");
            current_reading =Double.parseDouble(s1);
            System.out.println("current_reading"+current_reading);
        } catch (SQLException ex) {
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         }
         String qry5="select old_reading_petrol from shift where shift_id='"+b+"' ";
         try {
             st=conn.createStatement();
             rs=st.executeQuery(qry5);
              rs.next();
              sum_reading=rs.getDouble("old_reading_petrol");
              System.out.println("sum_reading"+sum_reading);
         } catch (SQLException ex) {
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         } 
             
        String qry="select bill_id from sales order by bill_id desc limit 1";
         try {
             st=conn.createStatement();
             rs=st.executeQuery(qry);
              rs.next();
              ending_id=rs.getInt("bill_id");
               System.out.println("ending_id"+ending_id);
                  String qry4="select sum(volume) as sum_volume  from sales where bill_id between '"+starting_id+"' and '"+ending_id+"' and item='petrol'";                
             rs=st.executeQuery(qry4);
              rs.next();
              sales_reading=rs.getDouble("sum_volume");
               
              System.out.println("sales_reading"+sales_reading);
              String qry40="select sum(amount) as sum_amount  from sales where bill_id between '"+starting_id+"' and '"+ending_id+"' and item='petrol'";                
             rs=st.executeQuery(qry40);
              rs.next();
              sales_amount1=rs.getDouble("sum_amount");
              total_reading=(current_reading-sum_reading);
              System.out.println("total_reading"+total_reading);
              not_bill_reading=(total_reading-sales_reading);
              System.out.println("not_bill_reading"+not_bill_reading);
               current_amount=(not_bill_reading*old_amount);
              System.out.println("current_amount"+current_amount);
         } catch (SQLException ex) {
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         } 
          String qry20="select starting_petrol from shift where shift_id='"+b+"'"; 
            try {
             st=conn.createStatement();
             st=conn.createStatement();
              rs=st.executeQuery(qry20);
            rs.next();
            starting_petrol=rs.getDouble("starting_petrol");
          System.out.println("starting_petrol"+starting_petrol);   
          petrol_sales=(current_reading-starting_petrol);
          String qry21="update shift set petrol_sales='"+petrol_sales+"' where shift_id='"+b+"'";
          try { 
             PreparedStatement pst=conn.prepareStatement(qry21);
             pst.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(userremove.class.getName()).log(Level.SEVERE, null, ex);
        }
         } catch (SQLException ex) {
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         } 
            String qry35="select bill_reading_petrol from shift where shift_id='"+b+"'"; 
            try {
             st=conn.createStatement();
              rs=st.executeQuery(qry35);
            rs.next();
            bill_reading_petrol=rs.getDouble("bill_reading_petrol");
            sales_reading=(bill_reading_petrol+sales_reading);
             String qry45="update shift set bill_reading_petrol='"+sales_reading+"' where shift_id='"+b+"'";
          
             PreparedStatement pst=conn.prepareStatement(qry45);
             pst.executeUpdate();
            String qry46="select not_bill_reading_petrol from shift where shift_id='"+b+"'"; 
       st=conn.createStatement();
              rs=st.executeQuery(qry46);
            rs.next();
            not_bill_reading_petrol=rs.getDouble("not_bill_reading_petrol");
            not_bill_reading_petrol=(not_bill_reading_petrol+not_bill_reading);
            String qry47="update shift set not_bill_reading_petrol='"+not_bill_reading_petrol+"' where shift_id='"+b+"'";
          
              pst=conn.prepareStatement(qry47);
             pst.executeUpdate();
             l=not_bill_reading_petrol;
             l1=(m3+l);
             s11=""+l1;
              String qry21="update temp_sales set petrol='"+s11+"'";
         try {
             pst = conn.prepareStatement(qry21);
             pst.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(Billing.class.getName()).log(Level.SEVERE, null, ex);
         }
          
                    l2=(m0-l);
              b2=""+l2;
              String qry29="update temp_purchases set petrol='"+b2+"'";
          
         try {
             pst=conn.prepareStatement(qry29);
              pst.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(Billing.class.getName()).log(Level.SEVERE, null, ex);
         }
         
              String qry48="select bill_petrol_amount from shift where shift_id='"+b+"'"; 
       st=conn.createStatement();
              rs=st.executeQuery(qry48);
              rs=st.executeQuery(qry48);
            rs.next();
            bill_petrol_amount=rs.getDouble("bill_petrol_amount");
            bill_petrol_amount=(bill_petrol_amount+sales_amount1);
            String qry49="update shift set bill_petrol_amount='"+bill_petrol_amount+"' where shift_id='"+b+"'";
          
              pst=conn.prepareStatement(qry49);
             pst.executeUpdate();
             String qry50="select not_bill_petrol_amount from shift where shift_id='"+b+"'"; 
       st=conn.createStatement();
              rs=st.executeQuery(qry50);
            rs.next();
            not_bill_petrol_amount=rs.getDouble("not_bill_petrol_amount");
            not_bill_petrol_amount=(not_bill_petrol_amount+current_amount);
            String qry51="update shift set not_bill_petrol_amount='"+not_bill_petrol_amount+"' where shift_id='"+b+"'";
          
              pst=conn.prepareStatement(qry51);
             pst.executeUpdate();
             
             
            } catch (SQLException ex) { 
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         } 
         total_petrol_amount=(bill_petrol_amount+not_bill_petrol_amount);  
         PreparedStatement pst;
          String qry60="update shift set total_petrol_amount='"+total_petrol_amount+"' where shift_id='"+b+"'";
           
         try {
             pst=conn.prepareStatement(qry60);
             pst.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         } 
             
    } 
    public void updation1(){
         String qry11="select diesel from prices";
         try {
             st=conn.createStatement();
              rs=st.executeQuery(qry11);
            rs.next();
            old_amount1=rs.getDouble("diesel");
          System.out.println("old_amount1"+old_amount1);   
         } catch (SQLException ex) {
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         } 
           
        String qry9="Select sum(current_reading) as diesel_sum from reading_diesel";
        try {
            st=conn.createStatement();
            rs=st.executeQuery(qry9);
            rs.next();
           String s1= ""+rs.getString("diesel_sum");
            current_reading =Double.parseDouble(s1);
            System.out.println("current_reading"+current_reading);
        } catch (SQLException ex) { 
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         } 
         String qry5="select old_reading_diesel from shift where shift_id='"+b+"' ";
         try {
             st=conn.createStatement();
             rs=st.executeQuery(qry5);
              rs.next();
              sum_reading=rs.getDouble("old_reading_diesel");
              System.out.println("sum_reading"+sum_reading);
         } catch (SQLException ex) {
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         }
             
        String qry="select bill_id from sales order by bill_id desc limit 1";
         try {
             st=conn.createStatement();
             rs=st.executeQuery(qry);
              rs.next();
              ending_id=rs.getInt("bill_id");
               System.out.println("ending_id"+ending_id);
                  String qry4="select sum(volume) as sum_volume  from sales where bill_id between '"+starting_id+"' and '"+ending_id+"' and item='diesel'";                
             rs=st.executeQuery(qry4);
              rs.next();
              sales_reading=rs.getDouble("sum_volume");
              System.out.println("sales_reading"+sales_reading);
              String qry41="select sum(amount) as sum_amount  from sales where bill_id between '"+starting_id+"' and '"+ending_id+"' and item='diesel'";                
             rs=st.executeQuery(qry41);
              rs.next();
              sales_amount2=rs.getDouble("sum_amount");
              total_reading=(current_reading-sum_reading);
              System.out.println("total_reading"+total_reading);
              not_bill_reading=(total_reading-sales_reading);
              System.out.println("not_bill_reading"+not_bill_reading);
               current_amount=(not_bill_reading*old_amount1);
              System.out.println("current_amount"+current_amount);
         } catch (SQLException ex) {
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         } 
          String qry20="select starting_diesel from shift where shift_id='"+b+"'"; 
            try {
             st=conn.createStatement();
              rs=st.executeQuery(qry20);
            rs.next();
            starting_diesel=rs.getDouble("starting_diesel");
          System.out.println("starting_diesel"+starting_diesel);   
          diesel_sales=(current_reading-starting_diesel);
          String qry21="update shift set diesel_sales='"+diesel_sales+"' where shift_id='"+b+"'";
          try { 
             PreparedStatement pst=conn.prepareStatement(qry21);
             pst.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(userremove.class.getName()).log(Level.SEVERE, null, ex);
        }
         } catch (SQLException ex) {
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         } 
             String qry35="select bill_reading_diesel from shift where shift_id='"+b+"'"; 
            try {
             st=conn.createStatement();
              rs=st.executeQuery(qry35);
            rs.next();
            bill_reading_diesel=rs.getDouble("bill_reading_diesel");
            sales_reading=(bill_reading_diesel+sales_reading);
             String qry45="update shift set bill_reading_diesel='"+sales_reading+"' where shift_id='"+b+"'";
          
             PreparedStatement pst=conn.prepareStatement(qry45);
             pst.executeUpdate();
            String qry46="select not_bill_reading_diesel from shift where shift_id='"+b+"'"; 
       st=conn.createStatement();
              rs=st.executeQuery(qry46);
            rs.next();
            not_bill_reading_diesel=rs.getDouble("not_bill_reading_diesel");
            not_bill_reading_diesel=(not_bill_reading_diesel+not_bill_reading);
            String qry47="update shift set not_bill_reading_diesel='"+not_bill_reading_diesel+"' where shift_id='"+b+"'";
          
              pst=conn.prepareStatement(qry47);
             pst.executeUpdate();
               l=not_bill_reading_diesel;
             l1=(m4+l);
              s11=""+l1;
              String qry21="update temp_sales set diesel='"+s11+"'";
         try {
             pst = conn.prepareStatement(qry21);
             pst.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(Billing.class.getName()).log(Level.SEVERE, null, ex);
         }
          
              l2=(m1-l);
              b2=""+l2;
              String qry29="update temp_purchases set diesel='"+b2+"'";
          
         try {
             pst=conn.prepareStatement(qry29);
              pst.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(Billing.class.getName()).log(Level.SEVERE, null, ex);
         }
              String qry48="select bill_diesel_amount from shift where shift_id='"+b+"'"; 
       st=conn.createStatement();
              rs=st.executeQuery(qry48);
            rs.next();
            bill_diesel_amount=rs.getDouble("bill_diesel_amount");
            bill_diesel_amount=(bill_diesel_amount+sales_amount2);
            String qry49="update shift set bill_diesel_amount='"+bill_diesel_amount+"' where shift_id='"+b+"'";
          
              pst=conn.prepareStatement(qry49);
             pst.executeUpdate();
             String qry50="select not_bill_diesel_amount from shift where shift_id='"+b+"'"; 
       st=conn.createStatement();
              rs=st.executeQuery(qry50);
            rs.next();
            not_bill_diesel_amount=rs.getDouble("not_bill_diesel_amount");
            not_bill_diesel_amount=(not_bill_diesel_amount+current_amount);
            String qry51="update shift set not_bill_diesel_amount='"+not_bill_diesel_amount+"' where shift_id='"+b+"'";
          
              pst=conn.prepareStatement(qry51);
             pst.executeUpdate();
             
            } catch (SQLException ex) { 
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         } 
        total_diesel_amount=(bill_diesel_amount+not_bill_diesel_amount);  
         PreparedStatement pst;
          String qry60="update shift set total_diesel_amount='"+total_diesel_amount+"' where shift_id='"+b+"'";
           
         try {
             pst=conn.prepareStatement(qry60);
             pst.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         }    
        
    }
     public void updation2(){
         String qry11="select oil from prices";
         try {
             st=conn.createStatement();
              rs=st.executeQuery(qry11);
            rs.next();
            old_amount2=rs.getDouble("oil");
            System.out.println("old_amount2"+old_amount2);
             
         } catch (SQLException ex) {
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         } 
           
        String qry9="Select sum(current_reading) as oil_sum from reading_oil";
        try {
            st=conn.createStatement();
            rs=st.executeQuery(qry9);
            rs.next();
           String s1= ""+rs.getString("oil_sum");
            current_reading =Double.parseDouble(s1);
            System.out.println("current_reading"+current_reading);
        } catch (SQLException ex) { 
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         } 
         String qry5="select old_reading_oil from shift where shift_id='"+b+"' ";
         try {
             st=conn.createStatement();
             rs=st.executeQuery(qry5);
              rs.next();
              sum_reading=rs.getDouble("old_reading_oil");
              System.out.println("sum_reading"+sum_reading);
         } catch (SQLException ex) {
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         } 
             
        String qry="select bill_id from sales order by bill_id desc limit 1";
         try {
             st=conn.createStatement();
             rs=st.executeQuery(qry);
              rs.next();
              ending_id=rs.getInt("bill_id");
               System.out.println("ending_id"+ending_id);
                  String qry4="select sum(volume) as sum_volume  from sales where bill_id between '"+starting_id+"' and '"+ending_id+"' and item='oil'";                
             rs=st.executeQuery(qry4);
              rs.next();
              sales_reading=rs.getDouble("sum_volume");
              System.out.println("sales_reading"+sales_reading);
                String qry42="select sum(amount) as sum_amount  from sales where bill_id between '"+starting_id+"' and '"+ending_id+"' and item='oil'";                
             rs=st.executeQuery(qry42);
              rs.next();
              sales_amount3=rs.getDouble("sum_amount");
              total_reading=(current_reading-sum_reading);
                      System.out.println("total_reading"+total_reading);
              not_bill_reading=(total_reading-sales_reading);
              System.out.println("not_bill_reading"+not_bill_reading);
               current_amount=(not_bill_reading*old_amount2);
              System.out.println("current_amount"+current_amount);
         } catch (SQLException ex) {
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         } 
         String qry20="select starting_oil from shift where shift_id='"+b+"'"; 
            try {
             st=conn.createStatement();
              rs=st.executeQuery(qry20);
            rs.next();
            starting_oil=rs.getDouble("starting_oil");
          System.out.println("starting_oil"+starting_oil);   
          oil_sales=(current_reading-starting_oil);
          String qry21="update shift set oil_sales='"+oil_sales+"' where shift_id='"+b+"'";
          try { 
             PreparedStatement pst=conn.prepareStatement(qry21);
             pst.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(userremove.class.getName()).log(Level.SEVERE, null, ex);
        }
         } catch (SQLException ex) {
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         }
          String qry35="select bill_reading_oil from shift where shift_id='"+b+"'"; 
            try {
             st=conn.createStatement();
              rs=st.executeQuery(qry35);
            rs.next();
            bill_reading_oil=rs.getDouble("bill_reading_oil");
            sales_reading=(bill_reading_oil+sales_reading);
             String qry45="update shift set bill_reading_oil='"+sales_reading+"' where shift_id='"+b+"'";
          
             PreparedStatement pst=conn.prepareStatement(qry45);
             pst.executeUpdate();
            String qry46="select not_bill_reading_oil from shift where shift_id='"+b+"'"; 
       st=conn.createStatement();
              rs=st.executeQuery(qry46);
            rs.next();
            not_bill_reading_oil=rs.getDouble("not_bill_reading_oil");
            not_bill_reading_oil=(not_bill_reading_oil+not_bill_reading);
            String qry47="update shift set not_bill_reading_oil='"+not_bill_reading_oil+"' where shift_id='"+b+"'";
          
              pst=conn.prepareStatement(qry47);
             pst.executeUpdate();
               l=not_bill_reading_oil;
              l1=(m5+l);
              s11=""+l1;
              String qry21="update temp_sales set oil='"+s11+"'";
         try {
             pst = conn.prepareStatement(qry21);
             pst.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(Billing.class.getName()).log(Level.SEVERE, null, ex);
         }
          
              l2=(m2-l);
              b2=""+l2;
              String qry29="update temp_purchases set oil='"+b2+"'";
          
         try {
             pst=conn.prepareStatement(qry29);
              pst.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(Billing.class.getName()).log(Level.SEVERE, null, ex);
         }
              String qry48="select bill_oil_amount from shift where shift_id='"+b+"'"; 
       st=conn.createStatement();
              rs=st.executeQuery(qry48);
            rs.next();
            bill_oil_amount=rs.getDouble("bill_oil_amount");
            bill_oil_amount=(bill_oil_amount+sales_amount3);
            String qry49="update shift set bill_oil_amount='"+bill_oil_amount+"' where shift_id='"+b+"'";
          
              pst=conn.prepareStatement(qry49);
             pst.executeUpdate();
             String qry50="select not_bill_oil_amount from shift where shift_id='"+b+"'"; 
       st=conn.createStatement();
              rs=st.executeQuery(qry50);
            rs.next();
            not_bill_oil_amount=rs.getDouble("not_bill_oil_amount");
            not_bill_oil_amount=(not_bill_oil_amount+current_amount);
            String qry51="update shift set not_bill_oil_amount='"+not_bill_oil_amount+"' where shift_id='"+b+"'";
          
              pst=conn.prepareStatement(qry51);
             pst.executeUpdate();
             
            } catch (SQLException ex) { 
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         } 
              
total_oil_amount=(bill_oil_amount+not_bill_oil_amount);  
         PreparedStatement pst;
          String qry60="update shift set total_oil_amount='"+total_oil_amount+"' where shift_id='"+b+"'";
           
         try {
             pst=conn.prepareStatement(qry60);
             pst.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         } 

          
    }
    public void update(){
        PreparedStatement pst;
        total_amount=(total_petrol_amount+total_diesel_amount+total_oil_amount);
        jLabel17.setText(""+total_amount);
          String qry61="update shift set total_amount='"+total_amount+"' where shift_id='"+b+"'";
           
         try {
             pst=conn.prepareStatement(qry61);
             pst.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         } 
    }
    public void update1(){
         String qry="SELECT starting_petrol as PETROL_READING,starting_diesel as DIESEL_READING,starting_oil as OIL_READING,petrol_sales as PETROL_SALES,diesel_sales as DIESEL_SALES,oil_sales as OIL_SALES,total_petrol_amount as PETROL_AMOUNT,total_diesel_amount as DIESEL_AMOUNT,total_oil_amount as OIL_AMOUNT FROM shift where shift_id='"+b+"'";
        try {
            st=conn.createStatement();
            rs=st.executeQuery(qry);
           System.out.println(rs);
            
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
    }    catch (SQLException ex) {    
             Logger.getLogger(vimal_update.class.getName()).log(Level.SEVERE, null, ex);
         }    
    
    } 
    
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vimal_update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vimal_update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vimal_update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vimal_update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new vimal_update().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
