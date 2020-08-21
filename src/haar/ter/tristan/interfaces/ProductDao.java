package haar.ter.tristan.interfaces;

import haar.ter.tristan.Main;
import haar.ter.tristan.models.OV_Chipkaart;
import haar.ter.tristan.models.Product;

import java.sql.Connection;
import java.util.List;

public interface ProductDao
{
    static Connection connection = Main.connection;

    List<Product> findAll();

    Product findByNummer(long nummer);

    Product save(Product product);

    Product update(Product product);

    boolean delete(long productID);

    List<OV_Chipkaart> getOV_ChipkaartenForProducts(Product product);

}
