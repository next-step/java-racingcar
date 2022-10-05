package racinggame.dto;

import racinggame.domain.RacingCars;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by seungwoo.song on 2022-09-26
 */
public class RaceResultDTO {

    private List<RoundSnapshot> roundSnapshots = new ArrayList<>();
    private List<WinCarsDTO> winners;

    public List<RoundSnapshot> getRoundSnapshots() {
        return roundSnapshots;
    }

    public void addRoundSnapshot(RoundSnapshot roundSnapshot) {
        roundSnapshots.add(roundSnapshot);
    }

    public List<WinCarsDTO> getWinners() {
        return winners;
    }

    public void addWinners(RacingCars cars) {
        winners = toWinCars(cars);
    }

    private List<WinCarsDTO> toWinCars(RacingCars cars) {
        return cars.winners().stream()
                .map(WinCarsDTO::new)
                .collect(Collectors.toList());
    }
}
