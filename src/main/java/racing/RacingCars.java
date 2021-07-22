package racing;

import java.util.ArrayList;
import java.util.List;

class RacingCars {
    private static final String DISPLAY_MARK = "-";

    private final List<String> cars;

    private RacingCars(ArrayList<String> cars) {
        this.cars = cars;
    }

    public static RacingCars from(ArrayList<String> cars) {
        return new RacingCars(cars);
    }

    public int size() {
        return this.cars.size();
    }

    public void goForward(int index, ForwardConditionStrategy strategy) {
        if(strategy.judgeCondition()) {
            return;
        }
        cars.set(index, cars.get(index) + DISPLAY_MARK);
    }

    public String get(int index) {
        return cars.get(index);
    }
}
