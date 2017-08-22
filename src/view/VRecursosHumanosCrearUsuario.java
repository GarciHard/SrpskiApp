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
import model.MEmpUsr;
import model.MUsuarios;
import model.MUsuariosDAO;

/**
 * Hecho con <3 por: 
 * @author Alexis (GarciHard)
 */
public class VRecursosHumanosCrearUsuario extends JDialog implements ActionListener, MouseListener{
    
    private MUsuariosDAO mUsuario = new MUsuariosDAO();
    private MEmpUsr empUsr;
    
    private JButton btnEmpBuscarID;
    private JButton btnEmpFoto;
    private JButton btnEmpCrearUsr;
    private JButton btnEmpCancelar;
    
    private JLabel lblEmpTitle;
    private JLabel lblEmpID;
    private JLabel lblEmpNombre;
    private JLabel lblEmpApellidoP;
    private JLabel lblEmpUsr;
    private JLabel lblEmpPasswd;
    
    private JPanel pnlBackground;
    
    private JTextField txtEmpID;
    private JTextField txtEmpNombre;
    private JTextField txtEmpApellidoP;
    private JTextField txtEmpUsr;
    private JTextField txtEmpPasswd;
    
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
        
        lblEmpTitle = new JLabel("Crear Usuario");
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
        txtEmpNombre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtEmpNombre.setForeground(new Color(0, 0, 0));
        txtEmpNombre.setHorizontalAlignment(SwingConstants.CENTER);
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
        txtEmpApellidoP.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtEmpApellidoP.setForeground(new Color(0, 0, 0));
        txtEmpApellidoP.setHorizontalAlignment(SwingConstants.CENTER);
        txtEmpApellidoP.setSize(new Dimension(145, 25));
        txtEmpApellidoP.setLocation(305, 180);
        txtEmpApellidoP.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        txtEmpApellidoP.setEditable(false);

        lblEmpUsr = new JLabel("Usuario", SwingConstants.CENTER);
        lblEmpUsr.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblEmpUsr.setForeground(new Color(0, 0, 0));
        lblEmpUsr.setSize(new Dimension(175, 25));
        lblEmpUsr.setLocation(37, 250);
        
        txtEmpUsr = new JTextField();
        txtEmpUsr.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtEmpUsr.setForeground(new Color(0, 0, 0));
        txtEmpUsr.setHorizontalAlignment(SwingConstants.CENTER);
        txtEmpUsr.setSize(new Dimension(175, 25));
        txtEmpUsr.setLocation(37, 285);
        txtEmpUsr.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        txtEmpUsr.setEditable(false);

        lblEmpPasswd = new JLabel("Contraseña", SwingConstants.CENTER);
        lblEmpPasswd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblEmpPasswd.setForeground(new Color(0, 0, 0));
        lblEmpPasswd.setSize(new Dimension(175, 25));
        lblEmpPasswd.setLocation(262, 250);
        
        txtEmpPasswd = new JTextField();
        txtEmpPasswd.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtEmpPasswd.setForeground(new Color(0, 0, 0));
        txtEmpPasswd.setHorizontalAlignment(SwingConstants.CENTER);
        txtEmpPasswd.setSize(new Dimension(175, 25));
        txtEmpPasswd.setLocation(262, 285);
        txtEmpPasswd.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        txtEmpPasswd.setEditable(false);

        btnEmpCrearUsr = new JButton("Crear Usuario");
        btnEmpCrearUsr.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnEmpCrearUsr.setForeground(new Color(255, 255, 255));
        btnEmpCrearUsr.setBackground(new Color(45, 137, 239));
        btnEmpCrearUsr.setIcon(new ImageIcon(this.getClass().getResource("/images/CreateUserWhiteIcon.png")));
        btnEmpCrearUsr.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnEmpCrearUsr.setContentAreaFilled(false);
        btnEmpCrearUsr.setOpaque(true);
        btnEmpCrearUsr.setFocusPainted(false);
        btnEmpCrearUsr.setSize(new Dimension(150, 35));
        btnEmpCrearUsr.setLocation(50, 335);
        btnEmpCrearUsr.addActionListener(this);
        btnEmpCrearUsr.addMouseListener(this);

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
        pnlBackground.add(lblEmpUsr);
        pnlBackground.add(txtEmpUsr);
        pnlBackground.add(lblEmpPasswd);
        pnlBackground.add(txtEmpPasswd);
        pnlBackground.add(btnEmpCrearUsr);
        pnlBackground.add(btnEmpCancelar);
        
        add(pnlBackground);
        setVisible(true);
    }
    
    public VRecursosHumanosCrearUsuario(JFrame parentFrame) {
        initFrame(parentFrame);
    }
        
//    public static void main(String[] args) {
//        new VRecursosHumanosCrearUsuario(null);
//    }
    
