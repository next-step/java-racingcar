package racingcar.domain;

import java.util.*;

public class RacingFleet {
    private final List<RacingCar> racingCars;

    private RacingFleet(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public static RacingFleet valueOf(List<String> carNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (int carNumber = 0; carNumber < carNames.size(); carNumber++) {
            racingCars.add(RacingCar.valueOf(carNames.get(carNumber), carNumber));
        }
        return new RacingFleet(racingCars);
    }

    public List<RacingCar> getRacingCars() {
        return this.racingCars;
    }

    public List<RacingCar> findWinners() {
        int topDistance = findTopDistance();
        return findCarNamesWithDistance(topDistance);
    }

    private int findTopDistance() {
        return Collections.max(this.racingCars, Comparator.comparingInt(RacingCar::getPosition)).getPosition();
    }

    private List<RacingCar> findCarNamesWithDistance(int distance) {
        List<RacingCar> carsWithDistance = new ArrayList<>();
        for (RacingCar car : this.racingCars) {
            updateCarsWithDistance(distance, car, carsWithDistance);
        }
        return carsWithDistance;
    }

    private void updateCarsWithDistance(int distance, RacingCar car, List<RacingCar> carsWithDistance) {
        if (car.isSamePosition(distance)) {
            carsWithDistance.add(car);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingFleet that = (RacingFleet) o;
        return Objects.equals(this.racingCars, that.racingCars);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.racingCars);
    }
}
