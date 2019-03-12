package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {
    private static final int RANGE = 9;
    public List<RacingCar> racingCars = new ArrayList<>();
    private int tryCount;
    private int carCount;

    public RacingGame(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
        this.createCars();
    }

    public void createCars() {
        IntStream.range(0, carCount).forEach(i -> {
            this.racingCars.add(new RacingCar());
        });
    }

    public void playRacing() {
        IntStream.range(0, this.tryCount).forEach(i -> {
            this.moveCar();
            new ResultView().printResult(this.racingCars);
        });
    }

    public void moveCar() {
        this.racingCars.forEach(car -> {
            car.move(new NumberWithRandom(RANGE));
        });
    }
}
