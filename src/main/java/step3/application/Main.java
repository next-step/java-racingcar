package step3.application;

public class Main {
    public static void main(String[] args) {
        Racing racing = new Racing(
                new ConsoleIn(),
                new ConsoleOut()
        );
        racing.init();
    }
}
