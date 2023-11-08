package carracing;

public class GameWinner {
    private static int CAR_RACING_WINNER_POINT = 1;

    private GameWinner() {
    }

    public static void carRaceTopPosition(Car car) {
        if (car.getPrevPosition() > CAR_RACING_WINNER_POINT) {
            CAR_RACING_WINNER_POINT = car.getPrevPosition();
        }
    }

    public static int getWinnerPoint() {
        return CAR_RACING_WINNER_POINT;
    }
}
