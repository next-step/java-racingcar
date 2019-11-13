package step3.racingcarWinner;

import step3.racingcarWinner.domain.Car;
import step3.racingcarWinner.domain.RacingGame;
import step3.racingcarWinner.view.InputView;
import step3.racingcarWinner.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        String carNames = inputView.carNames();
        int racingLap = inputView.racingLap();

        RacingGame racingGame = new RacingGame(carNames, racingLap);

        ResultView resultView = new ResultView();

        List<List<Car>> lapPerCarList = new ArrayList<>();
        List<List<Car>> lapPerCarMovedList = new ArrayList<>();
        for (int i = 0; i < racingLap; i++) {
            lapPerCarMovedList.add(generateCarMovedHistory(racingGame.run()));
            lapPerCarList.add(racingGame.run());
        }
        resultView.printLapPerCarPositionList(lapPerCarMovedList);
        resultView.printFinalWinner(lapPerCarList, racingLap);
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
