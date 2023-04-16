package racing.domain;

import racing.rule.RacingRule;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList;
    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public List<Integer> valueOfCarsPosition() {
        List<Integer> currentPositions = new ArrayList<>();
        for (Car car : carList) {
            currentPositions.add(car.valueOfCurrentPosition());
        }
        return currentPositions;
//        return carList.stream().map(Car::valueOfCurrentPosition)
//                .collect(Collectors.toList());
    }

    public RoundResult race(RacingRule racingRule) {
        List<Integer> result = new ArrayList<>();
        for (Car car : carList) {
            result.add(car.race(racingRule.generateNumber()));
        }
        return new RoundResult(result);
    }

    public int countTotalCar() {
        return carList.size();
    }
}
