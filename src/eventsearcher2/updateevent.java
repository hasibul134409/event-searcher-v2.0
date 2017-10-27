/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventsearcher2;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Shofol
 */
public class updateevent extends javax.swing.JFrame {

    Connection conn = null;

    /**
     * Creates new form example
     */
    int orgid;
    String oldname = null;

    public updateevent() {
        initComponents();
    }
    String orgname = null;
    String orgpass = null;

    public void setorg(String name, String pass) throws ClassNotFoundException, SQLException {
        orgname = name;
        orgpass = pass;
        organizerconnection org = new organizerconnection();
        conn = org.orgconnection();

        showEvent();
    }

    private void showEvent() throws SQLException {

        CallableStatement csmt = null;
        String proc = "{?= call admin.getorgid(?,?)}";
        csmt = conn.prepareCall(proc);
        csmt.registerOutParameter(1, Types.INTEGER);
        csmt.setString(2, orgname);
        csmt.setString(3, orgpass);
        csmt.execute();

        orgid = csmt.getInt(1);

        String pr = null;
        pr = "{?= call admin.showeventname(?,?)}";
        try {
            csmt = conn.prepareCall(pr);
            csmt.registerOutParameter(1, Types.ARRAY, "ADMIN.NAMEARR");
            csmt.setInt(2, orgid);

            csmt.registerOutParameter(3, Types.INTEGER);
            csmt.execute();

            Array arr = csmt.getArray(1);
            String[] data = null;
            if (arr != null) {
                data = (String[]) arr.getArray();
                int counter = csmt.getInt(3);
                for (int i = 0; i < counter; i++) {
                    Object Name = data[i];
                    eventlist.getModel().setValueAt(Name, i, 0);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(searchdevent.class.getName()).log(Level.SEVERE, null, ex);
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
        java.awt.GridBagConstraints gridBagConstraints;

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        name = new javax.swing.JTextField();
        type = new javax.swing.JTextField();
        venue = new javax.swing.JTextField();
        dura = new javax.swing.JTextField();
        details = new javax.swing.JTextField();
        link = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jdate = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        eventlist = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setOpaque(false);

        name.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N

        type.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N

        venue.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N

        dura.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N

        details.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N

        link.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N

        jButton2.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Home");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Berlin Sans FB", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("<-");
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButton4.setText("Update");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jdate.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N

        eventlist.setAutoCreateRowSorter(true);
        eventlist.setBackground(new java.awt.Color(53, 74, 95));
        eventlist.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        eventlist.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        eventlist.setForeground(new java.awt.Color(255, 255, 255));
        eventlist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Event Title"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        eventlist.setGridColor(new java.awt.Color(255, 255, 255));
        eventlist.setRowHeight(25);
        eventlist.setSelectionForeground(new java.awt.Color(255, 51, 51));
        eventlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eventlistMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(eventlist);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(208, 208, 208)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(venue, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jdate, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dura, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(type)
                            .addComponent(name)
                            .addComponent(details)
                            .addComponent(link))
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(venue, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dura, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(details, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(link, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel1, gridBagConstraints);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eventsearcher2/images/createevent.jpg"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jLabel1, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        startpage a = new startpage();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        orgoption a = new orgoption();
        a.setVisible(true);
        a.setorg(orgname, orgpass);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String eName = null;
        String eType = null;
        String eVen = null;
        String date = null;
        int day;
        String shor = null;
        String lin = null;

        eName = name.getText();
        eType = type.getText();
        eVen = venue.getText();
        date = ((JTextField) jdate.getDateEditor().getUiComponent()).getText();
        day = Integer.parseInt(dura.getText());
        shor = details.getText();
        lin = link.getText();
        int diff = 1;
        CallableStatement cstmt1;

        try {
            cstmt1 = conn.prepareCall("begin admin.checkdate(?,?);end;");
            cstmt1.registerOutParameter(2, Types.INTEGER);
            cstmt1.setString(1, date);
            cstmt1.execute();
            diff = cstmt1.getInt(2);
        } catch (Exception e) {
        }

        if (name.getText().equals("") || venue.getText().equals("") || ((JTextField) jdate.getDateEditor().getUiComponent()).getText().equals("")
                || dura.getText().equals("") || details.getText().equals("") || link.getText().equals("") || diff > 0) {
            JOptionPane.showMessageDialog(null, "Required Value Missing");
        } else {
            try {
                CallableStatement cs = null;
                String proc = "begin admin.updateevent(?,?,?,?,?,?,?,?);end;";

                cs = conn.prepareCall(proc);
                // JOptionPane.showMessageDialog(null,oldname);
                cs.setString(1, oldname);
                cs.setString(2, eName);
                cs.setString(3, eType);
                cs.setString(4, eVen);
                cs.setString(5, date);
                cs.setInt(6, day);
                cs.setString(7, shor);
                cs.setString(8, lin);
                //JOptionPane.showMessageDialog(null, date);
                cs.execute();

                // orgid = csmt.getInt(1);
                JOptionPane.showMessageDialog(null, "Update Successful !!");
            } catch (SQLException ex) {
                Logger.getLogger(updateevent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void eventlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventlistMouseClicked
        int sr = eventlist.getSelectedRow();
        String select = eventlist.getModel().getValueAt(sr, 0).toString();

        //   JOptionPane.showMessageDialog(null,oldname);
        // userconnection a = new userconnection();
        CallableStatement csmt = null;

        String proc = "begin admin.showevent(?,?,?,?,?,?,?,?);end;";

        try {
            csmt = conn.prepareCall(proc);
            csmt.setString(1, select);
            csmt.registerOutParameter(2, Types.VARCHAR);
            csmt.registerOutParameter(3, Types.VARCHAR);
            csmt.registerOutParameter(4, Types.VARCHAR);
            csmt.registerOutParameter(5, Types.DATE);
            csmt.registerOutParameter(6, Types.VARCHAR);
            csmt.registerOutParameter(7, Types.VARCHAR);
            csmt.registerOutParameter(8, Types.INTEGER);

            csmt.execute();

            String ename = csmt.getString(2);
            String etype = csmt.getString(3);
            String evenue = csmt.getString(4);
            String edate = csmt.getDate(5).toString();
            String edetails = csmt.getString(6);
            String elink = csmt.getString(7);
            int edura = csmt.getInt(8);

            name.setText(ename);
            type.setText(etype);
            venue.setText(evenue);
            details.setText(edetails);
            link.setText(elink);
            dura.setText(Integer.toString(edura));
            // System.out.println(name + " " + type + " " + venue + " " + " " + date + " " + details + " " + link + " " + dura);
            oldname = ename;

        } catch (SQLException ex) {
            Logger.getLogger(orgsignin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_eventlistMouseClicked

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
            java.util.logging.Logger.getLogger(updateevent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateevent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateevent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateevent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateevent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField details;
    private javax.swing.JTextField dura;
    private javax.swing.JTable eventlist;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdate;
    private javax.swing.JTextField link;
    private javax.swing.JTextField name;
    private javax.swing.JTextField type;
    private javax.swing.JTextField venue;
    // End of variables declaration//GEN-END:variables
}
