import java.util.List;

public class CarRacingGame {
    private Cars racingCars;

    private CarRacingGame(Cars racingCars) {
        this.racingCars = racingCars;
    }

    public static CarRacingGame gameSetting(Cars cars) {
        return new CarRacingGame(cars);
    }

    public void start() {

    }
}
