package view;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import model.MEmpleados;

/**
 * Hecho con <3 por: 
 * @author Alexis (GarciHard)
 */
public class VRecursosHumanos extends JFrame implements ActionListener, MouseListener {

    private JPanel pnlBackground;
    private JLabel lblDepartmentTitle;
    private JLabel lblEmpFirstNameTitle;
    private JLabel lblEmpLastNameTitle;
    private JButton btnEmpImageTitle;

    private JMenuItem mniCerrarSesion;

    private JButton btnEmpCreate;
    private JButton btnEmpRead;
    private JButton btnEmpUpdate;
    private JButton btnEmpDelete;
    private JButton btnUsrCrear;
    private JButton btnRHReporte;
    private JButton btnRHReporte1;
    private JButton btnRHReporte2;
    
    private void initFrame(MEmpleados mEmpleados) {
        //Creacion del JFrame 
        setTitle("Recursos Humanos - Principal");
        setSize(new Dimension(800, 600));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Creacion del JPanel Background
        pnlBackground = new JPanel();
        pnlBackground.setLayout(null);
        pnlBackground.setSize(new Dimension(getWidth(), getHeight()));
        pnlBackground.setBackground(new Color(245,248,250));//255,255,255

        //Creacion del JLabel DepartmentTitle
        lblDepartmentTitle = new JLabel("Recursos Humanos", SwingConstants.LEFT);
        lblDepartmentTitle.setFont(new Font("Segoe UI SemiLight", Font.PLAIN, 36));
        lblDepartmentTitle.setForeground(new Color(0, 0, 0));
        lblDepartmentTitle.setSize(new Dimension(350, 50));
        lblDepartmentTitle.setLocation(5, 5);

        //Creacion del titulo del usuario Nombre, Apellido y Foto
        lblEmpFirstNameTitle = new JLabel(mEmpleados.getEmpNombre().toString(), SwingConstants.RIGHT);
        lblEmpFirstNameTitle.setFont(new Font("Segoe UI SemiLight", Font.PLAIN, 18));
        lblEmpFirstNameTitle.setForeground(new Color(0, 0, 0));
        lblEmpFirstNameTitle.setSize(new Dimension(200, 25));
        lblEmpFirstNameTitle.setLocation(530, 5);

        lblEmpLastNameTitle = new JLabel(mEmpleados.getEmpApellidoP().toString(), SwingConstants.RIGHT);
        lblEmpLastNameTitle.setFont(new Font("Segoe UI SemiLight", Font.PLAIN, 14));
        lblEmpLastNameTitle.setForeground(new Color(0, 0, 0));
        lblEmpLastNameTitle.setSize(new Dimension(200, 25));
        lblEmpLastNameTitle.setLocation(530, 30);

        btnEmpImageTitle = new JButton();
        btnEmpImageTitle.setSize(new Dimension(50, 50));
        btnEmpImageTitle.setBackground(new Color(255, 255, 255));
        ImageIcon empF = new ImageIcon(mEmpleados.getEmpFoto());
        btnEmpImageTitle.setIcon(new ImageIcon(empF.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        btnEmpImageTitle.setContentAreaFilled(false);
        btnEmpImageTitle.setFocusPainted(false);
        btnEmpImageTitle.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnEmpImageTitle.setLocation(740, 5);
        btnEmpImageTitle.addMouseListener(this);

        mniCerrarSesion = new JMenuItem("Cerrar Sesi\u00f3n");
        mniCerrarSesion.setFont(new Font("Segoe UI SemiLight", Font.PLAIN, 12));
        mniCerrarSesion.setForeground(new Color(0, 0, 0));
        mniCerrarSesion.setBackground(new Color(255, 255, 255));
        mniCerrarSesion.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        mniCerrarSesion.setIcon(new ImageIcon(this.getClass().getResource("/images/ShutdownBlackIcon.png")));
        mniCerrarSesion.setSize(new Dimension(110, 25));
        mniCerrarSesion.setLocation(680, 55);
        mniCerrarSesion.setVisible(false);
        mniCerrarSesion.addActionListener(this);
        mniCerrarSesion.addMouseListener(this);

        //Grupo de JButton para el CRUD &ActionListener, MouseListener 
        btnEmpCreate = new JButton("Nuevo Empleado");
        btnEmpCreate.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnEmpCreate.setForeground(new Color(255, 255, 255));
        btnEmpCreate.setSize(new Dimension(200, 100));
        btnEmpCreate.setBackground(new Color(27, 161, 226));
        btnEmpCreate.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        btnEmpCreate.setContentAreaFilled(false);
        btnEmpCreate.setFocusPainted(false);
        btnEmpCreate.setOpaque(true);
        btnEmpCreate.setLocation(50, 150);
        btnEmpCreate.addActionListener(this);
        btnEmpCreate.addMouseListener(this);

        btnEmpRead = new JButton("Listar Empleados");
        btnEmpRead.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnEmpRead.setForeground(new Color(255, 255, 255));
        btnEmpRead.setSize(new Dimension(200, 100));
        btnEmpRead.setBackground(new Color(140, 191, 38));
        btnEmpRead.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        btnEmpRead.setContentAreaFilled(false);
        btnEmpRead.setFocusPainted(false);
        btnEmpRead.setOpaque(true);
        btnEmpRead.setLocation(300, 150);
        btnEmpRead.addActionListener(this);
        btnEmpRead.addMouseListener(this);

        btnEmpUpdate = new JButton("Actualizar Empleado");
        btnEmpUpdate.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnEmpUpdate.setForeground(new Color(255, 255, 255));
        btnEmpUpdate.setSize(new Dimension(200, 100));
        btnEmpUpdate.setBackground(new Color(159, 0, 167));
        btnEmpUpdate.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        btnEmpUpdate.setContentAreaFilled(false);
        btnEmpUpdate.setFocusPainted(false);
        btnEmpUpdate.setOpaque(true);
        btnEmpUpdate.setLocation(550, 150);
        btnEmpUpdate.addActionListener(this);
        btnEmpUpdate.addMouseListener(this);

        btnEmpDelete = new JButton("Eliminar Empleado");
        btnEmpDelete.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnEmpDelete.setForeground(new Color(255, 255, 255));
        btnEmpDelete.setSize(new Dimension(200, 100));
        btnEmpDelete.setBackground(new Color(229, 20, 0));
        btnEmpDelete.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        btnEmpDelete.setContentAreaFilled(false);
        btnEmpDelete.setFocusPainted(false);
        btnEmpDelete.setOpaque(true);
        btnEmpDelete.setLocation(50, 300);
        btnEmpDelete.addActionListener(this);
        btnEmpDelete.addMouseListener(this);
        
        btnUsrCrear = new JButton("Crear Usuario");
        btnUsrCrear.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnUsrCrear.setForeground(new Color(255, 255, 255));
        btnUsrCrear.setSize(new Dimension(200, 100));
        btnUsrCrear.setBackground(new Color(240,150,9));
        btnUsrCrear.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        btnUsrCrear.setContentAreaFilled(false);
        btnUsrCrear.setFocusPainted(false);
        btnUsrCrear.setOpaque(true);
        btnUsrCrear.setLocation(300, 300);
        btnUsrCrear.addActionListener(this);
        btnUsrCrear.addMouseListener(this);
        
        btnRHReporte = new JButton("Reporte Peliculas");
        btnRHReporte.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnRHReporte.setForeground(new Color(255, 255, 255));
        btnRHReporte.setSize(new Dimension(200, 33));
        btnRHReporte.setBackground(new Color(20,250,89));
        btnRHReporte.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        btnRHReporte.setContentAreaFilled(false);
        btnRHReporte.setFocusPainted(false);
        btnRHReporte.setOpaque(true);
        btnRHReporte.setLocation(550, 300);
        btnRHReporte.addActionListener(this);
        btnRHReporte.addMouseListener(this);
        
        btnRHReporte1 = new JButton("Reporte Empleados");
        btnRHReporte1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnRHReporte1.setForeground(new Color(255, 255, 255));
        btnRHReporte1.setSize(new Dimension(200, 33));
        btnRHReporte1.setBackground(new Color(20,250,89));
        btnRHReporte1.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        btnRHReporte1.setContentAreaFilled(false);
        btnRHReporte1.setFocusPainted(false);
        btnRHReporte1.setOpaque(true);
        btnRHReporte1.setLocation(550, 333);
        btnRHReporte1.addActionListener(this);
        btnRHReporte1.addMouseListener(this);
        
        btnRHReporte2 = new JButton("Reporte Ventas");
        btnRHReporte2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnRHReporte2.setForeground(new Color(255, 255, 255));
        btnRHReporte2.setSize(new Dimension(200, 33));
        btnRHReporte2.setBackground(new Color(20,250,89));
        btnRHReporte2.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        btnRHReporte2.setContentAreaFilled(false);
        btnRHReporte2.setFocusPainted(false);
        btnRHReporte2.setOpaque(true);
        btnRHReporte2.setLocation(550, 366);
        btnRHReporte2.addActionListener(this);
        btnRHReporte2.addMouseListener(this);
        

        //Agregan componentes al JPanel Background
        pnlBackground.add(lblDepartmentTitle);
        pnlBackground.add(lblEmpFirstNameTitle);
        pnlBackground.add(lblEmpLastNameTitle);
        pnlBackground.add(btnEmpImageTitle);
        pnlBackground.add(mniCerrarSesion);

        pnlBackground.add(btnEmpCreate);
        pnlBackground.add(btnEmpRead);
        pnlBackground.add(btnEmpUpdate);
        pnlBackground.add(btnEmpDelete);
        pnlBackground.add(btnUsrCrear);
        pnlBackground.add(btnRHReporte);
        pnlBackground.add(btnRHReporte1);
        pnlBackground.add(btnRHReporte2);

        //Agregan componentes al JFrame
        add(pnlBackground);
        setVisible(true);
    }
    
    public VRecursosHumanos(MEmpleados mEmpleados) {//Constructor de la clase
        initFrame(mEmpleados);
    }

    //Eventos de Boton y de Mouse
    @Override
    public void actionPerformed(ActionEvent evt) {//Eventos de JButtons
        if (evt.getSource() == btnEmpCreate) {
            new VRecursosHumanosCrear(this);
        } 
        if (evt.getSource() == btnEmpRead) {
            new  VRecursosHumanosListar(this);
        }
        if (evt.getSource() == btnEmpUpdate) {
            new VRecursosHumanosActualizar(this);
        }
        if (evt.getSource() == btnEmpDelete) {
            new VRecursosHumanosEliminar(this);
        }
        if (evt.getSource() == btnUsrCrear) {
            new VRecursosHumanosCrearUsuario(this);
        }
        if (evt.getSource() == btnRHReporte) {
            new  VRecursosHumanosReportes(this);
        }
        if (evt.getSource() == btnRHReporte1) {
            new  VRecursosHumanosReportes2(this);
        }
        if (evt.getSource() == btnRHReporte2) {
            new  VRecursosHumanosReportes3(this);
        }
        if (evt.getSource() == mniCerrarSesion) {
            this.dispose();
            new VLogin();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == btnEmpCreate) {
            btnEmpCreate.setBackground(new Color(27, 161, 226));
        }
        if(e.getSource() == btnEmpRead) {
            btnEmpRead.setBackground(new Color(140, 191, 38));
        }
        if (e.getSource() == btnEmpUpdate) {
            btnEmpUpdate.setBackground(new Color(159, 0, 167));
        }
        if (e.getSource() == btnEmpDelete) {
            btnEmpDelete.setBackground(new Color(229, 20, 0));
        }
        if (e.getSource() == btnEmpImageTitle) {
            mniCerrarSesion.setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {//Solo aqui cambia de color
        if (e.getSource() == btnEmpCreate) {
            btnEmpCreate.setBackground(new Color(7, 121, 186));
        }
        if (e.getSource() == btnEmpRead) {
            btnEmpRead.setBackground(new Color(100, 151, 8));
        }if (e.getSource() == btnEmpUpdate) {
            btnEmpUpdate.setBackground(new Color(119, 0, 127));
        }
        if (e.getSource() == btnEmpDelete) {
            btnEmpDelete.setBackground(new Color(189, 0, 0));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == btnEmpCreate) {
            btnEmpCreate.setBackground(new Color(27, 161, 226));
        }
        if (e.getSource() == btnEmpRead) {
            btnEmpRead.setBackground(new Color(140, 191, 38));
        }
        if (e.getSource() == btnEmpUpdate) {
            btnEmpUpdate.setBackground(new Color(159, 0, 167));
        }
        if (e.getSource() == btnEmpDelete) {
            btnEmpDelete.setBackground(new Color(229, 20, 0));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == btnEmpCreate) {
            btnEmpCreate.setBackground(new Color(27, 161, 226));
        }
        if (e.getSource() == btnEmpRead) {
            btnEmpRead.setBackground(new Color(140, 191, 38));
        }
        if (e.getSource() == btnEmpUpdate) {
            btnEmpUpdate.setBackground(new Color(159, 0, 167));
        }
        if (e.getSource() == btnEmpDelete) {
            btnEmpDelete.setBackground(new Color(229, 20, 0));
        }
        if (e.getSource() == mniCerrarSesion) {
            mniCerrarSesion.setVisible(true);
            mniCerrarSesion.setBackground(new Color(223, 223, 223));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == btnEmpCreate) {
            btnEmpCreate.setBackground(new Color(27, 161, 226));
        }
        if (e.getSource() == btnEmpRead) {
            btnEmpRead.setBackground(new Color(140, 191, 38));
        }
        if (e.getSource() == btnEmpUpdate) {
            btnEmpUpdate.setBackground(new Color(159, 0, 167));
        }
        if (e.getSource() == btnEmpDelete) {
            btnEmpDelete.setBackground(new Color(229, 20, 0));
        }
        if (e.getSource() == btnEmpImageTitle) {
            mniCerrarSesion.setVisible(false);
        }
        if (e.getSource() == mniCerrarSesion) {
            mniCerrarSesion.setVisible(false);
            mniCerrarSesion.setBackground(new Color(255, 255, 255));
        }
    }
}