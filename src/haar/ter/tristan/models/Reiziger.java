package haar.ter.tristan.models;

import haar.ter.tristan.DatabaseConfig;

import java.sql.Date;
import java.util.List;

public class Reiziger
{
    private long reizigerID;
    private String voorletters;
    private String tussenvoegsel;
    private String achternaam;
    private Date geboortedatum;

    public Reiziger()
    {
        //in afbeelding heeft Reiziger geen constructor params.
    }

    public Reiziger(long reizigerID, String voorletters, String tussenvoegsel, String achternaam, Date geboortedatum) {
        this.reizigerID = reizigerID;
        this.voorletters = voorletters;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
    }

    public long getReizigerID() {
        return reizigerID;
    }

    public void setReizigerID(long reizigerID) {
        this.reizigerID = reizigerID;
    }

    public String getVoorletters() {
        return this.voorletters;
    }

    public void setVoorletters(String voorletters) {
        this.voorletters = voorletters;
    }

    public String getTussenvoegsel() {
        return this.tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getAchternaam() {
        return this.achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public String getName()
    {
        return String.join(" ", new String[]{this.getVoorletters(), this.getTussenvoegsel(), this.getAchternaam()} );
    }

    public List<OV_Chipkaart> getOVChipkaarten ()
    {
        return DatabaseConfig.ov_chipkaartDao.findByReizigerID(this.getReizigerID());
    }

    public List<Adres> getAdressen ()
    {
        return DatabaseConfig.adresDao.findByReizigerID(this.getReizigerID());
    }
}
