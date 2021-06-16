package racingcargame.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCarHistory {
    private List<String> history;

    public RacingCarHistory() {
        this.history = new ArrayList<>();
        this.history.add("\n실행 결과");
    }

    public void addHistory(List<String> historys) {
        for (String history : historys) {
            this.history.add(history);
        }
    }

    public List<String> getHistory() {
        return history;
    }
}
