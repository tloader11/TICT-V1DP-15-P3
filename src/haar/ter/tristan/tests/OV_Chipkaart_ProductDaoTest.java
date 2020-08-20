package haar.ter.tristan.tests;

import haar.ter.tristan.implementations.OV_Chipkaart_ProductOracleDaoImpl;
import haar.ter.tristan.interfaces.DaoTest;
import haar.ter.tristan.interfaces.OV_Chipkaart_ProductDao;
import haar.ter.tristan.models.OV_Chipkaart_Product;

import java.sql.Date;

public class OV_Chipkaart_ProductDaoTest implements DaoTest
{
    public void doTest()
    {
        OV_Chipkaart_ProductDao ov_chipkaart_productDAO = new OV_Chipkaart_ProductOracleDaoImpl();

        OV_Chipkaart_Product ov_chipkaart_product = new OV_Chipkaart_Product();
        ov_chipkaart_product.setKaartNummer(1);
        ov_chipkaart_product.setProductNummer(1);
        ov_chipkaart_product.setReisproductStatus("actief");
        ov_chipkaart_product.setOvproductID(1);
        ov_chipkaart_product.setLastUpdate(Date.valueOf("2020-08-20"));

        System.out.println("CREATE TEST");
        //save
        ov_chipkaart_productDAO.save(ov_chipkaart_product);
        for(OV_Chipkaart_Product opgehaaldOV_Chipkaart_Product : ov_chipkaart_productDAO.findAll())
        {
            System.out.println(opgehaaldOV_Chipkaart_Product.getKaartNummer() + " - " + opgehaaldOV_Chipkaart_Product.getReisproductStatus());
        }

        System.out.println("UPDATE TEST");
        //update
        ov_chipkaart_product.setReisproductStatus("inactief");
        ov_chipkaart_productDAO.update(ov_chipkaart_product);

        for(OV_Chipkaart_Product opgehaaldOV_Chipkaart_Product : ov_chipkaart_productDAO.findAll())
        {
            System.out.println(opgehaaldOV_Chipkaart_Product.getKaartNummer() + " - " + opgehaaldOV_Chipkaart_Product.getReisproductStatus());
        }

        System.out.println("DELETE TEST");
        //delete
        ov_chipkaart_productDAO.delete(ov_chipkaart_product);
        for(OV_Chipkaart_Product opgehaaldOV_Chipkaart_Product : ov_chipkaart_productDAO.findAll())
        {
            System.out.println("THIS SHOULD NOT RETURN: " + opgehaaldOV_Chipkaart_Product.getKaartNummer() + " - " + opgehaaldOV_Chipkaart_Product.getReisproductStatus());
        }
        if(ov_chipkaart_productDAO.findAll().size() == 0)
        {
            System.out.println("No items found anymore, remove was successful.");
        }
    }
}
