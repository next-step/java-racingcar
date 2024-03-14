package step3.view;

import step3.view.model.RacingArguments;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);


    public RacingArguments receiveRacingArguments() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int moveCount = scanner.nextInt();

        return new RacingArguments(carCount, moveCount);
    }
}
