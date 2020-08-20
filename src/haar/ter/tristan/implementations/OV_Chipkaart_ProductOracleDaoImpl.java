package haar.ter.tristan.implementations;

import haar.ter.tristan.interfaces.OV_ChipkaartDao;
import haar.ter.tristan.interfaces.OV_Chipkaart_ProductDao;
import haar.ter.tristan.models.OV_Chipkaart;
import haar.ter.tristan.models.OV_Chipkaart_Product;

import java.util.ArrayList;
import java.util.List;

public class OV_Chipkaart_ProductOracleDaoImpl implements OV_Chipkaart_ProductDao
{
    List<OV_Chipkaart_Product> ov_chipkaart_producten = new ArrayList<>();

    @Override
    public List<OV_Chipkaart_Product> findAll() {
        return this.ov_chipkaart_producten;
    }

    @Override
    public List<OV_Chipkaart_Product> findByKaartnummer(long nummer) {
        List<OV_Chipkaart_Product> ov_chipkaart_productenMetKaartnummer = new ArrayList<>();
        for (OV_Chipkaart_Product ov_chipkaart_product: this.ov_chipkaart_producten)
        {
            if(ov_chipkaart_product.getKaartNummer() == nummer)
            {
                ov_chipkaart_productenMetKaartnummer.add(ov_chipkaart_product);
            }
        }
        return ov_chipkaart_productenMetKaartnummer;
    }

    @Override
    public List<OV_Chipkaart_Product> findByProductnummer(long nummer) {
        List<OV_Chipkaart_Product> ov_chipkaart_productenMetKaartnummer = new ArrayList<>();
        for (OV_Chipkaart_Product ov_chipkaart_product: this.ov_chipkaart_producten)
        {
            if(ov_chipkaart_product.getProductNummer() == nummer)
            {
                ov_chipkaart_productenMetKaartnummer.add(ov_chipkaart_product);
            }
        }
        return ov_chipkaart_productenMetKaartnummer;
    }

    @Override
    public OV_Chipkaart_Product findByID(long id) {
        OV_Chipkaart_Product foundOV_Chipkaart_Product = null;
        for (OV_Chipkaart_Product ov_chipkaart_product: this.ov_chipkaart_producten)
        {
            if(ov_chipkaart_product.getKaartNummer() == id)
            {
                foundOV_Chipkaart_Product = ov_chipkaart_product;
            }
        }
        return foundOV_Chipkaart_Product;
    }

    @Override
    public OV_Chipkaart_Product save(OV_Chipkaart_Product ov_chipkaart_product) {
        ov_chipkaart_producten.add(ov_chipkaart_product);
        return ov_chipkaart_product;
    }

    @Override
    public OV_Chipkaart_Product update(OV_Chipkaart_Product ov_chipkaart_product) {
        for (OV_Chipkaart_Product opgeslagenOV_Chipkaart_Product : this.ov_chipkaart_producten)
        {
            if(opgeslagenOV_Chipkaart_Product.equals(ov_chipkaart_product))
            {
                opgeslagenOV_Chipkaart_Product.setKaartNummer(ov_chipkaart_product.getKaartNummer());
                opgeslagenOV_Chipkaart_Product.setProductNummer(ov_chipkaart_product.getProductNummer());
                opgeslagenOV_Chipkaart_Product.setLastUpdate(ov_chipkaart_product.getLastUpdate());
                opgeslagenOV_Chipkaart_Product.setOvproductID(ov_chipkaart_product.getOvproductID());
                opgeslagenOV_Chipkaart_Product.setReisproductStatus(ov_chipkaart_product.getReisproductStatus());
                return opgeslagenOV_Chipkaart_Product;
            }
        }
        return null;
    }

    @Override
    public boolean delete(OV_Chipkaart_Product ov_chipkaart_product) {
        return this.ov_chipkaart_producten.remove(ov_chipkaart_product);
    }
}
