package Thread953;

class TwoStrings {
    synchronized static void print(String str1, String str2) {
        System.out.print(str1);
        try {
            Thread.sleep(500); // Simulasi delay
        } catch (InterruptedException ie) {
            // Tangani interupsi jika diperlukan
        }
        System.out.println(str2);
    }
}

class PrintStringsThread implements Runnable {
    Thread thread;
    String str1, str2;

    PrintStringsThread(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        TwoStrings.print(str1, str2);
    }
}

public class Thread5 {
    public static void main(String[] args) {
        new PrintStringsThread("Hello ", "there.");
        new PrintStringsThread("How are ", "you?");
        new PrintStringsThread("Thank you ", "very much!");
    }
}