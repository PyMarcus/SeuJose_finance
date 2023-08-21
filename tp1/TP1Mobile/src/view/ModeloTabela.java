package view;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;
import model.Finance;

public class ModeloTabela extends AbstractTableModel {
    private Vector<Finance> finances;

    public ModeloTabela(Vector<Finance> finances){
        this.finances = finances;
    }

    /**
     * @return 
     */
    @Override
    public int getRowCount() {
        return 0;
    }

    /**
     * @return 
     */
    @Override
    public int getColumnCount() {
        return 0;
    }

    /**
     * @param rowIndex    the row whose value is to be queried 
     * @param columnIndex the column whose value is to be queried
     * @return
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }
}