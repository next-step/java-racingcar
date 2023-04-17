package study.step4;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void startRacing() {
        for (Car car : cars) {
            car.move();
        }
    }

    public int getWinnerPosition() {
        return Collections.max(cars).getPosition();
    }

    public List<Car> getWinners() {
        int winnerPosition = getWinnerPosition();
        List<Car> winners = cars.stream().filter(car -> isWinner(car, winnerPosition)).collect(Collectors.toList());

        return winners;
    }

    private Boolean isWinner(Car car, int winnerPosition) {
        return car.getPosition() == winnerPosition;
    }

    public List<Car> getCars() {
        return cars;
    }
}
