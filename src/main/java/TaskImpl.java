import java.io.IOException;
import java.net.ServerSocket;

public class TaskImpl implements Task {

    private int startPort;
    private int endPort;
    private Thread scanThread;

    public TaskImpl(int startPort, int endPort) {
        this.startPort = startPort;
        this.endPort = endPort;
    }

    @Override
    public void start() {
        scanThread = new Thread( () -> {
            for (int i = startPort; i <= endPort; i++) {
                if (scanThread.isInterrupted()) {
                    System.out.println("Сканирование портов завершено");
                    break;
                } else {
                    try (ServerSocket serverSocket = new ServerSocket(i)) {
                        System.out.println("Порт " + i + " открыт");
                    } catch (IOException e) {

                    }
                }
            }
            System.out.println("Сканирование портов завершено");
        });
        scanThread.start();
    }

    @Override
    public void stop() {
        if (scanThread!= null && scanThread.isAlive()) {
            scanThread.interrupt();
            try {
                scanThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
