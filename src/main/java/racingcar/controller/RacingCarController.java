package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Winner;
import racingcar.utils.RandomNumber;
import racingcar.view.ResultView;

import java.util.Collections;
import java.util.List;

public class RacingCarController {
    private final ResultView resultView = new ResultView();
    private final RandomNumber randomNumber = new RandomNumber();

    public void getWinner(String[] carNames, int tryNumber) {
        List<Car> cars = Car.createCars(carNames);

        for(int i = 0; i < tryNumber; i++) {
            printAll(cars);
        }

        Collections.reverse(cars);
        List<Car> winners = createWinnerList(cars);
        resultView.getWinner(winners);
    }

    private List<Car> createWinnerList(List<Car> cars) {
        Winner winner = Winner.of(Winner.resultPointOfFirst(cars));
        return winner.winnerSelection(cars);
    }

    private void printAll(List<Car> cars) {
        for(Car car : cars) {
            int moveNumber = car.move(randomNumber.producedRandomNumber());
            resultView.print(car.getName(), moveNumber);
        }
        System.out.println();
    }
}
