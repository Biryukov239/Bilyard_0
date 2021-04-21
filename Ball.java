import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Ball {


    double x;
    double y;
    double vx = 1;
    double vy = 0.5;
    public static double width = 400;
    double height = 300;
    public static int r = 15;
    public double R = 1;
    int n = 8;
    double  a = 0.0001;


    BufferedImage ballImage;



    public Ball(double x, double y) throws IOException {

        this.x = x;
        this.y = y;
        this.ballImage = ImageIO.read(new File("C:\\Users\\Гриша\\Downloads\\Pool\\src\\ball.png"));
    }


    void draw(Graphics g) {


        if ((x + R >= 57 + width) || (x - R <= 70)) {

            vx = -vx;

        }

        x = x + vx;

        if ((y + R >= height + 57) || (y - R <= 80)) {

            vy = -vy;

        }

        y = y + vy;


        g.drawImage(ballImage, (int) this.x, (int) this.y, 2 * r, 2 * r, null);
    }

    public void update (double dt) {

        if (vx > 0) {

            vx = vx - a * dt;
        }
        if (vy > 0) {
            vy = vy - a * dt;
        }

    }


    public void collide() {


        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j <= n; j++) {


                double dx = Panel.balls[i].x - Panel.balls[j].x;
                double dy = Panel.balls[i].y - Panel.balls[j].y;
                double d = Math.sqrt(dx * dx + dy * dy);


                if (d <= 2 * r) {

                }
            }
        }
    }
}






