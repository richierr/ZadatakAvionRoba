package zadaci;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Avion;
import model.Roba;

import java.io.IOException;
import java.sql.SQLException;

public class Zadatak1KreiranjeTabela {
    public static void main(String[] args) {
        try(ConnectionSource conn=new JdbcConnectionSource(Konstante.BAZA_URL)){
            TableUtils.dropTable(conn, Roba.class,true);
            TableUtils.dropTable(conn, Avion.class,true);

            TableUtils.createTable(conn,Avion.class);
            TableUtils.createTable(conn,Roba.class);



    } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
