package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Winner;
import racingcar.view.ResultView;

import java.util.Collections;
import java.util.List;

public class RacingCarController {
    private final ResultView resultView = new ResultView();


    public List<Car> getWinner(String[] carNames, int tryNumber) {
        List<Car> cars = Car.createCars(carNames);

        for(int i = 0; i < tryNumber; i++) {
            resultView.printAll(cars);
        }

        Collections.reverse(cars);
        return createWinnerList(cars);
    }

    private List<Car> createWinnerList(List<Car> cars) {
        Winner winner = Winner.of(Winner.resultPointOfFirst(cars));
        return winner.winnerSelection(cars);
    }

}
