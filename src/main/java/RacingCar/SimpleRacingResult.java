package RacingCar;

import java.util.HashMap;

public class SimpleRacingResult implements RacingResult {
    public SimpleRacingResult(int numberOfCars) {
        this.numberOfCars = numberOfCars;
        distances = new HashMap<>();
        for (int i = 0; i < numberOfCars; i++) {
            distances.put(i, 0);
        }
    }

    public void increaseDistance(int carIndex) {
        int distance = distances.get(carIndex);
        distances.put(carIndex, distance + 1);
    }

    @Override
    public int getDistance(int carIndex) {
        return distances.get(carIndex);
    }

    @Override
    public int getNumberOfCars() {
        return numberOfCars;
    }


    private int numberOfCars;
    private HashMap<Integer, Integer> distances;
}
