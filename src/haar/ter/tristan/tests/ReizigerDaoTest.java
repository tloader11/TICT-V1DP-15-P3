package haar.ter.tristan.tests;

import haar.ter.tristan.implementations.ReizigerOracleDaoImpl;
import haar.ter.tristan.interfaces.DaoTest;
import haar.ter.tristan.interfaces.ReizigerDao;
import haar.ter.tristan.models.Reiziger;

import java.sql.Date;

public class ReizigerDaoTest implements DaoTest
{
    public void doTest()
    {
        ReizigerDao reizigerDAO = new ReizigerOracleDaoImpl();

        Reiziger reiziger = new Reiziger();
        reiziger.setVoornaam("Tristan");
        reiziger.setTussenvoegsel("ter");
        reiziger.setAchternaam("Haar");
        Date gbDatum = Date.valueOf("1998-04-15");
        reiziger.setGeboortedatum(gbDatum);

        System.out.println("CREATE TEST");
        //save
        reizigerDAO.save(reiziger);
        for(Reiziger opgehaaldeReiziger : reizigerDAO.findAll())
        {
            System.out.println(opgehaaldeReiziger.getName() + " - " + opgehaaldeReiziger.getGeboortedatum().toString());
        }

        System.out.println("UPDATE TEST");
        //update
        gbDatum = Date.valueOf("2000-04-15");
        reiziger.setGeboortedatum(gbDatum);
        reizigerDAO.update(reiziger);
        for(Reiziger opgehaaldeReiziger : reizigerDAO.findAll())
        {
            System.out.println(opgehaaldeReiziger.getName() + " - " + opgehaaldeReiziger.getGeboortedatum().toString());
        }

        System.out.println("DELETE TEST");
        //delete
        reizigerDAO.delete(reiziger);
        for(Reiziger opgehaaldeReiziger : reizigerDAO.findAll())
        {
            System.out.println("THIS SHOULD NOT RETURN: " + opgehaaldeReiziger.getName() + " - " + opgehaaldeReiziger.getGeboortedatum().toString());
        }
        if(reizigerDAO.findAll().size() == 0)
        {
            System.out.println("No items found anymore, remove was successful.");
        }
    }
}
