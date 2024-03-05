package threadRace;

import java.util.ArrayList;

public class myThread implements Runnable{
    ArrayList<Integer> subList;
    ArrayList<Integer> evenList;
    ArrayList<Integer> oddList;

    myThread(ArrayList<Integer> subList, ArrayList<Integer> evenList, ArrayList<Integer> oddList) {
        this.subList = subList;
        this.evenList = evenList;
        this.oddList = oddList;
    }

    @Override
    public void run() {
        for (int i : subList) {
            synchronized (evenList) {
                if (i % 2 == 0) {
                    System.out.println("Thread: " + Thread.currentThread().getName() + " çift sayı eklendi: " + i);
                    evenList.add(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            synchronized (oddList) {
                if (i % 2 != 0) {
                    System.out.println("Thread: " + Thread.currentThread().getName() + " tek sayı eklendi: " + i);
                    oddList.add(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}
