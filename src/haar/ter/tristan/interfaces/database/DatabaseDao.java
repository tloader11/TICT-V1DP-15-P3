package haar.ter.tristan.interfaces.database;

public interface DatabaseDao
{
    Object getConnection(); //model shows this as PROTECTED, which is most definitely impossible.
    void closeConnection();
}
