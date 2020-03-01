
public class Artist {
    private int artistID;
    private String firstname;
    private String lastname;
    private int popularity;

    public Artist(int artistID,String firstname,String lastname,int popularity){
        this.artistID=artistID;
        this.firstname=firstname;
        this.lastname=lastname;
        this.popularity=popularity;
    }

    public int getArtistID() {
        return artistID;
    }

    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }



}
