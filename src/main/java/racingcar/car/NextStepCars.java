package racingcar.car;

import java.util.List;
import java.util.stream.Collectors;

public class NextStepCars {
    private final List<Car> nextStepCars;

    public NextStepCars(List<Car> nextStepCars) {
        this.nextStepCars = nextStepCars;
    }

    public List<Car> getNextStepCars() {
        return nextStepCars;
    }

    public int carCount() {
        return nextStepCars.size();
    }

    public List<Car> getWinner() {
        int winnerPosition = 0;
        for(Car car : this.nextStepCars) {
            winnerPosition = Math.max(winnerPosition, car.getPosition());
        }
        int finalWinnerPosition = winnerPosition;
        List<Car> collect = this.nextStepCars.stream()
                .filter(car -> car.getPosition() == finalWinnerPosition)
                .collect(Collectors.toList());
        return collect;
    }
}
