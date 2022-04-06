package step02;

public class Main {

    public static void main(String[] args) {
        ConsoleReader consoleReader = new ConsoleReader();
        NumberSplitter numberSplitter = new NumberSplitter();
        OutputView outputView = new OutputView();
        NumberConverter numberConverter = new NumberConverter();

        CalculatorApplication application = new CalculatorApplication(
                consoleReader,
                numberSplitter,
                numberConverter,
                outputView
        );

        application.run();
    }

}
