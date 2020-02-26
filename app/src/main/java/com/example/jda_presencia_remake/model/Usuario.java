package com.example.jda_presencia_remake.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Usuario {
    private String user, password, token;
    private String[] settings;

    public Usuario(String user, String password) {
        this.user = user;
        this.password = password;
        //Tries to stablish a connection
        letMeIn();
    }

    private void letMeIn(){
        //TODO: Finish letMeIn(). Login method
        //Stablishes a connection with the login data.
        sqlThread.start();
    }

    private void stablishSecureConnection(){
        //TODO: Once there's time, upgrade to SSL sockets. Resources below

        //-SSL Connection
        //https://www.baeldung.com/java-ssl

        //-Storing passwords securely in an sql server
        //https://www.mssqltips.com/sqlservertip/4037/storing-passwords-in-a-secure-way-in-a-sql-server-database/
    }

    public String[] getSettings(){ //MIGHT NOT GET USED
        //Uses the sql connection to ask for the user's settings/preferences.
        return null;
    }

    Thread sqlThread = new Thread() {
        public void run() {
            try {
                Class.forName("org.postgresql.Driver");
                // "jdbc:postgresql://IP:PUERTO/DB", "USER", "PASSWORD");
                // NOTA: No utilizar 127.0.0.1 o localhost como IP, utilizar 10.0.2.2
                Connection conn = DriverManager.getConnection(
                        "jdbc:postgresql://95.23.236.150:5432/test_server", "test", "test");

                //Crear el statement necesario a partir de una string del comando SQL a ejecutar
                String stsql = "Select version()";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(stsql);
                rs.next();
                System.out.println( rs.getString(1) );
                conn.close();
            } catch (SQLException se) {
                System.out.println("No se puede conectar.\nError: " + se.toString());
            } catch (ClassNotFoundException e) {
                System.out.println("No se encuentra la clase.\nError: " + e.getMessage());
            }
        }
    };


}
