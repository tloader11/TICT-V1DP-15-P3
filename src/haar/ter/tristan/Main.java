package haar.ter.tristan;

import haar.ter.tristan.implementations.ReizigerOracleDaoImpl;
import haar.ter.tristan.interfaces.DaoTest;
import haar.ter.tristan.interfaces.ReizigerDao;
import haar.ter.tristan.models.Reiziger;
import haar.ter.tristan.tests.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("---==== STARTING REIZIGER DAO TEST ====---");
        DaoTest reizigerDaoTest = new ReizigerDaoTest();
        reizigerDaoTest.doTest();

        System.out.println("---==== STARTING ADRES DAO TEST ====---");
        DaoTest adresDaoTest = new AdresDaoTest();
        adresDaoTest.doTest();

        System.out.println("---==== STARTING PRODUCT DAO TEST ====---");
        DaoTest productDoaTest = new ProductDaoTest();
        productDoaTest.doTest();

        System.out.println("---==== STARTING OV_CHIPKAART DAO TEST ====---");
        DaoTest ov_chipkaartDoaTest = new OV_ChipkaartDaoTest();
        ov_chipkaartDoaTest.doTest();

        System.out.println("---==== STARTING OV_CHIPKAART_PRODUCT DAO TEST ====---");
        DaoTest ov_chipkaart_productDoaTest = new OV_Chipkaart_ProductDaoTest();
        ov_chipkaart_productDoaTest.doTest();

    }
}
