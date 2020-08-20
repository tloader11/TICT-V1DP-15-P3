package haar.ter.tristan.tests;

import haar.ter.tristan.implementations.OV_ChipkaartOracleDaoImpl;
import haar.ter.tristan.interfaces.OV_ChipkaartDao;
import haar.ter.tristan.interfaces.DaoTest;
import haar.ter.tristan.models.OV_Chipkaart;

import java.sql.Date;

public class OV_ChipkaartDaoTest implements DaoTest
{
    public void doTest()
    {
        OV_ChipkaartDao ov_chipkaartDAO = new OV_ChipkaartOracleDaoImpl();

        OV_Chipkaart ov_chipkaart = new OV_Chipkaart();
        ov_chipkaart.setKaartNummer(1);
        ov_chipkaart.setSaldo(999.98f);
        ov_chipkaart.setKlasse((short)2);
        ov_chipkaart.setGeldigTot(Date.valueOf("2020-08-31"));
        ov_chipkaart.setReizigerID(1);

        System.out.println("CREATE TEST");
        //save
        ov_chipkaartDAO.save(ov_chipkaart);
        for(OV_Chipkaart opgehaaldOV_Chipkaart : ov_chipkaartDAO.findAll())
        {
            System.out.println(opgehaaldOV_Chipkaart.getKaartNummer() + " - " + opgehaaldOV_Chipkaart.getGeldigTot().toString());
        }

        System.out.println("UPDATE TEST");
        //update
        ov_chipkaart.setGeldigTot(Date.valueOf("2021-01-01"));
        ov_chipkaartDAO.update(ov_chipkaart);
        for(OV_Chipkaart opgehaaldOV_Chipkaart : ov_chipkaartDAO.findAll())
        {
            System.out.println(opgehaaldOV_Chipkaart.getKaartNummer() + " - " + opgehaaldOV_Chipkaart.getGeldigTot().toString());
        }

        System.out.println("DELETE TEST");
        //delete
        ov_chipkaartDAO.delete(ov_chipkaart);
        for(OV_Chipkaart opgehaaldOV_Chipkaart : ov_chipkaartDAO.findAll())
        {
            System.out.println("THIS SHOULD NOT RETURN: " + opgehaaldOV_Chipkaart.getKaartNummer() + " - " + opgehaaldOV_Chipkaart.getGeldigTot().toString());
        }
        if(ov_chipkaartDAO.findAll().size() == 0)
        {
            System.out.println("No items found anymore, remove was successful.");
        }
    }
}
