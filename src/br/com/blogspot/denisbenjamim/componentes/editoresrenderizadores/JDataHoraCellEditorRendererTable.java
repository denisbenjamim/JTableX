package br.com.blogspot.denisbenjamim.componentes.editoresrenderizadores;

import br.com.blogspot.denisbenjamim.componentes.painel.JDataHora;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JTable;

/**
 *
 * @author Denis
 * 
 */
public class JDataHoraCellEditorRendererTable extends AbstractCellEditorRendererTable implements PropertyChangeListener {

    private final JDataHora dataHora;

    public JDataHoraCellEditorRendererTable() {
        this.dataHora = new JDataHora();
        this.dataHora.getjDC_data().addPropertyChangeListener(this);
        this.dataHora.getjSF_hora().addPropertyChangeListener(this);
        this.dataHora.getjSF_minuto().addPropertyChangeListener(this);
    }

    @Override
    public Date getCellEditorValue() {
        try {
            LocalDateTime dateTime = dataHora.getjDC_data().getDate().toInstant()
                    .atZone(ZoneId.systemDefault()).toLocalDate()
                    .atTime(
                            dataHora.getjSF_hora().getValue(),
                            dataHora.getjSF_minuto().getValue());
           
            return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
        } catch (NullPointerException exception) {
            return null;
        }
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value != null) {
            Calendar data = Calendar.getInstance();
            data.setTime((Date) value);
            this.dataHora.getjDC_data().setDate(data.getTime());
            this.dataHora.getjSF_hora().setValue(data.get(Calendar.HOUR_OF_DAY));
            this.dataHora.getjSF_minuto().setValue(data.get(Calendar.MINUTE));

        }
        return this.dataHora;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value != null) {
            Calendar data = Calendar.getInstance();
            data.setTime((Date) value);
            this.dataHora.getjDC_data().setDate(data.getTime());
            this.dataHora.getjSF_hora().setValue(data.get(Calendar.HOUR_OF_DAY));
            this.dataHora.getjSF_minuto().setValue(data.get(Calendar.MINUTE));

        }
        return this.dataHora;
    }

    @Override
    public JDataHora getComponent() {
        return this.dataHora;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        fireEditingStopped();
    }

}
