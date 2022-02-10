package racinggame.domain;

import java.util.List;

public class Winners {

    private final List<String> winners;

    public Winners(List<String> winners) {
        this.winners = winners;
    }

    public List<String> get() {
        return winners;
    }
}
