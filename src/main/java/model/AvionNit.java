package model;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import zadaci.Konstante;

import javax.xml.transform.sax.SAXSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AvionNit extends Thread {
    private Avion avion;
    private static boolean dozvoljenoPoletanje = true;
    private static Object key = new Object();
    private boolean poleteo=false;

    private static Dao<Avion,Integer> avionDao;
    public AvionNit(Avion avion) {
        this.avion = avion;

    }

    public synchronized boolean isPoleteo() {
        return poleteo;
    }

    public static boolean isDozvoljenoPoletanje() {
        synchronized (key) {
            if(dozvoljenoPoletanje){
                dozvoljenoPoletanje=false;
                return true;
            }else{
                return false;
            }


        }

    }

    public static void setDozvoljenoPoletanje(boolean dozvoljenoPoletanje) {
        synchronized (key) {
            AvionNit.dozvoljenoPoletanje = dozvoljenoPoletanje;
        }

    }

    @Override
    public void run() {
        //provera opreme

        System.out.println("Pocinju provere za avion" + avion.getId());
        try {
            sleep((long) (Math.random() * 2000));
            System.out.println("Avion " + avion.getId() + " je spreman za poletanje i ceka dozvolu za poletanje");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        do {
                poleteo=isDozvoljenoPoletanje();

        }
    while(!poleteo);
        System.out.println("Avion " + avion.getId() + " izlazi na pistu i polece");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Avion " + avion.getId() + " je poleteo");
        setDozvoljenoPoletanje(true);


}
    public static void main(String[] args) {

        try(ConnectionSource conn=new JdbcConnectionSource(Konstante.BAZA_URL)){
            avionDao= DaoManager.createDao(conn,Avion.class);
            List<Avion> listaAviona=avionDao.queryForAll();
            List<AvionNit> listaPokrenutih=new ArrayList<>();

            for(Avion a: listaAviona){
                AvionNit t=new AvionNit(a);
                listaPokrenutih.add(t);

                t.start();


        }
            for(AvionNit a:listaPokrenutih){
                a.join();
            }

            System.out.println("Svi avioni su poleteli");


    } catch (SQLException | IOException | InterruptedException throwables) {
            throwables.printStackTrace();
        }


    }
}
