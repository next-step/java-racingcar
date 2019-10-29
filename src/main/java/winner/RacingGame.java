package winner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-10-29 01:39
 */
public class RacingGame {

    public static void startCarRacingWinner() {
        CarRaceInputView carRaceInputView = new CarRaceInputView();
        CarRaceWinnerGame carRaceWinnerGame = new CarRaceWinnerGame(createCars(carRaceInputView.inputCarName()), carRaceInputView.inputGameRound());
        carRaceWinnerGame.play();
    }

    private static List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}
