package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGameResult {
    private final List<RoundResult> roundResult;

    public RacingGameResult() {
        this.roundResult = new ArrayList<>();
    }

    public void addRoundResult(RoundResult roundResult) {
        this.roundResult.add(roundResult);
    }

    public List<RoundResult> getAllRoundResults() {
        return roundResult;
    }

    public RoundResult getLastRoundResult() {
        return roundResult.get(roundResult.size() - 1);
    }

    public List<String> whoAreWinners() {
        RoundResult lastRoundResult = getLastRoundResult();
        List<RacingCarCurrentStatus> raceResult = lastRoundResult.getRaceProgress();

         Position maxPosition = findMaxPosition(raceResult);
        return findWinners(raceResult, maxPosition);
    }

    private List<String> findWinners(List<RacingCarCurrentStatus> raceResult, Position maxPosition) {
        List<String> winners = new ArrayList<>();
        for (RacingCarCurrentStatus car : raceResult) {
            addIfWinner(car, maxPosition, winners);
        }
        return winners;
    }

    private void addIfWinner(RacingCarCurrentStatus carStatus, Position maxPosition, List<String> winners) {
        if (carStatus.hasSamePositionWith(maxPosition)) {
            winners.add(carStatus.name());
        }
    }

    private Position findMaxPosition(List<RacingCarCurrentStatus> raceResult) {
        Position maxPosition = new Position(0);
        for (RacingCarCurrentStatus car : raceResult) {
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
}
