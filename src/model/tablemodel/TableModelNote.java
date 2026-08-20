package model.tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Note;
import util.DateUtil;

public class TableModelNote extends AbstractTableModel{
    
    private final String[] columns;
    private List<Note> rows;
    private final DateUtil dateUtil;
    
    public TableModelNote(){
        this.columns = new String[]{"Nome", "Descrição", "Possui alarme?", "Data e hora do alarme"};
        this.rows = new ArrayList<>();
        this.dateUtil = new DateUtil();
    }

    @Override
    public int getRowCount() {
        return this.rows.size();
    }

    @Override
    public int getColumnCount() {
        return this.columns.length;
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return this.columns[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Note note = rows.get(rowIndex);
        switch(columnIndex){
            case 0:
                return note.getName();
            case 1:
                return note.getDescription();
            case 2:
                return note.getAlarm() == 1 ? "Sim": "Não";
            case 3:
                return dateUtil.getDateTimeFormatted(note.getDateTimeAlarm());
                        
            default:
                return null;
        }   
    }
    
    public void setNotes(List<Note>notes){
        this.rows = notes;
        fireTableDataChanged();
    }
    
    public void addNote(Note note){
        this.rows.add(note);
        int lastIndex = getRowCount() -1;
        fireTableRowsInserted(lastIndex,lastIndex);
    }
    
    public void updateNote(Note note){
        for(int i=0; i< rows.size();i++){
            if(rows.get(i).getId() == note.getId()){
                rows.set(i, note);
                fireTableRowsUpdated(i,i);
            }
        }
    }
    
    public Note getNote(int index){
        return this.rows.get(index);
    }
    
    public void deleteNote(int index){
           this.rows.remove(index);
           fireTableDataChanged();
    }

}
