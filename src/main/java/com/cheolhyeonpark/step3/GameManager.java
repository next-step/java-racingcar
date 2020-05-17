package com.cheolhyeonpark.step3;

import java.util.Scanner;

public class GameManager {

    private final ResultView resultView = new ResultView();

    public void run() {
        Scanner scanner = new Scanner(System.in);
        RacingGame racingGame = new RacingGame(inputNumberOfCars(scanner), inputNumberOfStages(scanner));
        scanner.close();

        resultView.printResultTitle();
        while (racingGame.hasNextStage()) {
            racingGame.playStage();
            resultView.printStageResult(racingGame.getResultOfStage());
        }
    }

    private int inputNumberOfCars(Scanner scanner) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    private int inputNumberOfStages(Scanner scanner) {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
