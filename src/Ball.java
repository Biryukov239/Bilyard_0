import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Ball {


    public double x;
    public double y;
    double vx;
    double vy;
    int r = 9;
    public double R = 1;
    int n = 9;
    double a = 0.001;

    public static double xB;
    public static double yB;

    int w = 550;
    int h = 300;
    int X = 70;
    int Y = 80;
    int delta = 20;
    int d = 3;

    int holeLnY = 346;
    int holeLnX = 106;

    int holeLvX = 105;
    int holeLvY = 112;

    int holeVX = 346;
    int holeVY = 107;

    int holeRvX = 584;
    int holeRvY = 110;

    int holeRnX = 583;
    int holeRnY = 341;

    int holeNX = 346;
    int holeNY = 349;

    BufferedImage ballImage;

    double VxHit = 1;
    double VyHit = 1;

    Vector2D V = new Vector2D(vx, vy);
    Vector2D VHit = new Vector2D(VxHit, VyHit);

    public void hit() {

        for (int i = 0; i < n; i++) {
            double bx = Panel.balls[i].x;
            double by = Panel.balls[i].y;
            double d = Math.sqrt((xB - bx) * (xB - bx) + (yB - by) * (yB - by));

            if (d <= 2 * r) {
                Panel.balls[i].V = VHit;

            }
        }

    }


    {
        this.ballImage = ImageIO.read(new File("D:\\Pool\\src\\16.02\\src\\ball.png"));
    }

    public Ball(double x, double y) throws IOException {
        this.x = x;
        this.y = y;
    }


    void draw(Graphics g) {

        if ((x + R >= X + w - 25 - delta) || (x - R <= X + delta + 2)) {

            V.x = -V.x;

        }


        if ((y + R >= Y + h - 25 - delta) || (y - R <= Y + delta)) {

            V.y = -V.y;

        }

        x = x + V.x;
        y = y + V.y;

        if ((x >= holeLnX - d - 10) && (x <= holeLnX + d + 8) && (y >= holeLnY - d - 10) && (y <= holeLnY + d + 10)) {

            x = 10000000;
            V.x = 0;
            V.y = 0;

        }
        if ((x >= holeLvX - d - 5) && (x <= holeLvX + d + 1) && (y >= holeLvY - d - 10) && (y <= holeLvY + d)) {

            x = 18000000;
            V.x = 0;
            V.y = 0;

        }
        if ((x >= holeVX - d - 4) && (x <= holeVX + d - 5) && (y >= holeVY - d - 2) && (y <= holeVY + d + 2)) {

            x = 1900000;
            V.x = 0;
            V.y = 0;

        }
        if ((x >= holeRvX - d - 10) && (x <= holeRvX + d + 10) && (y >= holeRvY - d - 10) && (y <= holeRvY + d + 6)) {

            x = 19200000;
            V.x = 0;
            V.y = 0;

        }
        if ((x >= holeRnX - d - 10) && (x <= holeRnX + d + 10) && (y >= holeRnY - d - 10) && (y <= holeRnY + d + 5)) {

            x = 19400000;
            V.x = 0;
            V.y = 0;

        }
        if ((x >= holeNX - d - 10) && (x <= holeNX + d + 10) && (y >= holeNY - d - 12) && (y <= holeNY + d + 10)) {

            x = 19600000;
            V.x = 0;
            V.y = 0;

        }

        g.drawImage(ballImage, (int) this.x, (int) this.y, 2 * r, 2 * r, null);
    }

    public void update(double dt) {

        if (V.x > 0) {

            V.x = V.x - a * dt;
        }
        if (V.y > 0) {
            V.y = V.y - a * dt;
        }

    }


    public void collide() {


        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j <= n; j++) {

                double dx = Math.abs(Panel.balls[i].x - Panel.balls[j].x);
                double dy = Panel.balls[i].y - Panel.balls[j].y;
                double d = Math.sqrt(dx * dx + dy * dy);
                Vector2D k;

                if (d <= 2 * r + 5) {
                    k = Panel.balls[i].V;
                    Panel.balls[i].V = Panel.balls[j].V;
                    Panel.balls[j].V = k;
                }
            }
        }
    }
}
