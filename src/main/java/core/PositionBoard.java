package core;

import java.util.*;

public class PositionBoard {
    private Map<PositionTableKey, List<Integer>> positionTable;

    private PositionBoard(Map<PositionTableKey, List<Integer>> positionTable) {
        this.positionTable = positionTable;
    }

    public static PositionBoard create(Cars cars) {
        Map<PositionTableKey, List<Integer>> positionTable = new HashMap<>();
        for (Car car : cars.getCars()) {
            positionTable.put(PositionTableKey.of(car), new ArrayList<>());
        }
        return new PositionBoard(positionTable);
    }

    public Map<PositionTableKey, List<Integer>> recordPosition(Cars cars) {
        for (Car car : cars.getCars()) {
            List<Integer> positionHistory = positionTable.get(PositionTableKey.of(car));
            positionHistory.add(car.getPosition());
        }
        return getPositionTable();
    }

    public Set<PositionTableKey> keys() {
        return positionTable.keySet();
    }

    public List<Integer> getPositionHistory(PositionTableKey key) {
        return positionTable.get(key);
    }

    public Map<PositionTableKey, List<Integer>> getPositionTable() {
        Map<PositionTableKey, List<Integer>> temporaryTable = new HashMap<>();
        for (PositionTableKey key : positionTable.keySet()) {
            temporaryTable.put(key, Collections.unmodifiableList(positionTable.get(key)));
        }
        return Collections.unmodifiableMap(temporaryTable);
    }

    public int getPositionAtTurn(Car car, int turn) {
        return positionTable.get(PositionTableKey.of(car)).get(turn);
    }
}
