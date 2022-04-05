package step02;

public class Main {

    public static void main(String[] args) {
        ConsoleReader consoleReader = new ConsoleReader();
        NumberSplitter numberSplitter = new NumberSplitter();
        OutputView outputView = new OutputView();

        CalculatorApplication application = new CalculatorApplication(consoleReader, numberSplitter, outputView);
        application.run();
    }

}
