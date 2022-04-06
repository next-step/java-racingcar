package step02;

import java.util.List;

public class CalculatorApplication {

    private final ConsoleReader consoleReader;

    private final NumberSplitter numberSplitter;

    private final OutputView outputView;

    public CalculatorApplication(
            ConsoleReader consoleReader,
            NumberSplitter numberSplitter,
            OutputView outputView
    ) {
        this.consoleReader = consoleReader;
        this.numberSplitter = numberSplitter;
        this.outputView = outputView;
    }

    public void run() {
        try {
            String inputText = consoleReader.readLine();
            List<Number> numberList = splitAndTransformNumbers(inputText);
            Numbers numbers = new Numbers(numberList);
            outputView.printNumber(numbers.sum());
        } catch (Exception exception) {
            outputView.printExceptionMessage(exception);
        }
        outputView.printQuitMessage();
    }

    private List<Number> splitAndTransformNumbers(String inputText) {
        try {
            return numberSplitter.extractNumbersWithDelimiter(inputText);
        } catch (NumberFormatException numberFormatException) {
            throw new RuntimeException("잘못된 입력이 감지 되었습니다.", numberFormatException);
        }
    }

}
