package step4racinggamewinner;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private Cars cars;
    private List<String> winnerNameList = new ArrayList<>();

    public Winners(Cars cars) {
        this.cars = cars;

    }

    public List<String> findWinner() {
        List<Integer> currentCarPositionList = cars.currentCarPositionList();
        Car baseLineCar = this.cars.baseLineCar();
        winnerNameList.add(baseLineCar.carName());
        int baseLinePosition = baseLineCar.currentPosition();

        for (int carIndex = 1; carIndex < currentCarPositionList.size(); carIndex++) {
            baseLinePosition = compareCars(baseLinePosition, cars.currentCar(carIndex));
        }
        return winnerNameList;
    }

    private int compareCars(int baseLinePosition, Car currentCar) {
        int resultPosition = baseLinePosition;
        int currentCarPosition = currentCar.currentPosition();
        String currentCarName = currentCar.carName();

        if (baseLinePosition < currentCarPosition) {
            winnerNameList.clear();
            winnerNameList.add(currentCarName);
            resultPosition = currentCarPosition;
        } else if (baseLinePosition == currentCarPosition) {
            winnerNameList.add(currentCarName);
        }
        return resultPosition;
    }
}
