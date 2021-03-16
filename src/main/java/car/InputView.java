package car;

import car.model.UserInput;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static UserInput receiveInput() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int totalRound = scanner.nextInt();

        return new UserInput(carCount, totalRound);
    }
}
