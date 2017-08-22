package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.MEmpleados;
import model.MEmpleadosDAO;

/**
 * Hecho con <3 por: 
 * @author Alexis (GarciHard)
 */
public class VRecursosHumanosActualizar extends JDialog implements ActionListener, MouseListener, KeyListener{

    private MEmpleados empleadoObj;
    private MEmpleadosDAO empleadoDAO = new MEmpleadosDAO();
    
    private final int numEmpIDMax = 10;
    private final int numEmpNombreMax = 30;
    private final int numEmpApellidoPMax = 20;
    private final int numEmpApellidoMMax = 20;
    private final int numEmpCalleMax = 50;
    private final int numEmpNumExtMax = 5;
    private final int numEmpColoniaMax = 30;
    private final int numEmpMunicipioMax = 30;
    private final int numEmpNumeroMax = 10;
    private final int numEmpSalarioMax = 5;
    
    private JButton btnEmpFoto;
    private String btnEmpFotoUrl = "";
    private JButton btnEmpBuscarID;
    private JButton btnEmpActualizar;
    private JButton btnEmpCancelar;

    private JComboBox cmbEmpCargos;
    private JComboBox cmbEmpEstados;
    
    private JFileChooser jfcEmpBtnFoto;
    
    private JLabel lblEmpTitle;
    private JLabel lblEmpID;
    private JLabel lblEmpNombre;
    private JLabel lblEmpApellidoP;
    private JLabel lblEmpApellidoM;
    private JLabel lblEmpCalle;
    private JLabel lblEmpNumExt;
    private JLabel lblEmpColonia;
    private JLabel lblEmpMunicipio;
    private JLabel lblEmpEstado;
    private JLabel lblEmpNumero;
    private JLabel lblEmpCargo;
    private JLabel lblEmpSalario;
    
    private JPanel pnlBackground;
    
    private JTextField txtEmpID;
    private JTextField txtEmpNombre;
    private JTextField txtEmpApellidoP;
    private JTextField txtEmpApellidoM;
    private JTextField txtEmpCalle;
    private JTextField txtEmpNumExt;
    private JTextField txtEmpColonia;
    private JTextField txtEmpMunicipio;
    private JTextField txtEmpNumero;
    private JTextField txtEmpSalario;

    private String listaEstados[] = {"", "Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chiapas", "Chihuahua", "Coahuila", "Colima", "Durango",
        "Estado De Mexico", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "Michoacán", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla",
        "Querétaro", "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas"};

    private String listaCargos[] = {"", "Recursos Humanos", "Taquillero", "Programador De Cine", "Mapeador De Salas"};
    
