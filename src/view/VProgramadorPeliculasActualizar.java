package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.MClasificaciones;
import model.MClasificacionesDAO;
import model.MGeneros;
import model.MGenerosDAO;
import model.MPeliculas;
import model.MPeliculasDAO;

/**
 * Hecho con <3 por: 
 * @author Alexis (GarciHard)
 */
public class VProgramadorPeliculasActualizar extends JDialog implements ActionListener, MouseListener, KeyListener{

    private final MClasificacionesDAO claDAO = new MClasificacionesDAO();
    private final MGenerosDAO genDAO = new MGenerosDAO();
    private final MPeliculasDAO pelDAO = new MPeliculasDAO();
    private MClasificaciones claObj;
    private MGeneros genObj;
    private MPeliculas pelObj;
    
    private DefaultComboBoxModel cmbClaModel;
    private DefaultComboBoxModel cmbGenModel;
    
    private JButton btnPeliculaImg;
    private JButton btnPeliculaAceptar;
    private JButton btnPeliculaCancelar;
    
    private JComboBox cmbClasificacion;
    private JComboBox cmbGenero;
    
    private JFileChooser jfcBtnPelImg;
    private String btnPeliculaImgURL = "";
            
    private JLabel lblDepartmentTitle;
    private JLabel lblPeliculaID;
    private JLabel lblPeliculaNombre;
    private JLabel lblPeliculaGenero;
    private JLabel lblPeliculaClasif;
    private JLabel lblPeliculaDuracion;
    private JLabel lblPeliculaDuracionMins;
    private JLabel lblPeliculaEstado;
    
    private ButtonGroup btgPeliculasGroup;
    private JRadioButton rdbPeliculaEstadoA;
    private JRadioButton rdbPeliculaEstadoB;
    private char rdbPeliculaEstado = '\0';
    
    private JPanel pnlBackground;
    
    private JTextField txtPeliculaID;
    private JTextField txtPeliculaNombre;
    private JTextField txtPeliculaDuracion;

    private JMenu mnuArchivo;
    private JMenu mnuEditar;
    private JMenuBar mnbMenuPrincipal;
    private JMenuItem mniBuscarID;
    private JMenuItem mniEliminarPelicula;
    
