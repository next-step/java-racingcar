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

        Integer maxPosition = findMaxPosition(raceResult);
        return findWinners(raceResult, maxPosition);
    }

    private List<String> findWinners(List<RacingCarCurrentStatus> raceResult, Integer maxPosition) {
        List<String> winners = new ArrayList<>();
        for (RacingCarCurrentStatus car : raceResult) {
            addIfWinner(car, maxPosition, winners);
        }
        return winners;
    }

    private void addIfWinner(RacingCarCurrentStatus car, Integer maxPosition, List<String> winners) {
        if (maxPosition.equals(car.position())) {
            winners.add(car.name());
        }
    }

    private Integer findMaxPosition(List<RacingCarCurrentStatus> raceResult) {
        int maxPosition = 0;
        for (RacingCarCurrentStatus car : raceResult) {
            maxPosition = updateMaxPosition(car, maxPosition);
        }
        return maxPosition;
    }

    private Integer updateMaxPosition(RacingCarCurrentStatus car, int maxPosition) {
        if (car.position() > maxPosition) {
            maxPosition = car.position();
        }
        return maxPosition;
    }
}
