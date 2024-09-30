package racingcar;

import java.util.Random;

public class Car {
    private static final int RANDOM_SIZE = 10;
    private int distance = 0;
    private String carName = "";

    public Car(String carName) {
        this.carName = carName;
    }


    public void goCar() {
        setGoCar(getRandomNum());
    }

    private int getRandomNum() {
        Random random = new Random();
        return random.nextInt(RANDOM_SIZE);
    }

    public void setGoCar(int randomNum) {
        if (randomNum >= 4) {
            distance += 1;
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getCarName(){
        return carName;
    }
}
