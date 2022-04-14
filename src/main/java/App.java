import racing.RacingService;
import racing.exception.CarsNullPointerException;
import racing.exception.RacingNullPointerException;

public class App {
    public static void main(String[] args) throws RacingNullPointerException, CarsNullPointerException {
        new RacingService().StartRacingGame();
    }
}
