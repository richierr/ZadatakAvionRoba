package model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;

@DatabaseTable(tableName = "avion")
public class Avion {


    private static final String POLJE_OZNAKA="oznaka";
    private static final String POLJE_RASPON_KRILA="raspon_krila";


    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "oznaka",canBeNull = false)
    private String oznaka;

    @DatabaseField(columnName = "raspon_krila",canBeNull = false)
    private int raspon_krila;


    @ForeignCollectionField(foreignFieldName = "avion")
    private ForeignCollection<Roba> roba;


    public Avion(String oznaka, int raspon_krila) {
        this.oznaka = oznaka;
        this.raspon_krila = raspon_krila;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public int getRaspon_krila() {
        return raspon_krila;
    }

    public void setRaspon_krila(int raspon_krila) {
        this.raspon_krila = raspon_krila;
    }

    public ForeignCollection<Roba> getRoba() {
        return roba;
    }

    public void setRoba(ForeignCollection<Roba> roba) {
        this.roba = roba;
    }

    public Avion(){
    }

    @Override
    public String toString() {
        return "Avion{" +
                "id=" + id +
                ", oznaka='" + oznaka + '\'' +
                ", raspon_krila=" + raspon_krila +
                '}';
    }
}
