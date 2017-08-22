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
public class VProgramadorPeliculasCrear extends JDialog implements ActionListener, MouseListener, KeyListener{

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
    
    private void initFrame(JFrame parentFrame) {
        setTitle("Programador de Peliculas");
        setSize(new Dimension(540,380));
        setResizable(false);
        setModal(true);
        setLocationRelativeTo(parentFrame);
        
        pnlBackground = new JPanel(null);
        pnlBackground.setSize(getWidth(), getHeight());
        pnlBackground.setBackground(new Color(230, 233, 237));
        /**/
        lblDepartmentTitle = new JLabel("Agregar Película",SwingConstants.LEFT);
        lblDepartmentTitle.setForeground(new Color(0,0,0));
        lblDepartmentTitle.setFont(new Font("Segoe UI SemiLight", Font.PLAIN, 24));
        //lblDepartmentTitle.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        lblDepartmentTitle.setSize(new Dimension(520,50));
        lblDepartmentTitle.setLocation(10,10);
        
        btnPeliculaImg = new JButton();
        btnPeliculaImg.setIcon(new ImageIcon(this.getClass().getResource("/images/FilmBlackIcon.png")));
        btnPeliculaImg.setContentAreaFilled(false);
        btnPeliculaImg.setFocusPainted(false);
        btnPeliculaImg.setOpaque(true);
        btnPeliculaImg.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        btnPeliculaImg.setSize(new Dimension(150,200));
        btnPeliculaImg.setLocation(10,70);
        btnPeliculaImg.addActionListener(this);
        
        lblPeliculaID = new JLabel("ID Película: ", SwingConstants.LEFT);
        lblPeliculaID.setForeground(new Color(0,0,0));
        lblPeliculaID.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        //lblPeliculaID.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        lblPeliculaID.setSize(new Dimension(100,25));
        lblPeliculaID.setLocation(170,70);
        
        txtPeliculaID = new JTextField("PEL"+peliculaID(pelDAO.nvoPeliculaID()));
        txtPeliculaID.setHorizontalAlignment(SwingConstants.CENTER);
        txtPeliculaID.setForeground(new Color(0,0,0));
        txtPeliculaID.setFont(new Font("Segoe UI", Font.PLAIN,14));
        txtPeliculaID.setHorizontalAlignment(SwingConstants.CENTER);
        txtPeliculaID.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        txtPeliculaID.setSize(new Dimension(150,25));
        txtPeliculaID.setLocation(320,70);
        txtPeliculaID.setEditable(false);
        
        lblPeliculaNombre = new JLabel("Nombre Película: ", SwingConstants.LEFT);
        lblPeliculaNombre.setForeground(new Color(0,0,0));
        lblPeliculaNombre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        //lblPeliculaNombre.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        lblPeliculaNombre.setSize(new Dimension(150, 25));
        lblPeliculaNombre.setLocation(170, 105);

        txtPeliculaNombre = new JTextField();
        txtPeliculaNombre.setForeground(new Color(0, 0, 0));
        txtPeliculaNombre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPeliculaNombre.setHorizontalAlignment(SwingConstants.CENTER);
        txtPeliculaNombre.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        txtPeliculaNombre.setSize(new Dimension(200, 25));
        txtPeliculaNombre.setLocation(320, 105);
        txtPeliculaNombre.addKeyListener(this);
        
        lblPeliculaClasif = new JLabel("Clasificación: ", SwingConstants.LEFT);
        lblPeliculaClasif.setForeground(new Color(0,0,0));
        lblPeliculaClasif.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        //lblPeliculaClasif.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        lblPeliculaClasif.setSize(new Dimension(150,25));
        lblPeliculaClasif.setLocation(170, 140);
        
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
        cmbClasificacion.setLocation(320, 140);
        cmbClasificacion.addActionListener(this);
        
        lblPeliculaGenero = new JLabel("Género: ", SwingConstants.LEFT);
        lblPeliculaGenero.setForeground(new Color(0,0,0));
        lblPeliculaGenero.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        //lblPeliculaGenero.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        lblPeliculaGenero.setSize(new Dimension(150, 25));
        lblPeliculaGenero.setLocation(170, 175);

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
        cmbGenero.setLocation(320, 175);
        cmbGenero.addActionListener(this);
        
        lblPeliculaDuracion = new JLabel("Duración: ", SwingConstants.LEFT);
        lblPeliculaDuracion.setForeground(new Color(0,0,0));
        lblPeliculaDuracion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        //lblPeliculaDuracion.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        lblPeliculaDuracion.setSize(new Dimension(150, 25));
        lblPeliculaDuracion.setLocation(170, 210);

        txtPeliculaDuracion = new JTextField();
        txtPeliculaDuracion.setForeground(new Color(0, 0, 0));
        txtPeliculaDuracion.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPeliculaDuracion.setHorizontalAlignment(SwingConstants.CENTER);
        txtPeliculaDuracion.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        txtPeliculaDuracion.setSize(new Dimension(120, 25));
        txtPeliculaDuracion.setLocation(320, 210);
        txtPeliculaDuracion.addKeyListener(this);

        lblPeliculaDuracionMins = new JLabel("Minutos", SwingConstants.CENTER);
        lblPeliculaDuracionMins.setForeground(new Color(0, 0, 0));
        lblPeliculaDuracionMins.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        //lblPeliculaDuracionMins.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        lblPeliculaDuracionMins.setSize(new Dimension(100, 25));
        lblPeliculaDuracionMins.setLocation(440, 210);
        
        lblPeliculaEstado = new JLabel("Estado: ", SwingConstants.LEFT);
        lblPeliculaEstado.setForeground(new Color(0,0,0));
        lblPeliculaEstado.setFont(new Font("Segoe UI", Font.PLAIN,16));
        //lblPeliculaEstado.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        lblPeliculaEstado.setSize(new Dimension(150,25));
        lblPeliculaEstado.setLocation(170, 245);
        
        btgPeliculasGroup = new ButtonGroup();
        rdbPeliculaEstadoA = new JRadioButton("Activa");
        rdbPeliculaEstadoA.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        rdbPeliculaEstadoA.setSize(new Dimension(100, 25));
        rdbPeliculaEstadoA.setSelected(false);
        rdbPeliculaEstadoA.setLocation(320, 245);
        rdbPeliculaEstadoA.setFocusPainted(false);
        rdbPeliculaEstadoA.addActionListener(this);
        
        rdbPeliculaEstadoB = new JRadioButton("Inactiva");
        rdbPeliculaEstadoB.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        rdbPeliculaEstadoB.setSize(new Dimension(100, 25));
        rdbPeliculaEstadoB.setSelected(false);
        rdbPeliculaEstadoB.setLocation(420, 245);
        rdbPeliculaEstadoB.setFocusPainted(false);
        rdbPeliculaEstadoB.addActionListener(this);

        btnPeliculaAceptar = new JButton("Guardar");
        btnPeliculaAceptar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnPeliculaAceptar.setForeground(new Color(255, 255, 255));
        btnPeliculaAceptar.setIcon(new ImageIcon(this.getClass().getResource("/images/SaveWhiteIcon.png")));
        btnPeliculaAceptar.setBackground(new Color(45, 137, 239));
        btnPeliculaAceptar.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnPeliculaAceptar.setContentAreaFilled(false);
        btnPeliculaAceptar.setFocusPainted(false);
        btnPeliculaAceptar.setOpaque(true);
        btnPeliculaAceptar.setSize(new Dimension(200, 35));
        btnPeliculaAceptar.setLocation(25, 290);
        btnPeliculaAceptar.addActionListener(this);
        btnPeliculaAceptar.addMouseListener(this);

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
        btnPeliculaCancelar.setLocation(305, 290);
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
        setVisible(true);
    }

