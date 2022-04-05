package step02;

public class Main {

    public static void main(String[] args) {
        ConsoleReader consoleReader = new ConsoleReader();
        NumberSplitter numberSplitter = new NumberSplitter();
        NumberWriter numberWriter = new NumberWriter();

        CalculatorApplication application = new CalculatorApplication(consoleReader, numberSplitter, numberWriter);
        application.run();
    }

}
