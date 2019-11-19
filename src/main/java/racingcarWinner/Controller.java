package racingcarWinner;

import racingcarWinner.domain.Car;
import racingcarWinner.domain.RacingGame;
import racingcarWinner.view.InputView;
import racingcarWinner.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        RacingGame racingGame = new RacingGame(inputView.carNames());

        ResultView resultView = new ResultView();

        int racingLap = inputView.racingLap();

        List<List<Car>> lapPerCarList = new ArrayList<>();
        List<List<Car>> lapPerCarMovedList = new ArrayList<>();
        for (int i = 0; i < racingLap; i++) {
            lapPerCarMovedList.add(generateCarMovedHistory(racingGame.run()));
            lapPerCarList.add(racingGame.run());
            racingGame.prizeCheck(lapPerCarList, racingLap);
        }
        resultView.printLapPerCarPositionList(lapPerCarMovedList);
        resultView.printFinalWinner(lapPerCarList, racingLap - 1);
    }

    public static List<Car> generateCarMovedHistory(List<Car> carList) {
        List<Car> returnCarList = new ArrayList<>();
        for (Car cars : carList) {
            Car car = new Car(cars.getName(), cars.getPosition());
            returnCarList.add(car);
        }
        return returnCarList;
    }

}
