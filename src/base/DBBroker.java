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
import model.Profesor;
import model.Status;
import model.Zvanje;

/**
 *
 * @author vldmrk
 */
public class DBBroker {

    private Konekcija konek = Konekcija.getInstance();
    private List<Profesor> profesori;
    private static int i = 1;

    public List<Profesor> getProfesori() {
        return profesori;
    }

    public DBBroker() {
        profesori = new ArrayList<>();
    }

    public List<Profesor> ucitajListu() {
        System.out.println(i + "");
        i++;
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
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
