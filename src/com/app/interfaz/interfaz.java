package com.app.interfaz;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
import com.app.utilidad.PanelRound;
import com.app.conexion.Conexion;
import com.app.conexion.data.Sesion;
import com.app.manejodatos.Grafo;
import com.app.manejodatos.ListaEnlazadaNodos;
import com.app.manejodatos.Nodo;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

public class interfaz extends javax.swing.JFrame {

    /**
     * Creates new form intrefas
     */
    //831x940
    Grafo grafo = null;
    boolean check = true;
    Sesion sesion = null;
    Conexion cox = null;
    Boolean perm = false;
    Drawer draw = null;
    ListaEnlazadaNodos cargar = null;
    Buffer buffer = null;

    public interfaz(Sesion sesion, Conexion coxload, Grafo grafoload, Boolean perm, Buffer buf) {
        cox = coxload;
        buffer = buf;
        grafo = grafoload;
        cargar = grafoload.getNodos();
        this.perm = perm;
        initComponents();
        PanelRound dgree1 = new PanelRound();
        PanelRound dgree2 = new PanelRound();
        PanelRound dgree3 = new PanelRound();
        Busqueda.setLayout(new BorderLayout());
        Busqueda.add(dgree1, BorderLayout.CENTER);
        Busqueda.setOpaque(true);
        CerrarSesion.setLayout(new BorderLayout());
        CerrarSesion.add(dgree2, BorderLayout.CENTER);
        CerrarSesion.setOpaque(true);

        draw = new Drawer(false, cox, null, grafo.getNodos(), grafo.getAristas(),buffer);
        jPanel5.setLayout(new BorderLayout());
        jPanel5.add(draw, BorderLayout.CENTER);
        jPanel5.setVisible(true);
        if (perm) {
            Admin.setLayout(new BorderLayout());
            Admin.add(dgree3, BorderLayout.CENTER);
            Admin.setOpaque(true);
            Admin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }

        poblarComponentes();
        this.sesion = sesion;
        Bienvenida.setText("¡Bienvenido(a) " + sesion.getNombre() + "!");

        if (draw.getNodos().NodoPresente("J")) {
            NodoA.addItem("Biblioteca");
            NodoA.addItem("Auditorio menor");
            NodoB.addItem("Auditorio menor");
            NodoB.addItem("Biblioteca");
        }
        if (draw.getNodos().NodoPresente("H")) {
            NodoA.addItem("Auditorio mayor");
            NodoB.addItem("Auditorio mayor");
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

        PanelSecundario = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Check = new javax.swing.JLabel();
        dndviene = new javax.swing.JLabel();
        dndva1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Camino = new javax.swing.JTextArea();
        Ruta = new javax.swing.JLabel();
        NodoB = new combo_suggestion.ComboBoxSuggestion();
        NodoA = new combo_suggestion.ComboBoxSuggestion();
        Admin = new javax.swing.JPanel();
        AdminText = new javax.swing.JLabel();
        Buscar1 = new javax.swing.JPanel();
        dndviene1 = new javax.swing.JLabel();
        CerrarSesion = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Bienvenida = new javax.swing.JLabel();
        Busqueda = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Buscar3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelSecundario.setBackground(new java.awt.Color(0, 0, 0));
        PanelSecundario.setFocusable(false);
        PanelSecundario.setMinimumSize(new java.awt.Dimension(830, 980));
        PanelSecundario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel5.setEnabled(false);
        jPanel5.setFocusable(false);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PanelSecundario.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 830, 900));

