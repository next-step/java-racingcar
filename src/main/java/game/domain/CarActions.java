package game.domain;

import java.util.ArrayList;
import java.util.List;

public class CarActions {

    private final List<CarAction> actions = new ArrayList<>();

    public CarAction action(int index) {
        return actions.get(index);
    }

    public void addMove() {
        actions.add(CarAction.MOVE);
    }

    public void addStop() {
        actions.add(CarAction.STOP);
    }

    public int size() {
        return actions.size();
    }
}