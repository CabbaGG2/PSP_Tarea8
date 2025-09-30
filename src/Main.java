public class Main extends Thread {
    private final int nivelPaciencia;

    /**
     * Constructor que recibe el nombre del hilo y su nivel de paciencia,
     * y lo pasa a la clase padre (Thread) para su inicialización.
     * @param nombre El nombre para este hilo.
     * @param nivelPaciencia El nivel de paciencia del hilo.
     */
    public Main(String nombre, int nivelPaciencia) {
        super(nombre);
        this.nivelPaciencia = nivelPaciencia;
    }

    /**
     * Definimos lo que hace el hilo
     */
    @Override
    public void run() {
        for (int i = 0; i < nivelPaciencia; i++) {
            if (i == nivelPaciencia - 1) {
                System.out.println("[" + getName() + "]" + "Soy " + getName() + " y he terminado mi paciencia.");
            } else {
                System.out.println("[" + getName() + "]" + "Soy " + getName() + " y me quedan " + (nivelPaciencia - i) + " niveles de paciencia.");
                try {
                    Main.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Ocurrio un error: " + e.getMessage());;
                }
            }
        }
    }

    /**
     * El método main es el punto de entrada. Crea y lanza varios
     * hilos con diferentes niveles de paciencia y luego imprime un mensaje
     * para indicar que el hilo principal ha terminado sus tareas.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Programa inicializado");
        new Main("Diego", 4).start();
        new Main("Manuel", 5).start();
        new Main("Damian", 3).start();
        new Main("Araujo", 5).start();
        System.out.println("Programa terminado");
    }
}
