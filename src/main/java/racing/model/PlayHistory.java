package racing.model;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PlayHistory implements Iterable<TurnSnapshot> {

    private final List<TurnSnapshot> positions;

    public PlayHistory(List<TurnSnapshot> positions) {
        this.positions = positions;
    }

    public List<String> findWinners() {
        TurnSnapshot lastTurn = getLastTurn();
        return lastTurn.findMaxPositionCarNames();
    }

    private TurnSnapshot getLastTurn() {
        return this.positions.get(this.positions.size() - 1);
    }

    @Override
    public Iterator<TurnSnapshot> iterator() {
        return Collections.unmodifiableList(positions).iterator();
    }

}
