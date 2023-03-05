package racing;

import java.util.Random;

public class Car {
    private int distance;
    private String carName;

    Car(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }

        this.carName = name;
    }

    Car(String name, int distance) {
        this(name);
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public String getCarName() {
        return carName;
    }

    void carRacing() {
        carRun();
        statusPrint();
    }

    void carRun() {
        if((int) (Math.random() * 10) < 4) {
            return;
        }

        ++this.distance;
    }

    String statusPrint() {
        String resultText = this.carName + " : " + this.distance;
        System.out.println(resultText);
        return resultText;
    }
}
