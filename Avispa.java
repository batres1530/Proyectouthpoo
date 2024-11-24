public class Avispa extends Enemigos {
    public Avispa(int x, int y) {
        super(x, y, "avispa", "Imagenes/avispa.png");
        this.velocidad = 2;
        this.puntosDeDano = 50;
    }
}
