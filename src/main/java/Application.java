public class Application {
    public static void main(String[] args) {
        final InputView input = InputView.readGameInput();

        ResultView.printResultHeader();
        CarRacing.executeGame(input);
    }
}
