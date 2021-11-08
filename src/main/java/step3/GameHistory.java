package step3;

import java.util.HashMap;
import java.util.Map;

public class GameHistory {
    private final Map<Integer, Cars> history = new HashMap<>();

    public void save(Integer now, Cars tempHistory) {
        history.put(now, tempHistory);
    }

    public Cars getHistory(Integer time) {
        isValid(time);
        return history.get(time);
    }

    private void isValid(Integer time) {
        if (!history.containsKey(time)) {
            throw new IllegalArgumentException("history가 존재하지 않습니다.");
        }
    }
}
