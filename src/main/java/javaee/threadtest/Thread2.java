package javaee.threadtest;

public class Thread2 {
    public static void main(String[] args) {
        Station a  = new Station("窗口1");
        Station b  = new Station("窗口2");
        Station c  = new Station("窗口3");

        a.start();
        b.start();
        c.start();
    }

}

class Station extends Thread{
    static int num=1000;
    static final Object lock = new Object();

    private String name;

    public Station(String name){
       this.name=name ;
    }

    @Override
    public void run() {
        while(num>=1){
            synchronized (lock){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name+"售出了第"+num--);
            }
        }
    }
}