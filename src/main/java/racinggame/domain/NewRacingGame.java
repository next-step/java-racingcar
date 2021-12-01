package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewRacingGame {
    private static final int MAX_BOUND = 10;

    private final Cars cars;
    private final TryNo tryNo;

    public NewRacingGame(List<Car> cars, int tryNo) {
        this(() -> cars, tryNo);
    }

    public NewRacingGame(List<Car> cars, TryNo tryNo) {
        this(() -> cars, tryNo);
    }

    public NewRacingGame(Cars cars, int tryNo) {
        this(cars, new TryNo(tryNo));
    }

    public NewRacingGame(Cars cars, TryNo tryNo) {
        this.cars = cars;
        this.tryNo = tryNo;
    }

    public NewRacingGame racedGame() {
        List<Car> racedCars = new ArrayList<>();
        for (Car car : cars.cars()) {
            racedCars.add(car.movedCar(randomNo()));
        }
        return new NewRacingGame(racedCars, tryNo.race());
    }

    private RandomValue randomNo() {
        Random random = new Random();
        return new RandomValue(random.nextInt(MAX_BOUND));
    }
}
