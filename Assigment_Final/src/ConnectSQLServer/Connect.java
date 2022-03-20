/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectSQLServer;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class Connect {

   public static SQLServerDataSource data;
   public static Connection con;

    public static void Connect() throws SQLServerException, SQLException {

        data = new SQLServerDataSource();
        data.setUser("root2");
        data.setPassword("123");
        data.setPortNumber(1433);
        data.setDatabaseName("Edusys");
        data.setServerName("localhost");
        con = data.getConnection();
        
    }
   

}
