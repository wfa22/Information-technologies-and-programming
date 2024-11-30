import java.util.*;

public class NumeroUno {

    public static class MyRunnable implements Runnable {
        private int summa;
        private int numeros[];
        public MyRunnable(int[] numeros) {
            this.numeros = numeros;
        }
        public void run() {
            summa = 0;
            for (int i: numeros) {
                summa += i;
            }
        }
        public int getSumma() {
            return summa;
        }

    }

    public static void main(String[] args) {
        int numeros[] = new int[]{1,2,3,4,5};

        MyRunnable run1 = new MyRunnable(Arrays.copyOfRange(numeros, 0, numeros.length/2));
        MyRunnable run2 = new MyRunnable(Arrays.copyOfRange(numeros, numeros.length/2, numeros.length));

        Thread thread1 = new Thread(run1);
        Thread thread2 = new Thread(run2);
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(run1.getSumma());
        System.out.println(run2.getSumma());
        System.out.println(run1.getSumma()+run2.getSumma());
    }
}