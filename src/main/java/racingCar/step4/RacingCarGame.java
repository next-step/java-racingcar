package racingCar.step4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarGame {

    private RacingCars cars;

    public void gameStart(){
        String carNames = InputView.getCarNamesInputFromUser();
        int racingCount = InputView.getRacingCountInputFromUser();

        createRacingCars(carNames);
        ResultView.printResultMessage();
        startRace(racingCount);
        decideWinner();
    }

    private void createRacingCars(String carNames) {
        this.cars = RacingCars.createCarsWithNames(carNames);
    }

    private void startRace(int racingCount) {
        for (int i = 0; i < racingCount; i++) {
            cars.move();
            ResultView.printRaceResult(cars);
        }
    }

    private void decideWinner() {
        int maxCarPosition = cars.getMaxCarPosition();
        List<RacingCar> championCars = cars.findCarsByPosition(maxCarPosition);
        ResultView.printRaceChampion(championCars);
    }
}
