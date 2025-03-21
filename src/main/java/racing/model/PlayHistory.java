package racing.model;

import java.util.List;

public class PlayHistory {

    private final List<CarsAtTurn> positions;

    public PlayHistory(List<CarsAtTurn> positions) {
        this.positions = positions;
    }

    public List<CarsAtTurn> getPositions() {
        return this.positions;
    }

    public List<String> findWinners() {
        CarsAtTurn lastTurn = getLastTurn();
        return lastTurn.findMaxPositionCarNames();
    }

    private CarsAtTurn getLastTurn() {
        return this.positions.get(this.positions.size() - 1);
    }

}
