package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RoundResult {

    private List<Integer> result = new ArrayList<>();

    public void input(final Integer position) {
        result.add(position);
    }

    public List<Integer> getResult() {
        return result;
    }
}
