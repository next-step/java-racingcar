package domain;

import java.util.ArrayList;
import java.util.List;

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

    public List<String> findWinners() {
        return collectWinners(getMaxDistance());
    }

    private int getMaxDistance() {
        int max = racingCars.get(0).getDistance();
        for (int i = 1; i < racingCars.size(); i++) {
            max = Math.max(racingCars.get(i).getDistance(), max);
        }
        return max;
    }


    private List<String> collectWinners(int condition) {
        List<String> winners = new ArrayList<>();
        for (int i = 0; i< racingCars.size(); i++) {
            addWinner(winners, racingCars.get(i), condition);
        }
        return winners;
    }

    private void addWinner(List<String> winners, RacingCar car, int condition) {
        if (isWinner(car.getDistance(), condition)) {
            winners.add(car.getName());
        }
    }

    private boolean isWinner(int distance, int condition) {
        return distance == condition;
    }
}
