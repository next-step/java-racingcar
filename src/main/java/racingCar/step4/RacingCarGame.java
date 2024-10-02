package racingCar.step4;

import racingCar.step3.ResultView;

public class RacingCarGame {

    private static final String CAR_NAME_SEPARATOR = ",";

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
    }
}
