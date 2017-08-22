package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import model.MUsuarios;
import model.MUsuariosDAO;

/**
 * Hecho con <3 por: 
 * @author Alexis (GarciHard)
 */

public class VLogin extends JFrame implements ActionListener, MouseListener {

    private JPanel pnlBackground;
    private JLabel lblUsuario;
    private JTextField txtUsuario;
    private JLabel lblPassword;
    private JPasswordField pwdPassword;
    private JButton btnLogin;
    private JLabel lblLogo;
    
    private MUsuarios mUsuarios;
    private MUsuariosDAO mUsuariosDAO = new MUsuariosDAO();

    public VLogin() {
        initFrame();
    }

    private void initFrame() {
        //Creacion del JFrame de Login
        setTitle("Login");
        setSize(new Dimension(600, 400));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Creacion del JPanel Background
        pnlBackground = new JPanel();
        pnlBackground.setLayout(null);
        pnlBackground.setSize(getWidth(), getHeight());
        pnlBackground.setBackground(new Color(43, 87, 151));//46,88,148

        //Creacion de JLabel & JTextField Usuario
        lblUsuario = new JLabel("Usuario", SwingConstants.CENTER);
        lblUsuario.setFont(new Font("Segoe UI SemiLight", Font.PLAIN, 24));
        lblUsuario.setForeground(new Color(255, 255, 255));
        lblUsuario.setSize(new Dimension(273, 50));
        lblUsuario.setLocation(327, 50);

        txtUsuario = new JTextField();
        txtUsuario.setFont(new Font("Segoe UI SemiLight", Font.ITALIC, 18));
        txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        txtUsuario.setSize(new Dimension(200, 30));
        txtUsuario.setLocation(363, 105);

        //Creacion de JLabel & JTextField Password
        lblPassword = new JLabel("Contrase\u00f1a", SwingConstants.CENTER);
        lblPassword.setFont(new Font("Segoe UI SemiLight", Font.PLAIN, 24));
        lblPassword.setForeground(new Color(255, 255, 255));
        lblPassword.setSize(new Dimension(273, 50));
        lblPassword.setLocation(327, 150);

        pwdPassword = new JPasswordField();
        pwdPassword.setFont(new Font("Segoe UI SemiLight", Font.PLAIN, 18));
        pwdPassword.setHorizontalAlignment(SwingConstants.CENTER);
        pwdPassword.setSize(new Dimension(200, 30));
        pwdPassword.setLocation(363, 205);

        //Creacion del JButton Login, ActionListener & MouseListener
        btnLogin = new JButton("Iniciar Sesi\u00f3n");
        btnLogin.setFont(new Font("Segoe UI SemiLight", Font.PLAIN, 18));
        btnLogin.setForeground(new Color(255, 255, 255));
        btnLogin.setBackground(new Color(238, 17, 17));//186,67,42
        btnLogin.setFocusPainted(false);
        //btnLogin.setBorderPainted(false);
        btnLogin.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
        btnLogin.setContentAreaFilled(false);
        btnLogin.setOpaque(true);
        btnLogin.setSize(new Dimension(150, 50));
        btnLogin.setLocation(388, 285);
        btnLogin.setToolTipText("Ingresa tus datos para iniciar sesi\u00f3n");
        btnLogin.addActionListener(this);
        btnLogin.addMouseListener(this);

        //Creacion del JLabel Logo
        lblLogo = new JLabel();
        lblLogo.setSize(new Dimension(327, 334));
        lblLogo.setIcon(new ImageIcon(this.getClass().getResource("/images/327x334v2.png")));
        lblLogo.setLocation(0, 33);

        //Agregar elementos al JPanel Background
        pnlBackground.add(lblUsuario);
        pnlBackground.add(txtUsuario);
        pnlBackground.add(lblPassword);
        pnlBackground.add(pwdPassword);
        pnlBackground.add(btnLogin);
        pnlBackground.add(lblLogo);

        //Agregar elementos al JFrame
        add(pnlBackground);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new VLogin();
    }

    //Eventos de botón y de ratón
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == btnLogin) {
            if (txtUsuario.getText().length() < 1 || pwdPassword.getText().length() < 1) {
                txtUsuario.setText("");
                pwdPassword.setText("");
                new VMsjDialogo(this, "Ingrese todos los campos");
            } else {
                System.out.println("Hace validacion");
                mUsuarios = new MUsuarios(txtUsuario.getText().toLowerCase(), pwdPassword.getText().toLowerCase());
                switch (mUsuariosDAO.cargoEmpleado(mUsuarios)) {
                    case "Recursos Humanos":
                        new VRecursosHumanos(mUsuariosDAO.datosEmpleado(mUsuarios));
                        this.dispose();
                        break;
                    case "Programador De Cine"://.setVisible(true) si no funciona en un futuro, poner eso
                        new VProgramadorPeliculas(mUsuariosDAO.datosEmpleado(mUsuarios));
                        this.dispose();
                        break;
                    case "Taquillero":
                        new VTaquilla(mUsuariosDAO.datosEmpleado(mUsuarios));
                        this.dispose();
                        break;
                    case "sin empleo":
                        new VMsjDialogo(this, "Credenciales no válidas");
                        txtUsuario.setText("");
                        pwdPassword.setText("");
                        break;
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent evt) {
        btnLogin.setBackground(new Color(156, 37, 12));
    }

    @Override
    public void mouseReleased(MouseEvent evt) {
        btnLogin.setBackground(new Color(238, 17, 17));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        btnLogin.setBackground(new Color(238, 17, 17));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        btnLogin.setBackground(new Color(238, 17, 17));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        btnLogin.setBackground(new Color(238, 17, 17));
    }
}
