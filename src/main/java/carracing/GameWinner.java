package carracing;

import java.util.ArrayList;
import java.util.List;

public class GameWinner {

    private static int carRacingWinnerPoint = 1;
    private static final List<String> winnersNameBox = new ArrayList<>();

    private GameWinner() {
    }

    public static void carRaceTopPosition(Car car) {
        if (car.getPosition() > carRacingWinnerPoint) {
            carRacingWinnerPoint = car.getPosition();
        }
    }

    public static List<String> findWinners(List<Car> winners, int winnerPoint) {
        for (Car winner : winners) {
            return findTopPositionPlayer(winnerPoint, winner);
        }
        return winnersNameBox;
    }

    private static List<String> findTopPositionPlayer(int winnerPoint, Car winner) {
        if (winner.getPosition() == winnerPoint) {
            winnersNameBox.add(winner.getName());
        }
        return winnersNameBox;
    }

    public static int getWinnerPoint() {
        return carRacingWinnerPoint;
    }
}
