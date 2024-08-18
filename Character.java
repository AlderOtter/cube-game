
import java.awt.*;

public class Character  {
    private int x, y;
    private Color color;
    private int up, down, left, right, fire;

    private final int SIZE = 50; // Size of the cubes
    private final int MOVE_SPEED = 10; // Speed of the cubes

    // Flags for red cube movement
    private boolean moveLeft = false, moveRight = false, moveUp = false, moveDown = false;
    
    private Weapon weapon = new Weapon();

    public Character(int x, int y, Color color, int left, int right, int up, int down, int fire) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.left = left;
        this.right = right;
        this.up = up;
        this.down = down;
        this.fire = fire;
    }

    public void update() {
        if (moveLeft) x -= MOVE_SPEED;
        if (moveRight) x += MOVE_SPEED;
        if (moveUp) y -= MOVE_SPEED;
        if (moveDown) y += MOVE_SPEED;

        weapon.update();
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, SIZE, SIZE); // Draw blue cube
        weapon.draw(g);
    }

    public void keyPressed(int keyCode) {
        if (keyCode == left) moveLeft = true;
        if (keyCode == right) moveRight = true;
        if (keyCode == up) moveUp = true;
        if (keyCode == down) moveDown = true;

        if (keyCode == fire) weapon.fire(x, y);
    }

    public void keyReleased(int keyCode) {
        if (keyCode == left) moveLeft = false;
        if (keyCode == right) moveRight = false;
        if (keyCode == up) moveUp = false;
        if (keyCode == down) moveDown = false;
    }
}
