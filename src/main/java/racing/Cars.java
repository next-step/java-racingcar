package racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Cars {

    private static final Random random = new Random();
    private static final Integer RANDOM_BOUND = 10;

    private final List<Car> cars;
    private final int moveCount;

    public Cars(int carCount, int moveCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        this.moveCount = moveCount;
        this.cars = Collections.unmodifiableList(cars); // 원본 리스트 대신 수정 불가능 리스트 세팅 -> 외부에서 변경 불가능
    }

    public Cars move() {
        this.cars.forEach(car -> car.move(random.nextInt(RANDOM_BOUND)));
        return this;
    }

    public List<Car> values() {
        return cars;
    }

    public int moveCount() {
        return moveCount;
    }

}
