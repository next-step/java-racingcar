package domain.car;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {
    private Cars cars;
    private Max max;

    public CarRacingGame(List<Car> cars) {
        this.cars = new Cars(cars);
        this.max = new Max(Integer.MIN_VALUE);
    }

    public void start(int attemptNumber) {
        cars.play(attemptNumber);
    }

    public List<Car> finish() {
        cars.fixMaxDistance(max);

        List<Car> winners = getWinners();

        for (Car winner : winners) {
            System.out.print(winner.getName() + " ");
        }
        System.out.println("최종 우승했습니다.");

        return winners;
    }

    private List<Car> getWinners() {
        return cars.findWinner(max);
    }

    private void addWinner(List<Car> winners, Car car) {
        if (max.equals(new Max(car.getDistance()))) {
            winners.add(car);
        }

    }
}


