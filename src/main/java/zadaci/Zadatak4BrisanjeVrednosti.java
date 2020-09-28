package zadaci;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.io.IOException;
import java.sql.SQLException;

public class Zadatak4BrisanjeVrednosti {
    public static void main(String[] args) {

        try(ConnectionSource conn=new JdbcConnectionSource(Konstante.BAZA_URL)){




        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }

