package haar.ter.tristan.tests;

import haar.ter.tristan.implementations.ProductOracleDaoImpl;
import haar.ter.tristan.implementations.ProductOracleDaoImpl;
import haar.ter.tristan.interfaces.DaoTest;
import haar.ter.tristan.interfaces.ProductDao;
import haar.ter.tristan.models.Product;
import haar.ter.tristan.models.Product;

import java.sql.Date;

public class ProductDaoTest implements DaoTest
{
    public void doTest()
    {
        ProductDao productDAO = new ProductOracleDaoImpl();

        Product product = new Product();
        product.setProductNaam("Test Product");
        product.setBeschrijving("Een mooi product om wat DAO tests mee te doen....");
        product.setProductNummer(1);
        product.setPrijs(1.23f);

        System.out.println("CREATE TEST");
        //save
        productDAO.save(product);
        for(Product opgehaaldProduct : productDAO.findAll())
        {
            System.out.println(opgehaaldProduct.getProductNaam() + " - " + opgehaaldProduct.getBeschrijving());
        }

        System.out.println("UPDATE TEST");
        //update
        product.setProductNaam("Nutella");
        product.setBeschrijving("Heerlijk voor op brood!");
        productDAO.update(product);
        for(Product opgehaaldProduct : productDAO.findAll())
        {
            System.out.println(opgehaaldProduct.getProductNaam() + " - " + opgehaaldProduct.getBeschrijving());
        }

        System.out.println("DELETE TEST");
        //delete
        productDAO.delete(product.getProductNummer());
        for(Product opgehaaldProduct : productDAO.findAll())
        {
            System.out.println("THIS SHOULD NOT RETURN: " + opgehaaldProduct.getProductNaam() + " - " + opgehaaldProduct.getBeschrijving());
        }
        if(productDAO.findAll().size() == 0)
        {
            System.out.println("No items found anymore, remove was successful.");
        }
    }
}
