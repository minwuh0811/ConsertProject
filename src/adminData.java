import Database.DataBaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class adminData implements SQLData {
    private Administrator administrator;
    private ArrayList<Administrator> administrators=new ArrayList<>();
    private DataBaseConnection dataBaseConnection;

    public adminData( DataBaseConnection dataBaseConnection){
        this.dataBaseConnection= dataBaseConnection;

    }

    public adminData(){}

    public void setAdministrators(ArrayList<Administrator> administrators) {
        this.administrators = administrators;
    }

    public ArrayList<Administrator> load() throws SQLException {
        ArrayList<Administrator> administratorsNew=new ArrayList<>();
        ResultSet resultSet=dataBaseConnection.getSt().executeQuery("SELECT * FROM min.admin");
        while (resultSet.next()) {
            //System.out.println(resultSet.getInt(1));
            Administrator administrator = new Administrator(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
            administratorsNew.add(administrator);
        }
        return administratorsNew;
    }

    public ArrayList<Administrator> insert() throws SQLException{
        String sql="INSERT INTO min.admin (adID, name, login)  VALUES(" + administrator.getAdID()+", \'" + administrator.getName()+"\', \'" + administrator.getLogin()+"\') ";
        System.out.println(sql);
        dataBaseConnection.getSt().executeUpdate(sql);
        return load();
    }

    public ArrayList<Administrator> delete() throws SQLException{
        String sql="DELETE FROM min.admin" + " WHERE adID=" + administrator.getAdID();
        // System.out.println(sql);
        dataBaseConnection.getSt().executeUpdate(sql);
        return load();
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public DataBaseConnection getDataBaseConnection() {
        return dataBaseConnection;
    }

    public void setDataBaseConnection(DataBaseConnection dataBaseConnection) {
        this.dataBaseConnection = dataBaseConnection;
    }

    public Boolean isExist(int adin){
        for (Administrator admin: this.administrators){
            if (admin.getAdID()==adin){
                return true;
            }
        }
        return false;
    }
}
