package br.com.blogspot.denisbenjamim.componentes.editoresrenderizadores;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.Serializable;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author Denis
 * @param <generics>
 */
public class JComboBoxCellEditorRendererTable<generics> extends AbstractCellEditorRendererTable implements ItemListener, Serializable{

    private final JComboBox<generics> comboBox;

    public JComboBoxCellEditorRendererTable() {
        this.comboBox = new JComboBox<>(); 
        this.comboBox.addItemListener(this);
    }
    public JComboBoxCellEditorRendererTable(ComboBoxModel<generics> modeloCombo) {
        this.comboBox = new JComboBox<>(modeloCombo);  
        this.comboBox.addItemListener(this);
       
    }
    
    @Override
    public Object getCellEditorValue() {
        return this.comboBox.getSelectedItem();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value != null) {
            this.comboBox.setSelectedItem(value);
        }
        return this.comboBox;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value != null) {
            this.comboBox.setSelectedItem(value);
        }
        return this.comboBox;
    }

    @Override
    public JComboBox<generics> getComponent() {
        return this.comboBox;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
       if(e.getStateChange()==ItemEvent.SELECTED){          
           fireEditingStopped();
       }
    }
}
