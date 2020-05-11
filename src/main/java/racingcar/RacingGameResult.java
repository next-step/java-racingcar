package racingcar;


import java.util.ArrayList;
import java.util.List;

public class RacingGameResult {

    private final List<Car[]> results = new ArrayList<>();

    public void add(Car[] cars) {
        results.add(cars);
    }

    public int getSize() {
        return results.size();
    }
}
