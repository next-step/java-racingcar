package step1.racing.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import step1.racing.MoveStrategy;
import step1.racing.RacingGame;
import step1.racing.common.RandomIntegerGenerator;
import step1.racing.data.RacingCar;

public class GameGenerator {
    private static final String SPLIT_DELIMITER = ",";

    public static RacingGame getRacingGame() {
            Scanner scanner = new Scanner(System.in);
            String players = scanner.nextLine();
            int playTimes = scanner.nextInt();

            return new RacingGame(initCarPositions(players), new MoveStrategy(RandomIntegerGenerator.getInstance()), playTimes);
    }

    private static List<RacingCar> initCarPositions(String players) {
        return Arrays.stream(players.split(SPLIT_DELIMITER))
                     .map(RacingCar::new)
                     .collect(Collectors.toList());
    }
}
