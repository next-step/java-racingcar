package basicgame;

import util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class CarGroup {

    private static List<Car> cars;
    public static final String INPUT_ERROR_MESSAGE = "0이나 음수값은 입력하실 수 없습니다.";
    public static Counter triedCount;
    private final static int MAX_RANDOM = 10;
    public final static int ZERO = 0;


    public static void startGame(int carCount, int tryCount) {
        triedCount = new Counter(ZERO);
        if (carCount <= 0 || tryCount <= 0) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }

        initCar(carCount);

        ResultView.printResultTitle();
        for (int i = 0; i < tryCount; i++) {
            activeCar();
            ResultView.printResultList(cars);
            triedCount.autoIncrement();
        }
    }


    private static void activeCar() {
        for (Car car : cars) {
            car.go(RandomUtil.getRandomValue(MAX_RANDOM));
        }
    }

    private static void initCar(int carCount) {
        cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(new StringBuffer()));
        }
    }

    public static int carsSize() {
        return cars.size();
    }
}
