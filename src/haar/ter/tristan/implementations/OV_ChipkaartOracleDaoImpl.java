package haar.ter.tristan.implementations;

import haar.ter.tristan.interfaces.OV_ChipkaartDao;
import haar.ter.tristan.models.OV_Chipkaart;
import haar.ter.tristan.models.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OV_ChipkaartOracleDaoImpl implements OV_ChipkaartDao
{

    @Override
    public List<OV_Chipkaart> findAll() {
        try
        {
            Statement stmt = this.connection.createStatement();
            String query = "SELECT * FROM OV_CHIPKAART";
            ResultSet rs = stmt.executeQuery(query);
            List<OV_Chipkaart> ov_chipkaartList = new ArrayList<>();
            while (rs.next()) {
                //long kaartNummer, Date geldigTot, short klasse, float saldo, long reizigerID
                ov_chipkaartList.add(
                        new OV_Chipkaart(
                                rs.getInt("KAARTNUMMER"),
                                rs.getDate("GELDIGTOT"),
                                rs.getShort("KLASSE"),
                                rs.getFloat("SALDO"),
                                rs.getInt("REIZIGERID")
                        )
                );
            }
            rs.close();
            stmt.close();
            return ov_chipkaartList;
        }
        catch (SQLException ex)
        {
            return null;
        }
    }

    @Override
    public List<OV_Chipkaart> findByReizigerID(long id) {
        String query = "SELECT * FROM OV_CHIPKAART WHERE REIZIGERID =" + id;
        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            List<OV_Chipkaart> ovChipkaartMetReiziger = new ArrayList<>();
            while (rs.next()) {
                ovChipkaartMetReiziger.add(
                        new OV_Chipkaart(
                                rs.getInt("KAARTNUMMER"),
                                rs.getDate("GELDIGTOT"),
                                rs.getShort("KLASSE"),
                                rs.getFloat("SALDO"),
                                rs.getInt("REIZIGERID")
                        )
                );
            }
            rs.close();
            stmt.close();
            return ovChipkaartMetReiziger;
        }
        catch (SQLException ex)
        {
            return null;
        }
    }

    @Override
    public OV_Chipkaart findByID(long id) {
        String query = "SELECT * FROM OV_CHIPKAART WHERE KAARTNUMMER = " + id;
        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            OV_Chipkaart ov_chipkaart = null;
            rs.next();
            ov_chipkaart = new OV_Chipkaart(
                    rs.getInt("KAARTNUMMER"),
                    rs.getDate("GELDIGTOT"),
                    rs.getShort("KLASSE"),
                    rs.getFloat("SALDO"),
                    rs.getInt("REIZIGERID")
            );
            rs.close();
            stmt.close();
            return ov_chipkaart;
        }
        catch (SQLException ex)
        {
            return null;
        }
    }

    @Override
    public OV_Chipkaart save(OV_Chipkaart ov_chipkaart) {
        String query = "INSERT INTO OV_CHIPKAART (KAARTNUMMER, GELDIGTOT, KLASSE, SALDO, REIZIGERID) VALUES ("+
                ov_chipkaart.getKaartNummer()+","+
                "TO_DATE('"+ov_chipkaart.getGeldigTot()+"', 'YYYY-MM-DD'),"+
                ov_chipkaart.getKlasse()+","+
                ov_chipkaart.getSaldo()+","+
                ov_chipkaart.getReizigerID()+
                ")";
        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.close();
            stmt.close();
            return ov_chipkaart;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public OV_Chipkaart update(OV_Chipkaart ov_chipkaart) {
        String query = "UPDATE OV_CHIPKAART SET "+
                "GELDIGTOT=" + "TO_DATE('"+ov_chipkaart.getGeldigTot()+"', 'YYYY-MM-DD')"+","+
                "KLASSE=" + ov_chipkaart.getKlasse()+","+
                "SALDO=" + ov_chipkaart.getSaldo()+","+
                "REIZIGERID=" + ov_chipkaart.getReizigerID()+
                " WHERE KAARTNUMMER=" + ov_chipkaart.getKaartNummer();
        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.close();
            stmt.close();
            return ov_chipkaart;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean delete(long kaartnummer) {
        String query = "DELETE FROM OV_CHIPKAART WHERE  KAARTNUMMER=" + kaartnummer;
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
