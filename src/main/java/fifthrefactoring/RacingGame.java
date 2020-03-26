package fifthrefactoring;


import fifthrefactoring.domain.Car;
import fifthrefactoring.domain.CarAction;
import fifthrefactoring.view.InputView;
import fifthrefactoring.view.ResultView;

import java.util.*;

public class RacingGame {

    public static void main(String[] args) {
        String carName = InputView.askCarName();
        int tryNumber = InputView.askTryNumber();
        List<Car> carList = CarAction.ready(carName);
        ResultView.getTitle();
        ResultView.draw(carList);
        for (int i = 0; i < tryNumber - 1; i++) {
            CarAction.moveCar(carList);
            ResultView.draw(carList);
        }
        String firstName = CarAction.setRank(carList);
        ResultView.announceRank(firstName);

    }
}


