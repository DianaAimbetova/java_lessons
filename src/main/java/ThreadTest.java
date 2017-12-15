public class ThreadTest implements Runnable{


    @Override
    public void run() {
        System.out.println("I am running!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
class Test1{
    public static void main(String[] args) {
        ThreadTest tt = new ThreadTest();
        //System.out.println("ok");
        Thread t1 = new Thread(tt);
        Thread t2 = new Thread(tt);
        //new myThread().start();
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);

    }

    static class myThread extends Thread{
        public void run(){
            System.out.println("Extending...");
        }
    }


}
