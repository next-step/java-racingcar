package fifth_refactoring;


import fifth_refactoring.domain.Car;
import fifth_refactoring.domain.CarAction;
import fifth_refactoring.view.InputView;
import fifth_refactoring.view.ResultView;

import java.util.*;

public class RacingGame {

    public static void main(String[] args) {
        String carName = InputView.askCarName();

        int tryNumber = InputView.askTryNumber();

        List<Car> carList = CarAction.ready(carName);

        ResultView.getTitle();

        for (int i = 0; i < tryNumber; i++) {
            ResultView.draw(carList);
            CarAction.moveCar(carList);
        }

        ResultView.announceRank(carList);

    }
}


