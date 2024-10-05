package racingCar.step4;

import java.util.List;

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
        this.cars = RacingCars.ofNames(carNames);
    }

    private void startRace(int racingCount) {
        RandomNumber randomNumber = new RandomNumber();

        for (int i = 0; i < racingCount; i++) {
            cars.move(randomNumber);
            ResultView.printRaceResult(cars);
        }
    }

    private void decideWinner() {
        int maxCarPosition = cars.getMaxCarPosition();
        List<RacingCar> championCars = cars.findCarsByPosition(maxCarPosition);
        ResultView.printRaceChampion(championCars);
    }
}
