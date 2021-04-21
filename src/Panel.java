import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Panel extends JPanel implements MouseListener {


    public static Ball[] balls;

    int w = 550;
    int h = 300;
    int X = 70;
    int Y = 80;
    int n = 10;

    int r = 9;

    double xA;
    double yA;

    BufferedImage holeImage;

    Cue cue = new Cue();

    Score score = new Score();

    public Panel() throws IOException {

        balls = new Ball[n];
        for (int i = 0; i < n; ++i) {

            if (i < 4) {
                balls[i] = new Ball(364, 184 + 2 * r * i);
            } else {

                if (i < 7) {
                    balls[i] = new Ball(364 - 2 * r, 184 + r + 2 * r * (i - 4));
                }
                else {
                    if (i < 9) {
                        balls[i] = new Ball(364 - 4 * r, 184 + 2 * r + 2 * r * (i - 7));

                    }
                    else {
                        balls[i] = new Ball(364 - 6 * r, 184 + 3 * r);

                    }
                }
            }
        }
        this.holeImage = ImageIO.read(new File("D:\\Pool\\src\\16.02\\src\\Безымянный.png"));
        this.addMouseListener(this);
        this.addMouseMotionListener(cue);

    }

    protected void paintComponent(Graphics g) {

        g.drawImage(holeImage, X, Y, w, h, null);

        for (int i = 0; i < n; i++) {

            cue.draw(g);
            balls[i].draw(g);
            balls[i].collide();
            balls[i].hit();
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        //System.out.println("по оХ : " + e.getX());
        //System.out.println("по оY : " + e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {

        xA = e.getX();
        yA = e.getY();

        cue.ChangeXY(xA, yA);

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
