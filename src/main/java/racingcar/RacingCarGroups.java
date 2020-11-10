package racingcar;

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

    public List<String> findWinners(int condition) {
        List<String> winners = new ArrayList<>();
        for (int i = 0; i< racingCars.size(); i++) {
            racingCars.get(i).isWinner(winners, condition);
        }
        return winners;
    }

    public int getMaxDistance() {
        int max = racingCars.get(0).getDistance();
        for (int i = 1; i < racingCars.size(); i++) {
            max = Math.max(racingCars.get(i).getDistance(), max);
        }
        return max;
    }
}
