package car_racing;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_MESSAGE_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요 ?";
    private static final String INPUT_MESSAGE_NUMBER_OF_ROUND = "시도할 회수는 몇 회 인가요 ?";

    public int showMessageAndGetNumberOfCars() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(INPUT_MESSAGE_NUMBER_OF_CARS);
        int numberOfCars = scanner.nextInt();

        return numberOfCars;
    }

    public int showMessageAndGetNumberOfRound() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(INPUT_MESSAGE_NUMBER_OF_ROUND);
        int numberOfRound = scanner.nextInt();

        return numberOfRound;
    }
}
