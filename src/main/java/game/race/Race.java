package game.race;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final int tryCnt;
    private final int vehicleCnt;
    private final List<Car> cars = new ArrayList<>();

    public Race(int tryCnt, int vehicleCnt) {
        this.tryCnt = tryCnt;
        this.vehicleCnt = vehicleCnt;
    }

    public int getVehicleCnt() {
        return vehicleCnt;
    }

    public void start() {
        for (int attemptCnt = 0; attemptCnt < tryCnt; attemptCnt++) {
            go();
        }
    }

    public void go() {
        for (int vehicle = 0; vehicle < vehicleCnt; vehicle++) {
            Car car = new Car();
            car.goForward(tryCnt);

            cars.add(car);
        }
    }

    public List<String> getTireMarks() {
        List<String> tireMarks = new ArrayList<>();
        for (Car car : cars) {
            tireMarks.addAll(car.getTireMarks());
        }

        return tireMarks;
    }
}
