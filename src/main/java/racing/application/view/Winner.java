package racing.application.view;

import java.util.ArrayList;
import java.util.List;
import racing.domain.car.Name;

public class Winner {

    private final List<Name> winner;

    public Winner(List<Name> winner) {
        this.winner = winner;
    }

    public List<Name> winners() {
        return new ArrayList<>(winner);
    }
}
