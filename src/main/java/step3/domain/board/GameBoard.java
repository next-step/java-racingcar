package step3.domain.board;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class GameBoard {

    private final List<CarSnapShots> carSnapShots = new ArrayList<>();

    public void recordRound(List<CarSnapshot> carSnapshots) {
        carSnapShots.add(new CarSnapShots(carSnapshots));
    }

    public List<CarSnapShots> getCarSnapShots() {
        return unmodifiableList(carSnapShots);
    }
}
