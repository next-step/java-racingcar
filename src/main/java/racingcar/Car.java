package racingcar;


import java.util.Random;

public class Car {

    private static final int MAX_RANDOM_NUMBER = 10;
    private static final int MOVE_OR_STOP_BOUNDARY = 4;

    public static final Random RANDOM = new Random();
    private Integer distance = 0;
    private Integer playCount = 0;

    public Integer getDistance() {
        return distance;
    }

    public Integer getPlayCount() {
        return playCount;
    }

    public Integer play() {
        playCount++;
        if (moveOrStop()) {
            distance++;
        }
        return getDistance();
    }

    private boolean moveOrStop() {
        return RANDOM.nextInt(MAX_RANDOM_NUMBER) >= MOVE_OR_STOP_BOUNDARY;
    }
}