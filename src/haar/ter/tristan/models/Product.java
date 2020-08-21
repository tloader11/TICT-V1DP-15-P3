package haar.ter.tristan.models;

import haar.ter.tristan.DatabaseConfig;

import java.util.ArrayList;
import java.util.List;

public class Product
{
    private long productNummer;
    private String productNaam;
    private String beschrijving;
    private float prijs;        //double or decimal do not seem that important for this setup.
    private List<OV_Chipkaart_Product> ov_chipkaart_products;
    private List<OV_Chipkaart> ov_chipkaarten;

    public Product()
    {
    }

    public Product(long productNummer, String productNaam, String beschrijving, float prijs) {
        this.productNummer = productNummer;
        this.productNaam = productNaam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
    }

    public long getProductNummer() {
        return productNummer;
    }

    public void setProductNummer(long productNummer) {
        this.productNummer = productNummer;
    }

    public String getProductNaam() {
        return productNaam;
    }

    public void setProductNaam(String productNaam) {
        this.productNaam = productNaam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public float getPrijs() {
        return prijs;
    }

    public void setPrijs(float prijs) {
        this.prijs = prijs;
    }

    public List<OV_Chipkaart_Product> getOV_Chipkaart_producten()  //lazy loading instead of eager...., no loop problems..
    {
        if(this.ov_chipkaart_products == null)   //local memory caching :-)
        {
            this.ov_chipkaart_products = DatabaseConfig.ov_chipkaart_productDao.findByProductnummer(this.getProductNummer());
        }
        return this.ov_chipkaart_products;
    }

    //if eager loading is a must:
    //just eager load it with one constructor (the one with all params pasted in) and allow free-fill with the other constructor.
    //this will prevent a loop in case you get the OV-chipkaart via this function.
    public List<OV_Chipkaart> getOV_Chipkaarten() //lazy loading instead of eager...., no loop problems..
    {
        if(this.ov_chipkaarten == null)   //local memory caching :-)
        {
            List<OV_Chipkaart> ov_chipkaarten = new ArrayList<>();
            this.getOV_Chipkaart_producten();    //make sure the relation is init'ed.
            for(OV_Chipkaart_Product ov_chipkaart_product : this.getOV_Chipkaart_producten())
            {
                ov_chipkaarten.add(ov_chipkaart_product.getOV_Chipkaart());
            }
            this.ov_chipkaarten = ov_chipkaarten;
        }
        return this.ov_chipkaarten;
    }

}
