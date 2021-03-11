package study.step4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import study.step4.model.Car;
import study.step4.model.Movement;

/**
 * Racing Game Class
 *
 * 자동차 경주 클래스
 *
 */
public class Racing {
    private List<Car> carList;
    private Movement movement;

    public Racing() {
        carList = new ArrayList<>();
        movement = new Movement();
    }

    public void setUp(String[] names) {
        IntStream.range(0, names.length).forEach(i -> carList.add(new Car(names[i])));
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public void run() {
        carList.forEach(car -> car.move(movement.stopAndMove()));
    }

    public void printRacingResult(String printToken) {
    }
}
