import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.Timer;

public class Escenario extends JPanel implements KeyListener {
    Image fondo;
    Random r;
    Arania arania1;
    Arania arania2;
    Arania arania3;
    Arania arania4;
    Avispa [] avispas;
    int velocidadGeneral = 9;//menos es mas rapido
    TelaArania tela1;
    TelaArania tela2;
    TelaArania tela3;
    TelaArania tela4;
    Animal animal1;
    Animal animal2; 
    Animal animal3;
    Animal animal4;
    Adorno cartelVidas;
    Adorno cartelPuntos;
    Adorno cartelFrutas;
    Adorno cartelGrupo;
    Vidas [] vidas;

    public Escenario() {
        ImageIcon icono = new ImageIcon("imagenes/fondo.jpg");
        r = new Random();
        fondo = icono.getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH);
        this.setSize(1200, 700);
        this.setVisible(true);
        this.setFocusable(true);
        this.addKeyListener(this);

        tela1 = new TelaArania(100, 50);
        tela2 = new TelaArania(400, 50);
        tela3 = new TelaArania(700, 50);
        tela4 = new TelaArania(1000, 50);
        arania1 = new Arania(100, 50);
        arania2 = new Arania(400, 50);
        arania3 = new Arania(700, 50);
        arania4 = new Arania(1000, 50);
        animal1 = new Animal(100, 50, "imagenes/animal1.png", KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, "mono");
        animal2 = new Animal(400, 500, "imagenes/animal2.png", KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, "");
        animal3 = new Animal(400, 500, "imagenes/animal3.png", KeyEvent.VK_I, KeyEvent.VK_K, KeyEvent.VK_J, KeyEvent.VK_L, "");
        animal4 = new Animal(400, 500, "imagenes/animal4.png", KeyEvent.VK_T, KeyEvent.VK_G, KeyEvent.VK_F, KeyEvent.VK_H, "");
        avispas = new Avispa[10];
        cartelVidas = new Adorno(1000, 200);
        cartelPuntos = new Adorno(1000, 300);
        cartelFrutas = new Adorno(1000, 400);
        cartelGrupo = new Adorno(1000, 500);
        vidas = new Vidas[3];
        
        for (int i = 0; i < vidas.length; i++) {
            vidas[i] = new Vidas(1010 + i * 45, 240);
        }

        for (int i = 0; i < avispas.length; i++) {
            int randomX = r.nextInt(1200); 
            avispas[i] = new Avispa(randomX, 50);
        }

        Timer timer = new Timer(velocidadGeneral, e -> {
            moverAranias();
            moverAvispas();
            animal1.mover();
            animal2.mover();
            animal3.mover();
            animal4.mover();
            repaint();
        });
        timer.start();
    }

    public void moverAranias() {
        arania1.mover();
        arania2.mover();
        arania3.mover();
        arania4.mover();

        if (arania1.getY() > getHeight())
            arania1.setY(50);
        if (arania2.getY() > getHeight())
            arania2.setY(50);
        if (arania3.getY() > getHeight())
            arania3.setY(50);
        if (arania4.getY() > getHeight())
            arania4.setY(50);

        repaint();
    }
    public void moverAvispas() {
        for (int i = 0; i < avispas.length; i++) {
            avispas[i].setY(avispas[i].getY() + 1);
            if (avispas[i].getY() > getHeight()) {
                avispas[i].setVisible(0);
            }
        }
    }
    // Manejo de teclas presionadas
    public void keyPressed(KeyEvent e) {
        animal1.keyPressed(e);
        animal2.keyPressed(e);
        animal3.keyPressed(e);
        animal4.keyPressed(e);
        repaint();
    }
     // Manejo de teclas soltadas
    public void keyReleased(KeyEvent e) {
        animal1.keyReleased(e);
        animal2.keyReleased(e);
        animal3.keyReleased(e);
        animal4.keyReleased(e);
        repaint();
    }

    public void keyTyped(KeyEvent e) {
        // No necesita implementación
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(this.fondo, 0, 0, this);
        tela1.dibujar(g);
        tela2.dibujar(g);
        tela3.dibujar(g);
        tela4.dibujar(g);
        arania1.dibujar(g);
        arania2.dibujar(g);
        arania3.dibujar(g);
        arania4.dibujar(g);
        animal1.dibujar(g);
        animal2.dibujar(g);
        animal3.dibujar(g);
        animal4.dibujar(g);
        cartelVidas.dibujar(g);
        cartelPuntos.dibujar(g);
        cartelFrutas.dibujar(g);
        cartelGrupo.dibujar(g);

        for (int i = 0; i < avispas.length; i++) {
            avispas[i].dibujar(g);
        }
        for (int i = 0; i < vidas.length; i++) {
            vidas[i].dibujar(g);
        }
    }
}