    private void initFrame(JFrame parentFrame) {
        setTitle("Programador de Peliculas");
        setSize(new Dimension(540,380));
        setResizable(false);
        setModal(true);
        setLocationRelativeTo(parentFrame);
        
        pnlBackground = new JPanel(null);
        pnlBackground.setSize(getWidth(), getHeight());
        pnlBackground.setBackground(new Color(230, 233, 237));

        mnbMenuPrincipal = new JMenuBar();
        mnbMenuPrincipal.setBackground(new Color(255,255,255));
        mnbMenuPrincipal.setBorderPainted(true);
        
        mnuArchivo = new JMenu("Archivo");
        mnuArchivo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        mnuArchivo.setForeground(new Color(0,0,0));
        mnuArchivo.setBackground(new Color(255,255,255));
        
        mnuEditar = new JMenu("Editar");
        mnuEditar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        mnuEditar.setForeground(new Color(0,0,0));
        mnuEditar.setBackground(new Color(255,255,255));
        
        mniBuscarID = new JMenuItem("Buscar por ID de Pelicula");
        mniBuscarID.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        mniBuscarID.setForeground(new Color(0,0,0));
        mniBuscarID.setBackground(new Color(255,255,255));
        mniBuscarID.addActionListener(this);
        
        mniEliminarPelicula = new JMenuItem("Eliminar Pelicula");
        mniEliminarPelicula.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        mniEliminarPelicula.setForeground(new Color(0, 0, 0));
        mniEliminarPelicula.setBackground(new Color(255, 255, 255));
        mniEliminarPelicula.addActionListener(this);

        mnuArchivo.add(mniBuscarID);
        mnuEditar.add(mniEliminarPelicula);
        mnbMenuPrincipal.add(mnuArchivo);
        mnbMenuPrincipal.add(mnuEditar);
        
        /**/
        lblDepartmentTitle = new JLabel("Actualizar Película",SwingConstants.LEFT);
        lblDepartmentTitle.setForeground(new Color(0,0,0));
        lblDepartmentTitle.setFont(new Font("Segoe UI SemiLight", Font.PLAIN, 24));
        //lblDepartmentTitle.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        lblDepartmentTitle.setSize(new Dimension(520,50));
        lblDepartmentTitle.setLocation(10,0);
        
        btnPeliculaImg = new JButton();
        btnPeliculaImg.setIcon(new ImageIcon(this.getClass().getResource("/images/FilmBlackIcon.png")));
        btnPeliculaImg.setContentAreaFilled(false);
        btnPeliculaImg.setFocusPainted(false);
        btnPeliculaImg.setOpaque(true);
        btnPeliculaImg.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        btnPeliculaImg.setSize(new Dimension(150,200));
        btnPeliculaImg.setLocation(10,55);
        btnPeliculaImg.addActionListener(this);
        btnPeliculaImg.setEnabled(false);
        
        lblPeliculaID = new JLabel("ID Película: ", SwingConstants.LEFT);
        lblPeliculaID.setForeground(new Color(0,0,0));
        lblPeliculaID.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        //lblPeliculaID.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        lblPeliculaID.setSize(new Dimension(100,25));
        lblPeliculaID.setLocation(170,55);
        
        txtPeliculaID = new JTextField();
        txtPeliculaID.setForeground(new Color(0,0,0));
        txtPeliculaID.setFont(new Font("Segoe UI", Font.PLAIN,14));
        txtPeliculaID.setHorizontalAlignment(SwingConstants.CENTER);
        txtPeliculaID.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        txtPeliculaID.setSize(new Dimension(150,25));
        txtPeliculaID.setLocation(320,55);
        txtPeliculaID.setEditable(false);
        
        lblPeliculaNombre = new JLabel("Nombre Película: ", SwingConstants.LEFT);
        lblPeliculaNombre.setForeground(new Color(0,0,0));
        lblPeliculaNombre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        //lblPeliculaNombre.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        lblPeliculaNombre.setSize(new Dimension(150, 25));
        lblPeliculaNombre.setLocation(170, 90);

        txtPeliculaNombre = new JTextField();
        txtPeliculaNombre.setForeground(new Color(0, 0, 0));
        txtPeliculaNombre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPeliculaNombre.setHorizontalAlignment(SwingConstants.CENTER);
        txtPeliculaNombre.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        txtPeliculaNombre.setSize(new Dimension(200, 25));
        txtPeliculaNombre.setLocation(320, 90);
        txtPeliculaNombre.addKeyListener(this);
        txtPeliculaNombre.setEditable(false);
        
        lblPeliculaClasif = new JLabel("Clasificación: ", SwingConstants.LEFT);
        lblPeliculaClasif.setForeground(new Color(0,0,0));
        lblPeliculaClasif.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        //lblPeliculaClasif.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        lblPeliculaClasif.setSize(new Dimension(150,25));
        lblPeliculaClasif.setLocation(170, 125);
        
        cmbClaModel = new DefaultComboBoxModel();
        for (int i = 0; i < claDAO.clasificacionesArr().size(); i++) {
            claObj = claDAO.clasificacionesArr().get(i);
            cmbClaModel.addElement(claObj.getClasificacionID());
        }
        cmbClasificacion = new JComboBox(cmbClaModel);
        cmbClasificacion.setBackground(new Color(255,255,255));
        cmbClasificacion.setForeground(new Color(0, 0, 0));
        cmbClasificacion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        cmbClasificacion.setSize(new Dimension(200, 25));
        cmbClasificacion.setLocation(320, 125);
        cmbClasificacion.addActionListener(this);
        cmbClasificacion.setEnabled(false);
        
        lblPeliculaGenero = new JLabel("Género: ", SwingConstants.LEFT);
        lblPeliculaGenero.setForeground(new Color(0,0,0));
        lblPeliculaGenero.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        //lblPeliculaGenero.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        lblPeliculaGenero.setSize(new Dimension(150, 25));
        lblPeliculaGenero.setLocation(170, 160);

        /*****/
        cmbGenModel = new DefaultComboBoxModel();
        for (int i = 0; i < genDAO.generosArr().size(); i++) {
            genObj = genDAO.generosArr().get(i);
            cmbGenModel.addElement(genObj.getGeneroNombre());
        }
        cmbGenero = new JComboBox(cmbGenModel);
        cmbGenero.setBackground(new Color(255,255,255));
        cmbGenero.setForeground(new Color(0,0,0));
        cmbGenero.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        cmbGenero.setSize(new Dimension(200, 25));
        cmbGenero.setLocation(320, 160);
        cmbGenero.addActionListener(this);
        cmbGenero.setEnabled(false);
        
        lblPeliculaDuracion = new JLabel("Duración: ", SwingConstants.LEFT);
        lblPeliculaDuracion.setForeground(new Color(0,0,0));
        lblPeliculaDuracion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        //lblPeliculaDuracion.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        lblPeliculaDuracion.setSize(new Dimension(150, 25));
        lblPeliculaDuracion.setLocation(170, 195);

        txtPeliculaDuracion = new JTextField();
        txtPeliculaDuracion.setForeground(new Color(0, 0, 0));
        txtPeliculaDuracion.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPeliculaDuracion.setHorizontalAlignment(SwingConstants.CENTER);
        txtPeliculaDuracion.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        txtPeliculaDuracion.setSize(new Dimension(120, 25));
        txtPeliculaDuracion.setLocation(320, 195);
        txtPeliculaDuracion.addKeyListener(this);
        txtPeliculaDuracion.setEditable(false);

        lblPeliculaDuracionMins = new JLabel("Minutos", SwingConstants.CENTER);
        lblPeliculaDuracionMins.setForeground(new Color(0, 0, 0));
        lblPeliculaDuracionMins.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        //lblPeliculaDuracionMins.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        lblPeliculaDuracionMins.setSize(new Dimension(100, 25));
        lblPeliculaDuracionMins.setLocation(440, 195);
        
        lblPeliculaEstado = new JLabel("Estado: ", SwingConstants.LEFT);
        lblPeliculaEstado.setForeground(new Color(0,0,0));
        lblPeliculaEstado.setFont(new Font("Segoe UI", Font.PLAIN,16));
        //lblPeliculaEstado.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        lblPeliculaEstado.setSize(new Dimension(150,25));
        lblPeliculaEstado.setLocation(170, 230);
        
        btgPeliculasGroup = new ButtonGroup();
        rdbPeliculaEstadoA = new JRadioButton("Activa");
        rdbPeliculaEstadoA.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        rdbPeliculaEstadoA.setSize(new Dimension(100, 25));
        rdbPeliculaEstadoA.setSelected(false);
        rdbPeliculaEstadoA.setLocation(320, 230);
        rdbPeliculaEstadoA.setFocusPainted(false);
        rdbPeliculaEstadoA.addActionListener(this);
        rdbPeliculaEstadoA.setEnabled(false);
        
        rdbPeliculaEstadoB = new JRadioButton("Inactiva");
        rdbPeliculaEstadoB.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        rdbPeliculaEstadoB.setSize(new Dimension(100, 25));
        rdbPeliculaEstadoB.setSelected(false);
        rdbPeliculaEstadoB.setLocation(420, 230);
        rdbPeliculaEstadoB.setFocusPainted(false);
        rdbPeliculaEstadoB.addActionListener(this);
        rdbPeliculaEstadoB.setEnabled(false);

        btnPeliculaAceptar = new JButton("Actualizar");
        btnPeliculaAceptar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnPeliculaAceptar.setForeground(new Color(255, 255, 255));
        btnPeliculaAceptar.setIcon(new ImageIcon(this.getClass().getResource("/images/UpdateWhiteIcon.png")));
        btnPeliculaAceptar.setBackground(new Color(45, 137, 239));
        btnPeliculaAceptar.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnPeliculaAceptar.setContentAreaFilled(false);
        btnPeliculaAceptar.setFocusPainted(false);
        btnPeliculaAceptar.setOpaque(true);
        btnPeliculaAceptar.setSize(new Dimension(200, 35));
        btnPeliculaAceptar.setLocation(25, 275);

        btnPeliculaCancelar = new JButton("Cancelar");
        btnPeliculaCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnPeliculaCancelar.setForeground(new Color(255, 255, 255));
        btnPeliculaCancelar.setIcon(new ImageIcon(this.getClass().getResource("/images/CancelWhiteIcon.png")));
        btnPeliculaCancelar.setBackground(new Color(238, 17, 17));
        btnPeliculaCancelar.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnPeliculaCancelar.setContentAreaFilled(false);
        btnPeliculaCancelar.setFocusPainted(false);
        btnPeliculaCancelar.setOpaque(true);
        btnPeliculaCancelar.setSize(new Dimension(200, 35));
        btnPeliculaCancelar.setLocation(305, 275);
        btnPeliculaCancelar.addActionListener(this);
        btnPeliculaCancelar.addMouseListener(this);
        
        btgPeliculasGroup.add(rdbPeliculaEstadoA);
        btgPeliculasGroup.add(rdbPeliculaEstadoB);
        
        pnlBackground.add(lblDepartmentTitle);
        pnlBackground.add(btnPeliculaImg);
        pnlBackground.add(lblPeliculaID);
        pnlBackground.add(txtPeliculaID);
        pnlBackground.add(lblPeliculaNombre);
        pnlBackground.add(txtPeliculaNombre);
        pnlBackground.add(lblPeliculaClasif);
        pnlBackground.add(cmbClasificacion);
        pnlBackground.add(lblPeliculaGenero);
        pnlBackground.add(cmbGenero);
        pnlBackground.add(lblPeliculaDuracion);
        pnlBackground.add(txtPeliculaDuracion);
        pnlBackground.add(lblPeliculaDuracionMins);
        pnlBackground.add(lblPeliculaEstado);
        pnlBackground.add(rdbPeliculaEstadoA);
        pnlBackground.add(rdbPeliculaEstadoB);
        pnlBackground.add(btnPeliculaAceptar);
        pnlBackground.add(btnPeliculaCancelar);
        
        add(pnlBackground);
        setJMenuBar(mnbMenuPrincipal);
        setVisible(true);
    }

