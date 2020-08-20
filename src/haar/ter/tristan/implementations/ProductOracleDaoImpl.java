package haar.ter.tristan.implementations;

import haar.ter.tristan.interfaces.ProductDao;
import haar.ter.tristan.interfaces.ProductDao;
import haar.ter.tristan.models.Product;
import haar.ter.tristan.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductOracleDaoImpl implements ProductDao
{
    List<Product> producten = new ArrayList<>();

    @Override
    public List<Product> findAll() {
        return this.producten;
    }

    @Override
    public Product findByNummer(long nummer) {
        Product foundProduct = null;
        for (Product product: this.producten)
        {
            if(product.getProductNummer() == nummer)
            {
                foundProduct = product;
            }
        }
        return foundProduct;
    }

    @Override
    public Product save(Product product) {
        producten.add(product);
        return product;
    }

    @Override
    public Product update(Product product) {
        for (Product opgeslagenProduct : this.producten)
        {
            if(opgeslagenProduct.equals(product))
            {
                opgeslagenProduct.setProductNaam(product.getProductNaam());
                opgeslagenProduct.setProductNummer(product.getProductNummer());
                opgeslagenProduct.setBeschrijving(product.getBeschrijving());
                opgeslagenProduct.setPrijs(product.getPrijs());
                return opgeslagenProduct;
            }
        }
        return null;
    }

    @Override
    public boolean delete(Product product) {
        return this.producten.remove(product);
    }
}