/***********************************METODOS***********************************/ 
    
        private String comprobarCampos(VRecursosHumanosCrearUsuario vRHobj) {

        if (vRHobj.txtEmpID.getText().length() < 1) {
            return "El campo empleado id no puede estar vacio";
        } else if (vRHobj.txtEmpNombre.getText().length() < 1) {
            return "El campo nombre no puede estar vacio";
        } else if (vRHobj.txtEmpApellidoP.getText().length() < 1) {
            return "El campo apellidos no puede estar vacio";
        } else if (vRHobj.txtEmpUsr.getText().length() < 1) {
            return "El campo usuario no puede estar vacio";
        } else if (vRHobj.txtEmpPasswd.getText().length() < 1) {
            return "El campo contraseña no puede estar vacio";
        } else {
            return "ok";
        }
    }
    
    private boolean validarCampos(VRecursosHumanosCrearUsuario vRHObj) {
        return     vRHObj.txtEmpID.getText().length() > 0
                && vRHObj.txtEmpNombre.getText().length() > 0
                && vRHObj.txtEmpApellidoP.getText().length() > 0;
    }
    
    private void limpiarCampos(VRecursosHumanosCrearUsuario vRHobj) {
        vRHobj.btnEmpBuscarID.setEnabled(true);
        vRHobj.txtEmpID.setText("");
        vRHobj.txtEmpID.setEditable(true);
        vRHobj.txtEmpNombre.setText("");
        vRHobj.txtEmpApellidoP.setText("");
        vRHobj.txtEmpUsr.setText("");
        vRHobj.txtEmpUsr.setEditable(false);
        vRHobj.txtEmpPasswd.setText("");
        vRHobj.txtEmpPasswd.setEditable(false);
        vRHobj.btnEmpFoto.setIcon(new ImageIcon(this.getClass().getResource("/images/PictureBlackIcon.png")));
    }
    
    private void llenarHabilitarCampos(MEmpUsr empUsr) {
    MEmpUsr empUsrObj = empUsr;
        if (empUsrObj == null) {
            new VOptionPane(this, "Verifique ID del empleado");
            txtEmpID.setText("");
        } else {
            if (empUsrObj.getEmpUsrUsuario().isEmpty()) {
                if (empUsrObj.getEmpUsrCargo().compareTo("Recursos Humanos") == 0
                        || empUsrObj.getEmpUsrCargo().compareTo("Taquillero") == 0
                        || empUsrObj.getEmpUsrCargo().compareTo("Programador De Cine") == 0
                        || empUsrObj.getEmpUsrCargo().compareTo("Mapeador De Salas") == 0) {
                    new VOptionPane(this, "El empleado necesita un usuario");
                    txtEmpNombre.setText(empUsrObj.getEmpUsrNombre());
                    txtEmpApellidoP.setText(empUsrObj.getEmpUsrApellidos());
                    ImageIcon icEmpFoto = new ImageIcon(empUsrObj.getEmpUsrFoto());
                    btnEmpFoto.setIcon(new ImageIcon(icEmpFoto.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                    txtEmpUsr.setEditable(true);
                    txtEmpPasswd.setEditable(true);
                    txtEmpID.setEditable(false);
                    btnEmpBuscarID.setEnabled(false);
                } else {
                    new VOptionPane(this, "Cargo: "+empUsrObj.getEmpUsrCargo()+", no necesita usuario");
                    txtEmpID.setText("");
                }
            } else {
                new VOptionPane(this, "El empleado ya cuenta con usuario");
                txtEmpID.setText("");
            }
        }
    }
    
/**********************************INTERFACES**********************************/
    
    /*********************************Botones**********************************/
    @Override
    public void actionPerformed(ActionEvent evt) {
        
        if (evt.getSource() == btnEmpBuscarID) {
            
            llenarHabilitarCampos(mUsuario.datosCargo(txtEmpID.getText().toLowerCase()));
            
        }
        if (evt.getSource() == btnEmpCrearUsr) {
            if (comprobarCampos(this).compareTo("ok") != 0) {
                new VOptionPane(this, comprobarCampos(this));
            } else {
                try {
                    if (mUsuario.crearUsuario(new MUsuarios(txtEmpID.getText().toUpperCase(),
                            txtEmpUsr.getText().toLowerCase(),
                            txtEmpPasswd.getText().toLowerCase()))) {
                        new VOptionPane(this, "Usuario Creado Con Éxito");
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
        if (e.getSource() == btnEmpCrearUsr) {
            btnEmpCrearUsr.setBackground(new Color(43, 87, 151));
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
        if (e.getSource() == btnEmpCrearUsr) {
            btnEmpCrearUsr.setBackground(new Color(45, 137, 239));
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