    public VProgramadorPeliculasActualizar(JFrame parentFrame) {
        initFrame(parentFrame);
    }

//    public static void main(String[] args) {
//        new VProgramadorPeliculasActualizar(null);
//    }
    
/*************************************************** METODOS ***************************************************/    
    private File abrirCarpetaFotos() {/**Busca imagen en el sistema**/
        File imagenUrl;
        int yesNot;
        jfcBtnPelImg = new JFileChooser("C:\\Users\\Alexis\\Pictures\\SrpskiFilms\\SrpskiPelFoto");
        jfcBtnPelImg.setAccessory(new VPreviewChooser(jfcBtnPelImg));
        jfcBtnPelImg.setFileFilter(new FileNameExtensionFilter("png,jpg", "png", "jpg"));
        yesNot = jfcBtnPelImg.showOpenDialog(this);
        if (yesNot == JFileChooser.APPROVE_OPTION) {
            imagenUrl = jfcBtnPelImg.getSelectedFile();
            return imagenUrl;
        } else {
            return null;
        }
    }
    private String buscarGeneroID(String genNombre) {/**Busca generos**/
        String genID = "";
        for (int i = 0; i < genDAO.generosArr().size(); i++) {
            genObj = genDAO.generosArr().get(i);
            if (genObj.getGeneroNombre().compareTo(genNombre) == 0) {
                genID = genObj.getGeneroID();
            }
        }
        return genID;
    }
    private String comprobarCampos(VProgramadorPeliculasActualizar vProgObj) {/**Valida los campos**/
        if (vProgObj.txtPeliculaID.getText().length() < 1) {
            return "El campo \"ID PELICULA\" no puede estar vacio";
        } else if (vProgObj.txtPeliculaNombre.getText().length() < 1) {
            return "El campo \"NOMBRE PELICULA\" no puede estar vacio";
        } else if (vProgObj.cmbClasificacion.getSelectedItem().toString().length() < 1) {
            return "El campo \"CLASIFICACION\" no puede estar vacio";
        } else if (vProgObj.cmbGenero.getSelectedItem().toString().length() < 1) {
            return "El campo \"GENERO\" no puede estar vacio";
        } else if (vProgObj.txtPeliculaDuracion.getText().length() < 1) {
            return "El campo \"DURACION\" no puede estar vacio";
        } else if (vProgObj.btnPeliculaImgURL.isEmpty()) {
            return "Debe seleccionar una imagen";
        } else if (vProgObj.rdbPeliculaEstado == '\0') {
            return "Debe seleccionar un \"ESTADO\"";
        } else {
            return "ok";
        }
    }
    private void limpiarCampos(VProgramadorPeliculasActualizar vProgObj) {/**Limpia la interfaz**/
    vProgObj.txtPeliculaID.setText("");
    vProgObj.txtPeliculaNombre.setText("");
    vProgObj.cmbClasificacion.setSelectedIndex(0);
    vProgObj.cmbGenero.setSelectedIndex(0);
    vProgObj.txtPeliculaDuracion.setText("");
    vProgObj.btnPeliculaImgURL = "";
    vProgObj.rdbPeliculaEstado = '\0';
    vProgObj.rdbPeliculaEstadoA.setSelected(false);
    vProgObj.rdbPeliculaEstadoB.setSelected(false);
    vProgObj.btnPeliculaImg.setIcon(new ImageIcon(this.getClass().getResource("/images/FilmBlackIcon.png")));
}
    
