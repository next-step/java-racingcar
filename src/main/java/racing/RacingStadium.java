package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingStadium {

    private final int MAX_BOUND = 10;

    private int carCount;
    private int time;
    private List<Integer> carPosition;
    private List<Car> racingCars = new ArrayList<>();

    public RacingStadium(int carCount, int time) {
        this.carCount = carCount;
        this.time = time;
        readyRacingCars();
    }

    private void readyRacingCars() {
        for (int i = 0; i < carCount; i++) {
            racingCars.add(new Car());
        }
    }

    public void open() {
        RacingResultView racingResultView = new RacingResultView();
        for (int i = 0; i < time; i++) {
            racingResultView.print(startRacingGame());
        }
    }

    private List<Car> startRacingGame() {
        RacingGame racingGame;
        for (Car racingCar : racingCars) {
            racingGame = new RacingGame(racingCar);
            racingGame.start(new Random().nextInt(MAX_BOUND));
        }
        return racingCars;
    }

}
