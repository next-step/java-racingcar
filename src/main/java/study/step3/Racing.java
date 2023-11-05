package study.step3;

import java.util.ArrayList;
import java.util.List;

import static study.step3.InputView.loadRule;

public class Racing {

    private final List<Car> cars;
    private final int movingTimes;

    public Racing(List<Car> cars, int movingTimes) {
        this.cars = cars;
        this.movingTimes = movingTimes;
    }

    public static void start() {
        run(prepare());
    }

    private static Racing prepare() {
        Rule rule = loadRule();
        return setUpRacing(rule);
    }

    private static Racing setUpRacing(Rule rule) {
        List<Car> inReadyCars = new ArrayList<>();
        for (int i = 0; i < rule.getNumberOfCars(); i++) {
            inReadyCars.add(new Car());
        }
        return new Racing(inReadyCars, rule.getMovingTimes());
    }

    private static void run(Racing racing) {
        for (int i = 0; i < racing.getMovingTimes(); i++) {
            List<Car> cars = racing.getCars();
            move(cars);
        }
    }

    private static void move(List<Car> cars) {
        for (Car car: cars) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMovingTimes() {
        return movingTimes;
    }

}
