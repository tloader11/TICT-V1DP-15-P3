package haar.ter.tristan.interfaces;

import haar.ter.tristan.models.Reiziger;

import java.util.List;

public interface ReizigerDao
{
    List<Reiziger> findAll();

    List<Reiziger> findByGeboortedatum(String GBdatum);

    Reiziger findByID(long id);

    Reiziger save(Reiziger reiziger);

    Reiziger update(Reiziger reiziger);

    boolean delete(Reiziger reiziger);

}
