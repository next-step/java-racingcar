package racingcar;

// 자동차의 움직임을 관여한다.

import java.util.Random;

public class RacingCar {

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
        if (number >= 4) return "-";
        return "";
    }

    public int random() {
        Random random = new Random();
        int value = random.nextInt(10);

        return value;
    }
}
