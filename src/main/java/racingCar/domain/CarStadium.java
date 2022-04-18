package racingCar.domain;

import racingCar.NormalStrategy;
import racingCar.domain.Car;
import racingCar.view.InputViewRacingCar;
import racingCar.view.ResultViewRacingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarStadium {

    private static final int BOUND = 10;
    private static final Random random = new Random();

    private static List<Car> carList = new ArrayList<>();
    private static int rounds = 0;

    public static int extractRandomNumber() {
        return random.nextInt(BOUND);
    }

    public static void startRacing() {
        initRacingData();

        moveAndViewRacingCar();

        resultViewRacing();
    }

    private static void initRacingData() {
        initCars(InputViewRacingCar.inputPlayCarNum());
        initRounds(InputViewRacingCar.inputRounds());
    }

    private static void moveAndViewRacingCar() {
        for(int i = 0; i < rounds; i++) {
            moveCars();
            ResultViewRacingCar.resultViewCarData(carList);
        }
    }

    private static void moveCars() {
        for (Car car : carList) {
            moveCar(car);
        }
    }

    private static void resultViewRacing() {
        ResultViewRacingCar.resultViewWinners(getWinners(carList));
    }

    private static void initCars(String[] carNames) {
        for (String name : carNames) {
            Car car = new Car(name, new NormalStrategy());
            carList.add(car);
        }
    }

    private static void initRounds(int nums) {
        rounds = nums;
    }

    private static void moveCar(Car car) {
        car.move(extractRandomNumber());
    }

    private static List<String> getWinners(List<Car> cars) {
        List<String> winners = findWinners(cars, getMaxPosition(cars));

        return winners;
    }

    private static List<String> findWinners(List<Car> cars, int max) {
        List<String> winners = new ArrayList<>();

        for (int j = 0; j < cars.size(); ++j) {
            Car car = cars.get(j);
            addWinners(max, winners, car);
        }

        return winners;
    }

    private static void addWinners(int max, List<String> winners, Car car) {
        if (max == car.getPosition()) {
            winners.add(car.getName());
        }
    }

    private static int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;

        for (int j = 0; j < cars.size(); ++j) {
            int position = cars.get(j).getPosition();
            maxPosition = getMaxPosition(maxPosition, position);
        }
        return maxPosition;
    }

    private static int getMaxPosition(int maxPosition, int position) {
        if (position > maxPosition) {
            maxPosition = position;
        }
        return maxPosition;
    }
}
