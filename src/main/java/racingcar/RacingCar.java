package racingcar;

// 자동차의 움직임을 관여한다.

import java.util.Random;

public class RacingCar {

    private static final int MINIMUM_NUMBER = 4;

    private static Random random = new Random();
    private Car car;


    public RacingCar(Car car) {
        this.car = car;
    }

    public void move() {
        car.setLocation(isGo(random()));
    }

    public String status() {
        return car.getLocation();
    }

    public String isGo(int number) {
        if (number >= MINIMUM_NUMBER) return "-";
        return "";
    }

    public int random() {
        return random.nextInt(10);
    }
}
