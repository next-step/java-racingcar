package fourth_racing_ranking;


import java.util.*;

public class RacingGame {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        SetInputValue setInputValue = new SetInputValue();
        CarAction carAction = new CarAction();
        RacingGameResult racingGameResult = new RacingGameResult();

        String carName = inputView.askQuestion1();

        int tryNumber = inputView.askQuestion2();

        List<Car> car = setInputValue.ready(carName);

        carAction.start(car, tryNumber);

        racingGameResult.announceRank(car);

    }
}


