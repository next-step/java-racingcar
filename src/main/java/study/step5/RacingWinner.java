package study.step5;

import java.util.ArrayList;
import java.util.List;

import study.step5.domain.Car;

public class RacingWinner {
    private List<String> winnerNames = new ArrayList<>();

    public List<String> getWinnerNames() {
        return winnerNames;
    }

    public void determineWinners(List<Car> carList) {
        int winnerPosition = maxPosition(carList);
        carList.forEach(car -> addWinnerNames(car, winnerPosition));
    }

    private int maxPosition(List<Car> carList) {
        int winnerPosition = carList.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(-1);
        return winnerPosition;
    }

    private void addWinnerNames(Car car, int maxPosition) {
        if(isMaxValue(car.getPosition(), maxPosition)) {
            winnerNames.add(car.getName());
        }
    }

    public boolean isMaxValue(int a, int b) {
        return a == b;
    }
}
