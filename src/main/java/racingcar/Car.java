package racingcar;


import java.util.Random;

public class Car {

    public static final Random RANDOM = new Random();
    private static final int MOVE_PROBABILITY = 4;
    private static int TOTAL_PROBABILITY = 10;
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
        if (moveForwardOrNot()) {
            distance++;
        }
        return getDistance();
    }

    private static boolean moveForwardOrNot() {
        return RANDOM.nextInt(TOTAL_PROBABILITY) >= MOVE_PROBABILITY;
    }
}