        getContentPane().add(PanelSecundario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 0, 830, 1080));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/imagenes/NoChecked-removebg-preview.png"))); // NOI18N
        Check.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Check.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CheckMousePressed(evt);
            }
        });
        jPanel3.add(Check, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 510, 50, 50));

        dndviene.setFont(new java.awt.Font("Roboto Condensed ExtraBold", 0, 36)); // NOI18N
        dndviene.setForeground(new java.awt.Color(0, 0, 0));
        dndviene.setText("Escaleras");
        jPanel3.add(dndviene, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 520, 150, 40));

        dndva1.setFont(new java.awt.Font("Roboto Condensed ExtraBold", 0, 36)); // NOI18N
        dndva1.setForeground(new java.awt.Color(0, 0, 0));
        dndva1.setText("Edificio final");
        jPanel3.add(dndva1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 190, 40));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        Camino.setColumns(20);
        Camino.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        Camino.setRows(5);
        Camino.setBorder(null);
        Camino.setFocusable(false);
        Camino.setKeymap(null);
        jScrollPane3.setViewportView(Camino);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 620, 660, 90));

        Ruta.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        Ruta.setForeground(new java.awt.Color(0, 0, 0));
        Ruta.setText("Ruta a seguir ");
        jPanel3.add(Ruta, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 570, 200, 40));

        NodoB.setBackground(new java.awt.Color(0, 0, 0));
        NodoB.setBorder(null);
        NodoB.setForeground(new java.awt.Color(0, 0, 0));
        NodoB.setMaximumRowCount(5);
        NodoB.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        NodoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NodoBActionPerformed(evt);
            }
        });
        jPanel3.add(NodoB, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 430, 220, 50));

        NodoA.setBackground(new java.awt.Color(0, 0, 0));
        NodoA.setBorder(null);
        NodoA.setForeground(new java.awt.Color(0, 0, 0));
        NodoA.setMaximumRowCount(5);
        NodoA.setFocusCycleRoot(true);
        NodoA.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        NodoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NodoAActionPerformed(evt);
            }
        });
        jPanel3.add(NodoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 220, 50));

        Admin.setBackground(new java.awt.Color(255, 255, 255));
        Admin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AdminMousePressed(evt);
            }
        });
        Admin.setLayout(new java.awt.GridBagLayout());

        AdminText.setBackground(new java.awt.Color(255, 255, 255));
        AdminText.setFont(new java.awt.Font("Roboto Condensed ExtraBold", 0, 24)); // NOI18N
        AdminText.setForeground(new java.awt.Color(255, 255, 255));
        AdminText.setText("Modificar");
        Admin.add(AdminText, new java.awt.GridBagConstraints());

        Buscar1.setBackground(new java.awt.Color(140, 0, 0));
        Buscar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Buscar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Buscar1MousePressed(evt);
            }
        });
        Buscar1.setLayout(new java.awt.GridBagLayout());
        Admin.add(Buscar1, new java.awt.GridBagConstraints());

        jPanel3.add(Admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 740, 170, 70));

        dndviene1.setFont(new java.awt.Font("Roboto Condensed ExtraBold", 0, 36)); // NOI18N
        dndviene1.setForeground(new java.awt.Color(0, 0, 0));
        dndviene1.setText("Edificio Inicial ");
        jPanel3.add(dndviene1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 230, 40));

        CerrarSesion.setBackground(new java.awt.Color(255, 255, 255));
        CerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CerrarSesionMousePressed(evt);
            }
        });
        CerrarSesion.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Roboto Condensed ExtraBold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cerrar Sesion");
        CerrarSesion.add(jLabel2, new java.awt.GridBagConstraints());

        jPanel3.add(CerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1000, 170, 70));

        Bienvenida.setFont(new java.awt.Font("Roboto Condensed ExtraBold", 0, 48)); // NOI18N
        Bienvenida.setForeground(new java.awt.Color(0, 0, 0));
        Bienvenida.setText("¡Bienvenido(a)!");
        jPanel3.add(Bienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, -1, -1));

        Busqueda.setBackground(new java.awt.Color(255, 255, 255));
        Busqueda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Busqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BusquedaMousePressed(evt);
            }
        });
        Busqueda.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Roboto Condensed ExtraBold", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Buscar");
        Busqueda.add(jLabel3, new java.awt.GridBagConstraints());

        Buscar3.setBackground(new java.awt.Color(140, 0, 0));
        Buscar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Buscar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Buscar3MousePressed(evt);
            }
        });
        Buscar3.setLayout(new java.awt.GridBagLayout());
        Busqueda.add(Buscar3, new java.awt.GridBagConstraints());

        jPanel3.add(Busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 740, 170, 70));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/imagenes/upblogo.jpg"))); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/app/interfaz/Bundle"); // NOI18N
        jLabel9.setText(bundle.getString("Inicio_sesion.jLabel9.text")); // NOI18N
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 570, 220));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1920, 1080));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1100, 1110));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void CheckMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CheckMousePressed
        if (check == false) {
            Check.setIcon(new ImageIcon(getClass().getResource("/com/app/imagenes/NoChecked-removebg-preview.png")));
            check = true;
        } else {
            Check.setIcon(new ImageIcon(getClass().getResource("/com/app/imagenes/Checked-removebg-preview.png")));
            check = false;
        }
    }//GEN-LAST:event_CheckMousePressed

    private void CerrarSesionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarSesionMousePressed
        sesion = null;
        buffer = null;
        JFrame frame = this;
        Inicio_sesion inis = new Inicio_sesion(grafo, cox, buffer);
        inis.setExtendedState(JFrame.MAXIMIZED_BOTH);
        inis.setVisible(true);
        Timer timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
            }
        });
        timer.start();
    }//GEN-LAST:event_CerrarSesionMousePressed

    private void NodoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NodoBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NodoBActionPerformed

    private void Buscar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Buscar1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Buscar1MousePressed

    private void Buscar3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Buscar3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Buscar3MousePressed

    private void BusquedaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BusquedaMousePressed

        Camino.setText("");
        String nodoINI = "";
        String nodoFIN = "";
        nodoINI = (String) NodoA.getSelectedItem();
        nodoFIN = (String) NodoB.getSelectedItem();
        Boolean iniesp = false;
        Boolean finesp = false;
        String temp3 = "";
        String temp4 = "";
        if (NodoA.getSelectedItem().equals("Biblioteca")) {
            nodoINI = "J";
            iniesp = true;
            temp3 = "Biblioteca->";
        }
        if (NodoB.getSelectedItem().equals("Biblioteca")) {
            nodoFIN = "J";
            finesp = true;
            temp4 = "Biblioteca";
        }
        if (NodoA.getSelectedItem().equals("Auditorio menor")) {
            nodoINI = "J";
            iniesp = true;
            temp3 = "Auditorio menor->";
        }
        if (NodoB.getSelectedItem().equals("Auditorio menor")) {
            nodoFIN = "J";
            finesp = true;
            temp4 = "Auditorio menor";
        }
        if (NodoA.getSelectedItem().equals("Auditorio mayor")) {
            nodoINI = "H";
            iniesp = true;
            temp3 = "Auditorio mayor->";
        }
        if (NodoB.getSelectedItem().equals("Auditorio mayor")) {
            nodoFIN = "H";
            finesp = true;
            temp4 = "Auditorio mayor";
        }
        if (nodoINI == nodoFIN) {
            temp3 = "";
        }
        ListaEnlazadaNodos camino = grafo.Dijkstra(nodoINI, nodoFIN, check, Camino, draw);
        draw.setCamino(camino);
        if (camino.getCabeza() != null) {
            draw.ponerCamino();
        }
        if (iniesp && !finesp) {
            Nodo temp = camino.getCabeza().getSiguiente();

            while (temp != null) {
                if (Camino.getText().contains("Se encuentra sobre el mismo nodo")) {
                    Camino.setText("Se encuentra sobre el mismo nodo");
                    break;
                }
                temp3 = temp3 + temp.getNombre();

                temp = temp.getSiguiente();
                if (temp != null) {
                    temp3 = temp3 + "->";
                }
            }
        }
        if (finesp && !iniesp) {
            Nodo temp = camino.getCabeza();
            while (temp.getSiguiente() != null) {
                if (Camino.getText().contains("Se encuentra sobre el mismo nodo")) {
                    Camino.setText("Se encuentra sobre el mismo nodo");
                    break;
                }
                temp3 = temp3 + temp.getNombre();
                temp = temp.getSiguiente();
                if (temp != null) {
                    temp3 = temp3 + "->";
                }
                if (temp.getSiguiente() == null) {
                    temp3 = temp3 + temp4;
                    break;
                }
            }
        }
        if (!iniesp && !finesp) {
            Nodo temp = camino.getCabeza();

            while (temp != null) {
                if (Camino.getText().contains("Se encuentra sobre el mismo nodo")) {
                    Camino.setText("Se encuentra sobre el mismo nodo");
                    break;
                }
                temp3 = temp3 + temp.getNombre();

                temp = temp.getSiguiente();
                if (temp != null) {
                    temp3 = temp3 + "->";
                }
            }
        }
        if (iniesp && finesp) {
            Nodo temp = camino.getCabeza().getSiguiente();
            while (temp.getSiguiente() != null) {
                if (Camino.getText().contains("Se encuentra sobre el mismo nodo")) {
                    Camino.setText("Se encuentra sobre el mismo nodo");
                    break;
                }
                temp3 = temp3 + temp.getNombre();
                temp = temp.getSiguiente();
                if (temp != null) {
                    temp3 = temp3 + "->";
                }
                if (temp.getSiguiente() == null) {
                    temp3 = temp3 + temp4;
                    break;
                }
            }
        }
        if (camino.getSize() > 0) {
            Camino.append(temp3);
        }


    }//GEN-LAST:event_BusquedaMousePressed

    private void AdminMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminMousePressed
        if (perm) {
            draw.reiniciarAristas(grafo.getAristas());
            JFrame frame = this;
            ADMIN adminventana = new ADMIN(grafo, cox, this.sesion, buffer, draw);
            adminventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
            adminventana.setVisible(true);
            Timer timer = new Timer(10, new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    frame.setVisible(false);
                }
            });
            timer.start();
        }
    }//GEN-LAST:event_AdminMousePressed

    private void NodoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NodoAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NodoAActionPerformed

    private void poblarComponentes() {
        for (Nodo nodo : cargar) {
            NodoA.addItem(nodo.getNombre());
            NodoB.addItem(nodo.getNombre());
        }
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Admin;
    private javax.swing.JLabel AdminText;
    private javax.swing.JLabel Bienvenida;
    private javax.swing.JPanel Buscar1;
    private javax.swing.JPanel Buscar3;
    private javax.swing.JPanel Busqueda;
    private javax.swing.JTextArea Camino;
    private javax.swing.JPanel CerrarSesion;
    private javax.swing.JLabel Check;
    private combo_suggestion.ComboBoxSuggestion NodoA;
    private combo_suggestion.ComboBoxSuggestion NodoB;
    private javax.swing.JPanel PanelSecundario;
    private javax.swing.JLabel Ruta;
    private javax.swing.JLabel dndva1;
    private javax.swing.JLabel dndviene;
    private javax.swing.JLabel dndviene1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
