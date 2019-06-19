package step2.view;

import java.util.Scanner;

public class InputView {
    private final static String ASK_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
    private final static String ASK_NUMBER_OF_TRIALS = "시도할 횟수는 몇 회 인가요?";
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int getNumberOfCars() {
        System.out.println(ASK_NUMBER_OF_CARS);
        return scanner.nextInt();
    }

    public int getNumberOfTrials() {
        System.out.println(ASK_NUMBER_OF_TRIALS);
        final int numberOfTrials = scanner.nextInt();
        scanner.close();
        printEmptyLine();
        return numberOfTrials;
    }

    private void printEmptyLine() {
        System.out.println();
    }

}
