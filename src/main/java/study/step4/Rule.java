package study.step4;

import java.util.List;

import study.step4.exception.RacingException;


public class Rule {

    private final List<Car> cars;
    private final int movingTimes;

    public Rule(List<Car> cars, int movingTimes) {
        validate(cars, movingTimes);
        this.cars = cars;
        this.movingTimes = movingTimes;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMovingTimes() {
        return movingTimes;
    }

    private static void validate(List<Car> cars, int movingTimes) {
        if (!isValidNumberOfCars(cars)) {
            throw new RacingException("RuleValidationError: 자동차 대수는 2대 이상이여야 합니다.");
        }
        if (!isValidMovingTimes(movingTimes)) {
            throw new RacingException("RuleValidationError: 시도 회수는 최소 1회 이상이어야 합니다.");
        }
    }

    private static boolean isValidNumberOfCars(List<Car> cars) {
        return cars.size() >= 2;
    }

    private static boolean isValidMovingTimes(int movingTimes) {
        return movingTimes >= 1;
    }

}
