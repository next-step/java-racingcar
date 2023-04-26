package racingcar;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class CarCollection {
    private List<Car> carList;

    public CarCollection(List<String> carNames, MoveStrategy moveStrategy) {
        this.carList = new ArrayList<>();
        for (String carName: carNames) {
            carList.add(new Car(moveStrategy, carName));
        }
    }

    public void tryMove() {
        for (Car car: this.carList){
            car.tryMove();
        }
    }

    public List<CarScore> getCarScores() {
        List<CarScore> carScores = new ArrayList<>();
        for (Car car: this.carList){
            carScores.add(new CarScore(car.getName(), car.getPosition()));
        }
        return carScores;
    }

    public List<String> getFrontRunnerNames() {
        int maxPosition = getMaxPosition();

        List<String> frontRunnerNames = carList.stream()
                        .filter(i -> i.isAt(maxPosition))
                        .map(Car::getName)
                        .collect(Collectors.toList());

        return frontRunnerNames;
    }

    private int getMaxPosition() {
        return Collections.max(carList).getPosition();
    }
}
