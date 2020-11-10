package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingResult {
    private List<Map<String, Integer>> movingHistoryByTry = new ArrayList<>();
    private List<String> winners = new ArrayList<>();

    public List<Map<String, Integer>> getMovingHistoryByTry() {
        return movingHistoryByTry;
    }

    public List<String> getWinners() {
        return winners;
    }

    public void clear() {
        movingHistoryByTry.clear();
        winners.clear();
    }

    public void addMovingHistoryByTry(Map<String, Integer> resultMap) {
        movingHistoryByTry.add(resultMap);
    }

    public void setWinners(List<String> winners) {
        this.winners = winners;
    }
}
