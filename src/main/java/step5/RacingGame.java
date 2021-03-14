package step5;

import step5.View.InputView;
import step5.View.OutputView;
import step5.domain.Car;
import step5.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private List<Car> carList = new ArrayList<>();
    private List<Car> roundWinnerList;
    private Cars eachCar;

    private int attempt;

    public RacingGame(InputView inputView) {
        String carNames = inputView.inputCarNames();
        this.attempt = inputView.inputAttempt();
        this.cars = createCars(carNames);
    }

    private List<Car> createCars(String inputCarNames) {
        List<Car> cars = new ArrayList<>();
        String[] arrCarNames = inputCarNames.split(",");
        for(String name : arrCarNames) {
            cars.add(new Car(name, 0));
        }

        return cars;
    }

    public void start() {
        int round = attempt;
        OutputView outputView = new OutputView();
        outputView.printStart();
        while (round-- != 0) {
            move();
            outputView.printCarMove(eachCar);
            isReset();
            System.out.println();
        }

        outputView.printWinner(roundWinnerList);
    }

    public void move() {
        for (Car car : cars) {
            car.move();
            carList.add(car);
        }
        eachCar = new Cars(carList);
        roundWinnerList = eachCar.findWinner();
    }

    public void isReset() {
        carList = new ArrayList<>();
    }
}
