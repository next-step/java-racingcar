package step2;

import java.util.Scanner;

public class InputView {
    private static final String ASK_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String ASK_NUMBER_OF_TRIALS = "시도할 횟수는 몇 회 인가요?";
    private Scanner scanner = new Scanner(System.in);

    public int getNumberOfCars() {
        System.out.println(ASK_NUMBER_OF_CARS);
        return scanner.nextInt();
    }

    public int getNumberOfTrials() {
        System.out.println(ASK_NUMBER_OF_TRIALS);
        int numberOfTrials = scanner.nextInt();
        scanner.close();
        return numberOfTrials;
    }

}
