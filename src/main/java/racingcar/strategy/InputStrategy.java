package racingcar.strategy;

import racingcar.game.RacingInfomation;

import java.util.Scanner;

@FunctionalInterface
public interface InputStrategy {
    RacingInfomation question(Scanner scanner);
}
