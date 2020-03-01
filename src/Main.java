import Database.DataBaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private Scanner scanner;
    private boolean control = true;
    private DataBaseConnection dataBaseConnection;

    public Main(Scanner scanner) {
        this.scanner = scanner;
        this.dataBaseConnection = new DataBaseConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "w860314m");
    }


    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main(scanner);
        while (main.getControl()) {
            System.out.println("Administrator Press 1\nUser Press 2\nExit Press 3");
            String choice = main.getString();
            switch (choice) {
                case ("1"):
                    int n=0;
                    while(n<3) {
                        Administrators administrators = new Administrators(main.dataBaseConnection);
                        System.out.println("To login ... ");
                        System.out.println("Enter your username:");
                        String username = main.getString();
                        System.out.println("Enter your password");
                        String password = main.getString();
                        if (administrators.Login(username, password)) {
                            System.out.println("You have logined");
                            System.out.println("Add Artist Press 1\nManage Concert Press 2\nAdd more admin Press 3\nBack Press 4\n");
                            choice = main.getString();
                            switch (choice) {
                                case ("1"):


                                    break;
                                case ("2"):
                                    break;
                                case ("3"):
                                    while (true) {
                                        System.out.println(administrators);
                                        System.out.println("Enter a new AdminID: ");
                                        int adminID = Integer.parseInt(main.getString());
                                        if (administrators.isExist(adminID)) {
                                            System.out.println("The adID " + adminID + " Exist already!!");
                                            continue;
                                        } else {
                                            System.out.println("Enter name: ");
                                            String name = main.getString();
                                            System.out.println("Password: ");
                                            password = main.getString();
                                            administrators.adminSQLINSERT(new Administrator(adminID, name, password));
                                            break;
                                        }
                                    }
                                    break;
                                case ("4"):
                                    System.out.println("Back!");
                                    break;
                                default:
                                    System.out.println("invalid input");
                                    break;
                            }
                            break;
                        } else {
                            System.out.println("wrong username or password " + n + " times");
                            n+=1;
                            continue;
                        }
                    }

                    break;
                case ("2"):
                    break;
                case ("3"):
                    System.out.println("Exist");
                    main.setControl(false);
                    break;
                default:
                    System.out.println("invalid input!!");
                    break;

            }
        }

    }

    public String getString() {
        return scanner.nextLine();
    }

    public Boolean getControl() {
        return control;
    }

    public void setControl(boolean control) {
        this.control = control;
    }


}
