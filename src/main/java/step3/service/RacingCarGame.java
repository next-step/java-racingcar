package step3.service;

import step3.domain.Car;
import step3.domain.Cars;
import step3.view.InputView;
import step3.view.PrintView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private final CarEngine carEngine;
    private final PrintView printView = new PrintView();

    public RacingCarGame(CarEngine carEngine) {
        this.carEngine = carEngine;
    }

    // view 테스트용
    public static void main(String[] args) {
        CarEngine carEngine = new RandomEngine();
        RacingCarGame racingcar = new RacingCarGame(carEngine);

        InputView inputView = new InputView();
        inputView.receiveAndViewAndValidate();

        racingcar.execute(inputView.getCarNameArray(), inputView.getRound());
    }

    public void execute(String[] carNameArray, int round) {
        Cars cars = new Cars(createCars(carNameArray));

        race(cars, round);
    }

    private List<Car> createCars(String[] carNameArray) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNameArray.length; i++) {
            cars.add(new Car(carNameArray[i]));
        }

        return cars;
    }

    private void race(Cars cars, int round) {
        printView.print("실행 결과");
        for (int i = 0; i < round; i++) {
            cars.moveAll(carEngine);
            printView.result(cars);
        }

        getWinnerAndPrint(cars);
    }

    private void getWinnerAndPrint(Cars cars) {
        List<String> winner = cars.getWinner();

        printView.printWinner(winner);
    }

}
