package racingcar.game;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        List<Integer> progressList = history.keySet()
                .stream()
                .map(history::get)
                .sorted(Comparator.comparing(Integer::valueOf))
                .collect(Collectors.toList());

        return progressList.get(progressList.size()-1);
    }


    public String getWinner() {
        Map<String, Integer> lastHistory = histories.get(currentRound());
        Integer maxProgress = getMaxProgress(lastHistory);
        List<String> winners = lastHistory.keySet()
                .stream()
                .filter((name) -> lastHistory.get(name) >= maxProgress)
                .collect(Collectors.toList());

        return String.join(",", winners);
    }
}
