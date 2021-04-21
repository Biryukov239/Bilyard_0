import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Cue extends JPanel implements MouseMotionListener {

    double xA;
    double yA;

    int width = 250;
    int height = 250;

    double angleInRadians;

    BufferedImage cueImage;

    public void ChangeXY(double xA, double yA) {

        this.xA = xA;
        this.yA = yA;
    }

    public Cue() throws IOException {

        this.cueImage = ImageIO.read(new File("D:\\Pool\\src\\16.02\\src\\cUE.png"));
    }

    public void draw(Graphics g) {

        angleInRadians = Math.atan2(yA - yB, xA - xB);
        double locationX = cueImage.getWidth() / 2;
        double locationY = cueImage.getHeight() / 2;
        AffineTransform tx = AffineTransform.getRotateInstance(angleInRadians, locationX, locationY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

        if (xA > 0) {

            g.drawImage(op.filter(cueImage, null), (int) xA - width / 2, (int) yA - height / 2, width, height, null);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    private double xB;
    private double yB;

    @Override
    public void mouseMoved(MouseEvent e) {
        xB = e.getX();
        yB = e.getY();

        Ball.xB = xB;
        Ball.yB = yB;
    }
}
