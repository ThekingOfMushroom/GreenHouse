package com.greenhouse.ported;

public class Company {
    /*集中实现插入数据库和控制器控制*/
    public static SensorPortUtils serialPort;
    private static String s;

    public static void open(){
        getSp();
        serialPort.openSerialPort();
        System.out.println("打开端口");
    }
    public static SensorPortUtils getSp(){
        serialPort = SensorPortUtils.getIsSerialPort();
        return serialPort;
    }
    public static String setS(String s1){
        return s= s1;
    }
    public static void main(String[] args) {
        open();
        StorageData.setSerialPort(serialPort);
        Control.setSerialPort(serialPort);
        String a=setS("04");
        new Thread(new InsertInfo()).start();
//        new Thread(new Control("04")).start();
    }
//    public static void start(String a) {
//        open();
//        StorageData.setSerialPort(serialPort);
//        Control.setSerialPort(serialPort);
//    	  new Thread(new InsertInfo()).start();
//        new Thread(new Control(a)).start();
//    }
}
