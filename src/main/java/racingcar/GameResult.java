package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private List<RoundResult> result = new ArrayList<>();

    public void input(final RoundResult roundResult) {
        result.add(roundResult);
    }

    public List<RoundResult> getResult() {
        return result;
    }
}
