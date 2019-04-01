package br.com.blogspot.denisbenjamim.componentes.editoresrenderizadores;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.util.Date;
import javax.swing.JTable;

/**
 *
 * @author Denis
 */
public class JDateChooserCellEditorRendererTable extends AbstractCellEditorRendererTable {

    private final JDateChooser component;   
    
    public JDateChooserCellEditorRendererTable() {       
        this.component = new JDateChooser();    
    }  

    @Override
    public Object getCellEditorValue() {
        return this.component.getDate();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value != null && value instanceof Date) {
            this.component.setDate((Date)value);
        }
        return this.component;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value != null && value instanceof Date) {
            this.component.setDate((Date)value);
        }
        return this.component;
    }

    @Override
    public Component getComponent() {
        return this.component;
    }

    public void setFormatacaoDataHora(String formatacaoDataHora) {
       
        this.component.setDateFormatString(formatacaoDataHora);
    }
    
}
