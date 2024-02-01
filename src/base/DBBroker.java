/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package base;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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

    private Konekcija konek = Konekcija.getInstance();

    public DBBroker() {
    }

    public List<Profesor> ucitajListu() {
        List<Profesor> profesori = new ArrayList<>();
        try {
            String upit = "SELECT * FROM profesori";
            Statement st = konek.getKonek().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                int id = rs.getInt("id");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                Zvanje zvanje = Zvanje.valueOf(rs.getString("zvanje"));
                Status status = Status.valueOf(rs.getString("status"));

                Profesor p = new Profesor(id, ime, prezime, zvanje, status);

                profesori.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return profesori;
    }

    public void izmeniProfesora(Profesor p) {
        try {
            String upit = "UPDATE profesori SET ime=?, prezime=?, zvanje=? WHERE id=?";
            PreparedStatement ps = konek.getKonek().prepareStatement(upit);
            ps.setString(1, p.getIme());
            ps.setString(2, p.getPrezime());
            ps.setString(3, String.valueOf(p.getZvanje()));
            ps.setInt(4, p.getId());
            ps.executeUpdate();
            konek.getKonek().commit();

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Predaje> ucitajListuAngaz(List<Profesor> selekProf) {
        List<Predaje> lista = new ArrayList<>();
        for (Profesor p : selekProf) {
            try {
                String upit = "SELECT * FROM predaje JOIN predmeti ON predaje.predmetid=predmeti.id "
                        + "JOIN profesori ON profesori.id=predaje.profid WHERE predaje.profid=" + p.getId();
                Statement st = konek.getKonek().createStatement();
                ResultSet rs = st.executeQuery(upit);
                while (rs.next()) {
                    int id = rs.getInt("predmeti.id");
                    String naziv = rs.getString("predmeti.naziv");
                    int espb = rs.getInt("predmeti.espb");
                    int predId = rs.getInt("predaje.id");
                    Predmet pred = new Predmet(id, naziv, espb);
                    Predaje pr = new Predaje(predId, p, pred);
                    lista.add(pr);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lista;
    }

}
