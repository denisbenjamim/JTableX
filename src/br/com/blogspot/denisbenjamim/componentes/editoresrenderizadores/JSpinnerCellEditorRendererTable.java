package br.com.blogspot.denisbenjamim.componentes.editoresrenderizadores;


import java.awt.Component;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JSpinnerCellEditorRendererTable extends AbstractCellEditorRendererTable implements ChangeListener {
   private final JSpinner spinner;

   public JSpinnerCellEditorRendererTable() {
      this.spinner = new JSpinner();
      this.spinner.addChangeListener(this);
   }

   public JSpinnerCellEditorRendererTable(int init, int min, int max) {
      this.spinner = new JSpinner(new SpinnerNumberModel(init, min, max, 1));
      this.spinner.addChangeListener(this);
   }

   public JSpinnerCellEditorRendererTable(Object[] objetos) {
      this.spinner = new JSpinner(new SpinnerListModel(objetos));
   }

   public JSpinnerCellEditorRendererTable setNumberModel(int init, int min, int max) {
      this.spinner.setModel(new SpinnerNumberModel(init, min, max, 1));
      return this;
   }

   public Object getCellEditorValue() {
      return this.spinner.getValue();
   }

   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
      if (value != null && value instanceof Integer) {
         this.spinner.setValue(value);
      }

      return this.spinner;
   }

   public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
      if (value != null) {
         this.spinner.setValue(value);
      }

      return this.spinner;
   }

   public Component getComponent() {
      return this.spinner;
   }

   public void stateChanged(ChangeEvent e) {
      this.fireEditingStopped();
   }
}
