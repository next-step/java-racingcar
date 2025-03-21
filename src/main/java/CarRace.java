import java.util.ArrayList;
import java.util.List;

public class CarRace {
    private final List<Car> cars = new ArrayList<>();
    private final int runCount;

    public CarRace(int carCount, int runCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        this.runCount = runCount;
    }

    public List<List<Integer>> run() {
        List<List<Integer>> result = new ArrayList<>(runCount);
        for (int i = 0; i < runCount; i++) {
            result.add(runOnce());
        }
        return result;
    }

    private List<Integer> runOnce() {
        List<Integer> result = new ArrayList<>(cars.size());
        for (Car car : cars) {
            result.add(car.move());
        }
        return result;
    }

}

