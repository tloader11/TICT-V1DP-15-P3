package haar.ter.tristan;

import haar.ter.tristan.implementations.*;
import haar.ter.tristan.implementations.database.OracleDatabaseDao;
import haar.ter.tristan.interfaces.*;
import haar.ter.tristan.interfaces.database.DatabaseDao;
import haar.ter.tristan.models.OV_Chipkaart;

public class DatabaseConfig
{
    public static DatabaseDao databaseDao = new OracleDatabaseDao();
    public static AdresDao adresDao = new AdresOracleDaoImpl();
    public static OV_ChipkaartDao ov_chipkaartDao = new OV_ChipkaartOracleDaoImpl();
    public static OV_Chipkaart_ProductDao ov_chipkaart_productDao = new OV_Chipkaart_ProductOracleDaoImpl();
    public static ProductDao productDao = new ProductOracleDaoImpl();
    public static ReizigerDao reizigerDao = new ReizigerOracleDaoImpl();

}
