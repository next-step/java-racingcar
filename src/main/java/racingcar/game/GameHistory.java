package racingcar.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameHistory {
    private Map<Integer, Map<String, Integer>> histories = new HashMap<>();

    public GameHistory() {
    }

    public GameHistory(Map<Integer, Map<String, Integer>> histories) {
        this.histories = histories;
    }

    public Map<Integer, Map<String, Integer>> getHistoryAll() {
        return histories;
    }

    public Map<String, Integer> getHistoryOne(int round) {
        if (histories.size() < round) {
            throw new IllegalArgumentException();
        }
        return histories.get(round);
    }

    public Map<String,Integer> addHistory(int round, Map<String, Integer> result) {
        histories.put(round, result);
        return histories.get(round);
    }

    public int currentRound() {
        return histories.size();
    }

    private Integer getMaxProgress(Map<String, Integer> history) {
        int maxProgress = 0;
        for (Integer value : history.values()) {
            if (maxProgress < value) {
                maxProgress = value;
            }
        }
        return maxProgress;
    }

    public String getWinner() {
        List<String> winners = new ArrayList<>();
        Map<String, Integer> lastHistory = histories.get(currentRound());
        Integer maxProgress = getMaxProgress(lastHistory);
        lastHistory.forEach((name, progress)->{
            if (maxProgress <= progress) {
                winners.add(name);
            }
        });
        return String.join(",", winners);
    }
}
