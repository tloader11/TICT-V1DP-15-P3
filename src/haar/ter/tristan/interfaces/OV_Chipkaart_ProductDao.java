package haar.ter.tristan.interfaces;

import haar.ter.tristan.models.OV_Chipkaart;
import haar.ter.tristan.models.OV_Chipkaart_Product;

import java.util.List;

public interface OV_Chipkaart_ProductDao
{
    List<OV_Chipkaart_Product> findAll();

    List<OV_Chipkaart_Product> findByKaartnummer(long nummer);
    List<OV_Chipkaart_Product> findByProductnummer(long nummer);

    OV_Chipkaart_Product findByID(long id);

    OV_Chipkaart_Product save(OV_Chipkaart_Product ov_chipkaart_product);

    OV_Chipkaart_Product update(OV_Chipkaart_Product ov_chipkaart_product);

    boolean delete(OV_Chipkaart_Product ov_chipkaart_product);
}
