package carracing;

import java.util.List;

public class GameWinner {

    private static int carRacingWinnerPoint = 1;

    private GameWinner() {
    }

    public static void carRaceTopPosition(Car car) {
        if (car.getPrevPosition() > carRacingWinnerPoint) {
            carRacingWinnerPoint = car.getPrevPosition();
        }
    }

    public static void findWinners(List<Car> winners, int winnerPoint, List<String> winnersNameBox) {
        for (Car winner : winners) {
            if (winner.getPrevPosition() == winnerPoint) {
                winnersNameBox.add(winner.getName());
            }
        }
    }

    public static int getWinnerPoint() {
        return carRacingWinnerPoint;
    }
}
