package step2.racing.dto;

import java.util.Map;

public class CarPosition {

    private Map<Integer, Integer> carNumberPositions;

    public CarPosition(Map<Integer, Integer> carNumberPositions) {

        this.carNumberPositions = carNumberPositions;
    }

    public int getPosition(int carNumber) {

        return carNumberPositions.get(carNumber);
    }

    public int sizeOfCars() {

        return carNumberPositions.keySet().size();
    }

}
