package racing;

import java.util.List;

public class RacingGameResult {
    private int time;
    private List<Car> cars;

    public RacingGameResult(final int time, final List<Car> cars) {
        this.time = time;
        this.cars = cars;
    }

    public int getTime() {
        return this.time;
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