    private void llenarCampos(MPeliculas pelObj) {
        try {
            txtPeliculaID.setText(pelObj.getPeliculaID());
            txtPeliculaNombre.setText(pelObj.getPeliculaNombre());
            txtPeliculaDuracion.setText(Integer.toString(pelObj.getPeliculaDuracion()));
            
            cmbClasificacion.setSelectedItem(pelObj.getClasificacionID());
            cmbGenero.setSelectedItem(pelObj.getGeneroID());
            
            btnPeliculaImgURL = pelObj.getPeliculaImagen();
            ImageIcon icPel = new ImageIcon(pelObj.getPeliculaImagen());
            btnPeliculaImg.setIcon(new ImageIcon(icPel.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH)));
            
            if (String.valueOf(pelObj.getPeliculaEstado()).compareTo("V") == 0) {
                rdbPeliculaEstadoA.setSelected(true);
                rdbPeliculaEstadoB.setSelected(false);
                rdbPeliculaEstado = 'V';
            } else if (String.valueOf(pelObj.getPeliculaEstado()).compareTo("F") == 0) {
                rdbPeliculaEstadoA.setSelected(false);
                rdbPeliculaEstadoB.setSelected(true);
                rdbPeliculaEstado = 'F';
            } else {
                rdbPeliculaEstadoA.setSelected(false);
                rdbPeliculaEstadoB.setSelected(false);
                rdbPeliculaEstado = '\0';
            }
            
        } catch (Exception e) {
            System.out.println("llenarCamposPelAct:" + e);
        }
    }
    private void habilitarCampos(boolean siNo) {
        txtPeliculaNombre.setEditable(siNo);
        txtPeliculaDuracion.setEditable(siNo);
        cmbClasificacion.setEnabled(siNo);
        cmbGenero.setEnabled(siNo);
        btnPeliculaImg.setEnabled(siNo);
        rdbPeliculaEstadoA.setEnabled(siNo);
        rdbPeliculaEstadoB.setEnabled(siNo);
        if (siNo) {
            btnPeliculaAceptar.addActionListener(this);
            btnPeliculaAceptar.addMouseListener(this);
        } else {
            btnPeliculaAceptar.removeActionListener(this);
            btnPeliculaAceptar.removeMouseListener(this);
        }
    }
    private boolean validarCampos(VProgramadorPeliculasActualizar vProgObj) {
        return vProgObj.txtPeliculaNombre.getText().length() > 0
            || vProgObj.txtPeliculaDuracion.getText().length() > 0;
    }
