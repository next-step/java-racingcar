package racing;

import java.util.Random;

public class Car {
    private static final int MAX_LENGTH_NAME = 5;
    private static final int DEFAULT_DISTANCE = 0;
    private static final  int MIN_MOVE_VALUE = 4;
    private int distance;
    private String carName;

    Car(String name) {
        this(name, DEFAULT_DISTANCE);
    }

    Car(String name, int distance) {
        if (name.length() > MAX_LENGTH_NAME) {
            throw new IllegalArgumentException("자동차 이름은 "+ MAX_LENGTH_NAME +"글자를 초과할 수 없습니다.");
        }

        this.carName = name;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public String getCarName() {
        return this.carName;
    }

    void carRun(int randomNumber) {
        if(randomNumber >= MIN_MOVE_VALUE) {
            ++this.distance;
        }
    }

    String statusPrint() {
        String resultText = this.carName + " : " + this.distance;
        System.out.println(resultText);
        return resultText;
    }
}
