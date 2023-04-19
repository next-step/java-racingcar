package racingcar;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        List<String> frontRunnerNames = new ArrayList<>();
        int maxPosition = getMaxPosition();
        for (Car car: this.carList){
            if (car.getPosition() != maxPosition) continue;
            frontRunnerNames.add(car.getName());
        }
        return frontRunnerNames;
    }

    private int getMaxPosition() {
        return Collections.max(getPositions());
    }

    private List<Integer> getPositions() {
        List<Integer>  positions = new ArrayList<>();
        for (Car car: carList) {
            positions.add(car.getPosition());
        }
        return positions;
    }
}
