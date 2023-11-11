package racingcar.ui;

import racingcar.domain.Car;
import racingcar.ui.dto.RacingGameResponse;

import java.util.HashMap;
import java.util.List;

public class ResultView {
    private final String CAR_STATUS_EXPRESSION = "-";

    public void showRacingCarGame(RacingGameResponse response) {
        HashMap<Integer, List<Car>> movedCarsByTurn = response.getMovedCarsByTurn();
        for (int currentTurn = 1; currentTurn <= movedCarsByTurn.size(); currentTurn++) {
            System.out.println("Turn " + currentTurn);
            displayAllCarStatus(movedCarsByTurn.get(currentTurn));
        }
        checkWinners(response);
    }

    private void displayAllCarStatus(List<Car> movedCars) {
        for (Car car : movedCars) {
            displayCarStatus(car);
        }

    }

    private void displayCarStatus(Car car) {
        System.out.println(car.getName() + " : " + CAR_STATUS_EXPRESSION.repeat(car.getMoveCount()));
    }

    private void checkWinners(RacingGameResponse response) {
        if (response.getWinners() != null) {
            displayWinners(response);
        }
    }

    private void displayWinners(RacingGameResponse response) {
        System.out.print("최종 우승: ");
        for (String winner : response.getWinners()) {
            System.out.print(winner + " ");
        }
        System.out.println("");
    }
}
