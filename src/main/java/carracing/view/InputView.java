package carracing.view;

import java.util.Scanner;

public class InputView {
    private final String DELIMITER = ",";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] insertNamesOfCars() {
        printModelNamesMessage();
        return split(scanner.nextLine());
    }

    public int insertNumberOfAttempts() {
        printAttemptsMessage();
        return scanner.nextInt();
    }

    private String[] split(String text) {
        return text.split(DELIMITER);
    }

    private void printAttemptsMessage() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    private void printModelNamesMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }
}