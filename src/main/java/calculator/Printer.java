package calculator;

public class Printer {

    private static String INPUT_MESSAGE = "계산식을 입력하세요 : ";
    private static String OUTPUT_MESSAGE = "결과값 : ";
    private static String ERROR_PREFIX = "\n[ERROR] ";

    public void printInputMessage() {
        System.out.print(INPUT_MESSAGE);
    }

    public void printOutputMessage(double output) {
        System.out.print(OUTPUT_MESSAGE + output);
    }

    public void printErrorMessage(String message) {
        System.out.print(ERROR_PREFIX + message);
    }
}
