package haar.ter.tristan.implementations;

import haar.ter.tristan.interfaces.AdresDao;
import haar.ter.tristan.models.Adres;

import java.util.ArrayList;
import java.util.List;

public class AdresOracleDaoImpl implements AdresDao
{
    List<Adres> adressen = new ArrayList<>();
    @Override
    public List<Adres> findAll() {
        return this.adressen;
    }

    @Override
    public List<Adres> findByReizigerID(long id) {
        List<Adres> adresMetReizigerID = new ArrayList<>();
        for (Adres adres: this.adressen)
        {
            if(adres.getReizigerID() == id)
            {
                adresMetReizigerID.add(adres);
            }
        }
        return adresMetReizigerID;
    }

    @Override
    public Adres findByID(long id) {
        Adres foundAdres = null;
        for (Adres adres: this.adressen)
        {
            if(adres.getAdresID() == id)
            {
                foundAdres = adres;
            }
        }
        return foundAdres;
    }

    @Override
    public Adres save(Adres adres) {
        adressen.add(adres);
        return adres;
    }

    @Override
    public Adres update(Adres adres) {
        for (Adres opgeslagenAdres : this.adressen)
        {
            if(opgeslagenAdres.equals(adres))
            {
                opgeslagenAdres.setReizigerID(adres.getReizigerID());
                opgeslagenAdres.setAdresID(adres.getAdresID());
                opgeslagenAdres.setHuisnummer(adres.getHuisnummer());
                opgeslagenAdres.setPostcode(adres.getPostcode());
                opgeslagenAdres.setStraat(adres.getStraat());
                opgeslagenAdres.setWoonplaats(adres.getWoonplaats());
                return opgeslagenAdres;
            }
        }
        return null;
    }

    @Override
    public boolean delete(Adres adres) {
        return this.adressen.remove(adres);
    }
}
