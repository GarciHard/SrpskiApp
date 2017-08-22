package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import model.MEmpleados;

/**
 * Hecho con <3 por:
 * @author Alexis (GarciHard)
 */
public class VTaquilla extends JFrame implements ActionListener, MouseListener {

    private JButton btnTaquillaCrear;
    private JButton btnPeliView;
    private JButton btnPeliUpdate;
    private JLabel lblDepartmentTitle;
    private JLabel lblEmpFirstName;
    private JLabel lblEmpFoto;
    private JLabel lblEmpLastName;
    private JMenuItem mniCerrarSesion;
    private JPanel pnlBackground;
    private MEmpleados mEmpleados;

    private void initComponents(MEmpleados mEmpleados) {
        this.mEmpleados = mEmpleados;
        setTitle("Taquilla - Principal");
        setSize(new Dimension(800, 600));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pnlBackground = new JPanel();
        pnlBackground.setLayout(null);
        pnlBackground.setSize(new Dimension(getWidth(), getHeight()));
        pnlBackground.setBackground(new Color(230, 233, 237));

        lblDepartmentTitle = new JLabel("Punto De Venta - Taquilla", SwingConstants.LEFT);
        lblDepartmentTitle.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 36));
        lblDepartmentTitle.setForeground(new Color(0, 0, 0));
        //lblDepartmentTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblDepartmentTitle.setSize(new Dimension(450, 50));
        lblDepartmentTitle.setLocation(10, 5);

        lblEmpFirstName = new JLabel(mEmpleados.getEmpNombre().toString(), SwingConstants.RIGHT);
        lblEmpFirstName.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
        lblEmpFirstName.setForeground(new Color(0, 0, 0));
        //lblEmpFirstName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblEmpFirstName.setSize(new Dimension(200, 25));
        lblEmpFirstName.setLocation(530, 5);

        lblEmpLastName = new JLabel(mEmpleados.getEmpApellidoP().toString(), SwingConstants.RIGHT);
        lblEmpLastName.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
        lblEmpLastName.setForeground(new Color(0, 0, 0));
        //lblEmpLastName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblEmpLastName.setSize(new Dimension(200, 25));
        lblEmpLastName.setLocation(530, 30);

        lblEmpFoto = new JLabel();
        lblEmpFoto.setSize(new Dimension(50, 50));
        lblEmpFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ImageIcon empF = new ImageIcon(mEmpleados.getEmpFoto());
        lblEmpFoto.setIcon(new ImageIcon(empF.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        lblEmpFoto.setLocation(735, 5);
        lblEmpFoto.addMouseListener(this);

        mniCerrarSesion = new JMenuItem("Cerrar Sesión");
        mniCerrarSesion.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
        mniCerrarSesion.setForeground(new Color(0, 0, 0));
        mniCerrarSesion.setBackground(new Color(255, 255, 255));
        mniCerrarSesion.setIcon(new ImageIcon(getClass().getResource("/images/ShutdownBlackIcon.png")));
        mniCerrarSesion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mniCerrarSesion.setSize(new Dimension(110, 25));
        mniCerrarSesion.setLocation(675, 55);
        mniCerrarSesion.setVisible(false);
        mniCerrarSesion.addActionListener(this);
        mniCerrarSesion.addMouseListener(this);

        btnTaquillaCrear = new JButton("Ventas");
        btnTaquillaCrear.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnTaquillaCrear.setForeground(new Color(255, 255, 255));
        btnTaquillaCrear.setSize(new Dimension(200, 100));
        btnTaquillaCrear.setBackground(new Color(172, 146, 236));
        btnTaquillaCrear.setIcon(new ImageIcon(getClass().getResource("/images/NewTicketWhiteIcon.png")));
        btnTaquillaCrear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        //btnEmpCreate.setBorderPainted(false);
        btnTaquillaCrear.setContentAreaFilled(false);
        btnTaquillaCrear.setFocusPainted(false);
        btnTaquillaCrear.setOpaque(true);
        btnTaquillaCrear.setLocation(50, 150);
        btnTaquillaCrear.addActionListener(this);
        btnTaquillaCrear.addMouseListener(this);

        btnPeliView = new JButton("Listar Peliculas");
        btnPeliView.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnPeliView.setForeground(new Color(255, 255, 255));
        btnPeliView.setSize(new Dimension(190, 100));
        btnPeliView.setBackground(new Color(246,187,66));
        btnPeliView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ViewMovieWhiteIcon.png"))); // NOI18N
        btnPeliView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        //btnPeliView.setBorderPainted(false);
        btnPeliView.setContentAreaFilled(false);
        btnPeliView.setFocusPainted(false);
        btnPeliView.setOpaque(true);
        btnPeliView.setLocation(300, 150);
        btnPeliView.addActionListener(this);
        btnPeliView.addMouseListener(this);
        
        btnPeliUpdate = new JButton("Actualizar Peliculas");
        btnPeliUpdate.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnPeliUpdate.setForeground(new Color(255, 255, 255));
        btnPeliUpdate.setSize(new Dimension(210, 100));
        btnPeliUpdate.setBackground(new Color(255,0,151));
        btnPeliUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/UpdateMovieWhiteIcon.png"))); // NOI18N
        btnPeliUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        //btnPeliUpdate.setBorderPainted(false);
        btnPeliUpdate.setContentAreaFilled(false);
        btnPeliUpdate.setFocusPainted(false);
        btnPeliUpdate.setOpaque(true);
        btnPeliUpdate.setLocation(540, 150);
        btnPeliUpdate.addActionListener(this);
        btnPeliUpdate.addMouseListener(this);

        pnlBackground.add(lblDepartmentTitle);
        pnlBackground.add(lblEmpFirstName);
        pnlBackground.add(lblEmpLastName);
        pnlBackground.add(lblEmpFoto);
        pnlBackground.add(mniCerrarSesion);
        pnlBackground.add(btnTaquillaCrear);
        //pnlBackground.add(btnPeliView);
        //pnlBackground.add(btnPeliUpdate);

        add(pnlBackground);
        setVisible(true);
    }

    public VTaquilla(MEmpleados mEmpleados) {
        initComponents(mEmpleados);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        if ( evt.getSource() == btnTaquillaCrear ) {
            new VTaquillaVenta(this, mEmpleados);
        }
//        if ( evt.getSource() == btnPeliView ) {
//            new VProgramadorPeliculasListar(this);
//        }
//        if ( evt.getSource() == btnPeliUpdate ) {
//            new VProgramadorPeliculasActualizar(this);
//        }
        if (evt.getSource() == mniCerrarSesion) {
            this.dispose();
            new VLogin();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == lblEmpFoto) {
            mniCerrarSesion.setVisible(true);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == mniCerrarSesion) {
            mniCerrarSesion.setVisible(true);
            mniCerrarSesion.setBackground(new Color(223, 223, 223));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == mniCerrarSesion) {
            mniCerrarSesion.setVisible(false);
            mniCerrarSesion.setBackground(new Color(255, 255, 255));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {//Aqui se cambia el color al presionar el boton
      if (e.getSource() == btnTaquillaCrear) {
        btnTaquillaCrear.setBackground(new Color(150,122,220));
      }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      if (e.getSource() == btnTaquillaCrear) {
        btnTaquillaCrear.setBackground(new Color(172, 146, 236));
      }
    }              
}