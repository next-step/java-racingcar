package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    private static final int LIMIT = 10;
    private int carNum;
    private int moveNum;

    public Racing(int carNum, int moveNum) {
        this.carNum = carNum;
        this.moveNum = moveNum;
    }

    public static List<Car> create(int carNum) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNum; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public void race(List<Car> cars) {
        Random random = new Random();

        for (Car car : cars) {
            car.move(random.nextInt(LIMIT));
        }
    }
}
