package step1.racing.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import step1.racing.MoveStrategy;
import step1.racing.RacingGame;
import step1.racing.common.TerminalInput;
import step1.racing.common.RandomIntegerGenerator;
import step1.racing.data.RacingCar;

public class GameGenerator {
    private static final String SPLIT_DELIMITER = ",";

    public static RacingGame getRacingGame() {
            String players = TerminalInput.readLine("참여할 플레이어 이름 입력 (,) : ");
            int playTimes = TerminalInput.readInt("플레이 횟수 입력 : ");

            return new RacingGame(initCarPositions(players), new MoveStrategy(RandomIntegerGenerator.getInstance()), playTimes);
    }

    private static List<RacingCar> initCarPositions(String players) {
        return Arrays.stream(players.split(SPLIT_DELIMITER))
                     .map(RacingCar::new)
                     .collect(Collectors.toList());
    }
}
