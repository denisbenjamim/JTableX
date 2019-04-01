package br.com.blogspot.denisbenjamim.componentes.table;

import br.com.blogspot.denisbenjamim.componentes.editoresrenderizadores.AbstractCellEditorRendererTable;
import br.com.blogspot.denisbenjamim.componentes.editoresrenderizadores.RowColumnEditorRendererModel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class JTableX extends JTable {

    private RowColumnEditorRendererModel editorRendererModel;

    public JTableX() {
        super();
        this.editorRendererModel = null;
    }

    @Override
    public TableCellEditor getCellEditor(int row, int column) {

        AbstractCellEditorRendererTable editor = this.setEditorRenderer(row, column);

        return editor == null ? super.getCellEditor(row, column) : editor;
    }

    @Override
    public TableCellRenderer getCellRenderer(int row, int column) {

        AbstractCellEditorRendererTable renderer = this.setEditorRenderer(row, column);

        return renderer == null ? super.getCellRenderer(row, column) : renderer;
    }

    AbstractCellEditorRendererTable setEditorRenderer(int row, int column) {
        return this.getEditorRendererModel() != null && this.getEditorRendererModel().containsEditorRendererForRowColumn(row, column) ? this.getEditorRendererModel().getEditorRendererForRowColumn(row, column) : null;
    }

    public RowColumnEditorRendererModel getEditorRendererModel() {
        return this.editorRendererModel;
    }

    public void setEditorRendererModel(RowColumnEditorRendererModel editorRendererModel) {
        this.editorRendererModel = editorRendererModel;
    }
}
