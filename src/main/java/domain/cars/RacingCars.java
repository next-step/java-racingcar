package domain.cars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.request.RacingCarNameRequest;

public class RacingCars {
    private List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public static RacingCars of(RacingCarNameRequest request) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (String racingCarName : request.getNameList()) {
            RacingCar car = new RacingCar(racingCarName);
            racingCarList.add(car);
        }
        return new RacingCars(racingCarList);
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public void race(MovingStrategy movingStrategy) {
        for (RacingCar racingCar : racingCars) {
            racingCar.moveOrStop(movingStrategy);
        }
    }

    public Map<String, Integer> getResultOfEachCar() {
        Map<String, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < racingCars.size(); i++) {
            resultMap.put(racingCars.get(i).getName(), racingCars.get(i).getDistance());
        }
        return resultMap;
    }

    private int[] getDistancesOfRacingCars() {
        int[] distances = new int[racingCars.size()];
        for (int i = 0; i < racingCars.size(); i++) {
            distances[i] = racingCars.get(i).getDistance();
        }
        return distances;
    }

    public int getMaxDistance() {
        int maxDistance = 0;
        for (int distance : getDistancesOfRacingCars()) {
            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }
        return maxDistance;
    }

}
