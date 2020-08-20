package haar.ter.tristan.interfaces;

import haar.ter.tristan.Main;
import haar.ter.tristan.models.Adres;

import java.sql.Connection;
import java.util.List;

public interface AdresDao
{
    static Connection connection = Main.connection;

    List<Adres> findAll();

    List<Adres> findByReizigerID(long id);

    Adres findByID(long id);

    Adres save(Adres adres);

    Adres update(Adres adres);

    boolean delete(long adresID);
}
