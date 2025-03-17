package racingcar;


import java.util.Random;

public class Car {

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

    private static boolean moveOrStop() {
        return RANDOM.nextInt(10) >= 4;
    }
}