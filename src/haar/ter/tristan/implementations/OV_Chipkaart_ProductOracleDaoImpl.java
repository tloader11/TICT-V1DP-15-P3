package haar.ter.tristan.implementations;

import haar.ter.tristan.interfaces.OV_ChipkaartDao;
import haar.ter.tristan.interfaces.OV_Chipkaart_ProductDao;
import haar.ter.tristan.models.OV_Chipkaart;
import haar.ter.tristan.models.OV_Chipkaart_Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OV_Chipkaart_ProductOracleDaoImpl implements OV_Chipkaart_ProductDao
{
    List<OV_Chipkaart_Product> ov_chipkaart_producten = new ArrayList<>();

    @Override
    public List<OV_Chipkaart_Product> findAll() {
        try
        {
            Statement stmt = this.connection.createStatement();
            String query = "SELECT * FROM OV_CHIPKAART_PRODUCT";
            ResultSet rs = stmt.executeQuery(query);
            List<OV_Chipkaart_Product> ov_chipkaart_productList = new ArrayList<>();
            while (rs.next()) {
                //long ovproductID, long kaartNummer, long productNummer, String reisproductStatus, Date lastUpdate
                ov_chipkaart_productList.add(
                        new OV_Chipkaart_Product(
                                rs.getInt("OVPRODUCTID"),
                                rs.getInt("KAARTNUMMER"),
                                rs.getInt("PRODUCTNUMMER"),
                                rs.getString("REISPRODUCTSTATUS"),
                                rs.getDate("LASTUPDATE")
                        )
                );
            }
            rs.close();
            stmt.close();
            return ov_chipkaart_productList;
        }
        catch (SQLException ex)
        {
            return null;
        }
    }

    @Override
    public List<OV_Chipkaart_Product> findByKaartnummer(long nummer) {
        String query = "SELECT * FROM OV_CHIPKAART_PRODUCT WHERE KAARTNUMMER =" + nummer;
        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            List<OV_Chipkaart_Product> ovChipkaart_ProductMetKaartnummer = new ArrayList<>();
            while (rs.next()) {
                ovChipkaart_ProductMetKaartnummer.add(
                        new OV_Chipkaart_Product(
                                rs.getInt("OVPRODUCTID"),
                                rs.getInt("KAARTNUMMER"),
                                rs.getInt("PRODUCTNUMMER"),
                                rs.getString("REISPRODUCTSTATUS"),
                                rs.getDate("LASTUPDATE")
                        )
                );
            }
            rs.close();
            stmt.close();
            return ovChipkaart_ProductMetKaartnummer;
        }
        catch (SQLException ex)
        {
            return null;
        }
    }

    @Override
    public List<OV_Chipkaart_Product> findByProductnummer(long nummer) {
        String query = "SELECT * FROM OV_CHIPKAART_PRODUCT WHERE PRODUCTNUMMER =" + nummer;
        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            List<OV_Chipkaart_Product> ovChipkaart_ProductMetProductnummer = new ArrayList<>();
            while (rs.next()) {
                ovChipkaart_ProductMetProductnummer.add(
                        new OV_Chipkaart_Product(
                                rs.getInt("OVPRODUCTID"),
                                rs.getInt("KAARTNUMMER"),
                                rs.getInt("PRODUCTNUMMER"),
                                rs.getString("REISPRODUCTSTATUS"),
                                rs.getDate("LASTUPDATE")
                        )
                );
            }
            rs.close();
            stmt.close();
            return ovChipkaart_ProductMetProductnummer;
        }
        catch (SQLException ex)
        {
            return null;
        }
    }

    @Override
    public OV_Chipkaart_Product findByID(long id) {
        String query = "SELECT * FROM OV_CHIPKAART_PRODUCT WHERE OVPRODUCTID = " + id;
        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            OV_Chipkaart_Product ov_chipkaart_product = null;
            rs.next();
            ov_chipkaart_product = new OV_Chipkaart_Product(
                    rs.getInt("OVPRODUCTID"),
                    rs.getInt("KAARTNUMMER"),
                    rs.getInt("PRODUCTNUMMER"),
                    rs.getString("REISPRODUCTSTATUS"),
                    rs.getDate("LASTUPDATE")
            );
            rs.close();
            stmt.close();
            return ov_chipkaart_product;
        }
        catch (SQLException ex)
        {
            return null;
        }
    }

    @Override
    public OV_Chipkaart_Product save(OV_Chipkaart_Product ov_chipkaart_product) {
        String query = "INSERT INTO OV_CHIPKAART_PRODUCT(OVPRODUCTID, KAARTNUMMER, PRODUCTNUMMER, REISPRODUCTSTATUS, LASTUPDATE) VALUES ("+
                ov_chipkaart_product.getOvproductID()+","+
                ov_chipkaart_product.getKaartNummer()+","+
                ov_chipkaart_product.getProductNummer()+",'"+
                ov_chipkaart_product.getReisproductStatus()+"',"+
                "TO_DATE('"+ov_chipkaart_product.getLastUpdate()+"', 'YYYY-MM-DD')"+
                ")";
        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.close();
            stmt.close();
            return ov_chipkaart_product;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public OV_Chipkaart_Product update(OV_Chipkaart_Product ov_chipkaart_product) {
        String query = "UPDATE OV_CHIPKAART_PRODUCT SET "+
                "KAARTNUMMER=" + ov_chipkaart_product.getKaartNummer() +","+
                "PRODUCTNUMMER=" + ov_chipkaart_product.getProductNummer()+","+
                "REISPRODUCTSTATUS='" + ov_chipkaart_product.getReisproductStatus()+"',"+
                "LASTUPDATE=" + "TO_DATE('"+ov_chipkaart_product.getLastUpdate()+"', 'YYYY-MM-DD')" +
                " WHERE OVPRODUCTID=" + ov_chipkaart_product.getOvproductID();
        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.close();
            stmt.close();
            return ov_chipkaart_product;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean delete(long OVProductID) {
        String query = "DELETE FROM OV_CHIPKAART_PRODUCT WHERE  OVPRODUCTID=" + OVProductID;
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
