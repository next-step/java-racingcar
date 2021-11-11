package racinggame.vo;

import java.util.Collections;
import java.util.List;

public class Winners {

    private final List<String> winnerNames;

    public Winners(List<String> winnerNames) {
        this.winnerNames = winnerNames;
    }

    public List<String> names() {
        return Collections.unmodifiableList(winnerNames);
    }
}
