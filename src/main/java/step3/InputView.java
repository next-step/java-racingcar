package step3;

import java.util.Scanner;

public class InputView {
    private static String CAR_COUNT_INPUT_INFO = "자동차 대수는 몇 대 인가요?";
    private static String ROUND_TIME_INPUT_INFO = "시도할 회수는 몇 회 인가요?";
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public Integer readInputInt() {
        int input = Integer.parseInt(this.scanner.nextLine());

        validateIntegerInput(input);
        return input;
    }

    private void validateIntegerInput(int input) {
        ValidationUtils.isBiggerThanZero(input);
    }

    private void printLine(String line) {
        System.out.println(line);
    }

    public void printCarCountInfo () {
        printLine(CAR_COUNT_INPUT_INFO);
    }

    public void printRoundTimeInfo() {
        printLine(ROUND_TIME_INPUT_INFO);
    }

}
