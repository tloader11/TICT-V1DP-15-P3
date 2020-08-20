package haar.ter.tristan.models;

public class Adres
{
    private long adresID;
    private String postcode;
    private String huisnummer;
    private String straat;
    private String woonplaats;
    private long reizigerID;

    public Adres()
    {
    }

    public long getAdresID() {
        return adresID;
    }

    public void setAdresID(long adresID) {
        this.adresID = adresID;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(String huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public long getReizigerID() {
        return reizigerID;
    }

    public void setReizigerID(long reizigerID) {
        this.reizigerID = reizigerID;
    }
}
