package racing;

import java.util.Random;

public class Car {
    private int distance;
    private String carName;

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        if(carName.length() > 5) {
            System.out.println("자동차 이름은 5글자를 초과할 수 없습니다.");
            throw new IllegalArgumentException();
        }

        this.carName = carName;
    }

    void carRacing() {
        carRun();
        statusPrint();
    }

    int carRun() {
        int distance = (int) (Math.random() * 10);

        if(distance < 4) {
            return 0;
        }

        this.distance += distance;

        return distance;
    }

    String statusPrint() {
        String resultText = this.carName + " : " + this.distance;
        System.out.println(resultText);
        return resultText;
    }
}
