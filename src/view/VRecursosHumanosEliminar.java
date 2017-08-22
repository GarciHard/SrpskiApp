package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import model.MEmpleados;
import model.MEmpleadosDAO;

/**
 * Hecho con <3 por: 
 * @author Alexis (GarciHard)
 */
public class VRecursosHumanosEliminar extends JDialog implements ActionListener, MouseListener{
    
    private MEmpleadosDAO empleadoDAO = new MEmpleadosDAO();
    
    private JButton btnEmpBuscarID;
    private JButton btnEmpFoto;
    private JButton btnEmpEliminar;
    private JButton btnEmpCancelar;
    
    private JLabel lblEmpTitle;
    private JLabel lblEmpID;
    private JLabel lblEmpNombre;
    private JLabel lblEmpApellidoP;
    private JLabel lblEmpCargo;
    private JLabel lblEmpSalario;
    
    private JPanel pnlBackground;
    
    private JTextField txtEmpID;
    private JTextField txtEmpNombre;
    private JTextField txtEmpApellidoP;
    private JTextField txtEmpCargo;
    private JTextField txtEmpSalario;
    
    private void initFrame(JFrame parentFrame) {
        setTitle("Recursos Humanos");
        setSize(new Dimension(475,410));
        setResizable(false);
        setModal(true);
        setLocationRelativeTo(parentFrame);
        
        pnlBackground = new JPanel();
        pnlBackground.setBackground(new Color(223,223,223));
        pnlBackground.setLayout(null);
        pnlBackground.setSize(new Dimension(getWidth(),getHeight()));
        
        lblEmpTitle = new JLabel("Eliminar Empleado");
        lblEmpTitle.setFont(new Font("Segoe UI SemiLight", Font.PLAIN, 24));
        lblEmpTitle.setForeground(new Color(0,0,0));
        lblEmpTitle.setSize(new Dimension(425,50));
        lblEmpTitle.setLocation(25, 10);
                
        lblEmpID = new JLabel("Ingrese ID de Empleado",SwingConstants.CENTER);//16
        lblEmpID.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblEmpID.setForeground(new Color(0,0,0));
        lblEmpID.setSize(new Dimension(170,25));
        lblEmpID.setLocation(44,80);
                
        txtEmpID = new JTextField();//14
        txtEmpID.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtEmpID.setForeground(new Color(0,0,0));
        txtEmpID.setHorizontalAlignment(SwingConstants.CENTER);
        txtEmpID.setSize(new Dimension(170, 25));
        txtEmpID.setLocation(223,80);
        txtEmpID.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        
        btnEmpBuscarID = new JButton();
        btnEmpBuscarID.setIcon(new ImageIcon(this.getClass().getResource("/images/FindUserWhiteIcon.png")));
        btnEmpBuscarID.setBackground(new Color(45, 137, 239));
        btnEmpBuscarID.setContentAreaFilled(false);
        btnEmpBuscarID.setFocusPainted(false);
        btnEmpBuscarID.setOpaque(true);
        btnEmpBuscarID.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        btnEmpBuscarID.setSize(new Dimension(28, 25));
        btnEmpBuscarID.setLocation(402, 80);
        btnEmpBuscarID.addActionListener(this);
        btnEmpBuscarID.addMouseListener(this);

        btnEmpFoto = new JButton();
        btnEmpFoto.setBackground(new Color(223, 223, 223));
        btnEmpFoto.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnEmpFoto.setContentAreaFilled(false);
        btnEmpFoto.setFocusPainted(false);
        btnEmpFoto.setIcon(new ImageIcon(this.getClass().getResource("/images/PictureBlackIcon.png")));
        btnEmpFoto.setOpaque(true);
        btnEmpFoto.setSize(new Dimension(100, 100));
        btnEmpFoto.setLocation(25, 125);

        lblEmpNombre = new JLabel("Nombre(s)", SwingConstants.CENTER);
        lblEmpNombre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblEmpNombre.setForeground(new Color(0, 0, 0));
        lblEmpNombre.setSize(new Dimension(145, 25));
        lblEmpNombre.setLocation(140, 145);
        
        txtEmpNombre = new JTextField();
        txtEmpNombre.setHorizontalAlignment(SwingConstants.CENTER);
        txtEmpNombre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtEmpNombre.setForeground(new Color(0, 0, 0));
        txtEmpNombre.setSize(new Dimension(145, 25));
        txtEmpNombre.setLocation(140, 180);
        txtEmpNombre.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        txtEmpNombre.setEditable(false);

        lblEmpApellidoP = new JLabel("Apellidos",SwingConstants.CENTER);
        lblEmpApellidoP.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblEmpApellidoP.setForeground(new Color(0, 0, 0));
        lblEmpApellidoP.setSize(new Dimension(145, 25));
        lblEmpApellidoP.setLocation(305, 145);
        
        txtEmpApellidoP = new JTextField();
        txtEmpApellidoP.setHorizontalAlignment(SwingConstants.CENTER);
        txtEmpApellidoP.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtEmpApellidoP.setForeground(new Color(0, 0, 0));
        txtEmpApellidoP.setSize(new Dimension(145, 25));
        txtEmpApellidoP.setLocation(305, 180);
        txtEmpApellidoP.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        txtEmpApellidoP.setEditable(false);

        lblEmpCargo = new JLabel("Cargo", SwingConstants.CENTER);
        lblEmpCargo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblEmpCargo.setForeground(new Color(0, 0, 0));
        lblEmpCargo.setSize(new Dimension(175, 25));
        lblEmpCargo.setLocation(37, 250);
        
        txtEmpCargo = new JTextField();
        txtEmpCargo.setHorizontalAlignment(SwingConstants.CENTER);
        txtEmpCargo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtEmpCargo.setForeground(new Color(0, 0, 0));
        txtEmpCargo.setSize(new Dimension(175, 25));
        txtEmpCargo.setLocation(37, 285);
        txtEmpCargo.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        txtEmpCargo.setEditable(false);

        lblEmpSalario = new JLabel("Salario", SwingConstants.CENTER);
        lblEmpSalario.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblEmpSalario.setForeground(new Color(0, 0, 0));
        lblEmpSalario.setSize(new Dimension(175, 25));
        lblEmpSalario.setLocation(262, 250);
        
        txtEmpSalario = new JTextField();
        txtEmpSalario.setHorizontalAlignment(SwingConstants.CENTER);
        txtEmpSalario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtEmpSalario.setForeground(new Color(0, 0, 0));
        txtEmpSalario.setSize(new Dimension(175, 25));
        txtEmpSalario.setLocation(262, 285);
        txtEmpSalario.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        txtEmpSalario.setEditable(false);

        btnEmpEliminar = new JButton("Eliminar");
        btnEmpEliminar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnEmpEliminar.setForeground(new Color(255, 255, 255));
        btnEmpEliminar.setBackground(new Color(45, 137, 239));
        btnEmpEliminar.setIcon(new ImageIcon(this.getClass().getResource("/images/RemoveUserWhiteIcon.png")));
        btnEmpEliminar.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnEmpEliminar.setContentAreaFilled(false);
        btnEmpEliminar.setOpaque(true);
        btnEmpEliminar.setFocusPainted(false);
        btnEmpEliminar.setSize(new Dimension(150, 35));
        btnEmpEliminar.setLocation(50, 335);
        btnEmpEliminar.addActionListener(this);
        btnEmpEliminar.addMouseListener(this);

        btnEmpCancelar = new JButton("Cancelar");
        btnEmpCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnEmpCancelar.setForeground(new Color(255, 255, 255));
        btnEmpCancelar.setBackground(new Color(238, 17, 17));
        btnEmpCancelar.setIcon(new ImageIcon(this.getClass().getResource("/images/CancelWhiteIcon.png")));
        btnEmpCancelar.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnEmpCancelar.setContentAreaFilled(false);
        btnEmpCancelar.setOpaque(true);
        btnEmpCancelar.setFocusPainted(false);
        btnEmpCancelar.setSize(new Dimension(150, 35));
        btnEmpCancelar.setLocation(275, 335);
        btnEmpCancelar.addActionListener(this);
        btnEmpCancelar.addMouseListener(this);

        pnlBackground.add(lblEmpTitle);
        pnlBackground.add(lblEmpID);
        pnlBackground.add(txtEmpID);
        pnlBackground.add(btnEmpBuscarID);
        pnlBackground.add(btnEmpFoto);
        pnlBackground.add(lblEmpNombre);
        pnlBackground.add(txtEmpNombre);
        pnlBackground.add(lblEmpApellidoP);
        pnlBackground.add(txtEmpApellidoP);
        pnlBackground.add(lblEmpCargo);
        pnlBackground.add(txtEmpCargo);
        pnlBackground.add(lblEmpSalario);
        pnlBackground.add(txtEmpSalario);
        pnlBackground.add(btnEmpEliminar);
        pnlBackground.add(btnEmpCancelar);
        
        add(pnlBackground);
        setVisible(true);
    }
    
