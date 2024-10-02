package racingCar.step3;

import java.util.Random;

public class RacingCarGame {

    private static final int MOVE_CONDITION_LIMIT = 10;
    private static final Random MOVE_CONDITION_MAKER = new Random();

    public void gameStart(){
        int carCountInput = InputView.getCarCountInputFromUser();
        int racingCountInput = InputView.getRacingCountInputFromUser();

        ResultView.printResultMessage();
        startRace(racingCountInput, createRacingCars(carCountInput));
    }

    private void startRace(int racingCount, Car[] cars) {
        for (int i = 0; i < racingCount; i++) {
            raceCars(cars);
            ResultView.printRaceResult(cars);
        }
    }

    private void raceCars(Car[] cars) {
        for (Car car : cars) {
            car.move(createMoveCondition());
        }
    }

    private Car[] createRacingCars(int carCount) {
        Car[] cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = new Car();
        }
        return cars;
    }

    private int createMoveCondition(){
        return MOVE_CONDITION_MAKER.nextInt(MOVE_CONDITION_LIMIT);
    }
}
