package br.com.blogspot.denisbenjamim.componentes.table;

import br.com.blogspot.denisbenjamim.componentes.editoresrenderizadores.AbstractCellEditorRendererTable;
import br.com.blogspot.denisbenjamim.componentes.editoresrenderizadores.RowColumnEditorRendererModel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class JTableX extends JTable {
   private RowColumnEditorRendererModel mel = null;

   @Override
   public TableCellEditor getCellEditor(int row, int column) {
      AbstractCellEditorRendererTable erta = this.setEditorRenderer(row, column);
      return (TableCellEditor)(erta == null ? super.getCellEditor(row, column) : erta);
   }

   @Override
   public TableCellRenderer getCellRenderer(int row, int column) {
      AbstractCellEditorRendererTable erta = this.setEditorRenderer(row, column);
      return (TableCellRenderer)(erta == null ? super.getCellRenderer(row, column) : erta);
   }

   AbstractCellEditorRendererTable setEditorRenderer(int row, int column) {
      return this.getMel() != null && this.getMel().containsEditorRendererForRowColumn(row, column) ? this.getMel().getEditorRendererForRowColumn(row, column) : null;
   }

   public RowColumnEditorRendererModel getMel() {
      return this.mel;
   }

   public void setMel(RowColumnEditorRendererModel mel) {
      this.mel = mel;
   }
}
