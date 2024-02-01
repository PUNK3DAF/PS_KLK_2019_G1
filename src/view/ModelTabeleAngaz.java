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
public class ModelTabeleAngaz extends AbstractTableModel {

    private List<Predaje> predaje;
    private final String[] kolone = {"ID", "Ime", "Prezime", "Naziv Predmeta"};

    public List<Predaje> getPredaje() {
        return predaje;
    }

    public void setPredaje(List<Predaje> predaje) {
        this.predaje = predaje;
    }

    public ModelTabeleAngaz(List<Predaje> predaje) {
        this.predaje = predaje;
    }

    @Override
    public int getRowCount() {
        return predaje.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Predaje p = predaje.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getId();
            case 1:
                return p.getProfesor().getIme();
            case 2:
                return p.getProfesor().getPrezime();
            case 3:
                return p.getPredmet().getNaziv();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

}
