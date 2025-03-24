package racing.view;

import racing.domain.model.Car;
import racing.domain.RacingCarGame;
import racing.domain.model.Round;

import java.util.*;
import java.util.stream.Collectors;

public class ResultView {

    public void displayRaceResults(final RacingCarGame game) {
        System.out.println("\n실행 결과");

        for (Round round : game.getResult()) {
            displayRound(round);
            System.out.println();
        }
        displayWinner(game.getWinners());
    }

    private void displayRound(final Round round) {
        for (Map.Entry<Car, Integer> carPositionEntry : round.getCarPositions().entrySet()) {
            System.out.printf("%s : %s\n", carPositionEntry.getKey().getName(), "-".repeat(carPositionEntry.getValue()));
        }
    }

    private void displayWinner(final List<Car> cars) {
        String winnerNames = cars.stream().map(Car::getName).collect(Collectors.joining(", "));

        System.out.printf("%s가 최종 우승했습니다.\n", winnerNames);
    }
}
