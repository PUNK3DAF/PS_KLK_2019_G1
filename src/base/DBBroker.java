/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Predaje;
import model.Predmet;
import model.Profesor;
import model.Status;
import model.Zvanje;

/**
 *
 * @author vldmrk
 */
public class DBBroker {

    private static DBBroker instance;
    Connection konek = Konekcija.getInstance().getConnection();
    private List<Profesor> profesori = new ArrayList<>();
    private List<Predaje> predaje = new ArrayList<>();

    public List<Predaje> getPredaje() {
        return predaje;
    }

    public void setPredaje(List<Predaje> predaje) {
        this.predaje = predaje;
    }

    public List<Profesor> getProfesori() {
        return profesori;
    }

    public void setProfesori(List<Profesor> profesori) {
        this.profesori = profesori;
    }

    public static DBBroker getInstance() {
        if (instance == null) {
            instance = new DBBroker();
        }

        return instance;
    }

    public List<Profesor> ucitajListu() {
        List<Profesor> profe = new ArrayList<>();
        try {
            String upit = "SELECT * FROM profesori";
            Statement st = konek.createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                int id = rs.getInt("id");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                Status status = Status.valueOf(rs.getString("status"));
                Zvanje zvanje = Zvanje.valueOf(rs.getString("zvanje"));

                Profesor p = new Profesor(id, ime, prezime, zvanje, status);
                profe.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return profe;
    }

    public void izmeniProfesora(int id, String ime, String prezime, Zvanje zvanje) {
        try {
            String upit = "UPDATE profesori SET ime=?, prezime=?, zvanje=? WHERE id=?";
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setString(1, ime);
            ps.setString(2, prezime);
            ps.setString(3, String.valueOf(zvanje));
            ps.setInt(4, id);

            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Predaje> ucitajListuPred(List<Profesor> selekProf) {
        List<Predaje> pred = new ArrayList<>();
        for (Profesor p : selekProf) {

            try {
                String upit = "SELECT * FROM predaje pr JOIN profesori p ON profid=p.id JOIN predmet pre ON predmetid=pre.sifra WHERE p.id=" + p.getId() + " ORDER BY p.prezime ASC, pre.naziv ASC";
                Statement st = konek.createStatement();
                ResultSet rs = st.executeQuery(upit);
                while (rs.next()) {
                    int id = rs.getInt("pre.sifra");
                    String naziv = rs.getString("pre.naziv");
                    int ESPB = rs.getInt("ESPB");
                    Predmet predmet = new Predmet(id, naziv, ESPB);
                    int idPred = rs.getInt("pr.id");
                    Predaje pre = new Predaje(idPred, p, predmet);
                    pred.add(pre);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pred;
    }
}
