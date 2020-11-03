package racingcar.strategy;

import racingcar.game.RacingInfomation;

import java.util.Scanner;

import static racingcar.Constant.QUESTION_JOIN_CAR_NAME_LIST;
import static racingcar.Constant.QUESTION_PLAY_ROUND;

public class CarNameInputStrategy implements InputStrategy {

    private int questionPlayCount(Scanner scanner) {
        System.out.println(QUESTION_PLAY_ROUND);
        return scanner.nextInt();
    }

    private String questionCarNames(Scanner scanner) {
        System.out.println(QUESTION_JOIN_CAR_NAME_LIST);
        return scanner.nextLine();
    }

    @Override
    public RacingInfomation question(Scanner scanner) {
        String carNames = questionCarNames(scanner);
        int playCount = questionPlayCount(scanner);
        return new RacingInfomation.Builder(playCount)
                .carNames(carNames)
                .build();
    }
}
