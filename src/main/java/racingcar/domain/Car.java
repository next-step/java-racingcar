package racingcar.domain;

public class Car {
    //이동기능, 이동거리 기록
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

    public int compareToHighScore(int highScore) {
        return movingDistance > highScore ? movingDistance : highScore;
    }


    public void move(int randomNumValue) {
        if (randomNumValue > RUNNABLE_RULE_COUNT) {
            movingDistance++;
        }
    }
}
