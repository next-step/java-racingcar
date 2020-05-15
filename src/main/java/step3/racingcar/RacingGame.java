package step3.racingcar;

import java.util.List;

public class RacingGame {
    private int carCounts;
    private int gameTryCounts;

    public void run() {
        setGameInformation();
        List<Car> cars = CarFactory.makeCars(this.carCounts);
        startRacing(cars);
    }

    private void setGameInformation() {
        this.carCounts = InputViewProcessor.getUserInput(Message.CAR_COUNTS);
        this.gameTryCounts = InputViewProcessor.getUserInput(Message.GAME_TRY_COUNTS);
    }

    private void startRacing(List<Car> cars) {
        ResultViewProcessor.printResultHeader(Message.RESULT_HEADER);
        for (int i = 0; i < gameTryCounts; i++) {
            cars.forEach(Car::moveCarPosition);
            ResultViewProcessor.printResult(cars);
        }
    }
}