//    private String buscarClasifID(String claID) {
//        String clasID = "";
//        for (int i = 0; i < claDAO.clasificacionesArr().size(); i++) {
//            claObj = claDAO.clasificacionesArr().get(i);
//            if (claObj.getClasificacionID().compareTo(claID) == 0) {
//                clasID = claObj.getClasificacionID();
//            }
//        }
//        return clasID;
//    }


/************************************************** INTERFACES **************************************************/
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == btnPeliculaImg) {
            try {
                btnPeliculaImgURL = abrirCarpetaFotos().toString();
                ImageIcon icPelImg = new ImageIcon(btnPeliculaImgURL);
                btnPeliculaImg.setIcon(new ImageIcon(icPelImg.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH)));
            } catch (Exception e) {
                new VOptionPane(this, "Debe seleccionar una imagen");
            }
        }
        if (evt.getSource() == rdbPeliculaEstadoA) {
            rdbPeliculaEstado = 'V';
            System.out.println("-> " + rdbPeliculaEstado);
        }
        if (evt.getSource() == rdbPeliculaEstadoB) {
            rdbPeliculaEstado = 'F';
            System.out.println("-> " + rdbPeliculaEstado);
        }
        
        if (evt.getSource() == mniBuscarID) {
            String ID;
            ID = JOptionPane.showInputDialog(this, "Ingrese un ID", "Busqueda de Pelicula por ID", JOptionPane.PLAIN_MESSAGE).toUpperCase();
            if (ID.length() < 1) {
                new VOptionPane(this, "Ingrese un ID");
            } else {
                if (pelDAO.findPeliculas(ID) != null) {
                    llenarCampos(pelDAO.findPeliculas(ID));
                    habilitarCampos(true);
                } else {
                    new VOptionPane(this, "Pelicula No Encontrada, Verifique Datos");
                }
            }
        }
        
        //****//
        if (evt.getSource() == mniEliminarPelicula) {
            String ID2 = "";
            try {
                ID2 = JOptionPane.showInputDialog(this, "Ingrese un ID", "Eliminación de Pelicula por ID", JOptionPane.PLAIN_MESSAGE).toUpperCase();
                if (ID2.length() > 1 && ID2.compareTo("") != 0) {
                    if (JOptionPane.showConfirmDialog(this, "Desea eliminar la siguiente pelicula?\n\n"
                            + "Nombre: " + pelDAO.findPeliculas(ID2).getPeliculaNombre()
                            + "\nClasificacion: " + pelDAO.findPeliculas(ID2).getClasificacionID()
                            + "\nGenero: " + pelDAO.findPeliculas(ID2).getGeneroID() + "\n",
                            "Confirmacion de Eliminación", JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {

                        if (pelDAO.deletePelicula(ID2)) {
                            new VOptionPane(this, "Pelicula Eliminada");
                        } else {
                            new VOptionPane(this, "Pelicula No Encontrada");
                        }

                    } else {
                        System.out.println("Registro no valido");
                    }
                } else {
                    System.out.println("Pelicula No Encontrada");
                }

            } catch (Exception e) {
                //new VOptionPane(this, "Ingrese un valor de busqueda");
                System.out.println("error: " + e);
            }
        }
       //****//
        
        if (evt.getSource() == btnPeliculaAceptar) {
            if (comprobarCampos(this).compareTo("ok") != 0) {
                new VOptionPane(this, comprobarCampos(this));
            } else {
                try {
                    pelObj = new MPeliculas(txtPeliculaID.getText().toUpperCase(),
                            txtPeliculaNombre.getText().toUpperCase(),
                            buscarGeneroID(cmbGenero.getSelectedItem().toString()),
                            cmbClasificacion.getSelectedItem().toString(),
                            Integer.parseInt(txtPeliculaDuracion.getText()),
                            btnPeliculaImgURL.toUpperCase(),
                            rdbPeliculaEstado);
                } catch (Exception e) {
                    new VOptionPane(this, e.toString());
                }
                try {
                    if (pelDAO.updatePelicula(pelObj)) {
                        new VOptionPane(this, "Pelicula Actualizada");
                        habilitarCampos(false);
                        limpiarCampos(this);
                    }
                } catch (Exception e) {
                    new VOptionPane(this, e.toString());
                }
            }
        }
        if (evt.getSource() == btnPeliculaCancelar) {
            if (validarCampos(this)) {
                limpiarCampos(this);
                habilitarCampos(false);
            } else {
                this.dispose();
            }
        }
    }
    
    @Override
    public void keyTyped(KeyEvent evt) {
        if (evt.getSource() == txtPeliculaNombre) {
            if (txtPeliculaNombre.getText().length() == 150) {
                evt.consume();
                new VOptionPane(this,"Num. Caracteres excedido");
            }
        }
        if (evt.getSource() == txtPeliculaDuracion) {
            if (txtPeliculaDuracion.getText().length() == 3) {
                evt.consume();
                new VOptionPane(this,"Num. Caracteres excedido");
            }
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void mousePressed(MouseEvent evt) {
        if (evt.getSource() == btnPeliculaAceptar) {
            btnPeliculaAceptar.setBackground(new Color(43, 87, 151));
        }
        if (evt.getSource() == btnPeliculaCancelar) {
            btnPeliculaCancelar.setBackground(new Color(185, 29, 71));
        }
    }
    @Override
    public void mouseReleased(MouseEvent evt) {
        if (evt.getSource() == btnPeliculaAceptar) {
            btnPeliculaAceptar.setBackground(new Color(45, 137, 239));
        }
        if (evt.getSource() == btnPeliculaCancelar) {
            btnPeliculaCancelar.setBackground(new Color(238, 17, 17));
        }
    }
    @Override
    public void mouseEntered(MouseEvent evt) {}
    @Override
    public void mouseExited(MouseEvent evt) {}
    @Override
    public void mouseClicked(MouseEvent evt) {}
}