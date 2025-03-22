package racing.model;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PlayHistory implements Iterable<CarsAtTurn> {

    private final List<CarsAtTurn> positions;

    public PlayHistory(List<CarsAtTurn> positions) {
        this.positions = positions;
    }

    public List<String> findWinners() {
        CarsAtTurn lastTurn = getLastTurn();
        return lastTurn.findMaxPositionCarNames();
    }

    private CarsAtTurn getLastTurn() {
        return this.positions.get(this.positions.size() - 1);
    }

    @Override
    public Iterator<CarsAtTurn> iterator() {
        return Collections.unmodifiableList(positions).iterator();
    }

}
