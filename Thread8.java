package Thread2;
 
import javax.swing.*;
import java.awt.*;

public class Thread8 extends JFrame implements Runnable {
    String message = " Your name here! ";
    int x = 0;

    public Thread8() {
        setTitle("Banner");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.CYAN);
        setLocationRelativeTo(null);
        setVisible(true);
        Thread t = new Thread(this);
        t.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString(message, 50, 60);
    }

    public void run() {
        while (true) {
            // Memindahkan karakter pertama ke akhir (shift kiri)
            message = message.substring(1) + message.charAt(0);
            repaint();
            try {
                Thread.sleep(300); // Delay untuk efek bergerak
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread8();
    }
}