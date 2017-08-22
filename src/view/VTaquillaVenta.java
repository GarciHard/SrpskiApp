package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import model.MBoletos;
import model.MBoletosDAO;
import model.MEmpleados;
import model.MFunciones;
import model.MFuncionesDAO;

/**
 * Hecho con <3 por: 
 * @author Alexis (GarciHard)
 */
public class VTaquillaVenta extends JDialog implements ActionListener, MouseListener {
    
    private JLabel lblTitulo;
    private JLabel lblTituloFunciones;
    private JLabel lblFunFecha;
    private JLabel lblFunHorario;
    private JLabel lblFunPelicula;
    private JLabel lblFunPeliculaImg;
    private JPanel pnlBackground;
    private JComboBox cmbFunFecha;
    private JComboBox cmbFunPelicula;
    private JTextField txtFunHorario;
    private DefaultComboBoxModel cmbPelModel;
    private JLabel lblTituloBoletos;
    private JLabel lblBol3era;
    private JLabel lblBolCantidad;
    private JLabel lblBolPrecio;
    private JLabel lblBolTotal;

    private JTextField txtBolPrecio3;
    private JComboBox cmbBolCantidad3;
    private JTextField txtBolTotal3;
    private JLabel lblSubtotal;
    private JTextField txtSubtotal;
    private JLabel lblBolDisponibles;
    private JTextField txtBolDisponibles;
    
    private JButton btnBolConfirmar;
    private JButton btnBolAceptar;
    private JButton btnBolCancelar;
    
    private String bolFuncion = "";
    private String idEmp = "";
    private String funSala = "";
    
    private JScrollPane scpAreaBol;
    private JTextArea txaAreaBol;
    
    private String fechasDisponibles[] = {"","12/10/2015","14/10/2015","16/10/2015","17/10/2015"
                                            ,"19/10/2015","21/10/2015","23/10/2015","24/10/2015"
                                            ,"16/11/2015","18/11/2015","20/11/2015","21/11/2015"
                                            ,"23/11/2015","25/11/2015","27/11/2015","28/11/2015"};
    
    private String cantidadBoleto[] = {"0", "1", "2", "3", "4", "5"};

    private MFuncionesDAO funDAO = new MFuncionesDAO();
    private MFunciones funObj;
    private ArrayList<MFunciones> funcionesArr;
    private MBoletos bolObj;
    private MBoletosDAO bolDAO = new MBoletosDAO();
    
    public VTaquillaVenta(JFrame parentFrame, MEmpleados empInfo) {
        initFrame(parentFrame, empInfo);
    }
    
