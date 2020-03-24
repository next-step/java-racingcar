package fifth_refactoring;


import java.util.*;

public class RacingGame {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        SetInputValue setInputValue = new SetInputValue();
        CarAction carAction = new CarAction();
        RacingGameResult racingGameResult = new RacingGameResult();

        String carName = inputView.askCarName();

        int tryNumber = inputView.askTryNumber();

        List<Car> car = setInputValue.ready(carName);

        carAction.startCar(car, tryNumber);

        racingGameResult.announceRank(car);

    }
}


