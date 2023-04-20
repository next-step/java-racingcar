package racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(String inputCarNames) {
        cars = new ArrayList<>();
        for (String carName : splitCarNames(inputCarNames)) {
            add(carName);
        }
    }

    private String[] splitCarNames(String inputCarNames) {
        return inputCarNames.split(",");
    }

    private void add(String name){
        cars.add(new Car(name));
    }

    public int count() {
        return cars.size();
    }

    public Car findOne(int carIndex) {
        return cars.get(carIndex);
    }

    public String findOneName(int carIndex) {
        return cars.get(carIndex).getName();
    }

    public int findOneMoveStatus(int carIndex) {
        return cars.get(carIndex).getMoveStatus();
    }

    public boolean isWinner(int carIndex, int maxMoveStatus) {
        return maxMoveStatus <= findOneMoveStatus(carIndex);
    }

    public boolean isSharedWinner(int carIndex, int maxMoveStatus) {
        return maxMoveStatus == findOneMoveStatus(carIndex);
    }
}
