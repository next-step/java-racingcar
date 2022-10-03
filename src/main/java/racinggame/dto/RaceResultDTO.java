package racinggame.dto;

import racinggame.domain.RoundSnapshot;

import java.util.ArrayList;
import java.util.List;

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

    public void addWinners(List<WinCarsDTO> winners) {
        this.winners = winners;
    }
}
