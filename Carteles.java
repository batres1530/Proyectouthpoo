import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class Carteles {
    protected int x;
    protected int y;
    protected ImageIcon imagen;

    public Carteles(int x, int y, String rutaImagen) {
        this.x = x;
        this.y = y;
        this.imagen = new ImageIcon(rutaImagen);
    }

    public void dibujar(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(imagen.getImage(), x, y, null);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
