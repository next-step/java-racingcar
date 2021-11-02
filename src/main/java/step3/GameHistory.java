package step3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameHistory {
    private final Map<Long, List<Long>> history = new HashMap<>();

    public void save(Long now, List<Long> tempHistory) {
        List<Long> saveHistory = new ArrayList<>();
        tempHistory.stream()
                .forEach(saveHistory::add);
        history.put(now, saveHistory);
    }

    public List<Long> getHistory(Long time) {
        isValid(time);
        List<Long> saveHistory = history.get(time);
        List<Long> returnHistory = new ArrayList<>();
        saveHistory.stream()
                .forEach(returnHistory::add);
        return returnHistory;
    }

    private void isValid(Long time) {
        if(!history.containsKey(time)) {
            throw new IllegalArgumentException("history가 존재하지 않습니다.");
        }
    }
}
