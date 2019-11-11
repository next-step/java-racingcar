package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private static final String COMMA_CHARACTER = ",";

    private final int MAX_BOUND = 10;

    private String carName;
    private int time;
    private List<Car> racingCars = new ArrayList<>();

    public RacingGame(Cars cars, int time) {
        this.carName = carName;
        this.time = time;
        readyRacingCars();
    }

    private void readyRacingCars() {
        String[] carNames = carName.split(COMMA_CHARACTER);
        for (String carName : carNames) {
            racingCars.add(new Car(carName));
        }
    }

    public void open() {
        RacingResultView racingResultView = new RacingResultView();
        for (int i = 0; i < time; i++) {
            racingResultView.print(startRacingGame());
        }
        racingResultView.printWinner(racingCars);
    }

    private List<Car> startRacingGame() {
        for (Car racingCar : racingCars) {
            racingCar.move(new Random().nextInt(MAX_BOUND));
        }
        return racingCars;
    }

}
