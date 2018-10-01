package com.greenhouse.ported;

public class InsertInfo implements Runnable{
/*这个类用来实现Runnable接口，给Storage类的run方法添加循环*/
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10000);
                new StorageData(StorageData.getTemp(), StorageData.getHumi(), StorageData.getIllu()).start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
