/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import base.DBBroker;
import java.util.ArrayList;
import java.util.List;
import model.PoreskaStopa;
import model.Predaje;
import model.Profesor;
import model.Proizvod;
import model.Proizvodjac;
import model.Zvanje;

/**
 *
 * @author vldmrk
 */
public class Controller {

    private static Controller instance;
    private DBBroker dbb = DBBroker.getInstance();
    private final List<Proizvod> pr = new ArrayList<>();
    private final List<PoreskaStopa> ps = new ArrayList<>();
    private final List<Proizvodjac> pro = new ArrayList<>();

    public List<Proizvod> getPr() {
        return pr;
    }

    public List<PoreskaStopa> getPs() {
        return ps;
    }

    public List<Proizvodjac> getPro() {
        return pro;
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }

        return instance;
    }

    private Controller() {
        PoreskaStopa ps1 = new PoreskaStopa(1, "PS1", 10.0);
        PoreskaStopa ps2 = new PoreskaStopa(2, "PS2", 15.0);

        Proizvodjac pro1 = new Proizvodjac(1, "PRO1");
        Proizvodjac pro2 = new Proizvodjac(2, "PRO2");

        Proizvod p1 = new Proizvod(1, "P1", 99.99, pro1, ps1);
        Proizvod p2 = new Proizvod(2, "P2", 69.99, pro1, ps2);
        Proizvod p3 = new Proizvod(3, "P3", 49.99, pro2, ps1);
        Proizvod p4 = new Proizvod(4, "P4", 199.99, pro2, ps2);
        Proizvod p5 = new Proizvod(5, "P5", 249.99, pro1, ps1);

        ps.add(ps1);
        ps.add(ps2);

        pro.add(pro1);
        pro.add(pro2);

        pr.add(p1);
        pr.add(p2);
        pr.add(p3);
        pr.add(p4);
        pr.add(p5);
    }

    public List<Profesor> ucitajListu() {
        return dbb.ucitajListu();
    }

    public void izmeniProfesora(int id, String ime, String prezime, Zvanje zvanje) {
        dbb.izmeniProfesora(id, ime, prezime, zvanje);
    }

    public List<Predaje> ucitajListuPred(List<Profesor> selekProf) {
        return dbb.ucitajListuPred(selekProf);
    }

}
