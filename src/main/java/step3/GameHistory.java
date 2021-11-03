package step3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameHistory {
    private final Map<Integer, List<Position>> history = new HashMap<>();

    public void save(Integer now, List<Position> tempHistory) {
        List<Position> saveHistory = new ArrayList<>();
        tempHistory.stream()
                .forEach(saveHistory::add);
        history.put(now, saveHistory);
    }

    public List<Position> getHistory(Integer time) {
        isValid(time);
        List<Position> saveHistory = history.get(time);
        List<Position> returnHistory = new ArrayList<>();
        saveHistory.stream()
                .forEach(returnHistory::add);
        return returnHistory;
    }

    private void isValid(Integer time) {
        if (!history.containsKey(time)) {
            throw new IllegalArgumentException("history가 존재하지 않습니다.");
        }
    }
}
