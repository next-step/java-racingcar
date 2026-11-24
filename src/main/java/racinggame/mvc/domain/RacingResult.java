package racinggame.mvc.domain;

import java.util.List;

public class RacingResult {

    private final List<Car> racers;
    private final List<Car> winners;

    public RacingResult(List<Car> racers, List<Car> winners) {
        this.racers = racers;
        this.winners = winners;
    }

    public List<Car> getRacers() {
        return racers;
    }

    public List<Car> getWinners() {
        return winners;
    }
}
