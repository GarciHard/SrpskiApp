package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 * Hecho con <3 por:
 * @author Alexis (GarciHard)
 */
public class VMsjDialogo extends JDialog implements ActionListener, MouseListener {

    private JPanel pnlBackground;
    private JLabel lblLogo;
    private JLabel lblAnuncio;
    private JLabel lblMensaje;
    private JButton btnConfirmacion;

    public VMsjDialogo(JFrame parentFrame, String message) {
        initFrame(parentFrame, message);
    }

    private void initFrame(JFrame parentFrame, String message) {
        //Creación del JDialog de tipo modal para los avisos de inicio de sesión
        setSize(new Dimension(400, 100));
        setUndecorated(true);
        setLocationRelativeTo(parentFrame);
        setModal(true);

        //Creacion del JPanel de fondo xD
        pnlBackground = new JPanel();
        pnlBackground.setLayout(null);
        pnlBackground.setSize(getSize());
        pnlBackground.setBackground(new Color(238, 17, 17));
        pnlBackground.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));

        //Creacion del JLabel para el logo de los mensajes
        lblLogo = new JLabel();
        lblLogo.setSize(new Dimension(100, 100));
        lblLogo.setIcon(new ImageIcon(this.getClass().getResource("/images/AttentionWhiteIcon.png")));
        lblLogo.setLocation(0, 0);

        //Creacion del JLabel de título xD
        lblAnuncio = new JLabel("Verifica los datos de inicio de sesi\u00f3n", SwingConstants.LEFT);
        lblAnuncio.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblAnuncio.setForeground(new Color(255, 255, 255));
        lblAnuncio.setSize(new Dimension(getWidth() - 100, 25));
        lblAnuncio.setLocation(100, 10);

        //Creacion del JLabel para los mensajes del JDialog
        lblMensaje = new JLabel(message, SwingConstants.LEFT);
        lblMensaje.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        lblMensaje.setForeground(new Color(255, 255, 255));
        lblMensaje.setSize(new Dimension(getWidth() - 100, 25));
        lblMensaje.setLocation(100, 35);

        //Creacion del JButton Confirmacion
        btnConfirmacion = new JButton("Aceptar");
        btnConfirmacion.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnConfirmacion.setForeground(new Color(255, 255, 255));
        btnConfirmacion.setBackground(new Color(63, 107, 171));
        btnConfirmacion.setSize(new Dimension(90, 25));
        btnConfirmacion.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        btnConfirmacion.setContentAreaFilled(false);
        btnConfirmacion.setOpaque(true);
        btnConfirmacion.setFocusPainted(false);
        btnConfirmacion.setLocation(300, 67);
        btnConfirmacion.addActionListener(this);
        btnConfirmacion.addMouseListener(this);

        //Se agregan los diferentes componentes al JPanel Background
        pnlBackground.add(lblLogo);
        pnlBackground.add(lblAnuncio);
        pnlBackground.add(lblMensaje);
        pnlBackground.add(btnConfirmacion);

        //Se añaden los elementos al JDialog
        add(pnlBackground);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == btnConfirmacion) {
            this.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == btnConfirmacion) {
            btnConfirmacion.setBackground(new Color(63, 107, 171));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == btnConfirmacion) {
            btnConfirmacion.setBackground(new Color(43, 87, 151));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == btnConfirmacion) {
            btnConfirmacion.setBackground(new Color(63, 107, 171));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == btnConfirmacion) {
            btnConfirmacion.setBackground(new Color(63, 107, 171));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == btnConfirmacion) {
            btnConfirmacion.setBackground(new Color(63, 107, 171));
        }
    }
}