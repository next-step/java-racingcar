package racingCar.step4;

import racingCar.step3.ResultView;

import java.util.Random;

public class RacingCarGame {

    private static final String CAR_NAME_SEPARATOR = ",";
    private static final int MOVE_CONDITION_LIMIT = 10;
    private static final Random MOVE_CONDITION_MAKER = new Random();

    public void gameStart(){
        String carNames = InputView.getCarNamesInputFromUser();
        int racingCount = InputView.getRacingCountInputFromUser();

        ResultView.printResultMessage();
        startRace(racingCount, createRacingCars(carNames));
    }

    private Car[] createRacingCars(String carNames) {
        return createCarsFromNames(splitCarName(carNames));
    }

    private static Car[] createCarsFromNames(String[] carNames) {
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
        return cars;
    }

    private static String[] splitCarName(String carNames) {
        return carNames.split(CAR_NAME_SEPARATOR);
    }

    private void startRace(int racingCount, Car[] cars) {
        for(int i = 0; i < racingCount; i++){
            raceCars(cars);
        }
    }

    private void raceCars(Car[] cars) {
        for (Car car : cars) {
            car.move(createMoveCondition());
        }
    }

    private int createMoveCondition(){
        return MOVE_CONDITION_MAKER.nextInt(MOVE_CONDITION_LIMIT);
    }
}
