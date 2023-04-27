package domain.cars;

import java.util.ArrayList;
import java.util.List;

import domain.request.RacingCarNameRequest;

public class RacingCars {
    private List<RacingCar> racingCars;

    public RacingCars(RacingCarNameRequest request) {
        this.racingCars = new ArrayList<>();
        for (String racingCarName : request.getNameList()) {
            RacingCar car = new RacingCar(racingCarName);
            racingCars.add(car);
        }
    }

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public void race(MovingStrategy movingStrategy) {
        for (RacingCar racingCar : racingCars) {
            racingCar.moveOrStop(movingStrategy);
        }
    }

    public String[] getResultOfEachCar() {
        String[] result = new String[racingCars.size()];
        for (int i = 0; i < racingCars.size(); i++) {
            result[i] = racingCars.get(i).getResult();
        }
        return result;
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
