package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import model.Roba;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Zadatak4BrisanjeVrednosti {
    private static Dao<Roba,Integer> robaDao;

    public static void main(String[] args) {

        try(ConnectionSource conn=new JdbcConnectionSource(Konstante.BAZA_URL)){
    //Izlistavanje tabele roba pre izmena
            robaDao= DaoManager.createDao(conn, Roba.class);
            List<Roba> robaList=robaDao.queryForAll();
            System.out.println("------------Izlistavanje pre izmene");
            for(Roba r:robaList){
                System.out.println(r);
            }

            QueryBuilder<Roba, Integer> robaQuery=robaDao.queryBuilder();
            robaQuery.where().like(Roba.POLJE_NAZIV,"Voda");
            PreparedQuery<Roba> robaPreparedQuery=robaQuery.prepare();

            List<Roba> listaRobeZaIzmenu=robaDao.query(robaPreparedQuery);

            for(Roba r:listaRobeZaIzmenu){
                robaDao.delete(r);

            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }

