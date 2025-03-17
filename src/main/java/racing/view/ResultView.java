package racing.view;

import racing.domain.Car;
import racing.domain.Round;

import java.util.List;
import java.util.Map;

public class ResultView {

    public void displayRaceResults(final List<Round> rounds) {
        System.out.println("\n실행 결과");

        for (Round round : rounds) {
            displayRound(round);
            System.out.println();
        }
    }

    private void displayRound(final Round round) {
        for (Map.Entry<Car, Integer> carPositionEntry : round.getCarPositions().entrySet()) {
            System.out.println("-".repeat(carPositionEntry.getValue()));
        }
    }
}
