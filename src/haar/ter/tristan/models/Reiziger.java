package haar.ter.tristan.models;

import java.sql.Date;

public class Reiziger
{
    private long reizigerID;
    private String voornaam;
    private String tussenvoegsel;
    private String achternaam;
    private Date geboortedatum;

    public Reiziger()
    {
        //in afbeelding heeft Reiziger geen constructor params.
    }

    public long getReizigerID() {
        return reizigerID;
    }

    public void setReizigerID(long reizigerID) {
        this.reizigerID = reizigerID;
    }

    public String getVoornaam() {
        return this.voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
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
        return String.join(" ", new String[]{this.getVoornaam(), this.getTussenvoegsel(), this.getAchternaam()} );
    }
}
