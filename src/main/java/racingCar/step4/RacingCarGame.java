package racingCar.step4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarGame {

    private static final String CAR_NAME_SEPARATOR = ",";
    private static final int MOVE_CONDITION_LIMIT = 10;
    private static final Random MOVE_CONDITION_MAKER = new Random();

    private RacingCar[] cars;

    public void gameStart(){
        String carNames = InputView.getCarNamesInputFromUser();
        int racingCount = InputView.getRacingCountInputFromUser();

        ResultView.printResultMessage();
        startRace(racingCount, createRacingCars(carNames));
        decideWinner();
    }

    private RacingCar[] createRacingCars(String carNames) {
        return createCarsFromNames(splitCarName(carNames));
    }

    private RacingCar[] createCarsFromNames(String[] carNames) {
        cars = new RacingCar[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = RacingCar.createCarWithName(carNames[i]);
        }
        return cars;
    }

    private static String[] splitCarName(String carNames) {
        return carNames.split(CAR_NAME_SEPARATOR);
    }

    private void startRace(int racingCount, RacingCar[] cars) {
        for(int i = 0; i < racingCount; i++){
            raceCars(cars);
            ResultView.printRaceResult(cars);
        }
    }

    private void decideWinner() {
        int maxCarPosition = getMaxCarPosition();
        List<RacingCar> championCars = findChampionCars(maxCarPosition);
        ResultView.printRaceChampion(championCars);
    }

    private List<RacingCar> findChampionCars(int maxCarPosition) {
        List<RacingCar> championCars = new ArrayList<>();
        for (RacingCar car : cars) {
            if (isChampionCar(car, maxCarPosition)) championCars.add(car);
        }
        return championCars;
    }

    private static boolean isChampionCar(RacingCar car, int maxCarPosition) {
        return car.isCurrentPosition(maxCarPosition);
    }

    private int getMaxCarPosition() {
        int maxCarPosition = 0;
        for (RacingCar car : cars) {
            maxCarPosition = Math.max(maxCarPosition, car.getPosition());
        }
        return maxCarPosition;
    }

    private void raceCars(RacingCar[] cars) {
        for (RacingCar car : cars) {
            car.move(createMoveCondition());
        }
    }

    private int createMoveCondition(){
        return MOVE_CONDITION_MAKER.nextInt(MOVE_CONDITION_LIMIT);
    }
}
