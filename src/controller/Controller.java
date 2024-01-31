/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import base.DBBroker;
import java.util.ArrayList;
import java.util.List;
import model.PoreskaStopa;
import model.Profesor;
import model.Proizvod;
import model.Proizvodjac;
import model.Zvanje;

/**
 *
 * @author vldmrk
 */
public class Controller {

    private List<Proizvod> proizvodi = new ArrayList<>();
    private List<Proizvodjac> proizvodjaci = new ArrayList<>();
    private List<PoreskaStopa> ps = new ArrayList<>();
    private static Controller instance;
    private DBBroker dbb;

    public List<Proizvod> getProizvodi() {
        return proizvodi;
    }

    public List<Proizvodjac> getProizvodjaci() {
        return proizvodjaci;
    }

    public List<PoreskaStopa> getPs() {
        return ps;
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }

        return instance;
    }

    private Controller() {
        dbb = new DBBroker();

        PoreskaStopa ps1 = new PoreskaStopa(1, "PS1", 20.00);
        PoreskaStopa ps2 = new PoreskaStopa(2, "PS2", 10.00);

        ps.add(ps1);
        ps.add(ps2);

        Proizvodjac pr1 = new Proizvodjac(1, "Proizvodjac1");
        Proizvodjac pr2 = new Proizvodjac(2, "Proizvodjac2");

        proizvodjaci.add(pr1);
        proizvodjaci.add(pr2);

        Proizvod p1 = new Proizvod(1, "P1", 199.99, ps1, pr1);
        Proizvod p2 = new Proizvod(2, "P2", 299.99, ps2, pr1);
        Proizvod p3 = new Proizvod(3, "P3", 99.99, ps1, pr2);

        proizvodi.add(p1);
        proizvodi.add(p2);
        proizvodi.add(p3);
    }

    public List<Profesor> ucitajListu() {
        return dbb.ucitajListu();
    }

    public void izmeniProfesora(Profesor p) {
        dbb.izmeniProfesora(p);
    }

}
