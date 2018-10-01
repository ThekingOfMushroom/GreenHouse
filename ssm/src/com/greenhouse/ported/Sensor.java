package com.greenhouse.ported;

import java.sql.Timestamp;
import java.util.Date;

public class Sensor {
    private int id;
    private Date date;
    private Timestamp time;
    private float temp;
    private float humi;
    private int illu;

    public Sensor(Date date, float temp, float humi, int illu) {
        this.date = date;
        this.temp = temp;
        this.humi = humi;
        this.illu = illu;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Timestamp getTime(){
        time= new Timestamp(date.getTime());
        return time;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getHumi() {
        return humi;
    }

    public void setHumi(float humi) {
        this.humi = humi;
    }

    public int getIllu() {
        return illu;
    }

    public void setIllu(int illu) {
        this.illu = illu;
    }
}
