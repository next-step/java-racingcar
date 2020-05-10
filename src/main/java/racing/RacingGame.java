package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int time;
    private List<Car> cars = new ArrayList<>();

    public RacingGame(int time, int cars) {
        this.time = time;
        for (int i = 0; i < cars; i++) {
            this.cars.add(new Car());
        }
    }

    public void startRacing() {

    }
}
