import Database.DataBaseConnection;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;


import static org.junit.jupiter.api.Assertions.*;


class adminDataTest {
    DataBaseConnection dataBaseConnection=new DataBaseConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "w860314m");

    @Test
    void load() throws SQLException {
        Administrators administrators=new Administrators(dataBaseConnection);
        administrators.getAdministrators();
        int m=administrators.getAdministrators().size();
        assertEquals(9,m);
    }





}