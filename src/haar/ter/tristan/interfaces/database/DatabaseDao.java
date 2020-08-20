package haar.ter.tristan.interfaces.database;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseDao
{
    Connection getConnection() throws SQLException; //model shows this as PROTECTED, which is most definitely impossible.
    void closeConnection();
}
