package haar.ter.tristan.implementations;

import haar.ter.tristan.interfaces.ReizigerDao;
import haar.ter.tristan.models.Reiziger;

import java.util.ArrayList;
import java.util.List;

public class ReizigerOracleDaoImpl implements ReizigerDao
{
    List<Reiziger> reizigers = new ArrayList<>();

    @Override
    public List<Reiziger> findAll() {
        return this.reizigers;
    }

    @Override
    public List<Reiziger> findByGeboortedatum(String GBdatum) {
        List<Reiziger> reizigerMetGBDatum = new ArrayList<>();
        for (Reiziger reiziger: this.reizigers)
        {
            if(reiziger.getGeboortedatum().toString().equalsIgnoreCase(GBdatum))
            {
                reizigerMetGBDatum.add(reiziger);
            }
        }
        return reizigerMetGBDatum;
    }

    @Override
    public Reiziger findByID(long id) {
        Reiziger foundReiziger = null;
        for (Reiziger reiziger: this.reizigers)
        {
            if(reiziger.getReizigerID() == id)
            {
                foundReiziger = reiziger;
            }
        }
        return foundReiziger;
    }

    @Override
    public Reiziger save(Reiziger reiziger) {
        reizigers.add(reiziger);
        return reiziger;
    }

    //update is object reference bound for now, as the P1 exercise tells us no DB connection is needed yet.
    @Override
    public Reiziger update(Reiziger reiziger)
    {
        for (Reiziger opgeslagenReiziger : this.reizigers)
        {
            if(opgeslagenReiziger.equals(reiziger))
            {
                opgeslagenReiziger.setReizigerID(reiziger.getReizigerID());
                opgeslagenReiziger.setGeboortedatum(reiziger.getGeboortedatum());
                opgeslagenReiziger.setVoornaam(reiziger.getVoornaam());
                opgeslagenReiziger.setTussenvoegsel(reiziger.getTussenvoegsel());
                opgeslagenReiziger.setAchternaam(reiziger.getAchternaam());
                return opgeslagenReiziger;
            }
        }

        //if no match found to update, null should be returned....
        return null;
    }

    @Override
    public boolean delete(Reiziger reiziger) {
        return this.reizigers.remove(reiziger);
    }
}
