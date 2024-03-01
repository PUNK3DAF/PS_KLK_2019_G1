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
public class Proizvod {

    private int sifra;
    private String naziv;
    private double cena;
    private Proizvodjac proizvodjac;
    private PoreskaStopa ps;

    public Proizvod() {
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
        final Proizvod other = (Proizvod) obj;
        if (this.sifra != other.sifra) {
            return false;
        }
        if (Double.doubleToLongBits(this.cena) != Double.doubleToLongBits(other.cena)) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.proizvodjac, other.proizvodjac)) {
            return false;
        }
        return Objects.equals(this.ps, other.ps);
    }

    @Override
    public String toString() {
        return naziv;
    }

    public Proizvod(int sifra, String naziv, double cena, Proizvodjac proizvodjac, PoreskaStopa ps) {
        this.sifra = sifra;
        this.naziv = naziv;
        this.cena = cena;
        this.proizvodjac = proizvodjac;
        this.ps = ps;
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

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Proizvodjac getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(Proizvodjac proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public PoreskaStopa getPs() {
        return ps;
    }

    public void setPs(PoreskaStopa ps) {
        this.ps = ps;
    }

}
