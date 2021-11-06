package racinggame;

import java.util.Scanner;

public class InputView {

    public static void executeGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        String numberOfCars = scanner.nextLine();
        System.out.println("시도할 회수는 몇 회 인가요?");
        String numberOfAttempts = scanner.nextLine();

        GameExecutor gameExecutor = GameExecutorFactory.createGameExecutor(numberOfCars, numberOfAttempts);

        gameExecutor.execute()
                .showResult();
    }
}
