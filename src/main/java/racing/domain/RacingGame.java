package racing.domain;

import racing.Car;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private static final int MAX_BOUND = 10;
    private List<Car> cars;
    private String carNames;

    public RacingGame(String carNames) {
        cars = new ArrayList<>();
        this.carNames = carNames;
        initSettingCar();
    }

    public GameResult startGame() {
        //경기 시작
        return doTracing();
    }

    private void initSettingCar() {
        String[] names = carNames.split(" ");
        int carNumber = names.length;

        for (int i = 0; i < carNumber; i++) {
            cars.add(new Car(names[i]));
        }
    }

    private GameResult doTracing() {
        List<Car> newCars = new ArrayList<>();
        for (Car car : cars) {
            newCars.add(setNewPosition(car));
        }

        return new GameResult(newCars);
    }

    private Car setNewPosition(Car car) {
        int randomValue = new Random().nextInt(MAX_BOUND);
        car.addPosition(randomValue);
        return new Car(car.getName(), car.getPosition());
    }
}
