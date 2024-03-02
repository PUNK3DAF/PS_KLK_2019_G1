/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package base;

import java.sql.Connection;
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

    private static DBBroker instance;
    Connection konek = Konekcija.getInstance().getConnection();
    private List<Profesor> profesori = new ArrayList<>();

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

    private DBBroker() {
        try {
            String upit = "SELECT * FROM profesori";
            Statement st = konek.createStatement();
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

    }

    public List<Profesor> ucitajListu() {
        return profesori;
    }

}
