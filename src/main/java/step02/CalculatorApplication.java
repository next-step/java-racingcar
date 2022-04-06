package step02;

import java.util.List;

public class CalculatorApplication {

    private final ConsoleReader consoleReader;

    private final NumberSplitter numberSplitter;

    private final NumberConverter numberConverter;

    private final OutputView outputView;

    public CalculatorApplication(
            ConsoleReader consoleReader,
            NumberSplitter numberSplitter,
            NumberConverter numberConverter,
            OutputView outputView
    ) {
        this.consoleReader = consoleReader;
        this.numberSplitter = numberSplitter;
        this.numberConverter = numberConverter;
        this.outputView = outputView;
    }

    public void run() {
        try {
            String inputText = consoleReader.readLine();
            List<Integer> numberList = splitAndConvertNumber(inputText);
            Numbers numbers = new Numbers(NumberFactory.of(numberList));
            outputView.printNumber(numbers.sum());
        } catch (Exception exception) {
            outputView.printExceptionMessage(exception);
        }
        outputView.printQuitMessage();
    }

    private List<Integer> splitAndConvertNumber(String inputText) {
        try {
            List<String> stringNumbers = numberSplitter.extractNumbersWithDelimiter(inputText);
            return numberConverter.convertToNumber(stringNumbers);
        } catch (NumberFormatException numberFormatException) {
            throw new RuntimeException("잘못된 입력이 감지 되었습니다.", numberFormatException);
        }
    }

}
