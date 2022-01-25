package racingcar.domain;

import racingcar.racing.RacingGame;
import racingcar.util.RandomUtil;

public class RacingCar {

    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;
    private static final int THRESHOLD = 4;
    private static final int NAME_MAX_SIZE = 5;
    private final String name;
    private int position = 0;

    public RacingCar(String name) {
        try {
            isCorrectNameSize(name);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            RacingGame racingGame = new RacingGame();
            racingGame.inputAll();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        int randomNum = RandomUtil.pickNumberInRange(RANDOM_START, RANDOM_END);
        if (THRESHOLD <= randomNum) {
            position++;
        }
    }

    private void isCorrectNameSize(String name) {
        if (NAME_MAX_SIZE < name.length()) {
            throw new IllegalArgumentException("자동차 이름의 길이가 5를 초과했습니다!");
        }
    }

    @Override
    public String toString() {
        return name + " : " + position;
    }
}