    public VRecursosHumanosEliminar(JFrame parentFrame) {
        initFrame(parentFrame);
    }
        
//    public static void main(String[] args) {
//        new VRecursosHumanosEliminar(null);
//    }
    
/***********************************METODOS***********************************/ 

    private void llenarCampos(MEmpleados empObj) {
        try {
            txtEmpID.setEditable(false);
            txtEmpNombre.setText(empObj.getEmpNombre());
            txtEmpApellidoP.setText(empObj.getEmpApellidoP());
            ImageIcon icEmpFoto = new ImageIcon(empObj.getEmpFoto());
            btnEmpFoto.setIcon(new ImageIcon(icEmpFoto.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
            txtEmpCargo.setText(empObj.getEmpCargo());
            txtEmpSalario.setText(Integer.toString(empObj.getEmpSalario()));
        } catch (Exception e) {
            System.out.println("llenarCamposElim" + e);
        }
    }

    private boolean validarCampos(VRecursosHumanosEliminar vRHObj) {
        return vRHObj.txtEmpNombre.getText().length() > 0
                && vRHObj.txtEmpApellidoP.getText().length() > 0
                && vRHObj.txtEmpCargo.getText().length() > 0
                && vRHObj.txtEmpSalario.getText().length() > 0;
    }

    private void limpiarCampos(VRecursosHumanosEliminar vRHobj) {
        vRHobj.txtEmpID.setText("");
        vRHobj.txtEmpID.setEditable(true);
        vRHobj.txtEmpNombre.setText("");
        vRHobj.txtEmpApellidoP.setText("");
        vRHobj.txtEmpCargo.setText("");
        vRHobj.txtEmpSalario.setText("");
        vRHobj.btnEmpFoto.setIcon(new ImageIcon(this.getClass().getResource("/images/PictureBlackIcon.png")));
    }
    
    private String comprobarCampos(VRecursosHumanosEliminar vRHobj) {

        if (vRHobj.txtEmpID.getText().length() < 1) {
            return "El campo empleado id no puede estar vacio";
        } else if (vRHobj.txtEmpNombre.getText().length() < 1) {
            return "El campo nombre no puede estar vacio";
        } else if (vRHobj.txtEmpApellidoP.getText().length() < 1) {
            return "El apellido paterno no puede estar vacio";
        } else if (vRHobj.txtEmpCargo.getText().length() < 1) {
            return "El campo cargo no puede estar vacio";
        } else if (vRHobj.txtEmpSalario.getText().length() < 1) {
            return "El campo salario no puede estar vacio";
        } else {
            return "ok";
        }
    }
    
/**********************************INTERFACES**********************************/
    
    /*********************************Botones**********************************/
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == btnEmpBuscarID) {
            System.out.println("Boton Buscar Apretado");
            if (txtEmpID.getText().length() < 1) {
                new VOptionPane(this, "Ingrese un ID");
            } else {
                if (empleadoDAO.DAOEmpDelSearch(txtEmpID.getText().toLowerCase()) != null) {
                    llenarCampos(empleadoDAO.DAOEmpDelSearch(txtEmpID.getText().toLowerCase()));
                } else {
                    new VOptionPane(this, "Empleado No Encontrado, Verifique Datos");
                    txtEmpID.setText("");
                }
            }
        }
        if (evt.getSource() == btnEmpEliminar) {
            if (comprobarCampos(this).compareTo("ok") != 0) {
                new VOptionPane(this, comprobarCampos(this));
            } else {
                try {
                    if (empleadoDAO.DAOEmpDelete(txtEmpID.getText().toLowerCase())) {
                        new VOptionPane(this, "Empleado Eliminado");
                        limpiarCampos(this);
                    }
                } catch (Exception e) {
                    new VOptionPane(this, e.toString());
                }
            }

        }
        if (evt.getSource() == btnEmpCancelar) {
            if (validarCampos(this)) {
                limpiarCampos(this);
            } else {
                this.dispose();
            }
        }
    }
    
    /**********************************Mouse**********************************/
@Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == btnEmpBuscarID) {
            btnEmpBuscarID.setBackground(new Color(43, 87, 151));
        }
        if (e.getSource() == btnEmpEliminar) {
            btnEmpEliminar.setBackground(new Color(43, 87, 151));
        }
        if (e.getSource() == btnEmpCancelar) {
            btnEmpCancelar.setBackground(new Color(185, 29, 71));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == btnEmpBuscarID) {
            btnEmpBuscarID.setBackground(new Color(45, 137, 239));
        }
        if (e.getSource() == btnEmpEliminar) {
            btnEmpEliminar.setBackground(new Color(45, 137, 239));
        }
        if (e.getSource() == btnEmpCancelar) {
            btnEmpCancelar.setBackground(new Color(238, 17, 17));
        }
    }

    @Override
    public void mouseEntered(MouseEvent evt) {}
    @Override
    public void mouseExited(MouseEvent evt) {}
    @Override
    public void mouseClicked(MouseEvent evt) {}
}