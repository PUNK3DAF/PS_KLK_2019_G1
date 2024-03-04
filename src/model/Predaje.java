/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author vldmrk
 */
public class Predaje {

    private int id;
    private Profesor prof;
    private Predmet pred;

    @Override
    public String toString() {
        return "Predaje{" + "id=" + id + ", prof=" + prof + ", pred=" + pred + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Predaje other = (Predaje) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.prof, other.prof)) {
            return false;
        }
        return Objects.equals(this.pred, other.pred);
    }

    public Predaje() {
    }

    public Predaje(int id, Profesor prof, Predmet pred) {
        this.id = id;
        this.prof = prof;
        this.pred = pred;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Profesor getProf() {
        return prof;
    }

    public void setProf(Profesor prof) {
        this.prof = prof;
    }

    public Predmet getPred() {
        return pred;
    }

    public void setPred(Predmet pred) {
        this.pred = pred;
    }

}
