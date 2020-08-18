package com.android.oracle.android.regster.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static android.provider.Telephony.Carriers.PASSWORD;
import static com.android.oracle.android.regster.app.Config.CONNECTION_URL;
import static com.android.oracle.android.regster.app.Config.DRIVER;
import static com.android.oracle.android.regster.app.Config.USERNAME;

public class ConnectionProvider {
    private static Connection con;

    private ConnectionProvider(){
        
    }

    public static Connection getConnection() throws ClassNotFoundException
    {
        if(con==null)
        {
            try {
                Class.forName(DRIVER);
                con= DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD);
            } catch (SQLException e) {

                e.printStackTrace();
            }

        }
        return con;
    }
}


