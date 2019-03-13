package racing.board;

import racing.model.RacingCar;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {

    private List<String> winners;

    public GameResult(List<RacingCar> cars, int winnerPosition) {
        this.winners = cars
                .stream()
                .filter(car -> car.isAt(winnerPosition))
                .map(RacingCar::toString)
                .collect(Collectors.toList());
    }

    public static int maxPosition(List<Integer> positions) {
        return Collections.max(positions);
    }

    public String getWinnerNames() {
        return winners.stream()
                .collect(Collectors.joining(", "));
    }
}
