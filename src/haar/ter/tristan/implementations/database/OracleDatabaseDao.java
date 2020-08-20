package haar.ter.tristan.implementations.database;

import haar.ter.tristan.interfaces.database.DatabaseDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDatabaseDao implements DatabaseDao
{

    private final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
    private final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    private final String DB_USER = "DATAPROCESSING";
    private final String DB_PASS = "123456789";
    private Connection conn;

    @Override
    public Connection getConnection() throws SQLException
    {
        //Besluit welke driver je gaat gebruiken voor je verbinding
        try {
            Class.forName(DB_DRIV).newInstance();
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        // Leg de connectie met de database
        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

        return conn;
    }

    @Override
    public void closeConnection() {
        try{
            conn.close();
        }
        catch (SQLException ex)
        {
            //connection was already closed probably, ignoring this for now...
        }
    }
}
