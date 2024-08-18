
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class Weapon {
    private int x, y;
    private boolean isSwinging = false;
    private long swingStartTime;
    private final long SWING_DURATION = 250; // Swing duration in milliseconds

    public Weapon() {
       
    }
    
    public void update() {
        if (isSwinging) {
            long elapsedTime = System.currentTimeMillis() - swingStartTime;
            if (elapsedTime > SWING_DURATION) {
                isSwinging = false; // Stop the swing animation after 0.25 seconds
            }
        }
    }

    public void draw(Graphics g) {
        if (isSwinging) {
            long elapsedTime = System.currentTimeMillis() - swingStartTime;
            double swingProgress = (double) elapsedTime / SWING_DURATION;
            double angle = Math.sin(swingProgress * Math.PI) * 45; // Swing back and forth 45 degrees

            Graphics2D g2 = (Graphics2D) g;
            AffineTransform old = g2.getTransform();
            g2.rotate(Math.toRadians(angle), x, y);
            g2.setColor(Color.BLACK);
            g2.drawLine(x, y, x + 50, y);
            g2.setTransform(old);
        }
    }

    public void fire(int x, int y) {
        System.out.println("Weapon fired!");
        this.x = x;
        this.y = y;
        isSwinging = true;
        swingStartTime = System.currentTimeMillis();
    }
}