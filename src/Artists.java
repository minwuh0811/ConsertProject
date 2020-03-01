import Database.DataBaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Artists{
    ArrayList<Artist> artists= new ArrayList<>();
    private DataBaseConnection dataBaseConnection;
    private artistData artistData=new artistData();

    public Artists(DataBaseConnection dataBaseConnection) throws SQLException {
        this.dataBaseConnection=dataBaseConnection;
        artistData=new artistData(dataBaseConnection);
        artistData.load();
    }
    public ArrayList<Artist> addArtist(Artist artist) throws SQLException{
        for(Artist artist1: artists){
            if(artist1.getArtistID()==artist.getArtistID()){
                return artists;
            }
        }
        artists.add(artist);
        return artists;
    }

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public void setArtists(ArrayList<Artist> artists) {
        this.artists = artists;
    }

    public ArrayList<Artist> artSQLINSERT(Artist artist) throws SQLException{
          artistData.setArtist(artist);
          return artistData.insert();
    }

    public ArrayList<Artist> artSQLDel(Artist artist) throws SQLException{
        artistData.setArtist(artist);
        return artistData.delete();
    }

    public Boolean isExist(int adin){
       artistData.setArtists(artists);
       return artistData.isExist(adin);
    }

}
