package haar.ter.tristan;

import haar.ter.tristan.implementations.AdresOracleDaoImpl;
import haar.ter.tristan.implementations.OV_ChipkaartOracleDaoImpl;
import haar.ter.tristan.implementations.ProductOracleDaoImpl;
import haar.ter.tristan.implementations.ReizigerOracleDaoImpl;
import haar.ter.tristan.implementations.database.OracleDatabaseDao;
import haar.ter.tristan.interfaces.*;
import haar.ter.tristan.interfaces.database.DatabaseDao;
import haar.ter.tristan.models.*;
import haar.ter.tristan.tests.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static Connection connection;

    public static void main(String[] args) {
        try {
            connection = DatabaseConfig.databaseDao.getConnection();
        } catch (SQLException ex) {
            System.out.println("ERROR STARTING DB CONNECTION. PLEASE MAKE SURE THE ORACLE DB SERVER IS RUNNING");
        }

        //clear all tables
        System.out.println("---==== CLEARING ALL TABLES ====---");
        for (OV_Chipkaart ov_chipkaart : DatabaseConfig.ov_chipkaartDao.findAll()) {
            DatabaseConfig.ov_chipkaartDao.delete(ov_chipkaart.getKaartNummer());   //OV_Chipkaart_Product is cascaded....
        }
        for (Reiziger reiziger : DatabaseConfig.reizigerDao.findAll()) {
            DatabaseConfig.reizigerDao.delete(reiziger.getReizigerID());    //adres table is cascaded as well, so no need to manually empty that one.
        }
        for (Product product : DatabaseConfig.productDao.findAll()) {
            DatabaseConfig.productDao.delete(product.getProductNummer());
        }
        System.out.println("---==== CLEARED ALL TABLES ====---");

        System.out.println("---==== FILLING TABLES ====---");

        //productNummer, String productNaam, String beschrijving, float prijs
        Product testProduct1 = new Product(1, "Studenten OV", "Gratis reizen door de weeks!", 0.0f);
        Product testProduct2 = new Product(2, "Weekend OV", "Gratis reizen in het weekend!", 0.0f);
        Product testProduct3 = new Product(3, "NS Business", "Naar je werk met de trein is prima te doen met onze business pas!", 40.5f);
        Product testProduct4 = new Product(4, "Platinum", "Inclusief alle bussen en metros in Nederland!", 89.9f);
        DatabaseConfig.productDao.save(testProduct1);
        DatabaseConfig.productDao.save(testProduct2);
        DatabaseConfig.productDao.save(testProduct3);
        DatabaseConfig.productDao.save(testProduct4);

        //reizigerID, String voorletters, String tussenvoegsel, String achternaam, Date geboortedatum
        Reiziger testReiziger1 = new Reiziger(1, "T.F.", "ter", "Haar", Date.valueOf("1998-04-15"));
        Reiziger testReiziger2 = new Reiziger(2, "T.E.S.T.", "", "Pashouder", Date.valueOf("1970-01-01"));
        DatabaseConfig.reizigerDao.save(testReiziger1);
        DatabaseConfig.reizigerDao.save(testReiziger2);

        //adresID, String postcode, String huisnummer, String straat, String woonplaats, long reizigerID
        Adres testAdres1 = new Adres(1, "2811RH", "48", "Zwanebloem", "Reeuwijk", 1);
        Adres testAdres2 = new Adres(2, "2802ER", "37", "Lazaruskade", "Gouda", 2);
        Adres testAdres3 = new Adres(3, "1000AA", "123", "Grau", "Groningen", 2);
        DatabaseConfig.adresDao.save(testAdres1);
        DatabaseConfig.adresDao.save(testAdres2);
        DatabaseConfig.adresDao.save(testAdres3);

        //kaartNummer, Date geldigTot, short klasse, float saldo, long reizigerID
        OV_Chipkaart testOV_Chipkaart1 = new OV_Chipkaart(1, Date.valueOf("2021-01-01"), (short) 1, 995f, 1);
        OV_Chipkaart testOV_Chipkaart2 = new OV_Chipkaart(2, Date.valueOf("2019-01-01"), (short) 1, 0f, 1);
        OV_Chipkaart testOV_Chipkaart3 = new OV_Chipkaart(3, Date.valueOf("2025-01-01"), (short) 1, 0f, 2);
        DatabaseConfig.ov_chipkaartDao.save(testOV_Chipkaart1);
        DatabaseConfig.ov_chipkaartDao.save(testOV_Chipkaart2);
        DatabaseConfig.ov_chipkaartDao.save(testOV_Chipkaart3);

        //ovproductID, long kaartNummer, long productNummer, String reisproductStatus, Date lastUpdate
        OV_Chipkaart_Product testOV_Chipkaart_Product1 = new OV_Chipkaart_Product(1, 1, 1, "actief", Date.valueOf("2020-08-21"));
        OV_Chipkaart_Product testOV_Chipkaart_Product2 = new OV_Chipkaart_Product(2, 1, 4, "actief", Date.valueOf("2020-08-21"));
        OV_Chipkaart_Product testOV_Chipkaart_Product3 = new OV_Chipkaart_Product(3, 2, 1, "actief", Date.valueOf("2020-08-21"));
        OV_Chipkaart_Product testOV_Chipkaart_Product4 = new OV_Chipkaart_Product(4, 3, 1, "actief", Date.valueOf("2020-08-21"));
        DatabaseConfig.ov_chipkaart_productDao.save(testOV_Chipkaart_Product1);
        DatabaseConfig.ov_chipkaart_productDao.save(testOV_Chipkaart_Product2);
        DatabaseConfig.ov_chipkaart_productDao.save(testOV_Chipkaart_Product3);
        DatabaseConfig.ov_chipkaart_productDao.save(testOV_Chipkaart_Product4);

        System.out.println("---==== DONE FILLING TABLES ====---");


        //someone scans their pass
        OV_Chipkaart kaart = DatabaseConfig.ov_chipkaartDao.findByID(1);
        System.out.println("Kaart gescanned: " + kaart.getKaartNummer() + ", " +
                "Reiziger: " + kaart.getReiziger().getName() + " " +
                "Met Producten:");
        for (OV_Chipkaart_Product ov_c_p : kaart.getOV_Chipkaart_producten())
        {
            System.out.println("\t- " + ov_c_p.getProduct().getProductNaam());
        }
        //SIMULATE OUT-OF-PRODUCT
        System.out.println("Before transaction: " + kaart.getSaldo());

        kaart.setSaldo(kaart.getSaldo() - 20.43f);      //lange rit...
        DatabaseConfig.ov_chipkaartDao.update(kaart);   //write naar OV

        //re-read chip to validate write
        kaart = DatabaseConfig.ov_chipkaartDao.findByID(kaart.getKaartNummer());

        System.out.println("After transaction: " + kaart.getSaldo());

        //Nu andersom; via bijvoorbeeld de balie:
        List<Reiziger> reizigers = DatabaseConfig.reizigerDao.findByGeboortedatum("1998-04-15");
        for(Reiziger reiziger : reizigers)
        {
            System.out.println(reiziger.getName() + " met adres(sen)");
            for(Adres adres : reiziger.getAdressen())
            {
                System.out.println(adres.getStraat() + " " + adres.getHuisnummer());
            }
        }
        //Medewerker selecteert de juiste reiziger op basis van het weergegeven adres bijvoorbeeld...
        Reiziger reiziger = reizigers.get(0);
        DatabaseConfig.adresDao.delete(reiziger.getAdressen().get(0).getAdresID()); //old address, he asked it to be removed for example...
        Adres newAdres = new Adres(4, "4321AB", "567", "NieuwStraat", "NieuwBouwPlaats", reiziger.getReizigerID());
        DatabaseConfig.adresDao.save(newAdres);

        System.out.println("After adres change: ");
        //validate adres change
        reiziger = DatabaseConfig.reizigerDao.findByID(reiziger.getReizigerID());
        for(Adres adres : reiziger.getAdressen())
        {
            System.out.println(adres.getStraat() + " " + adres.getHuisnummer());
        }

        
        //P3 addons:

        //get products for OV_Chipkaart via DAO
        OV_Chipkaart p3_ov_test = DatabaseConfig.ov_chipkaartDao.findByID(1);
        List<Product> p3_products = DatabaseConfig.ov_chipkaartDao.getProductsForOV_Chipkaart(p3_ov_test);
        for(Product product : p3_products)
        {
            System.out.println("Kaart met ID: " + p3_ov_test.getKaartNummer() + " heeft product " + product.getProductNaam());
        }
        //get products for OV_Chipkaart via Object
        p3_products = p3_ov_test.getProducten();
        for(Product product : p3_products)
        {
            System.out.println("Kaart met ID: " + p3_ov_test.getKaartNummer() + " heeft product " + product.getProductNaam());
        }



        //get OV_Chipkaarten for products via DAO
        Product p3_test = DatabaseConfig.productDao.findByNummer(1);
        List<OV_Chipkaart> p3_ov_chipkaarten = DatabaseConfig.productDao.getOV_ChipkaartenForProducts(p3_test);
        for(OV_Chipkaart ov_chipkaart: p3_ov_chipkaarten)
        {
            System.out.println("Kaart met ID: " + ov_chipkaart.getKaartNummer() + " en klasse " + ov_chipkaart.getKlasse() + " gevonden voor product " + p3_test.getProductNaam() + " !");
        }
        //get OV_Chipkaarten for product via Object
        List<OV_Chipkaart> ov_chipkaartList = p3_test.getOV_Chipkaarten();
        for(OV_Chipkaart ov_chipkaart : ov_chipkaartList)
        {
            System.out.println("Kaart met ID: " + ov_chipkaart.getKaartNummer() + " en klasse " + ov_chipkaart.getKlasse() + " gevonden voor product " + p3_test.getProductNaam() + " !");
        }


    }
}