    private void initFrame(JFrame parentFrame) {
        setTitle("Recursos Humanos");
        setSize(new Dimension(475, 650));
        setLocationRelativeTo(parentFrame);
        setModal(true);
        setResizable(false);
        
        pnlBackground = new JPanel();
        pnlBackground.setLayout(null);
        pnlBackground.setSize(new Dimension(getHeight(), getWidth()));
        pnlBackground.setBackground(new Color(223,223,223));
        
        lblEmpTitle = new JLabel("Actualizar Empleado");
        lblEmpTitle.setFont(new Font("Segoe UI SemiLight", Font.PLAIN, 24));
        lblEmpTitle.setForeground(new Color(0,0,0));
        lblEmpTitle.setSize(new Dimension(425, 50));
        lblEmpTitle.setLocation(25, 10);
        
        btnEmpFoto = new JButton();
        btnEmpFoto.setBackground(new Color(223, 223, 223));
        btnEmpFoto.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnEmpFoto.setContentAreaFilled(false);
        btnEmpFoto.setFocusPainted(false);
        btnEmpFoto.setIcon(new ImageIcon(this.getClass().getResource("/images/PictureBlackIcon.png")));
        btnEmpFoto.setOpaque(true);
        btnEmpFoto.setSize(new Dimension(100, 100));
        btnEmpFoto.setLocation(25, 80);
        btnEmpFoto.addActionListener(this);
        btnEmpFoto.setEnabled(false);
        
        lblEmpID = new JLabel("Ingrese ID de Empleado", SwingConstants.CENTER);
        lblEmpID.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblEmpID.setForeground(new Color(0, 0, 0));
        lblEmpID.setSize(new Dimension(170, 25));
        lblEmpID.setLocation(187, 100);
        
        txtEmpID = new JTextField();
        txtEmpID.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtEmpID.setForeground(new Color(0, 0, 0));
        txtEmpID.setSize(new Dimension(170, 25));
        txtEmpID.setEnabled(true);
        txtEmpID.setLocation(187, 135); 
        txtEmpID.setHorizontalAlignment(SwingConstants.CENTER);
        txtEmpID.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        txtEmpID.setToolTipText("M\u00e1ximo 10 caracteres");
        txtEmpID.addKeyListener(this);
        
        lblEmpNombre = new JLabel("Nombre(s): ");
        lblEmpNombre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblEmpNombre.setForeground(new Color(0, 0, 0));
        lblEmpNombre.setSize(new Dimension(200, 25));
        lblEmpNombre.setLocation(25, 265);

        txtEmpNombre = new JTextField();
        txtEmpNombre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtEmpNombre.setForeground(new Color(0, 0, 0));
        txtEmpNombre.setSize(new Dimension(200, 25));
        txtEmpNombre.setLocation(25, 295);
        txtEmpNombre.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        txtEmpNombre.setToolTipText("M\u00e1ximo 30 caracteres");
        txtEmpNombre.addKeyListener(this);
        txtEmpNombre.setEditable(false);

        lblEmpApellidoP = new JLabel("Apellido Paterno: ");
        lblEmpApellidoP.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblEmpApellidoP.setForeground(new Color(0, 0, 0));
        lblEmpApellidoP.setSize(new Dimension(200, 25));
        lblEmpApellidoP.setLocation(25, 325);

        txtEmpApellidoP = new JTextField();
        txtEmpApellidoP.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtEmpApellidoP.setForeground(new Color(0, 0, 0));
        txtEmpApellidoP.setSize(new Dimension(200, 25));
        txtEmpApellidoP.setLocation(25, 355);
        txtEmpApellidoP.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        txtEmpApellidoP.setToolTipText("M\u00e1ximo 20 caracteres");
        txtEmpApellidoP.addKeyListener(this);
        txtEmpApellidoP.setEditable(false);

        lblEmpApellidoM = new JLabel("Apellido Materno: ");
        lblEmpApellidoM.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblEmpApellidoM.setForeground(new Color(0, 0, 0));
        lblEmpApellidoM.setSize(new Dimension(200, 25));
        lblEmpApellidoM.setLocation(25, 385);

        txtEmpApellidoM = new JTextField();
        txtEmpApellidoM.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtEmpApellidoM.setForeground(new Color(0, 0, 0));
        txtEmpApellidoM.setSize(new Dimension(200, 25));
        txtEmpApellidoM.setLocation(25, 415);
        txtEmpApellidoM.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        txtEmpApellidoM.setToolTipText("M\u00e1ximo 20 caracteres");
        txtEmpApellidoM.addKeyListener(this);
        txtEmpApellidoM.setEditable(false);
        
        lblEmpCalle = new JLabel("Calle: ");
        lblEmpCalle.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblEmpCalle.setForeground(new Color(0, 0, 0));
        lblEmpCalle.setSize(new Dimension(200, 25));
        lblEmpCalle.setLocation(25, 445);

        txtEmpCalle = new JTextField();
        txtEmpCalle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtEmpCalle.setForeground(new Color(0, 0, 0));
        txtEmpCalle.setSize(new Dimension(200, 25));
        txtEmpCalle.setLocation(25, 475);
        txtEmpCalle.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        txtEmpCalle.setToolTipText("M\u00e1ximo 50 caracteres");
        txtEmpCalle.addKeyListener(this);
        txtEmpCalle.setEditable(false);

        lblEmpNumExt = new JLabel("N\u00fam. Exterior: ");
        lblEmpNumExt.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblEmpNumExt.setForeground(new Color(0, 0, 0));
        lblEmpNumExt.setSize(new Dimension(200, 25));
        lblEmpNumExt.setLocation(25, 505);

        txtEmpNumExt = new JTextField();
        txtEmpNumExt.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtEmpNumExt.setForeground(new Color(0, 0, 0));
        txtEmpNumExt.setSize(new Dimension(200, 25));
        txtEmpNumExt.setLocation(25, 535);
        txtEmpNumExt.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        txtEmpNumExt.setToolTipText("M\u00e1ximo 5 caracteres");
        txtEmpNumExt.addKeyListener(this);
        txtEmpNumExt.setEditable(false);
        /*Primer Columna*/
        lblEmpColonia = new JLabel("Colonia: ");
        lblEmpColonia.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblEmpColonia.setForeground(new Color(0, 0, 0));
        lblEmpColonia.setSize(new Dimension(200, 25));
        lblEmpColonia.setLocation(250, 205);

        txtEmpColonia = new JTextField();
        txtEmpColonia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtEmpColonia.setForeground(new Color(0, 0, 0));
        txtEmpColonia.setSize(new Dimension(200, 25));
        txtEmpColonia.setLocation(250, 235);
        txtEmpColonia.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        txtEmpColonia.setToolTipText("M\u00e1ximo 30 caracteres");
        txtEmpColonia.addKeyListener(this);
        txtEmpColonia.setEditable(false);

        lblEmpMunicipio = new JLabel("Municipio: ");
        lblEmpMunicipio.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblEmpMunicipio.setForeground(new Color(0, 0, 0));
        lblEmpMunicipio.setSize(new Dimension(200, 25));
        lblEmpMunicipio.setLocation(250, 265);

        txtEmpMunicipio = new JTextField();
        txtEmpMunicipio.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtEmpMunicipio.setForeground(new Color(0, 0, 0));
        txtEmpMunicipio.setSize(new Dimension(200, 25));
        txtEmpMunicipio.setLocation(250, 295);
        txtEmpMunicipio.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        txtEmpMunicipio.setToolTipText("M\u00e1ximo 30 caracteres");
        txtEmpMunicipio.addKeyListener(this);
        txtEmpMunicipio.setEditable(false);
        
        lblEmpEstado = new JLabel("Estado: ");
        lblEmpEstado.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblEmpEstado.setForeground(new Color(0, 0, 0));
        lblEmpEstado.setSize(new Dimension(200, 25));
        lblEmpEstado.setLocation(250, 325);

        cmbEmpEstados = new JComboBox();
        cmbEmpEstados.setModel(new javax.swing.DefaultComboBoxModel<>(listaEstados));
        cmbEmpEstados.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cmbEmpEstados.setForeground(new Color(0, 0, 0));
        cmbEmpEstados.setSize(new Dimension(200, 25));
        cmbEmpEstados.setLocation(250, 355);
        cmbEmpEstados.setEnabled(false);
        
        lblEmpNumero = new JLabel("N\u00famero: ");
        lblEmpNumero.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblEmpNumero.setForeground(new Color(0, 0, 0));
        lblEmpNumero.setSize(new Dimension(200, 25));
        lblEmpNumero.setLocation(250, 385);

        txtEmpNumero = new JTextField();
        txtEmpNumero.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtEmpNumero.setForeground(new Color(0, 0, 0));
        txtEmpNumero.setSize(new Dimension(200, 25));
        txtEmpNumero.setLocation(250, 415);
        txtEmpNumero.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        txtEmpNumero.setToolTipText("M\u00e1ximo 10 caracteres");
        txtEmpNumero.addKeyListener(this);
        txtEmpNumero.setEditable(false);

        lblEmpCargo = new JLabel("Cargo: ");
        lblEmpCargo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblEmpCargo.setForeground(new Color(0, 0, 0));
        lblEmpCargo.setSize(new Dimension(200, 25));
        lblEmpCargo.setLocation(250, 445);

        cmbEmpCargos = new JComboBox(listaCargos);
        cmbEmpCargos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cmbEmpCargos.setForeground(new Color(0, 0, 0));
        cmbEmpCargos.setSize(new Dimension(200, 25));
        cmbEmpCargos.setLocation(250, 475);
        cmbEmpCargos.addActionListener(this);
        cmbEmpCargos.setEnabled(false);

        lblEmpSalario = new JLabel("Salario: ");
        lblEmpSalario.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblEmpSalario.setForeground(new Color(0, 0, 0));
        lblEmpSalario.setSize(new Dimension(200, 25));
        lblEmpSalario.setLocation(250, 505);

        txtEmpSalario = new JTextField();
        txtEmpSalario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtEmpSalario.setForeground(new Color(0, 0, 0));
        txtEmpSalario.setSize(new Dimension(200, 25));
        txtEmpSalario.setLocation(250, 535);
        txtEmpSalario.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        txtEmpSalario.setToolTipText("M\u00e1ximo 5 caracteres");
        txtEmpSalario.addKeyListener(this);
        txtEmpSalario.setEditable(false);
        
        btnEmpBuscarID = new JButton("");
        btnEmpBuscarID.setIcon(new ImageIcon(this.getClass().getResource("/images/FindUserWhiteIcon.png")));
        btnEmpBuscarID.setBackground(new Color(45, 137, 239));
        btnEmpBuscarID.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        btnEmpBuscarID.setContentAreaFilled(false);
        btnEmpBuscarID.setOpaque(true);
        btnEmpBuscarID.setSize(new Dimension(28,25));
        btnEmpBuscarID.setLocation(362, 135);
        btnEmpBuscarID.addActionListener(this);
        btnEmpBuscarID.addMouseListener(this);
        
        btnEmpActualizar = new JButton("Actualizar");
        btnEmpActualizar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnEmpActualizar.setForeground(new Color(255,255,255));
        btnEmpActualizar.setBackground(new Color(45, 137, 239));
        btnEmpActualizar.setIcon(new ImageIcon(this.getClass().getResource("/images/UpdateUserWhiteIcon.png")));
        btnEmpActualizar.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        btnEmpActualizar.setContentAreaFilled(false);
        btnEmpActualizar.setOpaque(true);
        btnEmpActualizar.setFocusPainted(false);
        btnEmpActualizar.setSize(new Dimension(150,35));
        btnEmpActualizar.setLocation(50, 575);
        btnEmpActualizar.addActionListener(this);
        btnEmpActualizar.addMouseListener(this);

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
        btnEmpCancelar.setLocation(275, 575);
        btnEmpCancelar.addActionListener(this);
        btnEmpCancelar.addMouseListener(this);
        
        pnlBackground.add(lblEmpTitle);
        pnlBackground.add(btnEmpFoto);
        pnlBackground.add(lblEmpID);
        pnlBackground.add(txtEmpID);
        pnlBackground.add(btnEmpBuscarID);
        pnlBackground.add(lblEmpNombre);
        pnlBackground.add(txtEmpNombre);
        pnlBackground.add(lblEmpApellidoP);
        pnlBackground.add(txtEmpApellidoP);
        pnlBackground.add(lblEmpApellidoM);
        pnlBackground.add(txtEmpApellidoM);
        pnlBackground.add(lblEmpCalle);
        pnlBackground.add(txtEmpCalle);
        pnlBackground.add(lblEmpNumExt);
        pnlBackground.add(txtEmpNumExt);
        pnlBackground.add(lblEmpColonia);
        pnlBackground.add(txtEmpColonia);
        pnlBackground.add(lblEmpMunicipio);
        pnlBackground.add(txtEmpMunicipio);
        pnlBackground.add(lblEmpEstado);
        pnlBackground.add(cmbEmpEstados);
        pnlBackground.add(lblEmpNumero);
        pnlBackground.add(txtEmpNumero);
        pnlBackground.add(lblEmpCargo);
        pnlBackground.add(cmbEmpCargos);
        pnlBackground.add(lblEmpSalario);
        pnlBackground.add(txtEmpSalario);
        pnlBackground.add(btnEmpActualizar);
        pnlBackground.add(btnEmpCancelar);
        
        add(pnlBackground);
        setVisible(true);
    }
    
