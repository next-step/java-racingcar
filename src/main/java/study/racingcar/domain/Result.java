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
        for (Car car : cars) {
            compareCarLength(car);
        }
    }

    private void compareCarLength(Car car) {
        if (car.length() >= maxLength) {
            maxLength = car.length();
        }
    }

    private void setWinner() {
        for (Car car : cars) {
            addWinners(car);
        }
    }

    private void addWinners(Car car) {
        if (car.length() == maxLength) {
            winners.add(car);
        }
    }
}
