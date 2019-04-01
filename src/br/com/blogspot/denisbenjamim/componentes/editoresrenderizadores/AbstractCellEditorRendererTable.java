package br.com.blogspot.denisbenjamim.componentes.editoresrenderizadores;

import java.awt.Component;
import java.io.Serializable;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Denis
 */
public abstract class AbstractCellEditorRendererTable extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, Serializable {

    public abstract Component getComponent();
    
    public TableCellEditor getTableCellEditor() {
        return this;
    }

    public TableCellRenderer getTableCellRenderer() {
        return this;
    }

    @Override
    public boolean isCellEditable(EventObject e) {
        return true;
    }
    
    
}
