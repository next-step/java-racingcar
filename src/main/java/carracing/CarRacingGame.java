package carracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacingGame {

    private final InputView inputView;
    private final OutputView outputView;
    private int carCounts;
    private int tryTimes;

    public CarRacingGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        startInput();
        outputView.printStart();

        List<Car> cars = carList(carCounts);
        move(tryTimes, cars);
    }

    private void startInput() {
        inputView.printQuestionCarCount();
        carCounts = inputView.carCounts();
        inputView.printQuestionTryTimes();
        tryTimes = inputView.tryTimes();
    }

    private void move(int tryTimes, List<Car> cars) {
        for (int j = 0; j < tryTimes; j++) {
            moveTry(cars);
            outputView.printResult(cars);
        }
    }

    private void moveTry(List<Car> cars) {
        Random random = new Random();

        for (Car car : cars) {
            int randomInt = random.nextInt(10);
            car.move(randomInt);
        }
    }

    private List<Car> carList(int carCounts) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < carCounts; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
