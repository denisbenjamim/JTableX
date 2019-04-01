package br.com.blogspot.denisbenjamim.componentes.editoresrenderizadores;


import java.util.HashMap;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class RowColumnEditorRendererModel {
   private final HashMap<Integer, HashMap<Integer, AbstractCellEditorRendererTable>> rows = new HashMap();

   public void addEditorRendererForRowColumn(Integer row, Integer column, AbstractCellEditorRendererTable editorRenderer) {
      if (this.rows.containsKey(row)) {
         ((HashMap)this.rows.get(row)).put(column, editorRenderer);
      } else {
         HashMap<Integer, AbstractCellEditorRendererTable> editorsRenderers = new HashMap();
         editorsRenderers.put(column, editorRenderer);
         this.rows.put(row, editorsRenderers);
      }

   }

   public void remEditorRendererForRowColumn(Integer row, Integer column) {
      ((HashMap)this.rows.get(row)).remove(column);
      if (((HashMap)this.rows.get(row)).isEmpty()) {
         this.rows.remove(row);
      }

   }

   public AbstractCellEditorRendererTable getEditorRendererForRowColumn(Integer row, Integer column) {
      return (AbstractCellEditorRendererTable)((HashMap)this.rows.get(row)).get(column);
   }

   public TableCellRenderer getRendererForRowColumn(Integer row, Integer column) {
      return ((AbstractCellEditorRendererTable)((HashMap)this.rows.get(row)).get(column)).getTableCellRenderer();
   }

   public TableCellEditor getEditorForRowColumn(Integer row, Integer column) {
      return ((AbstractCellEditorRendererTable)((HashMap)this.rows.get(row)).get(column)).getTableCellEditor();
   }

   public boolean containsEditorRendererForRowColumn(Integer row, Integer column) {
      return this.rows.containsKey(row) ? ((HashMap)this.rows.get(row)).containsKey(column) : false;
   }
}
