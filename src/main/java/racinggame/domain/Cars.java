package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

    private static final Integer START_INDEX = 0;
    private static final Integer MAX_MOVE_VALUE = 9;

    private final List<Car> cars;
    private final Random random;

    public Cars(Integer carCount) {
        random = new Random();
        cars = IntStream.range(START_INDEX, carCount)
                .mapToObj((idx) -> new Car())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void roundRacing() {
        for (Car car : cars) {
            car.move(random.nextInt(MAX_MOVE_VALUE));
        }
    }

    public List<Long> getRacingHistory(int round) {
        List<Long> records = new ArrayList<>();
        for (Car car : cars) {
            records.add(car.getRecord(round));
        }
        return records;
    }
}