    public VRecursosHumanosActualizar(JFrame parentFrame) {
        initFrame(parentFrame);
    }
    
//    public static void main(String[] args) {
//        new VRecursosHumanosActualizar(null);
//    }
/***********************************METODOS***********************************/    

    private File abrirCarpetaFotos() {
        File imagenUrl;
        int yesNot;
        jfcEmpBtnFoto = new JFileChooser("C:\\Users\\Alexis\\Pictures\\SrpskiFilms\\SrpskiEmpFoto");
        jfcEmpBtnFoto.setAccessory(new VPreviewChooser(jfcEmpBtnFoto));
        jfcEmpBtnFoto.setFileFilter(new FileNameExtensionFilter("png,jpg", "png", "jpg"));
        yesNot = jfcEmpBtnFoto.showOpenDialog(this);
        if (yesNot == JFileChooser.APPROVE_OPTION) {
            imagenUrl = jfcEmpBtnFoto.getSelectedFile();
            return imagenUrl;
        } else {
            return null;
        }
    }
    
    private void habilitarCampos() {
        btnEmpFoto.setEnabled(true);
        txtEmpID.setEditable(false);
        txtEmpNombre.setEditable(true);
        txtEmpApellidoP.setEditable(true);
        txtEmpApellidoM.setEditable(true);
        txtEmpCalle.setEditable(true);
        txtEmpNumExt.setEditable(true);
        txtEmpColonia.setEditable(true);
        txtEmpMunicipio.setEditable(true);
        cmbEmpEstados.setEnabled(true);
        txtEmpNumero.setEditable(true);
        cmbEmpCargos.setEnabled(true);
        txtEmpSalario.setEditable(true);
    }