    public VProgramadorPeliculasCrear(JFrame parentFrame) {
        initFrame(parentFrame);
    }

//    public static void main(String[] args) {
//        new VProgramadorPeliculasCrear(null);
//    }
    
/*************************************************** METODOS ***************************************************/    
    private String peliculaID(String ID) {
        char r1 = '\0';
        char r2 = '\0';
        char r3 = '\0';
        char r4 = '\0';
        char r5 = '\0';
        char r6 = '\0';
        String uniID ="";

        if (ID.length() == 4) {
            r1 = ID.charAt(3);
            uniID = ""+r1;
            System.out.println("tam4: "+uniID);
        }
        if (ID.length() == 5) {
            r1 = ID.charAt(3);
            r2 = ID.charAt(4);
            uniID = ""+r1+r2;
            System.out.println("tam5: "+uniID);
        }
        if (ID.length() == 6) {
            r1 = ID.charAt(3);
            r2 = ID.charAt(4);
            r3 = ID.charAt(5);
            uniID = ""+r1+r2+r3;
        }
        if (ID.length() == 7) {
            r1 = ID.charAt(3);
            r2 = ID.charAt(4);
            r3 = ID.charAt(5);
            r4 = ID.charAt(6);
            uniID = ""+r1+r2+r3+r4;
        }
        if (ID.length() == 8) {
            r1 = ID.charAt(3);
            r2 = ID.charAt(4);
            r3 = ID.charAt(5);
            r4 = ID.charAt(6);
            r5 = ID.charAt(7);
            uniID = ""+r1+r2+r3+r4+r5;
        }
        if (ID.length() == 9) {
            r1 = ID.charAt(3);
            r2 = ID.charAt(4);
            r3 = ID.charAt(5);
            r4 = ID.charAt(6);
            r5 = ID.charAt(7);
            r6 = ID.charAt(8);
            uniID = ""+r1+r2+r3+r4+r5+r6;
        }
        int tmpID = Integer.parseInt(uniID);
        String tmp = Integer.toString(tmpID+1);
        System.out.println("t: "+tmp);
        
        return tmp;
    }
    
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
    private String comprobarCampos(VProgramadorPeliculasCrear vProgObj) {/**Valida los campos**/
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
    private void limpiarCampos(VProgramadorPeliculasCrear vProgObj) {/**Limpia la interfaz**/
    vProgObj.txtPeliculaID.setText("PEL"+peliculaID(pelDAO.nvoPeliculaID()));
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
        if (evt.getSource() == btnPeliculaAceptar) {

            if (comprobarCampos(this).compareTo("ok") != 0) {
                new VOptionPane(this, comprobarCampos(this));
            } else {
                try {
                    pelObj = new MPeliculas(
                            txtPeliculaNombre.getText().toLowerCase(),
                            cmbClasificacion.getSelectedItem().toString(),
                            buscarGeneroID(cmbGenero.getSelectedItem().toString()),
                            Integer.parseInt(txtPeliculaDuracion.getText()),
                            btnPeliculaImgURL.toLowerCase(),
                            rdbPeliculaEstado);
                } catch (Exception e) {
                    new VOptionPane(this, e.toString());
                }
                try {
                    if (pelDAO.createPelicula(pelObj)) {
                        new VOptionPane(this, "Pelicula Agregada");
                        limpiarCampos(this);
                    }
                } catch (Exception e) {
                    new VOptionPane(this, e.toString());
                }
            }
        }
        if (evt.getSource() == btnPeliculaCancelar) {
            this.dispose();
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