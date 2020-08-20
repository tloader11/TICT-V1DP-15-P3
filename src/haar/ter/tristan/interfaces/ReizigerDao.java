package haar.ter.tristan.interfaces;

import haar.ter.tristan.Main;
import haar.ter.tristan.models.Reiziger;

import java.sql.Connection;
import java.util.List;

public interface ReizigerDao
{
    static Connection connection = Main.connection;
    List<Reiziger> findAll();

    List<Reiziger> findByGeboortedatum(String GBdatum);

    Reiziger findByID(long id);

    Reiziger save(Reiziger reiziger);

    Reiziger update(Reiziger reiziger);

    boolean delete(long reizigerID);

}
