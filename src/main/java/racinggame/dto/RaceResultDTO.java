package racinggame.dto;

import racinggame.domain.Car;
import racinggame.domain.RoundSnapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by seungwoo.song on 2022-09-26
 */
public class RaceResultDTO {

    private List<RoundSnapshot> roundSnapshots = new ArrayList<>();
    private List<Car> winners;

    public List<RoundSnapshot> getRoundSnapshots() {
        return roundSnapshots;
    }

    public void addRoundSnapshot(RoundSnapshot roundSnapshot) {
        roundSnapshots.add(roundSnapshot);
    }

    public List<Car> getWinners() {
        return winners;
    }

    public void addWinners(List<Car> winners) {
        this.winners = winners;
    }
}
