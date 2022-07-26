/**
 * Class Name: HotelGUI
 * 
 * Date: 8/16/2022
 * 
 * Programmer: Olaf Sanburg
 * 
 * Description: creates and displays the GUI of the main menus of the program
 * 
 * Main menu panel is: java.swing.JPanel MainPanel;
 * customer menu, manager menu, and manager report menu are java.swing.JDialog CustMenu, EmpMenu, and MangReportMenu respectively
 * OpenHotelMenu() creates and display a new instance of the hotel's main menus
 */


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package starprogrammers;

import java.beans.Customizer;

import javax.swing.JDialog;

public class HotelGUI extends javax.swing.JFrame {

    /**
     * Creates new form HotelGUI
     */
    public HotelGUI() {
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

        CustMenu = new javax.swing.JDialog();
        custTitle = new javax.swing.JLabel();
        custViewRsrvnButton = new javax.swing.JButton();
        custBookButton = new javax.swing.JButton();
        custReturnMainButton = new javax.swing.JButton();
        custChangeRsrvnButton = new javax.swing.JButton();
        custCancelRsrvnButton = new javax.swing.JButton();
        EmpMenu = new javax.swing.JDialog();
        empTitle = new javax.swing.JLabel();
        empReturnMainButton = new javax.swing.JButton();
        empCheckInCustButton = new javax.swing.JButton();
        empCancelRoomRsrvnButton = new javax.swing.JButton();
        empChangeRoomRsrvnButton = new javax.swing.JButton();
        empGenMangReportButton = new javax.swing.JButton();
        MangReportMenu = new javax.swing.JDialog();
        reportTitle = new javax.swing.JLabel();
        reportShowRoomsButton = new javax.swing.JButton();
        reportShowResrvnsButton = new javax.swing.JButton();
        reportShowRoomsToCheckoutButton = new javax.swing.JButton();
        reportShowOccupiedRoomsButton = new javax.swing.JButton();
        reportGoBackButton = new javax.swing.JButton();
        MainPanel = new javax.swing.JPanel();
        mainTitle = new javax.swing.JLabel();
        CustButton = new javax.swing.JButton();
        MangButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();

        custTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        custTitle.setText("FiveStarProgrammer Customer Menu");

        custViewRsrvnButton.setText("View Reservation");
        custViewRsrvnButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                custViewRsrvnButtonMouseClicked(evt);
            }
        });

        custBookButton.setText("Book Room");
        custBookButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                custBookButtonMouseClicked(evt);
            }
        });

        custReturnMainButton.setText("Return to Main Menu");
        custReturnMainButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                custReturnMainButtonMouseClicked(evt);
            }
        });

        custChangeRsrvnButton.setText("Change Reservation");
        custChangeRsrvnButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                custChangeRsrvnButtonMouseClicked(evt);
            }
        });

        custCancelRsrvnButton.setText("Cancel Reservation");
        custCancelRsrvnButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                custCancelRsrvnButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout CustMenuLayout = new javax.swing.GroupLayout(CustMenu.getContentPane());
        CustMenu.getContentPane().setLayout(CustMenuLayout);
        CustMenuLayout.setHorizontalGroup(
            CustMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CustMenuLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(CustMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(custReturnMainButton)
                    .addComponent(custCancelRsrvnButton)
                    .addComponent(custChangeRsrvnButton)
                    .addComponent(custViewRsrvnButton)
                    .addGroup(CustMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(custBookButton, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(custTitle)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        CustMenuLayout.setVerticalGroup(
            CustMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CustMenuLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(custTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(custBookButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(custViewRsrvnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(custChangeRsrvnButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(custCancelRsrvnButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(custReturnMainButton)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        empTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        empTitle.setText("FiveStarProgrammer Employee Menu");

        empReturnMainButton.setText("Return to Main Menu");
        empReturnMainButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empReturnMainButtonMouseClicked(evt);
            }
        });

        empCheckInCustButton.setText("Check-in Customer");
        empCheckInCustButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empCheckInCustButtonMouseClicked(evt);
            }
        });

        empCancelRoomRsrvnButton.setText("Cancel Room Reservation");
        empCancelRoomRsrvnButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empCancelRoomRsrvnButtonMouseClicked(evt);
            }
        });

        empChangeRoomRsrvnButton.setText("Change Room Reservation ");
        empChangeRoomRsrvnButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empChangeRoomRsrvnButtonMouseClicked(evt);
            }
        });

        empGenMangReportButton.setText("Generate Report For Manager");
        empGenMangReportButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empGenMangReportButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout EmpMenuLayout = new javax.swing.GroupLayout(EmpMenu.getContentPane());
        EmpMenu.getContentPane().setLayout(EmpMenuLayout);
        EmpMenuLayout.setHorizontalGroup(
            EmpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmpMenuLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(EmpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EmpMenuLayout.createSequentialGroup()
                        .addComponent(empCheckInCustButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(EmpMenuLayout.createSequentialGroup()
                        .addGroup(EmpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(empGenMangReportButton)
                            .addComponent(empChangeRoomRsrvnButton)
                            .addComponent(empReturnMainButton)
                            .addComponent(empTitle)
                            .addComponent(empCancelRoomRsrvnButton))
                        .addContainerGap(44, Short.MAX_VALUE))))
        );
        EmpMenuLayout.setVerticalGroup(
            EmpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmpMenuLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(empTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(empCheckInCustButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(empChangeRoomRsrvnButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(empCancelRoomRsrvnButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(empGenMangReportButton)
                .addGap(12, 12, 12)
                .addComponent(empReturnMainButton)
                .addGap(59, 59, 59))
        );

        reportTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        reportTitle.setText("FiveStarProgrammer Manager Report");

        reportShowRoomsButton.setText("Show All Rooms In Hotel");
        reportShowRoomsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportShowRoomsButtonMouseClicked(evt);
            }
        });

        reportShowResrvnsButton.setText("Show All Hotel Reservations");
        reportShowResrvnsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportShowResrvnsButtonMouseClicked(evt);
            }
        });

        reportShowRoomsToCheckoutButton.setText("Show All Rooms That Check-out Today ");
        reportShowRoomsToCheckoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportShowRoomsToCheckoutButtonMouseClicked(evt);
            }
        });

        reportShowOccupiedRoomsButton.setText("Show All Currently Occupied Rooms");
        reportShowOccupiedRoomsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportShowOccupiedRoomsButtonMouseClicked(evt);
            }
        });

        reportGoBackButton.setText("Go Back");
        reportGoBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportGoBackButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout MangReportMenuLayout = new javax.swing.GroupLayout(MangReportMenu.getContentPane());
        MangReportMenu.getContentPane().setLayout(MangReportMenuLayout);
        MangReportMenuLayout.setHorizontalGroup(
            MangReportMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MangReportMenuLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(MangReportMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reportGoBackButton)
                    .addComponent(reportShowOccupiedRoomsButton)
                    .addComponent(reportShowRoomsToCheckoutButton)
                    .addComponent(reportShowResrvnsButton)
                    .addComponent(reportShowRoomsButton)
                    .addComponent(reportTitle))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        MangReportMenuLayout.setVerticalGroup(
            MangReportMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MangReportMenuLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(reportTitle)
                .addGap(32, 32, 32)
                .addComponent(reportShowRoomsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reportShowResrvnsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reportShowRoomsToCheckoutButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reportShowOccupiedRoomsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reportGoBackButton)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mainTitle.setText("Welcome to the FiveStarProgrammer Hotel");

        CustButton.setText("Customer login");
        CustButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustButtonMouseClicked(evt);
            }
        });

        MangButton.setText("Manager login");
        MangButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MangButtonMouseClicked(evt);
            }
        });

        ExitButton.setText("Exit");
        ExitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(CustButton)
                        .addGap(18, 18, 18)
                        .addComponent(MangButton)
                        .addGap(18, 18, 18)
                        .addComponent(ExitButton))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(mainTitle)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(mainTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CustButton)
                    .addComponent(MangButton)
                    .addComponent(ExitButton))
                .addContainerGap(166, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /** 
     * Event listener for user clicking the customer login button from main menu
     * @param this.CustMenu;cm.pack();cm.setSize(cm.getPreferredSize().width
     * @param this.EmpMenu;em.pack();em.setSize(em.getPreferredSize().width
     * @param this.MangReportMenu;rm.pack();rm.setSize(rm.getPreferredSize().width
     * @param OpenHotelMenu(
     */
    private void CustButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustButtonMouseClicked
        JDialog cm = this.CustMenu;
        cm.pack();
        cm.setSize(cm.getPreferredSize().width, cm.getPreferredSize().height);
        cm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_CustButtonMouseClicked

    
    /** 
     * Event listener for user clicking the manager login button from main menu
     * @param this.EmpMenu;em.pack();em.setSize(em.getPreferredSize().width
     * @param this.MangReportMenu;rm.pack();rm.setSize(rm.getPreferredSize().width
     * @param OpenHotelMenu(
     */
    private void MangButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MangButtonMouseClicked
        JDialog em = this.EmpMenu;
        em.pack();
        em.setSize(em.getPreferredSize().width, em.getPreferredSize().height);
        em.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MangButtonMouseClicked

    
    /** 
     * Event listener for user clicking the exit button from main menu
     * @param this.MangReportMenu;rm.pack();rm.setSize(rm.getPreferredSize().width
     * @param OpenHotelMenu(
     */
    private void ExitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitButtonMouseClicked
        this.dispose();
    }//GEN-LAST:event_ExitButtonMouseClicked

    
    /** 
     * Event listener for user clicking the view reservation button from the customer menu
     * @param this.MangReportMenu;rm.pack();rm.setSize(rm.getPreferredSize().width
     * @param OpenHotelMenu(
     */
    private void custViewRsrvnButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custViewRsrvnButtonMouseClicked
        User.viewReservation();
    }//GEN-LAST:event_custViewRsrvnButtonMouseClicked

    
    /** 
     * Event listener for user clicking the book room button from the customer menu
     * @param this.MangReportMenu;rm.pack();rm.setSize(rm.getPreferredSize().width
     * @param OpenHotelMenu(
     */
    private void custBookButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custBookButtonMouseClicked
        User.bookRoom();
    }//GEN-LAST:event_custBookButtonMouseClicked

    
    /**
     * Event listener for user clicking the return to main menu button from the customer menu 
     * @param this.MangReportMenu;rm.pack();rm.setSize(rm.getPreferredSize().width
     * @param OpenHotelMenu(
     */
    private void custReturnMainButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custReturnMainButtonMouseClicked
        this.setVisible(true);
        this.CustMenu.setVisible(false);
    }//GEN-LAST:event_custReturnMainButtonMouseClicked

    
    /** 
     * Event listener for user clicking the change reservation button from the customer menu 
     * @param this.MangReportMenu;rm.pack();rm.setSize(rm.getPreferredSize().width
     * @param OpenHotelMenu(
     */
    private void custChangeRsrvnButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custChangeRsrvnButtonMouseClicked
        User.changeReservation();
    }//GEN-LAST:event_custChangeRsrvnButtonMouseClicked

    
    /** 
     * Event listener for user clicking the cancel reservation button from the customer menu 
     * @param this.MangReportMenu;rm.pack();rm.setSize(rm.getPreferredSize().width
     * @param OpenHotelMenu(
     */
    private void custCancelRsrvnButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custCancelRsrvnButtonMouseClicked
        User.cancelReservation();
    }//GEN-LAST:event_custCancelRsrvnButtonMouseClicked

    
    /** 
     * Event listener for user clicking the return to main menu button from manager menu
     * @param this.MangReportMenu;rm.pack();rm.setSize(rm.getPreferredSize().width
     * @param OpenHotelMenu(
     */
    private void empReturnMainButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empReturnMainButtonMouseClicked
        this.setVisible(true);
        this.EmpMenu.setVisible(false);
    }//GEN-LAST:event_empReturnMainButtonMouseClicked
    
    
    /** 
     * Event listener for user clicking the check-in customer button from manager menu
     * @param this.MangReportMenu;rm.pack();rm.setSize(rm.getPreferredSize().width
     * @param OpenHotelMenu(
     */
    private void empCheckInCustButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empCheckInCustButtonMouseClicked
        Manager.checkCustomerIn();
    }//GEN-LAST:event_empCheckInCustButtonMouseClicked

    
    /** 
     * Event listener for user clicking the change room reservation button from manager menu
     * @param this.MangReportMenu;rm.pack();rm.setSize(rm.getPreferredSize().width
     * @param OpenHotelMenu(
     */
    private void empChangeRoomRsrvnButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empChangeRoomRsrvnButtonMouseClicked
        Manager.changeRoomReservation();
    }//GEN-LAST:event_empChangeRoomRsrvnButtonMouseClicked

    
    /** 
     * Event listener for user clicking the cancel room reservation button from manager menu
     * @param this.MangReportMenu;rm.pack();rm.setSize(rm.getPreferredSize().width
     * @param OpenHotelMenu(
     */
    private void empCancelRoomRsrvnButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empCancelRoomRsrvnButtonMouseClicked
        Manager.cancelRoomReservation();
    }//GEN-LAST:event_empCancelRoomRsrvnButtonMouseClicked

    
    /** 
     * Event listener for user clicking the generate report for manager button from manager menu
     * @param this.MangReportMenu;rm.pack();rm.setSize(rm.getPreferredSize().width
     * @param OpenHotelMenu(
     */
    private void empGenMangReportButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empGenMangReportButtonMouseClicked
        JDialog rm = this.MangReportMenu;
        rm.pack();
        rm.setSize(rm.getPreferredSize().width, rm.getPreferredSize().height);
        rm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_empGenMangReportButtonMouseClicked

    
    /** 
     * Event listener for user clicking the show all room in hotel button from manager report menu
     * @param OpenHotelMenu(
     */
    private void reportShowRoomsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportShowRoomsButtonMouseClicked
        Hotel.printAllRooms();
    }//GEN-LAST:event_reportShowRoomsButtonMouseClicked

    
    /** 
     * Event listener for user clicking the show all hotel reservations button from manager report menu
     * @param OpenHotelMenu(
     */
    private void reportShowResrvnsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportShowResrvnsButtonMouseClicked
        Hotel.getReservations();
    }//GEN-LAST:event_reportShowResrvnsButtonMouseClicked

    
    /** 
     * Event listener for user clicking the show all rooms that check-out today button from manager report menu
     * @param OpenHotelMenu(
     */
    private void reportShowRoomsToCheckoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportShowRoomsToCheckoutButtonMouseClicked
        Hotel.getReservationsToCheckOut();
    }//GEN-LAST:event_reportShowRoomsToCheckoutButtonMouseClicked

    
    /** 
     * Event listener for user clicking the show all currently occupied rooms button from manager report menu
     * @param OpenHotelMenu(
     */
    private void reportShowOccupiedRoomsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportShowOccupiedRoomsButtonMouseClicked
        Hotel.getReservedRooms();
    }//GEN-LAST:event_reportShowOccupiedRoomsButtonMouseClicked

    
    /**
     * Event listener for user clicking the go back button from manager report menu 
     * @param OpenHotelMenu(
     */
    private void reportGoBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportGoBackButtonMouseClicked
        this.EmpMenu.setVisible(true);
        this.MangReportMenu.setVisible(false);
    }//GEN-LAST:event_reportGoBackButtonMouseClicked

    /** 
     * creates and opens a new instance of the hotel menu GUI
    */
    public static void OpenHotelMenu() {
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
            java.util.logging.Logger.getLogger(HotelGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HotelGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HotelGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HotelGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HotelGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CustButton;
    private javax.swing.JDialog CustMenu;
    private javax.swing.JDialog EmpMenu;
    private javax.swing.JButton ExitButton;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton MangButton;
    private javax.swing.JDialog MangReportMenu;
    private javax.swing.JButton custBookButton;
    private javax.swing.JButton custCancelRsrvnButton;
    private javax.swing.JButton custChangeRsrvnButton;
    private javax.swing.JButton custReturnMainButton;
    private javax.swing.JLabel custTitle;
    private javax.swing.JButton custViewRsrvnButton;
    private javax.swing.JButton empCancelRoomRsrvnButton;
    private javax.swing.JButton empChangeRoomRsrvnButton;
    private javax.swing.JButton empCheckInCustButton;
    private javax.swing.JButton empGenMangReportButton;
    private javax.swing.JButton empReturnMainButton;
    private javax.swing.JLabel empTitle;
    private javax.swing.JLabel mainTitle;
    private javax.swing.JButton reportGoBackButton;
    private javax.swing.JButton reportShowOccupiedRoomsButton;
    private javax.swing.JButton reportShowResrvnsButton;
    private javax.swing.JButton reportShowRoomsButton;
    private javax.swing.JButton reportShowRoomsToCheckoutButton;
    private javax.swing.JLabel reportTitle;
    // End of variables declaration//GEN-END:variables
}
