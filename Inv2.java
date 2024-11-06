// Componente: interfaz que define el método común
interface Cafe {
    String getDescripcion();
    double getCosto();
}

// Componente concreto: una clase que implementa la interfaz
class CafeSimple implements Cafe {
    public String getDescripcion() {
        return "Café simple";
    }

    public double getCosto() {
        return 10.0; // Precio base del café simple
    }
}

// Decorador abstracto: implementa la misma interfaz y contiene una referencia al objeto que decora
abstract class CafeDecorador implements Cafe {
    protected Cafe cafeDecorado;

    public CafeDecorador(Cafe cafeDecorado) {
        this.cafeDecorado = cafeDecorado;
    }

    public String getDescripcion() {
        return cafeDecorado.getDescripcion();
    }

    public double getCosto() {
        return cafeDecorado.getCosto();
    }
}

// Decoradores concretos: extienden el decorador abstracto y añaden nuevas funcionalidades
class LecheDecorador extends CafeDecorador {
    public LecheDecorador(Cafe cafeDecorado) {
        super(cafeDecorado);
    }

    public String getDescripcion() {
        return cafeDecorado.getDescripcion() + ", con leche";
    }

    public double getCosto() {
        return cafeDecorado.getCosto() + 2.0; // Precio adicional de la leche
    }
}

class AzucarDecorador extends CafeDecorador {
    public AzucarDecorador(Cafe cafeDecorado) {
        super(cafeDecorado);
    }

    public String getDescripcion() {
        return cafeDecorado.getDescripcion() + ", con azúcar";
    }

    public double getCosto() {
        return cafeDecorado.getCosto() + 1.0; // Precio adicional del azúcar
    }
}

// Clase principal para probar el patrón decorador
public class Main {
    public static void main(String[] args) {
        Cafe cafe = new CafeSimple();
        System.out.println(cafe.getDescripcion() + " cuesta " + cafe.getCosto() + " USD");

        // Agregar leche al café
        cafe = new LecheDecorador(cafe);
        System.out.println(cafe.getDescripcion() + " cuesta " + cafe.getCosto() + " USD");

        // Agregar azúcar al café
        cafe = new AzucarDecorador(cafe);
        System.out.println(cafe.getDescripcion() + " cuesta " + cafe.getCosto() + " USD");
    }
}
