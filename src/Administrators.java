import Database.DataBaseConnection;

import java.sql.SQLException;
import java.util.ArrayList;

public class Administrators {
    private ArrayList<Administrator> administrators;
    private adminData adminData=new adminData();

    public Administrators(DataBaseConnection dataBaseConnection) throws SQLException {
        adminData.setDataBaseConnection(dataBaseConnection);
        this.administrators= adminData.load();
        //System.out.println(administrators);
    }

    public void addAdmin(Administrator administrator) throws SQLException{
        for(Administrator administrator1: administrators){
            if(administrator1.getAdID()==administrator.getAdID()){
                return;
            }
        }
        administrators.add(administrator);
    }

    public ArrayList<Administrator> getAdministrators() {
        return administrators;
    }

    public void setAdministrators(ArrayList<Administrator> administrators) {
        this.administrators = administrators;
    }

    public ArrayList<Administrator> adminSQLINSERT(Administrator administrator) throws SQLException{
        adminData.setAdministrator(administrator);
        return adminData.insert();
    }

    public ArrayList<Administrator> adminSQLDel(Administrator administrator) throws SQLException{
       adminData.setAdministrator(administrator);
       return adminData.delete();
    }


    public Boolean isExist(int adin){
        adminData.setAdministrators(administrators);
        return adminData.isExist(adin);
    }

    public Boolean Login(String name, String login){
        for (Administrator administrator: administrators){
            if (administrator.getName().equals(name) && administrator.getLogin().equals(login)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String output="";
        for (Administrator administrator: administrators){
            output += "AdminID: "+ administrator.getAdID() + " name: " + administrator.getName() + " login: " + administrator.getLogin() + " \n";
        }
        return output;
    }


}
