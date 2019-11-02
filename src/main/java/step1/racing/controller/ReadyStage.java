package step1.racing.controller;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import step1.racing.MoveStrategy;
import step1.racing.Moveable;
import step1.racing.RacingCarHandler;
import step1.racing.RacingGame;
import step1.racing.RandomIntegerGenerator;
import step1.racing.data.RacingCar;
import step1.racing.view.CarPositionViewer;

public class ReadyStage {
    private static final String SPLIT_DELIMITER = ",";
    private static final String CAR_INDICATOR = "-";

    private RacingCarHandler racingCarHandler;
    private Moveable moveStrategy;

    public ReadyStage() {
        initValues();
    }

    public void play() {
        RacingGame racingGame = new RacingGame(racingCarHandler, moveStrategy);
        CarPositionViewer.printStatus(racingCarHandler, CAR_INDICATOR);
        racingGame.move();
        CarPositionViewer.printStatus(racingCarHandler, CAR_INDICATOR);
        CarPositionViewer.printWinner(racingCarHandler);
    }

    private void initValues() {
        Scanner scanner = new Scanner(System.in);
        String players = scanner.nextLine();
        int playTimes = scanner.nextInt();

        racingCarHandler = initCarPositions(players, playTimes);
        moveStrategy = new MoveStrategy(RandomIntegerGenerator.getInstance());
    }

    private RacingCarHandler initCarPositions(String players, int playTimes) {
        return new RacingCarHandler(Arrays.stream(players.split(SPLIT_DELIMITER))
                                          .map(RacingCar::new)
                                          .collect(Collectors.toList()), playTimes);
    }
}
