package game;

import java.util.ArrayList;
import java.util.List;

public class CarActionRecord {

    private final List<CarAction> actions = new ArrayList<>();

    public List<CarAction> actions() {
        return actions;
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