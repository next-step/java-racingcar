package racingCar;

import java.util.Random;

public class RacingCarGame {

    private static final int RANDOM_LIMIT = 10;
    private static final int MINIMUM_MOVE_THRESHOLD = 4;

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

    private static void raceCars(Car[] cars) {
        for (Car car : cars) {
            moveIfConditionSatisfied(car);
        }
    }

    private static void moveIfConditionSatisfied(Car car) {
        if(car.getMoveCondition() >= MINIMUM_MOVE_THRESHOLD){
            car.move();
        }
    }

    private Car[] createRacingCars(int carCount) {
        Car[] cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = new Car(getRandomInt());
        }
        return cars;
    }

    private int getRandomInt(){
        return new Random().nextInt(RANDOM_LIMIT);
    }
}
