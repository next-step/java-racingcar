package domain.car;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {
    private List<Car> cars;
    private int max;

    public CarRacingGame(List<Car> cars) {
        this.cars = cars;
        this.max = Integer.MIN_VALUE;
    }

    public void start(int attemptNumber) {
        for (Car car : cars) {
            car.play(attemptNumber);
        }
    }

    public List<Car> finish() {
        for (Car car : cars) {
            setMaxDistance(car);
        }

        List<Car> winners = getWinners();

        for (Car winner : winners) {
            System.out.print(winner.getName() + " ");
        }
        System.out.println("최종 우승했습니다.");

        return winners;
    }

    private void setMaxDistance(Car car) {
        if (this.max < car.getDistance()) {
            this.max = car.getDistance();
        }
    }

    private List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            addWinner(winners, car);
        }

        return winners;
    }

    private void addWinner(List<Car> winners, Car car) {
        if (this.max == car.getDistance()) {
            winners.add(car);
        }

    }
}


