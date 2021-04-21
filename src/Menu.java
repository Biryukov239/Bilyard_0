import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Menu extends JPanel implements MouseListener {

    double width = 100;
    double height = 70;
    double x = 250;
    double y = 350;

    public Menu() {
        this.addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {

        g.setColor(Color.blue);
        g.drawString("Start", (int) x, (int) y);
        g.setColor(Color.red);
        g.fillRect((int) x, (int) y, (int) width, (int) height);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
