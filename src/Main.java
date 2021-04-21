import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class Main implements MouseListener {
    static JFrame frame;
    static Panel p;
    static Menu m;
    static double dt = 0.000005;

    public static void main(String[] args) throws IOException {


        Main ma = new Main();
        frame = new JFrame();
        p = new Panel();
        m = new Menu();
        frame.add(p);
        frame.setVisible(true);
        frame.setLocation(500, 50);
        frame.setSize(700, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        m.addMouseListener(ma);

        while (true) {
            for (Ball b : Panel.balls) {
                b.update(dt);
            }
            frame.repaint();
        }

    }


    @Override
    public void mouseClicked(MouseEvent e) {


        System.out.println(1);
        if (((e.getX() >= 50) && (e.getX() <= 1000)) && ((e.getY() <= 1000) && (e.getY() >= 0))) {
            System.out.println("works !");

            frame.add(m);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

