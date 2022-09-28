package RacingCar;

import java.util.*;

public class Racing {
    private static final Random random = new Random();
    private static final int RANDOM_NUMBER_RANGE = 10;

    private int carCount;
    private int round;
    private List<Car> carList;

    public Racing(int carCount, int round) {
        initCarList(carCount);
        this.round = round;
    }

    private void initCarList(int carCount) {
        carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
    }

    public void round() {
        for (Car car : carList) {
            car.move(random());
        }
    }

    private int random() {
        return random.nextInt(RANDOM_NUMBER_RANGE);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getRound() {
        return round;
    }
}