    private void limpiarBloquearCampos(VRecursosHumanosActualizar vRHobj) {
        vRHobj.txtEmpID.setText("");
        vRHobj.txtEmpID.setEditable(false);
        vRHobj.txtEmpNombre.setText("");
        vRHobj.txtEmpNombre.setEditable(false);
        vRHobj.txtEmpApellidoP.setText("");
        vRHobj.txtEmpApellidoP.setEditable(false);
        vRHobj.txtEmpApellidoM.setText("");
        vRHobj.txtEmpApellidoM.setEditable(false);
        vRHobj.txtEmpCalle.setText("");
        vRHobj.txtEmpCalle.setEditable(false);
        vRHobj.txtEmpNumExt.setText("");
        vRHobj.txtEmpNumExt.setEditable(false);
        vRHobj.txtEmpColonia.setText("");
        vRHobj.txtEmpColonia.setEditable(false);
        vRHobj.txtEmpMunicipio.setText("");
        vRHobj.txtEmpMunicipio.setEditable(false);
        vRHobj.cmbEmpEstados.setSelectedIndex(0);
        vRHobj.cmbEmpEstados.setEnabled(false);
        vRHobj.txtEmpNumero.setText("");
        vRHobj.txtEmpNumero.setEditable(false);
        vRHobj.btnEmpFotoUrl = "";
        vRHobj.cmbEmpCargos.setSelectedIndex(0);
        vRHobj.cmbEmpCargos.setEnabled(false);
        vRHobj.txtEmpSalario.setText("");
        vRHobj.txtEmpSalario.setEditable(false);
        vRHobj.btnEmpFoto.setIcon(new ImageIcon(this.getClass().getResource("/images/PictureBlackIcon.png")));
        vRHobj.btnEmpFoto.setEnabled(false);
        vRHobj.txtEmpID.setEditable(true);
    }
    
