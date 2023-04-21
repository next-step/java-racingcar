package study.racingcar.domain;

public class Result {
    private final Winners winners;
    private final GameCars cars;

    private int maxPosition = Integer.MIN_VALUE;

    public Result(GameCars cars) {
        this.winners = new Winners();
        this.cars = cars;
    }

    public Winners winners() {
        setMaxPosition();
        setWinner();
        return winners;
    }

    private void setMaxPosition() {
        cars.forEach(this::comparePosition);
    }

    private void comparePosition(Car car) {
        if (car.getPosition() >= maxPosition) {
            maxPosition = car.getPosition();
        }
    }

    private void setWinner() {
        cars.forEach(this::addWinner);
    }

    private void addWinner(Car car) {
        if (car.getPosition() == maxPosition) {
            winners.add(car);
        }
    }
}
