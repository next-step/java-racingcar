package racingCar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {
    private static final int SAME_SCORE = 0;
    private static final int CHANGE_WINNER = -1;
    private List<Car> cars;
    List<Car> winningCars = new ArrayList<>();

    public RacingResult(List<Car> cars) {
        this.cars = cars;
    }

    public void getWinners() {
        winningCars.add(cars.get(0));
        for(int i = 1; i < cars.size(); i++) {
            compareCars(winningCars, cars.get(i));
        }
    }

    private void compareCars(List<Car> winningCars, Car car) {
        Car winnerCar = winningCars.get(0);
        int result = winnerCar.compareTo(car);

        if(result == SAME_SCORE) {
            winningCars.add(car);
        }
        if(result == CHANGE_WINNER) {
            winningCars.clear();
            winningCars.add(car);
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
