package autoracing;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {
    private static final String QUESTION_NUMBER_OF_CARS = "자동차 대수는 몇 대인가요?";
    private static final String QUESTION_TOTAL_ROUNDS = "시도할 횟수는 몇 회인가요?";
    public static InputView takeInput(InputStream inputStream) {
        Scanner scan = new Scanner(inputStream);
        System.out.println(QUESTION_NUMBER_OF_CARS);
        int numberOfCars = Integer.parseInt(scan.nextLine().trim());
        System.out.println(QUESTION_TOTAL_ROUNDS);
        int totalRounds = Integer.parseInt(scan.nextLine().trim());
        System.out.println();
        scan.close();
        return new InputView(numberOfCars, totalRounds);
    }

    private final int numberOfCars;
    private final int totalRounds;

    public InputView(int numberOfCars, int totalRounds) {
        this.numberOfCars = numberOfCars;
        this.totalRounds = totalRounds;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getTotalRounds() {
        return totalRounds;
    }
}
