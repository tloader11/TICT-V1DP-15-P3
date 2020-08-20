package haar.ter.tristan.interfaces;

import haar.ter.tristan.models.Adres;

import java.util.List;

public interface AdresDao
{
    List<Adres> findAll();

    List<Adres> findByReizigerID(long id);

    Adres findByID(long id);

    Adres save(Adres adres);

    Adres update(Adres adres);

    boolean delete(Adres adres);
}
