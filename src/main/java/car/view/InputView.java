package car.view;

import car.model.UserInput;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static UserInput receiveInput() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        if (isInvalid(carCount)) {
            throw new IllegalArgumentException("Car count must be positive");
        }
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int totalRound = scanner.nextInt();
        if (isInvalid(totalRound)) {
            throw new IllegalArgumentException("Total round must be positive");
        }

        System.out.println();
        System.out.println("실행 결과");
        return new UserInput(carCount, totalRound);
    }

    private static boolean isInvalid(int input) {
        return input <= 0;
    }
}
