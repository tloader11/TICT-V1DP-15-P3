package haar.ter.tristan.models;

import haar.ter.tristan.DatabaseConfig;

import java.sql.Date;

public class OV_Chipkaart_Product
{
    private long ovproductID;
    private long kaartNummer;
    private long productNummer;
    private String reisproductStatus;
    private Date lastUpdate;

    public OV_Chipkaart_Product()
    {
    }

    public OV_Chipkaart_Product(long ovproductID, long kaartNummer, long productNummer, String reisproductStatus, Date lastUpdate) {
        this.ovproductID = ovproductID;
        this.kaartNummer = kaartNummer;
        this.productNummer = productNummer;
        this.reisproductStatus = reisproductStatus;
        this.lastUpdate = lastUpdate;
    }

    public long getOvproductID() {
        return ovproductID;
    }

    public void setOvproductID(long ovproductID) {
        this.ovproductID = ovproductID;
    }

    public long getKaartNummer() {
        return kaartNummer;
    }

    public void setKaartNummer(long kaartNummer) {
        this.kaartNummer = kaartNummer;
    }

    public long getProductNummer() {
        return productNummer;
    }

    public void setProductNummer(long productNummer) {
        this.productNummer = productNummer;
    }

    public String getReisproductStatus() {
        return reisproductStatus;
    }

    public void setReisproductStatus(String reisproductStatus) {
        this.reisproductStatus = reisproductStatus;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public OV_Chipkaart getOV_Chipkaart()
    {
        return DatabaseConfig.ov_chipkaartDao.findByID(this.getKaartNummer());
    }

    public Product getProduct()
    {
        return DatabaseConfig.productDao.findByNummer(this.getProductNummer());
    }

}
