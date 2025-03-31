package domain;

import view.RoundResultFormatter;

import java.util.ArrayList;
import java.util.List;

public class RoundResult {
    List<RacingCarCurrentStatus> raceProgress;

    public RoundResult(RacingCars cars) {
        this.raceProgress = cars.listCurrentRacingCarStatuses();
    }

    public List<String> findWinners() {
        List<String> winners = new ArrayList<>();
        for (RacingCarCurrentStatus car : raceProgress) {
            addIfWinner(car, findMaxPosition(), winners);
        }
        return winners;
    }

    public RoundResultFormatter generateFormatter() {
        return new RoundResultFormatter(raceProgress);
    }

    private Position findMaxPosition() {
        Position maxPosition = new Position(0);
        for (RacingCarCurrentStatus car : raceProgress) {
            maxPosition = updateMaxPosition(car, maxPosition);
        }
        return maxPosition;
    }

    private Position updateMaxPosition(RacingCarCurrentStatus carStatus, Position maxPosition) {
        if (carStatus.isAheadOf(maxPosition)) {
            maxPosition = carStatus.position();
        }
        return maxPosition;
    }

    private void addIfWinner(RacingCarCurrentStatus carStatus, Position maxPosition, List<String> winners) {
        if (carStatus.isSameOf(maxPosition)) {
            winners.add(carStatus.name());
        }
    }
}
