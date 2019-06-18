package step2;

import java.util.Scanner;

public class InputView {
    private final static String ASK_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
    private final static String ASK_NUMBER_OF_TRIALS = "시도할 횟수는 몇 회 인가요?";
    private final static int MINIMUM_NUMBER_CAN_BE_INPUT = 1;
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int getNumberOfCars() {
        System.out.println(ASK_NUMBER_OF_CARS);
        final int numberOfCars = scanner.nextInt();
        inputNumberValidation(numberOfCars);
        return numberOfCars;
    }

    public int getNumberOfTrials() {
        System.out.println(ASK_NUMBER_OF_TRIALS);
        final int numberOfTrials = scanner.nextInt();
        inputNumberValidation(numberOfTrials);
        scanner.close();
        System.out.println();
        return numberOfTrials;
    }

    public void inputNumberValidation(int number) {
        if(number < MINIMUM_NUMBER_CAN_BE_INPUT) {
            scanner.close();
            throw new IllegalArgumentException("최소 1대의 자동차와 최소 1번의 시도횟수가 필요합니다.");
        }
    }

}
