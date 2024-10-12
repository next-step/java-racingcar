package step3;

public class ConsoleOutputView implements OutputView {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
