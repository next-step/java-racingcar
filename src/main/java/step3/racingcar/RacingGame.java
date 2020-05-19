package step3.racingcar;

import java.util.List;

public class RacingGame {

    private String[] carNames;
    private int gameTryCounts;

    public RacingGame(String[] carNames, int gameTryCounts) {
        this.carNames = carNames;
        this.gameTryCounts = gameTryCounts;
    }

    public void run() {
        //List<Car> cars = CarFactory.makeCars(this.carCounts);
        //startRacing(cars);
    }

    private void startRacing(List<Car> cars) {
        ResultViewProcessor.printResultHeader(Message.RESULT_HEADER);
        for (int i = 0; i < gameTryCounts; i++) {
            cars.forEach(Car::move);
            ResultViewProcessor.printResult(cars);
        }
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getGameTryCounts() {
        return gameTryCounts;
    }
}
