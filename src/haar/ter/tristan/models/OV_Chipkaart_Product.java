package haar.ter.tristan.models;

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
}
