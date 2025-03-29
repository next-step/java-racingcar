package carracing;

import carracing.domain.Car;
import carracing.domain.MovingStrategy;
import carracing.domain.Race;
import carracing.domain.RandomMovingStrategy;
import carracing.view.InputView;
import carracing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String[] carNames = inputView.getCarNames();
        int numberOfRounds = inputView.getNumberOfRounds();

        MovingStrategy movingStrategy = new RandomMovingStrategy();

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        Race race = new Race(cars, numberOfRounds, movingStrategy);
        ResultView resultView = new ResultView();
        System.out.println("실행 결과");
        race.playGame().forEach(tmpCarList -> {
            resultView.printResult(tmpCarList);
            resultView.printRoundSeparator();
        });
        resultView.printWinners(race.getWinners());
    }
}
