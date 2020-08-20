package haar.ter.tristan.interfaces;

import haar.ter.tristan.models.Product;

import java.util.List;

public interface ProductDao
{
    List<Product> findAll();

    Product findByNummer(long nummer);

    Product save(Product product);

    Product update(Product product);

    boolean delete(Product product);
}
