package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Winner;
import racingcar.utils.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.Collections;
import java.util.List;

public class RacingGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        String[] carNames = inputView.insertCarNames();
        int tryNumber = inputView.getNumberOfTry();

        List<Car> cars = Car.createCars(carNames);

        for(int i = 0; i < tryNumber; i++) {
            printAll(cars);
        }

        Collections.reverse(cars);

        Winner winner = Winner.of(Winner.resultPointOfFirst(cars));
        System.out.println(winner.firstResultPoint());

        List<Car> winners = winner.winnerSelection(cars);
        resultView.getWinner(winners);
    }

    public static void printAll(List<Car> cars) {
        RandomNumber randomNumber = new RandomNumber();
        ResultView resultView = new ResultView();
        for(Car car: cars) {
            int moveNumber = car.move(randomNumber.producedRandomNumber());
            resultView.print(car.getName(), moveNumber);
        }
        System.out.println();
    }
}
