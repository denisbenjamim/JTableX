package br.com.blogspot.denisbenjamim.componentes.table;

import br.com.blogspot.denisbenjamim.componentes.editoresrenderizadores.AbstractCellEditorRendererTable;
import br.com.blogspot.denisbenjamim.componentes.editoresrenderizadores.RowColumnEditorRendererModel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class JTableX extends JTable {
    
   private RowColumnEditorRendererModel  rcer;

    public JTableX() {
        super();
        this.rcer = null;
    }

   
   @Override
   public TableCellEditor getCellEditor(int row, int column) {
      AbstractCellEditorRendererTable editor = this.setEditorRenderer(row, column);
      
      return (TableCellEditor)(editor == null ? super.getCellEditor(row, column) : editor);
   }

   @Override
   public TableCellRenderer getCellRenderer(int row, int column) {
      AbstractCellEditorRendererTable renderer = this.setEditorRenderer(row, column);
      return (TableCellRenderer)(renderer == null ? super.getCellRenderer(row, column) : renderer);
   }

   AbstractCellEditorRendererTable setEditorRenderer(int row, int column) {
      return this.getRcer() != null && this.getRcer().containsEditorRendererForRowColumn(row, column) ? this.getRcer().getEditorRendererForRowColumn(row, column) : null;
   }

   public RowColumnEditorRendererModel getRcer() {
      return this.rcer;
   }

   public void setRcer(RowColumnEditorRendererModel rcer) {
      this.rcer = rcer;
   }
}
