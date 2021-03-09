package racing.io;

public class ConsoleOutputDriver implements OutputDriver {

    @Override
    public void println(String message) {
        System.out.println(message);
    }

    @Override
    public void print(String message) {
        System.out.print(message);
    }
}