    private void llenarCampos(MEmpleados empObj) {
        try {
            txtEmpNombre.setText(empObj.getEmpNombre());
            txtEmpApellidoP.setText(empObj.getEmpApellidoP());
            txtEmpApellidoM.setText(empObj.getEmpApellidoM());
            txtEmpCalle.setText(empObj.getEmpCalle());
            txtEmpNumExt.setText(Integer.toString(empObj.getEmpNumExt()));
            txtEmpColonia.setText(empObj.getEmpColonia());
            txtEmpMunicipio.setText(empObj.getEmpMunicipio());
            cmbEmpEstados.setSelectedItem(empObj.getEmpEstado());
            txtEmpNumero.setText(Long.toString(empObj.getEmpNumero()));
            
            btnEmpFotoUrl = empObj.getEmpFoto();
            ImageIcon icEmpFoto = new ImageIcon(empObj.getEmpFoto());
            btnEmpFoto.setIcon(new ImageIcon(icEmpFoto.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
            
            cmbEmpCargos.setSelectedItem(empObj.getEmpCargo());
            txtEmpSalario.setText(Integer.toString(empObj.getEmpSalario()));
        } catch(Exception e) {
            System.out.println("llenarCampos"+e);
        }

    }
    
    private String comprobarCampos(VRecursosHumanosActualizar vRHobj) {

        if (vRHobj.txtEmpID.getText().length() < 1) {
            return "El campo empleado id no puede estar vacio";
        } else if (vRHobj.txtEmpNombre.getText().length() < 1) {
            return "El campo nombre no puede estar vacio";
        } else if (vRHobj.txtEmpApellidoP.getText().length() < 1) {
            return "El apellido paterno no puede estar vacio";
        } else if (vRHobj.txtEmpApellidoM.getText().length() < 1) {
            return "El apellido materno no puede estar vacio";
        } else if (vRHobj.txtEmpCalle.getText().length() < 1) {
            return "El campo calle no puede estar vacio";
        } else if (vRHobj.txtEmpNumExt.getText().length() < 1) {
            return "El numero exterior no puede estar vacio";
        } else if (vRHobj.txtEmpColonia.getText().length() < 1) {
            return "El campo colonia no puede estar vacio";
        } else if (vRHobj.txtEmpMunicipio.getText().length() < 1) {
            return "El campo municipio no puede estar vacio";
        } else if (vRHobj.cmbEmpEstados.getSelectedItem().toString().length() < 1) {
            return "El campo estado no puede estar vacio";
        } else if (vRHobj.txtEmpNumero.getText().length() < 1) {
            return "El campo numero no puede estar vacio";
        } else if (vRHobj.btnEmpFotoUrl.isEmpty()) {
            return "Debe seleccionar una imagen";
        } else if (vRHobj.cmbEmpCargos.getSelectedItem().toString().length() < 1) {
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
        
        if (evt.getSource() == btnEmpFoto) {
            try {
                btnEmpFotoUrl = abrirCarpetaFotos().toString();
                ImageIcon icEmpFoto = new ImageIcon(btnEmpFotoUrl);
                btnEmpFoto.setIcon(new ImageIcon(icEmpFoto.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
            } catch(NullPointerException e) {
                //new VOptionPane(this, "Debe seleccionar una imagen");
            }
        }
        
        if (evt.getSource() == btnEmpBuscarID) {
            System.out.println("Boton Buscar Apretado");
            if (txtEmpID.getText().length() < 1) {
                new VOptionPane(this, "Ingrese un ID");
            } else {
                if (empleadoDAO.DAOEmpSearch(txtEmpID.getText().toLowerCase()) != null) {
                    llenarCampos(empleadoDAO.DAOEmpSearch(txtEmpID.getText().toLowerCase()));
                    habilitarCampos();
                } else {
                    new VOptionPane(this, "Empleado No Encontrado, Verifique Datos");
                    txtEmpID.setText("");
                }

            }

        }
        if (evt.getSource() == btnEmpActualizar) {
            if (comprobarCampos(this).compareTo("ok") != 0) {
                new VOptionPane(this, comprobarCampos(this));
            } else {
                try {
                    empleadoObj = new MEmpleados(
                            txtEmpID.getText().toLowerCase(),
                            txtEmpNombre.getText().toLowerCase(),
                            txtEmpApellidoP.getText().toLowerCase(),
                            txtEmpApellidoM.getText().toLowerCase(),
                            txtEmpCalle.getText().toLowerCase(),
                            Integer.parseInt(txtEmpNumExt.getText()),
                            txtEmpColonia.getText().toLowerCase(),
                            txtEmpMunicipio.getText().toLowerCase(),
                            cmbEmpEstados.getSelectedItem().toString().toLowerCase(),
                            Long.parseLong(txtEmpNumero.getText()),
                            btnEmpFotoUrl.toString().toLowerCase(),
                            cmbEmpCargos.getSelectedItem().toString().toLowerCase(),
                            Integer.parseInt(txtEmpSalario.getText()));
                } catch (Exception e) {
                    new VOptionPane(this, e.toString());
                }
                try {
                    if (empleadoDAO.DAOEmpUpdate(empleadoObj)) {
                        new VOptionPane(this, "Empleado Actualizado");
                        System.out.println("Actualizo Correctamente");
                        limpiarBloquearCampos(this);
                        
                    }
                } catch (Exception e) {
                    new VOptionPane(this, e.toString());
                }
            }
        }
        if (evt.getSource() == btnEmpCancelar) {
            this.dispose();
        }
    }
    /**********************************Mouse**********************************/
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == btnEmpBuscarID) {
            btnEmpBuscarID.setBackground(new Color(43, 87, 151));
        }
        if (e.getSource() == btnEmpActualizar) {
            btnEmpActualizar.setBackground(new Color(43, 87, 151));
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
        if (e.getSource() == btnEmpActualizar) {
            btnEmpActualizar.setBackground(new Color(45, 137, 239));
        }
        if (e.getSource() == btnEmpCancelar) {
            btnEmpCancelar.setBackground(new Color(238, 17, 17));
        }
    }
       
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    
    /*********************************Teclado*********************************/
    @Override
    public void keyTyped(KeyEvent evt) {
        if (evt.getSource() == txtEmpID) {
            if (txtEmpID.getText().length() == numEmpIDMax) {
                evt.consume();
            }
        }
        if (evt.getSource() == txtEmpNombre) {
            if (txtEmpNombre.getText().length() == numEmpNombreMax) {
                evt.consume();
            }
        }
        if (evt.getSource() == txtEmpApellidoP) {
            if (txtEmpApellidoP.getText().length() == numEmpApellidoPMax) {
                evt.consume();
            }
        }
        if (evt.getSource() == txtEmpApellidoM) {
            if (txtEmpApellidoM.getText().length() == numEmpApellidoMMax) {
                evt.consume();
            }
        }
        if (evt.getSource() == txtEmpCalle) {
            if (txtEmpCalle.getText().length() == numEmpCalleMax) {
                evt.consume();
            }
        }
        if (evt.getSource() == txtEmpNumExt) {
            if (txtEmpNumExt.getText().length() == numEmpNumExtMax) {
                evt.consume();
            }
        }
        if (evt.getSource() == txtEmpColonia) {
            if (txtEmpColonia.getText().length() == numEmpColoniaMax) {
                evt.consume();
            }
        }
        if (evt.getSource() == txtEmpMunicipio) {
            if (txtEmpMunicipio.getText().length() == numEmpMunicipioMax) {
                evt.consume();
            }
        }
        if (evt.getSource() == txtEmpNumero) {
            if (txtEmpNumero.getText().length() == numEmpNumeroMax) {
                evt.consume();
            }
        }
        if (evt.getSource() == txtEmpSalario) {
            if (txtEmpSalario.getText().length() == numEmpSalarioMax) {
                evt.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
}