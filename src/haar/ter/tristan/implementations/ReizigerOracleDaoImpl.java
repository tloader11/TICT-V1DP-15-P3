package haar.ter.tristan.implementations;

import haar.ter.tristan.interfaces.ReizigerDao;
import haar.ter.tristan.models.Reiziger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReizigerOracleDaoImpl implements ReizigerDao
{

    @Override
    public List<Reiziger> findAll() {
        try
        {
            Statement stmt = this.connection.createStatement();
            String query = "SELECT * FROM REIZIGER";
            ResultSet rs = stmt.executeQuery(query);
            List<Reiziger> reizigers = new ArrayList<>();
            while (rs.next()) {
                //long reizigerID, String voornaam, String tussenvoegsel, String achternaam, Date geboortedatum
                reizigers.add(
                        new Reiziger(
                                rs.getInt("REIZIGERID"),
                                rs.getString("VOORLETTERS"),
                                rs.getString("TUSSENVOEGSEL"),
                                rs.getString("ACHTERNAAM"),
                                rs.getDate("GEBOORTEDATUM")
                        )
                );
            }
            rs.close();
            stmt.close();
            return reizigers;
        }
        catch (SQLException ex)
        {
            return null;
        }
    }

    @Override
    public List<Reiziger> findByGeboortedatum(String GBdatum) {
        List<Reiziger> reizigerMetGBDatum = new ArrayList<>();
        String query = "SELECT * FROM REIZIGER WHERE GEBOORTEDATUM LIKE TO_DATE('" + GBdatum + "', 'YYYY-MM-DD')";
        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            List<Reiziger> reizigers = new ArrayList<>();
            while (rs.next()) {
                //long reizigerID, String voornaam, String tussenvoegsel, String achternaam, Date geboortedatum
                reizigerMetGBDatum.add(
                        new Reiziger(
                                rs.getInt("REIZIGERID"),
                                rs.getString("VOORLETTERS"),
                                rs.getString("TUSSENVOEGSEL"),
                                rs.getString("ACHTERNAAM"),
                                rs.getDate("GEBOORTEDATUM")
                        )
                );
            }
            rs.close();
            stmt.close();
            return reizigerMetGBDatum;
        }
        catch (SQLException ex)
        {
            return null;
        }
    }

    @Override
    public Reiziger findByID(long id) {
        String query = "SELECT * FROM REIZIGER WHERE REIZIGERID = " + id;
        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            Reiziger reiziger = null;
            rs.next();
            reiziger = new Reiziger(
                            rs.getInt("REIZIGERID"),
                            rs.getString("VOORLETTERS"),
                            rs.getString("TUSSENVOEGSEL"),
                            rs.getString("ACHTERNAAM"),
                            rs.getDate("GEBOORTEDATUM")
                        );
            rs.close();
            stmt.close();
            return reiziger;
        }
        catch (SQLException ex)
        {
            return null;
        }
    }

    @Override
    public Reiziger save(Reiziger reiziger) {
        String query = "INSERT INTO REIZIGER (REIZIGERID, VOORLETTERS, TUSSENVOEGSEL, ACHTERNAAM, GEBOORTEDATUM) VALUES ("+
                reiziger.getReizigerID()+",'"+
                reiziger.getVoorletters()+"','"+
                reiziger.getTussenvoegsel()+"','"+
                reiziger.getAchternaam()+"',"+
                "TO_DATE('"+reiziger.getGeboortedatum()+"', 'YYYY-MM-DD')"+
        ")";
        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.close();
            stmt.close();
            return reiziger;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }


    @Override
    public Reiziger update(Reiziger reiziger)
    {
        String query = "UPDATE REIZIGER SET "+
                "VOORLETTERS='" + reiziger.getVoorletters()+"',"+
                "TUSSENVOEGSEL='" + reiziger.getTussenvoegsel()+"',"+
                "ACHTERNAAM='" + reiziger.getAchternaam()+"',"+
                "GEBOORTEDATUM=" + "TO_DATE('"+reiziger.getGeboortedatum()+"', 'YYYY-MM-DD')"+
                " WHERE REIZIGERID=" + reiziger.getReizigerID();
        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.close();
            stmt.close();
            return reiziger;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean delete(long reizigerID) {
        String query = "DELETE FROM REIZIGER WHERE  REIZIGERID=" + reizigerID;
        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.close();
            stmt.close();
            return true;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return false;
        }
    }
}
