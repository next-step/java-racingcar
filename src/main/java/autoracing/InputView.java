package autoracing;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {
    private static final String QUESTION_NUMBER_OF_CARS = "자동차 대수는 몇 대인가요?";
    private static final String QUESTION_TOTAL_ROUNDS = "시도할 횟수는 몇 회인가요?";

    private final int numberOfCars;
    private final int totalRounds;

    public InputView(int numberOfCars, int totalRounds) {
        this.numberOfCars = numberOfCars;
        this.totalRounds = totalRounds;
    }

    public static InputView takeInput(InputStream inputStream) {
        Scanner scan = new Scanner(inputStream);

        int numberOfCars = takeNumberOfCars(scan);
        int totalRounds = takeTotalRounds(scan);
        System.out.println();

        scan.close();

        return new InputView(numberOfCars, totalRounds);
    }

    private static int takeNumberOfCars(Scanner scan) {
        System.out.println(QUESTION_NUMBER_OF_CARS);
        return Integer.parseInt(scan.nextLine().trim());
    }

    private static int takeTotalRounds(Scanner scan) {
        System.out.println(QUESTION_TOTAL_ROUNDS);
        return Integer.parseInt(scan.nextLine().trim());
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getTotalRounds() {
        return totalRounds;
    }
}
