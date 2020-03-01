import Database.DataBaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class artistData implements SQLData {
    private Artist artist;
    private ArrayList<Artist> artists=new ArrayList<>();
    private DataBaseConnection dataBaseConnection;

    public artistData(){

    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setArtists(ArrayList<Artist> artists) {
        this.artists = artists;
    }

    public void setDataBaseConnection(DataBaseConnection dataBaseConnection) {
        this.dataBaseConnection = dataBaseConnection;
    }

    public artistData(DataBaseConnection dataBaseConnection){
        this.dataBaseConnection=dataBaseConnection;
    }

    public ArrayList<Artist> load() throws SQLException{
        ArrayList<Artist> artistsNew=new ArrayList<>();
        ResultSet resultSet=dataBaseConnection.getSt().executeQuery("SELECT * FROM min.artist");
        while (resultSet.next()) {
            //System.out.println(resultSet.getInt(1));
            Artist artist = new Artist(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
            artistsNew.add(artist);
        }
        return artistsNew;


    }
    public ArrayList<Artist> insert() throws  SQLException{
        String sql="INSERT INTO min.artist (artistid, firstname, lastname, popularity)  VALUES(" + artist.getArtistID()+", \'" + artist.getFirstname()+"\', \'" + artist.getLastname()+"\', " + artist.getPopularity()+ ")";
        System.out.println(sql);
        dataBaseConnection.getSt().executeUpdate(sql);
        return load();
    }
    public ArrayList<Artist> delete() throws  SQLException {
        String sql="DELETE FROM min.artist" + " WHERE artistid=" + artist.getArtistID();
        // System.out.println(sql);
        dataBaseConnection.getSt().executeUpdate(sql);
        return load();
    }

    public Boolean isExist(int adin){
        for (Artist art: this.artists){
            if (art.getArtistID()==adin){
                return true;
            }
        }
        return false;
    }
}
