package racingcar.car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NextStepCars {
    private List<Car> nextStepCars;

    public NextStepCars(List<Car> nextStepCars) {
        this.nextStepCars = nextStepCars;
    }

    public NextStepCars(String carList) {
        nextStepCars = new ArrayList<>();
        for(String car : carList.split(",")) {
            nextStepCars.add(new NextStepCar(car));
        }
    }

    public List<Car> getNextStepCars() {
        return nextStepCars;
    }

    public int carCount() {
        return nextStepCars.size();
    }

    public List<String> getWinner() {
        int winnerPosition = 0;
        for(Car car : this.nextStepCars) {
            winnerPosition = Math.max(winnerPosition, car.getPosition().getPosition());
        }
        int finalWinnerPosition = winnerPosition;
        List<String> collect = this.nextStepCars.stream()
                .filter(car -> car.getPosition().getPosition() == finalWinnerPosition)
                .map(car -> car.getName())
                .collect(Collectors.toList());
        return collect;
    }
}
