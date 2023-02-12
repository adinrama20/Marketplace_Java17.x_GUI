package adin.rama.form.login.db_connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementTest {

    private static Connection connection() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        return connection;
    }

    private static Statement statement() throws SQLException {
        Statement statement = connection().createStatement();
        return statement;
    }

    public static boolean testExecuteUpdate(String a) {
        try {
            connection();
            statement();

            String sql = "INSERT INTO anggota(nama) VALUES('" +a+ "')";
            int update = statement().executeUpdate(sql);
            System.out.println(update);

            statement().close();
            connection().close();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean testExecuteQuery(String a, String b) {
        try {
            String cekNama = null;
            String cekId = null;

            connection();
            statement();

            String sql = "SELECT * FROM anggota WHERE nama='" +a+ "' AND id='" +b+ "'";
            ResultSet resultSet = statement().executeQuery(sql);
            
            while(resultSet.next()) {
                cekNama = resultSet.getString("nama");
                cekId = resultSet.getString("id");
            }

            resultSet.close();
            statement().close();
            connection().close();

            if (cekNama==null && cekId==null) {
                return false;
            }
            else {
                return true;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String testExecuteQueryId(String a) {
        try {
            connection();
            statement();

            String sql = "SELECT * FROM anggota WHERE nama='" +a+ "'";
            ResultSet resultSet = statement().executeQuery(sql);
            
            while(resultSet.next()) {
                if (resultSet.getString("nama").equals(a)) {
                    return resultSet.getString("id");
                }
            }
            
            statement().close();
            connection().close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
