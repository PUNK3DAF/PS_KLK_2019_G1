/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Predaje;

/**
 *
 * @author vldmrk
 */
public class ModelTabelePredmeti extends AbstractTableModel {

    private final List<Predaje> lista;
    private final String[] kolone = {"ime", "prezime", "predmet"};

    public ModelTabelePredmeti(List<Predaje> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                return lista.get(rowIndex).getProf().getIme();
            }
            case 1 -> {
                return lista.get(rowIndex).getProf().getPrezime();
            }
            case 2 -> {
                return lista.get(rowIndex).getPred().getNaziv();
            }
            default ->
                throw new AssertionError();
        }
    }

}
