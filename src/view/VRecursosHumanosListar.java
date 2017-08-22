package view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.MEmpleadosDAO;

/**
 * Hecho con <3 por: 
 * @author Alexis (GarciHard)
 */
public class VRecursosHumanosListar extends JDialog {

    private JPanel pnlBackground;
    private JScrollPane scpEmpTablaFondo;
    private JTable tblEmpTabla;

    public VRecursosHumanosListar(JFrame parentFrame) {
        initFrame(parentFrame);
    }
    
    private void initFrame(JFrame parentFrame) {
        this.setTitle("Recursos Humanos");
        this.setSize(new Dimension(800, 600));
        this.setModal(true);
        this.setLocationRelativeTo(parentFrame);
        this.setResizable(false);
        
        pnlBackground = new JPanel(null);
        pnlBackground.setSize(new Dimension(800,600));
        pnlBackground.setBackground(new Color(223,223,223));
        
        String columnas[] = {"nombre","id","ejemplo","otra cosa"};
        String datos[][] ={
            {"alexis","13","hola","xD"},
            {"laura","28", "hello", "XD"}
        };
        
        DefaultTableModel dtmModeloTabla = new MEmpleadosDAO().DAOEmpRead();
        
        tblEmpTabla = new JTable(dtmModeloTabla);
        
        tblEmpTabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        scpEmpTablaFondo = new JScrollPane(tblEmpTabla,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scpEmpTablaFondo.setSize(700,400);
        scpEmpTablaFondo.setLocation(50,100);
        
        pnlBackground.add(scpEmpTablaFondo);
        
        this.add(pnlBackground);
        this.setVisible(true);
    }
    
//    public static void main(String[] args) {
//        new VRecursosHumanosListar(null);
//    }
}
