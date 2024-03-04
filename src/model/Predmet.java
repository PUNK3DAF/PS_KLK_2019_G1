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
public class Predmet {

    private int sifra;
    private String naziv;
    private int ESPB;

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Predmet other = (Predmet) obj;
        if (this.sifra != other.sifra) {
            return false;
        }
        if (this.ESPB != other.ESPB) {
            return false;
        }
        return Objects.equals(this.naziv, other.naziv);
    }

    public Predmet() {
    }

    public Predmet(int sifra, String naziv, int ESPB) {
        this.sifra = sifra;
        this.naziv = naziv;
        this.ESPB = ESPB;
    }

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getESPB() {
        return ESPB;
    }

    public void setESPB(int ESPB) {
        this.ESPB = ESPB;
    }

}
