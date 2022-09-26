package car;

import java.util.ArrayList;
import java.util.List;

public class RacingCar implements Car {
    private static final String OUT_PUT_TEXT = "- ";
    private List<Boolean> distance;
    private MovableStrategy movableStrategy;

    public RacingCar(MovableStrategy movableStrategy) {
        distance = new ArrayList<>();
        this.movableStrategy = movableStrategy;
    }

    @Override
    public void racing() {
        if (movableStrategy.isMovable()) {
            distance.add(true);
            return;
        }
        distance.add(false);
    }

    @Override
    public String printResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < distance.size(); i++) {
            stringBuilder.append(printRace(i));
        }
        return stringBuilder.toString();
    }

    private String printRace(int stage) {
        if(distance.get(stage)) {
            return OUT_PUT_TEXT;
        }
        return "";
    }
}
