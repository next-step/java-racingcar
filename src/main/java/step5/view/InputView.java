package step5.view;

import java.util.Scanner;

public class InputView {

    private final String DELIMETER = ",";

    private final Scanner scanner = new Scanner(System.in);

    public Scanner scanner() {
        return this.scanner;
    }

    public void close() {
        this.scanner().close();
    }

    public int inputNumberOfCars() {
        System.out.println("자동차 대수는 몇 대인가요?");
        return inputInteger(scanner);
    }

    public String[] inputNamesSplittedByComma() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return inputStringSplittedByComma(scanner);
    }

    public int inputCountRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return inputInteger(scanner);
    }

    private int inputInteger(Scanner scanner){
        return scanner.nextInt();
    }

    private String[] inputStringSplittedByComma(Scanner scanner) {
        String input = scanner.next();
        return input.split(DELIMETER);
    }

}
