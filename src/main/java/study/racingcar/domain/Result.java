package study.racingcar.domain;

public class Result {
    private final Winners winners;
    private final GameCars cars;

    private int maxLength = Integer.MIN_VALUE;

    public Result(GameCars cars) {
        this.winners = new Winners();
        this.cars = cars;
    }

    public String winners() {
        setMaxLength();
        setWinner();
        return winners.toString();
    }

    private void setMaxLength() {
        cars.forEach(this::compareCarLength);
    }

    private void compareCarLength(Car car) {
        if (car.length() >= maxLength) {
            maxLength = car.length();
        }
    }

    private void setWinner() {
        cars.forEach(this::addWinner);
    }

    private void addWinner(Car car) {
        if (car.length() == maxLength) {
            winners.add(car);
        }
    }
}
