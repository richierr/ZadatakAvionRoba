package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Avion;
import model.Roba;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Zadatak2DodavanjeVrednosti {
    static Dao<Avion,Integer> avionDao;
    static Dao<Roba,Integer> robaDao;

    public static void main(String[] args) {


        try(ConnectionSource conn=new JdbcConnectionSource(Konstante.BAZA_URL)){

            TableUtils.clearTable(conn,Roba.class);
            TableUtils.clearTable(conn,Avion.class);

            Avion a1=new Avion("Avion1",34);
            Avion a2=new Avion("Avion2",21);

            avionDao= DaoManager.createDao(conn,Avion.class);
            avionDao.create(a1);
            avionDao.create(a2);

            Roba r1=new Roba("Patike","Duboke patike",1);
            r1.setAvion(a1);
            Roba r2=new Roba("Kosulja","Na duge rukave",0.4);
            r2.setAvion(a1);
            Roba r3=new Roba("Voda","Voda za pice",1.4);
            r3.setAvion(a1);
            Roba r4=new Roba("Ploce","Drvene ploce",3.4);
            r4.setAvion(a2);
            Roba r5=new Roba("Stolica","Plasticna stolica",2.4);
            r5.setAvion(a2);

            robaDao=DaoManager.createDao(conn,Roba.class);
            robaDao.create(r1);
            robaDao.create(r2);
            robaDao.create(r3);
            robaDao.create(r4);
            robaDao.create(r5);

            //ispis posle upisa
            System.out.println("Ispis posle upisa, tabela Avion:");
            List<Avion> avionList=avionDao.queryForAll();
            for(Avion a: avionList){
                System.out.println(a);
            }
            System.out.println("Ispis posle upisa, tabela Roba");
            List<Roba> robaList=robaDao.queryForAll();
            for(Roba r:robaList){
                System.out.println(r);
            }





        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

