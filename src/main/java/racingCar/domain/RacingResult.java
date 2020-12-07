package racingCar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class RacingResult {
    private static final int SAME_SCORE = 0;
    private static final int CHANGE_WINNER = -1;
    private List<Car> cars;
    private List<Car> winningCars;

    public RacingResult(List<Car> cars) {
        this.cars = cars;
        this.winningCars = new ArrayList<>();
    }

    public void calculateResult() {
        Position maxPosition = cars.stream().max(Car::compareTo).get().getPosition();

        for(Car car : cars) {
            if(maxPosition.equals(car.getPosition())) {
                winningCars.add(car);
            }
        }
    }

    @Override
    public String toString() {
        String winners = "";
        for(Car car : winningCars) {
            winners += car.getName() +", ";
        }
        winners = winners.replaceAll(", $", "");
        return winners +
                "가 최종 우승했습니다.";
    }
}
