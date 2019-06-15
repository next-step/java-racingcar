package step2.racing.dto;

import java.util.Map;

public class CarPosition {

    private Map<Integer, Integer> carNumberPositionMap;

    public CarPosition(Map<Integer, Integer> carNumberPositionMap) {

        this.carNumberPositionMap = carNumberPositionMap;
    }

    public int getPosition(int carNumber) {

        return carNumberPositionMap.get(carNumber);
    }

    public int sizeOfCars() {

        return carNumberPositionMap.keySet().size();
    }

}
