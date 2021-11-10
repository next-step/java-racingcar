package racingcar;

import common.InputView;
import common.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    private final ListView<Car> carListView;
    private final int tryCount;
    private final Random random;

    public Racing(int carCount, int tryCount) {
        this.carListView = new ListView<>(makeCar(carCount));
        this.tryCount = tryCount;
        this.random = new Random(System.currentTimeMillis());
    }

    public static void main(String[] args) {
        int carCount = InputView.nextInt("자동차 대수는 몇 대 인가요?");
        int tryCount = InputView.nextInt("시도할 회수는 몇 회 인가요?");

        Racing racing = new Racing(carCount, tryCount);
        racing.start();
    }

    public List<Car> makeCar(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
        return carList;
    }

    public void goingTry() {
        for (Car car : carListView.getList()) {
            car.increaseState(random.nextInt(10));
        }
        carListView.print();
    }

    public void start() {
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            this.goingTry();
        }
    }

    public List<Car> getCarList() {
        return carListView.getList();
    }
}
