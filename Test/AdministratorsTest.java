import Database.DataBaseConnection;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AdministratorsTest {
    DataBaseConnection dataBaseConnection=new DataBaseConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "w860314m");

    @Test
    void addAdminExist() throws SQLException {
        Administrators administrators=new Administrators(dataBaseConnection);
        int n = administrators.getAdministrators().size();
        administrators.addAdmin(new Administrator(2, "anaza", "123456"));
        int m = administrators.getAdministrators().size();
        assertEquals(n,m);
    }

    @Test
    void addAdminNotExist() throws SQLException {
        Administrators administrators=new Administrators(dataBaseConnection);
        int n = administrators.getAdministrators().size();
        administrators.addAdmin(new Administrator(1000, "anaza", "123456"));
        int m = administrators.getAdministrators().size();
        assertEquals(n+1,m);
    }


    @Test
    void adminSQLINSERT() throws SQLException{
        Administrators administrators=new Administrators(dataBaseConnection);
        int n = administrators.getAdministrators().size();
        //System.out.println(n);
        int m= administrators.adminSQLINSERT(new Administrator(1000, "Alexandra", "123456")).size();
        assertEquals(n+1,m);
        administrators.adminSQLDel(new Administrator(1000, "Alexandra", "123456"));
    }
    @Test
    void adminSQLDel() throws SQLException{{
        Administrators administrators= new Administrators(dataBaseConnection);
        int n = administrators.getAdministrators().size();
        //System.out.println(n);
        administrators.adminSQLINSERT(new Administrator(1000, "Alexandra", "123456"));
        administrators.adminSQLDel(new Administrator(1000, "Alexandra", "123456"));
        int m=administrators.getAdministrators().size();
        assertEquals(n,m);
    }}


    @Test
    void isExist() throws SQLException {
        Administrators administrators= new Administrators(dataBaseConnection);
        Boolean result=administrators.isExist(6);
        assertTrue(result);
    }

    @Test
    void isNotExist() throws SQLException {
        Administrators administrators= new Administrators(dataBaseConnection);
        Boolean result=administrators.isExist(100);
        assertFalse(result);
    }

    @Test
    void login() throws SQLException {
        Administrators administrators= new Administrators(dataBaseConnection);
        Boolean result=administrators.Login("minwuh081", "123456");
        assertTrue(result);
    }

    @Test
    void Notlogin() throws SQLException {
        Administrators administrators= new Administrators(dataBaseConnection);
        Boolean result=administrators.Login("Goteborg", "123456");
        assertFalse(result);
    }
}