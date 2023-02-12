package adin.rama.form.login.db_connection;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPoolTest {
    
    void testUtil() {
        try {
            Connection connection = ConnectionUtil.getDataSource().getConnection();
            connection.close(); // mengembalikan koneksi ke HikariCP (pool)
            ConnectionUtil.getDataSource().close(); // menutup koneksi pada HikariCP (pool)
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
