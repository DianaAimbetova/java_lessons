public class ThreadsTest {

    /**
     * Чтобы узнать как работают несколько потоков с одним объектом
     * @param args
     */

    public static void main(String[] args) {
        Threads tt = new Threads();
        Thread t1 = new Thread(tt);
        Thread t2 = new Thread(tt);
        t1.start();
        tt.increment();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // System.out.println(tt.getC());
        t2.start();
        tt.increment();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // System.out.println(tt.getC());


    }
}

class Threads extends Thread {
    int c;
    public synchronized void inc(){
        c++;
    }
    public synchronized void dec(){
        c--;
    }
    public synchronized int getC(){
        return c;
    }

    public void increment(){
        synchronized (this){
            c++;
        }
        System.out.println(c);
    }
}
