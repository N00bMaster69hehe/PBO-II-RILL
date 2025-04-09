package Thraed961;

class SharedData {
    int data;

    synchronized void set(int value) {
        System.out.println("Generate " + value);
        data = value;
    }

    synchronized int get() {
        System.out.println("Get " + data);
        return data;
    }
}

class Producer implements Runnable {
    SharedData sd;

    Producer(SharedData sd) {
        this.sd = sd;
        new Thread(this, "Producer").start();
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            sd.set((int) (Math.random() * 100));
            try {
                Thread.sleep(200); // Tambahkan delay untuk efek lebih nyata
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    SharedData sd;

    Consumer(SharedData sd) {
        this.sd = sd;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            sd.get();
            try {
                Thread.sleep(200); // Tambahkan delay untuk efek lebih nyata
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Thread7 {
    public static void main(String[] args) {
        SharedData sd = new SharedData();
        new Producer(sd);
        new Consumer(sd);
    }
}