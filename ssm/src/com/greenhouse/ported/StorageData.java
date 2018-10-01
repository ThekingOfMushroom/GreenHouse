package com.greenhouse.ported;

import java.util.Date;
/*
* 这个类继承Thread类，重写的run方法用来实现给数据库插入数据*/
public class StorageData extends Thread {
    private float humi;
    private float temp;
    private int light;
    public static SensorPortUtils serialPort;

    public StorageData(String temp, String humi, String light) {
        String[] humis = humi.split(" ");
        int humiCal = Integer.parseInt(humis[1] + humis[0], 16);
        this.humi = humiCal * 0.01f;

        String[] temps = temp.split(" ");
        int tempCal = Integer.parseInt(temps[1] + temps[0], 16);
        this.temp = tempCal * 0.01f;

        String[] lights = light.split(" ");
        int lightCal = Integer.parseInt(lights[1] + lights[0], 16);
        this.light = lightCal;
    }
    public static void setSerialPort(SensorPortUtils serialPort1){
        serialPort=serialPort1;
    }
    public static String getTemp(){
        return serialPort.dataAll.get(serialPort.sensor.get("TEMP"));
    }
    public static String getHumi(){
        return serialPort.dataAll.get(serialPort.sensor.get("HUMI"));
    }
    public static String getIllu(){
        return serialPort.dataAll.get(serialPort.sensor.get("ILLU"));
    }
    @Override
    public void run() {
        StorageData sd = new StorageData(
                getTemp(),
                getHumi(),
                getIllu());
        float tempd = sd.temp;
        float humid = sd.humi;
        int illu = sd.light;
        Date date = new Date();
        System.out.println("湿度：" + humid + "。温度：" + tempd + "。时间：" + date + "。光照度" + illu);
        Sensor sensor = new Sensor(date, tempd, humid, illu);
        SqlConn.insert(sensor);
    }
}