package racing.domain;

import java.util.List;
import java.util.Random;

public class RacingGame {
    private static final int MAX_RANDOM = 10;

    private Random random = new Random();
    private RoundCars roundCars = new RoundCars();
    private Cars cars;

    private int tryNo;

    public RacingGame(String carNames, int tryNo) {
        Cars cars = new Cars(carNames);
        this.cars = cars;
        this.tryNo = tryNo;
    }

    public void race() {
        Cars newCars = new Cars();
        for (Car car : cars.getCars()) {
            newCars.add(car.getRandomMove(random.nextInt(MAX_RANDOM)));
        }
        roundCars.add(newCars);
        this.cars = newCars;
    }

    public RoundCars getRoundCars() {
        return roundCars;
    }

    public boolean isEnd() {
        tryNo--;
        return tryNo < 0;
    }

    public Winners getWinners() {
        Winners winners = new Winners(cars);
        return winners;
    }
}
