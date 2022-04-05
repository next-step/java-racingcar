package step02;

import java.util.List;

public class CalculatorApplication {

    private final ConsoleReader consoleReader;

    private final NumberSplitter numberSplitter;

    private final NumberWriter numberWriter;

    public CalculatorApplication(
            ConsoleReader consoleReader,
            NumberSplitter numberSplitter,
            NumberWriter numberWriter
    ) {
        this.consoleReader = consoleReader;
        this.numberSplitter = numberSplitter;
        this.numberWriter = numberWriter;
    }

    public void run() {
        try {
            String inputText = consoleReader.readLine();
            List<Number> numberList = splitAndTransformNumbers(inputText);
            Numbers numbers = new Numbers(numberList);
            numberWriter.printNumber(numbers.sum());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            System.out.println("프로그램을 종료합니다.");
        }
    }

    private List<Number> splitAndTransformNumbers(String inputText) {
        try {
            return numberSplitter.extractNumbersWithDelimiter(inputText);
        } catch (NumberFormatException numberFormatException) {
            throw new RuntimeException("잘못된 입력이 감지 되었습니다.", numberFormatException);
        }
    }

}
