package racingcar;

import java.util.Random;

public class Car {
    //이동기능, 이동거리 기록
    private static final int RULE_COUNT = 10;
    private static final int RUNNABLE_RULE_COUNT = 3;

    private int movingDistance = 0;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMovingDistance() {
        return movingDistance;
    }

    public boolean isHighScore(int highScore) {
        return this.movingDistance == highScore;
    }

    public boolean compareToHighScore(int highScore) {
        return this.movingDistance > highScore;
    }


    public void move() {
        int randomValue = getRandomValue();
        moveCar(randomValue);
    }

    public void moveCar(int randomValue) {
        if (randomValue > RUNNABLE_RULE_COUNT) {
            movingDistance++;
        }
    }

    private int getRandomValue() {
        return new Random().nextInt(RULE_COUNT);
    }
}
