package haar.ter.tristan.implementations.database;

import haar.ter.tristan.interfaces.database.DatabaseDao;

public class OracleDatabaseDao implements DatabaseDao
{
    @Override
    public Object getConnection() {
        return null;
    }

    @Override
    public void closeConnection() {

    }
}
