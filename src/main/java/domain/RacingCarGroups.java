package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingCarGroups {
    private final List<RacingCar> racingCars;

    public RacingCarGroups(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public void move() {
        for(int i = 0; i < racingCars.size(); i++) {
            racingCars.get(i).move(new GoStraightBehavior());
        }
    }

    public List<CarName> findWinners() {
        return collectWinners(getMaxDistance());
    }

    private int getMaxDistance() {
        int max = 0;
        for (int i = 0; i < racingCars.size(); i++) {
            max = Math.max(racingCars.get(i).getCarDistance().getDistance(), max);
        }
        return max;
    }

    private List<CarName> collectWinners(int condition) {
        List<CarName> winners = new ArrayList<>();
        for (int i = 0; i< racingCars.size(); i++) {
            addWinner(winners, racingCars.get(i), condition);
        }
        return winners;
    }

    private void addWinner(List<CarName> winners, RacingCar car, int condition) {
        if (isWinner(car.getCarDistance().getDistance(), condition)) {
            winners.add(car.getCarName());
        }
    }

    private boolean isWinner(int distance, int condition) {
        return distance == condition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCarGroups that = (RacingCarGroups) o;
        return Objects.equals(racingCars, that.racingCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCars);
    }
}
