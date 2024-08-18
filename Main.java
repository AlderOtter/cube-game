/*
 * Add collision detection between players
 * add weapon image and collision detection
 * add Health system
 * add different health and speed based on class of character
 * add weapons
 * add accessories
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JPanel implements KeyListener {

    private Character player1 = new Character(50, 100, Color.RED, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_SPACE);
    private Character player2 = new Character(450, 100, Color.BLUE, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_ENTER);

    public Main() {
        setFocusable(true);
        addKeyListener(this);
        new Timer(1000/30, e -> update()).start();
    }

    private void update() {
        player1.update();
        player2.update();

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player1.draw(g);
        player2.draw(g);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        player1.keyPressed(e.getKeyCode());
        player2.keyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player1.keyReleased(e.getKeyCode());
        player2.keyReleased(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) { }
}

class CubeGame {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cube Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
       
        Main main = new Main();
        frame.add(main);
        frame.setVisible(true);
    }
}