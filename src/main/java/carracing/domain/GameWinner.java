package carracing;

import java.util.ArrayList;
import java.util.List;

public class GameWinner {

    private static int carRacingWinnerPoint = 1;
    private final List<String> winnersNameBox = new ArrayList<>();

    public GameWinner() {
    }

    public static void carRaceTopPosition(Car car) {
        if (car.getPosition() > carRacingWinnerPoint) {
            carRacingWinnerPoint = car.getPosition();
        }
    }

    public List<String> findWinners(List<Car> winners, int winnerPoint) {
        for (Car winner : winners) {
            findTopPositionPlayer(winnerPoint, winner);
        }
        return winnersNameBox;
    }

    private void findTopPositionPlayer(int winnerPoint, Car winner) {
        if (winner.getPosition() == winnerPoint) {
            winnersNameBox.add(winner.getName());
        }
    }

    public static int getWinnerPoint() {
        return carRacingWinnerPoint;
    }
}
