/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Profesor;

/**
 *
 * @author vldmrk
 */
public class ModelTabeleProfesori extends AbstractTableModel {

    private final List<Profesor> profesori;
    private final String[] kolone = {"id", "ime", "prezime", "zvanje", "status"};

    public ModelTabeleProfesori(List<Profesor> profesori) {
        this.profesori = profesori;
    }

    @Override
    public int getRowCount() {
        return profesori.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                return profesori.get(rowIndex).getId();
            }
            case 1 -> {
                return profesori.get(rowIndex).getIme();
            }
            case 2 -> {
                return profesori.get(rowIndex).getPrezime();
            }
            case 3 -> {
                return profesori.get(rowIndex).getZvanje();
            }
            case 4 -> {
                return profesori.get(rowIndex).getStatus();
            }
            default ->
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

}
