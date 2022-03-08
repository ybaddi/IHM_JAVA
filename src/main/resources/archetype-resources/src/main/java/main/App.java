package main.java.main;

import java.sql.Connection;
import main.java.config.MyConnection;
import main.java.dao.UserDaoImpl;
import main.java.gui.*;

import java.util.List;
import main.java.models.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Connection connexion = MyConnection.getConnexion();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        List<User> users = userDaoImpl.getAll();
        
        users.forEach(System.out::println);
        
        
        // main frame
        ConnexionFrame cnf = new ConnexionFrame();
        
        // Calculette
//        Calculette calculette = new Calculette();
        
        
    }
}