    private void initFrame(JFrame parentFrame, MEmpleados empInfo) {
        setTitle("Taquilla");
        setResizable(false);
        setModal(true);
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(parentFrame);
        System.out.println("Emp:" + empInfo.getEmpID());
        idEmp = empInfo.getEmpID();

        pnlBackground = new JPanel();
        pnlBackground.setLayout(null);
        pnlBackground.setSize(new Dimension(getWidth(), getHeight()));
        pnlBackground.setBackground(new Color(230, 233, 237));
        
        lblTitulo = new JLabel("Venta Boletos", SwingConstants.LEFT);
        lblTitulo.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 36));
        lblTitulo.setForeground(new Color(0, 0, 0));
        lblTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblTitulo.setSize(new Dimension(780, 50));
        lblTitulo.setLocation(10, 5);
        
        lblTituloFunciones = new JLabel("Funciones", SwingConstants.CENTER);
        lblTituloFunciones.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
        lblTituloFunciones.setForeground(new Color(0, 0, 0));
        lblTituloFunciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblTituloFunciones.setSize(new Dimension(200, 15));
        lblTituloFunciones.setLocation(10, 65);
        
        lblFunFecha = new JLabel("Fecha: ",SwingConstants.LEFT);
        lblFunFecha.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
        lblFunFecha.setForeground(new Color(0, 0, 0));
        lblFunFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblFunFecha.setSize(new Dimension(50, 20));
        lblFunFecha.setLocation(10, 85);
        
        cmbFunFecha = new JComboBox(fechasDisponibles);
        cmbFunFecha.setAlignmentY(CENTER_ALIGNMENT);
        cmbFunFecha.setBackground(new Color(255,255,255));
        cmbFunFecha.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
        cmbFunFecha.setForeground(new Color(0, 0, 0));
        //cmbFunFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmbFunFecha.setSize(new Dimension(150, 20));
        cmbFunFecha.setLocation(60, 85);
        cmbFunFecha.addActionListener(this);
        
        lblFunPelicula = new JLabel("Pelicula: ",SwingConstants.LEFT);
        lblFunPelicula.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
        lblFunPelicula.setForeground(new Color(0, 0, 0));
        lblFunPelicula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblFunPelicula.setSize(new Dimension(50, 20));
        lblFunPelicula.setLocation(10, 105);
        
        cmbFunPelicula = new JComboBox();
        cmbFunPelicula.setBackground(new Color(255,255,255));
        cmbFunPelicula.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
        cmbFunPelicula.setForeground(new Color(0, 0, 0));
        //cmbFunPelicula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmbFunPelicula.setSize(new Dimension(150, 20));
        cmbFunPelicula.setLocation(60, 105);
        cmbFunPelicula.addActionListener(this);
        
        lblFunHorario = new JLabel("Horario: ",SwingConstants.LEFT);
        lblFunHorario.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
        lblFunHorario.setForeground(new Color(0, 0, 0));
        lblFunHorario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblFunHorario.setSize(new Dimension(50, 20));
        lblFunHorario.setLocation(10, 125);

        txtFunHorario = new JTextField();
        txtFunHorario.setBackground(new Color(255, 255, 255));
        txtFunHorario.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
        txtFunHorario.setForeground(new Color(0, 0, 0));
        //cmbFunHorario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtFunHorario.setSize(new Dimension(150, 20));
        txtFunHorario.setLocation(60, 125);
        txtFunHorario.setEditable(false);
        txtFunHorario.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblBolDisponibles = new JLabel("Boletos Disponibles: ");
        lblBolDisponibles.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
        lblBolDisponibles.setForeground(new Color(0, 0, 0));
        lblBolDisponibles.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblBolDisponibles.setSize(new Dimension(150, 20));
        lblBolDisponibles.setLocation(10, 145);
        
        txtBolDisponibles = new JTextField();
        txtBolDisponibles.setBackground(new Color(255, 255, 255));
        txtBolDisponibles.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
        txtBolDisponibles.setForeground(new Color(0, 0, 0));
        //txtBolDisponibles.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtBolDisponibles.setSize(new Dimension(50, 20));
        txtBolDisponibles.setLocation(160, 145);
        txtBolDisponibles.setEditable(false);
        txtBolDisponibles.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblFunPeliculaImg = new JLabel();
        lblFunPeliculaImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblFunPeliculaImg.setSize(new Dimension(150, 220));
        lblFunPeliculaImg.setLocation(215, 85);
        
        lblTituloBoletos = new JLabel("Boletos", SwingConstants.CENTER);
        lblTituloBoletos.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
        lblTituloBoletos.setForeground(new Color(0, 0, 0));
        lblTituloBoletos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblTituloBoletos.setSize(new Dimension(200, 15));
        lblTituloBoletos.setLocation(10, 185);

        lblBolCantidad = new JLabel("Cantidad", SwingConstants.CENTER);
        lblBolCantidad.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
        lblBolCantidad.setForeground(new Color(0, 0, 0));
        lblBolCantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblBolCantidad.setSize(new Dimension(55, 20));
        lblBolCantidad.setLocation(65, 205);
     
        lblBolPrecio = new JLabel("Precio", SwingConstants.CENTER);
        lblBolPrecio.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
        lblBolPrecio.setForeground(new Color(0, 0, 0));
        lblBolPrecio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblBolPrecio.setSize(new Dimension(55, 20));
        lblBolPrecio.setLocation(120, 205);
        
        lblBolTotal = new JLabel("Total", SwingConstants.CENTER);
        lblBolTotal.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
        lblBolTotal.setForeground(new Color(0, 0, 0));
        lblBolTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblBolTotal.setSize(new Dimension(35, 20));
        lblBolTotal.setLocation(175, 205);

        lblBol3era = new JLabel("General",SwingConstants.LEFT);
        lblBol3era.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
        lblBol3era.setForeground(new Color(0, 0, 0));
        lblBol3era.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblBol3era.setSize(new Dimension(55, 20));
        lblBol3era.setLocation(10, 225);

        cmbBolCantidad3 = new JComboBox(cantidadBoleto);
        cmbBolCantidad3.setAlignmentY(CENTER_ALIGNMENT);
        cmbBolCantidad3.setBackground(new Color(255, 255, 255));
        cmbBolCantidad3.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
        cmbBolCantidad3.setForeground(new Color(0, 0, 0));
        //cmbBolCantidad3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmbBolCantidad3.setSize(new Dimension(55, 20));
        cmbBolCantidad3.setLocation(65, 225);
        cmbBolCantidad3.addActionListener(this);

        txtBolPrecio3 = new JTextField("25");
        txtBolPrecio3.setHorizontalAlignment(SwingConstants.CENTER);
        txtBolPrecio3.setBackground(new Color(255, 255, 255));
        txtBolPrecio3.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
        txtBolPrecio3.setForeground(new Color(0, 0, 0));
        //txtBolPrecio3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtBolPrecio3.setSize(new Dimension(55, 20));
        txtBolPrecio3.setLocation(120, 225);
        txtBolPrecio3.addActionListener(this);
        txtBolPrecio3.setEditable(false);
        
        txtBolTotal3 = new JTextField("0");
        txtBolTotal3.setHorizontalAlignment(SwingConstants.CENTER);
        txtBolTotal3.setBackground(new Color(255, 255, 255));
        txtBolTotal3.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
        txtBolTotal3.setForeground(new Color(0, 0, 0));
        //txtBolTotal3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtBolTotal3.setSize(new Dimension(35, 20));
        txtBolTotal3.setLocation(175, 225);
        txtBolTotal3.addActionListener(this);
        txtBolTotal3.setEditable(false);
        
        lblSubtotal = new JLabel("SUBTOTAL:",SwingConstants.LEFT);
        lblSubtotal.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
        lblSubtotal.setForeground(new Color(0, 0, 0));
        lblSubtotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblSubtotal.setSize(new Dimension(70, 20));
        lblSubtotal.setLocation(10, 285);
        
        txtSubtotal = new JTextField("0");
        txtSubtotal.setHorizontalAlignment(SwingConstants.CENTER);
        txtSubtotal.setBackground(new Color(255, 255, 255));
        txtSubtotal.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
        txtSubtotal.setForeground(new Color(0, 0, 0));
        //txtSubtotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSubtotal.setSize(new Dimension(130, 20));
        txtSubtotal.setLocation(80, 285);
        txtSubtotal.addActionListener(this);
        txtSubtotal.setEditable(false);
        
        btnBolConfirmar = new JButton();
        btnBolConfirmar = new JButton("Confirmar");
        btnBolConfirmar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnBolConfirmar.setForeground(new Color(255, 255, 255));
        btnBolConfirmar.setIcon(new ImageIcon(this.getClass().getResource("/images/CancelWhiteIcon.png")));
        btnBolConfirmar.setBackground(new Color(238, 17, 17));
        btnBolConfirmar.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        //btnBolConfirmar.setContentAreaFilled(false);
        btnBolConfirmar.setFocusPainted(false);
        btnBolConfirmar.setOpaque(true);
        btnBolConfirmar.setSize(new Dimension(200, 35));
        btnBolConfirmar.setLocation(10, 315);
        btnBolConfirmar.addActionListener(this);
        btnBolConfirmar.addMouseListener(this);
        
        btnBolAceptar = new JButton();
        btnBolAceptar = new JButton("Aceptar");
        btnBolAceptar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnBolAceptar.setForeground(new Color(255, 255, 255));
        btnBolAceptar.setIcon(new ImageIcon(this.getClass().getResource("/images/CancelWhiteIcon.png")));
        btnBolAceptar.setBackground(new Color(238, 17, 17));
        btnBolAceptar.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        //btnBolAceptar.setContentAreaFilled(false);
        btnBolAceptar.setFocusPainted(false);
        btnBolAceptar.setOpaque(true);
        btnBolAceptar.setSize(new Dimension(200, 35));
        btnBolAceptar.setLocation(10, 355);
        btnBolAceptar.addActionListener(this);
        btnBolAceptar.addMouseListener(this);
        
        btnBolCancelar = new JButton();
        btnBolCancelar = new JButton("Cancelar");
        btnBolCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnBolCancelar.setForeground(new Color(255, 255, 255));
        btnBolCancelar.setIcon(new ImageIcon(this.getClass().getResource("/images/CancelWhiteIcon.png")));
        btnBolCancelar.setBackground(new Color(238, 17, 17));
        btnBolCancelar.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        //btnBolCancelar.setContentAreaFilled(false);
        btnBolCancelar.setFocusPainted(false);
        btnBolCancelar.setOpaque(true);
        btnBolCancelar.setSize(new Dimension(200, 35));
        btnBolCancelar.setLocation(10, 395);
        btnBolCancelar.addActionListener(this);
        btnBolCancelar.addMouseListener(this);
        
        txaAreaBol = new JTextArea(5, 20);
        scpAreaBol = new JScrollPane(txaAreaBol);
        txaAreaBol.setSize(new Dimension(400, 220));
        txaAreaBol.setLocation(375, 85);
        txaAreaBol.setEditable(false);
        txaAreaBol.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        txaAreaBol.setForeground(new Color(0,0,0));
        txaAreaBol.setBackground(new Color(230, 233, 237));
        txaAreaBol.setBorder(BorderFactory.createTitledBorder("Confirmación Orden"));
        
        pnlBackground.add(scpAreaBol);
        pnlBackground.add(txaAreaBol);
        pnlBackground.add(lblTitulo);
        pnlBackground.add(lblTituloFunciones);
        pnlBackground.add(lblFunFecha);
        pnlBackground.add(cmbFunFecha);
        pnlBackground.add(lblFunPelicula);
        pnlBackground.add(cmbFunPelicula);
        pnlBackground.add(lblFunHorario);
        pnlBackground.add(txtFunHorario);
        pnlBackground.add(lblFunPeliculaImg);
        pnlBackground.add(lblTituloBoletos);
        pnlBackground.add(lblBol3era);
        pnlBackground.add(lblBolCantidad);
        pnlBackground.add(lblBolPrecio);
        pnlBackground.add(lblBolTotal);
        pnlBackground.add(txtBolPrecio3);
        pnlBackground.add(cmbBolCantidad3);
        pnlBackground.add(txtBolTotal3);
        pnlBackground.add(lblSubtotal);
        pnlBackground.add(txtSubtotal);
        pnlBackground.add(lblBolDisponibles);
        pnlBackground.add(txtBolDisponibles);
        pnlBackground.add(btnBolConfirmar);
        pnlBackground.add(btnBolAceptar);
        pnlBackground.add(btnBolCancelar);
        
        add(pnlBackground);
        setVisible(true);
    }
    
    /****METODOS****/
    private void limpiarCampos(VTaquillaVenta taqObj) {
        taqObj.cmbFunFecha.setSelectedIndex(0);
        taqObj.cmbFunPelicula.removeAllItems();
        taqObj.txtFunHorario.setText("");
        taqObj.txtBolDisponibles.setText("");
        taqObj.cmbBolCantidad3.setSelectedIndex(0);
        taqObj.lblFunPeliculaImg.setIcon(null);
        taqObj.txaAreaBol.setText("");
    }
       
    /****INTERFACES****/
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == cmbFunFecha) {/**COMBO FECHAS FUNCIONES**/
            funcionesArr = funDAO.funcionesArr(cmbFunFecha.getSelectedItem().toString());
            cmbPelModel = new DefaultComboBoxModel();
            for (int i = 0; i < funcionesArr.size(); i++) {
                funObj = funcionesArr.get(i);
                cmbPelModel.addElement(funObj.getPelID());
            }
            cmbFunPelicula.setModel(cmbPelModel);
        }
        if (evt.getSource() == cmbFunPelicula) {/**COMBO NOMBRES PELICULAS**/
            String fecha = cmbFunFecha.getSelectedItem().toString();
            String pelNom = cmbFunPelicula.getSelectedItem().toString().toLowerCase();
            String hora = funDAO.funcionesHora(fecha, pelNom);
            txtFunHorario.setText(hora);
            bolFuncion = funDAO.funcionesID(fecha, pelNom);
            funSala = funDAO.funSala(fecha, pelNom);
            String funBolDis = funDAO.funcionesBolDisponibles(funDAO.funcionesID(fecha, pelNom));
            txtBolDisponibles.setText(funBolDis);
            
            String lblPeliculaImgURL = funDAO.funcionesIMG(fecha, pelNom);
            ImageIcon icPel = new ImageIcon(lblPeliculaImgURL);       
            lblFunPeliculaImg.setIcon(new ImageIcon(icPel.getImage().getScaledInstance(150, 220, Image.SCALE_SMOOTH)));
        }
        if (evt.getSource() == cmbBolCantidad3) {/**COMBO CANTIDAD DE BOLETOS 3ERA EDAD**/
            switch (cmbBolCantidad3.getSelectedItem().toString()) {
                case "5":
                    txtBolTotal3.setText(Integer.toString(25*5));
                    break;
                case "4":
                    txtBolTotal3.setText(Integer.toString(25*4));
                    break;
                case "3":
                    txtBolTotal3.setText(Integer.toString(25*3));
                    break;
                case "2":
                    txtBolTotal3.setText(Integer.toString(25*2));
                    break;
                case "1":
                    txtBolTotal3.setText(Integer.toString(25*1));
                    break;
                case "0":
                    txtBolTotal3.setText(Integer.toString(25*0));
                    break;
            }
        }
        txtSubtotal.setText(Integer.toString(Integer.parseInt(txtBolTotal3.getText())/**SUMA PARA EL SUBTOTAL**/
        ));
        if (evt.getSource() == btnBolConfirmar) {//CONFIRMACION DE BOLETOS
            System.out.println("presionadoConfirmar");
            txaAreaBol.setText("\n"+
                    cmbBolCantidad3.getSelectedItem().toString() +" Boleto(s) para:\n"+
                    cmbFunPelicula.getSelectedItem().toString()+
                    "\nEl día: "+cmbFunFecha.getSelectedItem().toString()+"\nA las: "+txtFunHorario.getText()
            +"\nEn la sala: "+funSala);
            
            System.out.println("bolCa: "+cmbBolCantidad3.getSelectedItem().toString());
            System.out.println("bolID: ");
            System.out.println("funID: "+bolFuncion);
            System.out.println("empID: "+idEmp);
            System.out.println("cteID: ");
            System.out.println("bolNa: "+lblBol3era.getText());
            System.out.println("bolPr: "+txtBolPrecio3.getText());
        }
        if (evt.getSource() == btnBolAceptar) {//AGREGAR DATOS BASE DE DATOS
            System.out.println("presionadoAceptar");
            if (bolDAO.createBol( Integer.parseInt(cmbBolCantidad3.getSelectedItem().toString()) ,
                                  bolFuncion,
                                  idEmp, lblBol3era.getText(),
                                  Integer.parseInt(txtBolPrecio3.getText()) )) {
                new VOptionPane(this, "Compra Realizada Con Exito");
                limpiarCampos(this);
            } else {
                System.out.println("Matate!");
            }
        }
        if (evt.getSource() == btnBolCancelar) {
            limpiarCampos(this);
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {//Aqui se cambia el color al presionar el boton
        
    }
    @Override
    public void mouseReleased(MouseEvent e) {}        
    /*******/
}