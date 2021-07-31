package step5;

import step5.domain.Car;
import step5.domain.CarEngine;
import step5.domain.CarStadium;
import step5.domain.Referee;
import step5.domain.RandomDrivingStrategy;
import step5.view.InputView;
import step5.view.ResultView;
import java.util.ArrayList;

public class RacingCarGame {

    public static void main(String[] args) {
        String[] names = InputView.inputCarNames().split(",");
        int carCount = InputView.inputTryCount();
        int tryCount = names.length;

        Referee referee = new Referee(tryCount);

        ArrayList<Car> cars = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(names[i], new CarEngine(), new RandomDrivingStrategy()));
        }

        CarStadium carstadium = new CarStadium(referee, cars);

        ResultView resultView = new ResultView();

        for (int i = 0; i < tryCount; i++) {
            carstadium.moveCars();
            resultView.printResult(carstadium);
        }

        resultView.printWinners(carstadium.winners());
    }
}
