package car;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    private List<Car> cars;
    private int max;

    public CarRacing(List<Car> cars) {
        this.cars = cars;
        this.max = Integer.MIN_VALUE;
    }

    public void play(int attemptNumber) {
        for (int i = 0; i < attemptNumber; i++) {
            racing();
        }
    }

    private void racing() {
        for (Car car : cars) {
            car.move(Dice.roll());
            car.print();
        }
        System.out.println();
    }

    public List<Car> finish() {
        int max = getMaxDistance();
        List<Car> winners = getWinners();

        for (Car winner : winners) {
            System.out.print(winner.getName() + " ");
        }
        System.out.println("최종 우승했습니다.");

        return winners;
    }
    private int getMaxDistance() {
        for (Car car : cars) {
            replaceMaxValue(car);
        }

        return this.max;
    }

    private void replaceMaxValue(Car car) {
        if (this.max < car.getDistance()) {
            this.max = car.getDistance();
        }
    }

    private List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            getWinner(winners, car);
        }

        return winners;
    }

    private void getWinner(List<Car> winners, Car car) {
        if (this.max == car.getDistance()) {
            winners.add(car);
        }
    }
}


