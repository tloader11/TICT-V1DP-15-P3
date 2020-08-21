package haar.ter.tristan.models;

import haar.ter.tristan.DatabaseConfig;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OV_Chipkaart
{
    private long kaartNummer;
    private Date geldigTot;
    private short klasse;
    private float saldo;
    private long reizigerID;
    private Reiziger reiziger;
    private List<OV_Chipkaart_Product> ov_chipkaart_products;
    private List<Product> products;

    public OV_Chipkaart()
    {
    }

    public long getKaartNummer() {
        return kaartNummer;
    }

    public OV_Chipkaart(long kaartNummer, Date geldigTot, short klasse, float saldo, long reizigerID) {
        this.kaartNummer = kaartNummer;
        this.geldigTot = geldigTot;
        this.klasse = klasse;
        this.saldo = saldo;
        this.reizigerID = reizigerID;
    }

    public void setKaartNummer(long kaartNummer) {
        this.kaartNummer = kaartNummer;
    }

    public Date getGeldigTot() {
        return geldigTot;
    }

    public void setGeldigTot(Date geldigTot) {
        this.geldigTot = geldigTot;
    }

    public short getKlasse() {
        return klasse;
    }

    public void setKlasse(short klasse) {
        this.klasse = klasse;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public long getReizigerID() {
        return reizigerID;
    }

    public void setReizigerID(long reizigerID) {
        this.reizigerID = reizigerID;
    }

    public Reiziger getReiziger()
    {
        if(this.reiziger == null)   //local memory caching :-)
        {
            this.reiziger = DatabaseConfig.reizigerDao.findByID(this.getReizigerID());
        }
        return this.reiziger;
    }

    public List<OV_Chipkaart_Product> getOV_Chipkaart_producten()  //lazy loading instead of eager...., no loop problems..
    {
        if(this.ov_chipkaart_products == null)   //local memory caching :-)
        {
            this.ov_chipkaart_products = DatabaseConfig.ov_chipkaart_productDao.findByKaartnummer(this.getKaartNummer());
        }
        return this.ov_chipkaart_products;
    }

    public List<Product> getProducten() //lazy loading instead of eager...., no loop problems..
    {
        if(this.products == null)   //local memory caching :-)
        {
            List<Product> products = new ArrayList<>();
            this.getOV_Chipkaart_producten();    //make sure the relation is init'ed.
            for(OV_Chipkaart_Product ov_chipkaart_product : this.getOV_Chipkaart_producten())
            {
                products.add(ov_chipkaart_product.getProduct());
            }
            this.products = products;
        }
        return this.products;
    }
}
