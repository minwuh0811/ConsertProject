import Database.DataBaseConnection;

public class Administrator {
    private int adID;
    private String name;
    private String login;

    public Administrator(int adID, String name, String login) {
        this.adID = adID;
        this.name = name;
        this.login = login;
    }

    public int getAdID() {
        return adID;
    }

    public void setAdID(int adID) {
        this.adID = adID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
