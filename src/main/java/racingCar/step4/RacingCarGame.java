package racingCar.step4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarGame {

    private static final String CAR_NAME_SEPARATOR = ",";
    private static final int MOVE_CONDITION_LIMIT = 10;
    private static final Random MOVE_CONDITION_MAKER = new Random();

    private Car[] cars;

    public void gameStart(){
        String carNames = InputView.getCarNamesInputFromUser();
        int racingCount = InputView.getRacingCountInputFromUser();

        ResultView.printResultMessage();
        startRace(racingCount, createRacingCars(carNames));
        decideWinner();
    }

    private Car[] createRacingCars(String carNames) {
        return createCarsFromNames(splitCarName(carNames));
    }

    private Car[] createCarsFromNames(String[] carNames) {
        cars = new Car[carNames.length];
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
            ResultView.printRaceResult(cars);
        }
    }

    private void decideWinner() {
        int maxCarPosition = getMaxCarPosition();
        List<Car> championCars = findChampionCars(maxCarPosition);
    }

    private List<Car> findChampionCars(int maxCarPosition) {
        List<Car> championCars = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == maxCarPosition) {
                championCars.add(car);
            }
        }
        return championCars;
    }

    private int getMaxCarPosition() {
        int maxCarPosition = 0;
        for (Car car : cars) {
            maxCarPosition = Math.max(maxCarPosition, car.getPosition());
        }
        return maxCarPosition;
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
