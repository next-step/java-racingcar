package racing.model;

import racing.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void add(Car car) {
        cars.add(car);
    }

    public List<Car> getWinners() {
        int winnerPosition = getWinnerPosition();
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == winnerPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    public int size() {
        return cars.size();
    }

    private void CarMoveProcess(Car car) {
        if (car.canMove(RandomGenerator.generate())) {
            car.move();
        }
    }

    public void race() {
        for (Car car : cars) {
            CarMoveProcess(car);
        }
    }

    public int getWinnerPosition() {
        int winnerPosition = 0;
        for (Car car : cars) {
            winnerPosition = car.getPosition() > winnerPosition ? car.getPosition() : winnerPosition;
        }
        return winnerPosition;
    }

    public List<String> getLapTime() {
        ArrayList<String> lapTimes = new ArrayList<>();
        for (Car car : cars) {
            lapTimes.add(car.getSkidMark());
        }
        lapTimes.add("");
        return lapTimes;
    }
}
