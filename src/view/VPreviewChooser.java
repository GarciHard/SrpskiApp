package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;

/**
 * Hecho con <3 por: 
 * @author Alexis (GarciHard)
 */
public class VPreviewChooser extends JComponent implements PropertyChangeListener {

    Double lebarImg = 200.0;
    Double tinggiImg = 200.0;
    File file = null;
    ImageIcon imageIcon = null;

    public VPreviewChooser(JFileChooser fileChooser) {
        setPreferredSize(new Dimension(lebarImg.intValue(), tinggiImg.intValue()));
        fileChooser.addPropertyChangeListener(this);
    }

    public double getScale(ImageIcon img) {
        double skala;
        if ((lebarImg >= img.getIconWidth()) && (tinggiImg >= img.getIconHeight())) {
            skala = 1;
        } else {
            double lebarSkala = lebarImg / img.getIconWidth();
            double tinggiSkala = tinggiImg / img.getIconHeight();

            if (lebarSkala > tinggiSkala) {
                skala = tinggiSkala;
            } else {
                skala = lebarSkala;
            }
        }
        return skala;
    }

    public void propertyChange(PropertyChangeEvent pce) {
        String properti = pce.getPropertyName();
        if (JFileChooser.DIRECTORY_CHANGED_PROPERTY.equals(properti)) {
            file = null;
        } else if (JFileChooser.SELECTED_FILE_CHANGED_PROPERTY.equals(properti)) {
            file = (File) pce.getNewValue();
        }
        if (file == null) {
            imageIcon = null;
        } else {
            ImageIcon imgIcon = new ImageIcon(file.getPath());
            double skala = getScale(imgIcon);
            imageIcon = new ImageIcon(imgIcon.getImage().getScaledInstance((int) ((double) imgIcon.getIconWidth() * skala), (int) ((double) imgIcon.getIconHeight() * skala), Image.SCALE_DEFAULT));
        }
        repaint();
    }

    protected void paintComponent(Graphics graph) {
        if (imageIcon != null) {
            int x = getWidth() / 2 - imageIcon.getIconWidth() / 2;
            int y = getHeight() / 2 - imageIcon.getIconHeight() / 2;
            imageIcon.paintIcon(this, graph, x, y);
        }
    }
}