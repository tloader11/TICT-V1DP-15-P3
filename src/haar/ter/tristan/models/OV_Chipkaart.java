package haar.ter.tristan.models;

import java.sql.Date;

public class OV_Chipkaart
{
    private long kaartNummer;
    private Date geldigTot;
    private short klasse;
    private float saldo;
    private long reizigerID;

    public OV_Chipkaart()
    {
    }

    public long getKaartNummer() {
        return kaartNummer;
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
}
