package step3;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();

    private List<Car> cars;

    private RaceRoulette raceRoulette = RaceRoulette.simple(9);
    private RaceResult raceResult = new RaceResult();

    public void start() {
        readyToRace(getCarNames());

        int totalTries = getNumOfTries();
        if (totalTries < 1) throw new RuntimeException("Invalid Input - totalTries is " + totalTries);

        int currentTry = 1;
        System.out.println("실행 결과");

        while (currentTry++ <= totalTries) {
            tryMovingAllCars();
            displayCurrentMovingDistances();
        }

        announceRaceWinner();
    }

    private void announceRaceWinner() {
        resultView.showRaceWinner(raceResult.findRaceWinners(cars));
    }

    private List<String> getCarNames() {
        return inputView.getCarNames();
    }

    private int getNumOfTries() {
        return inputView.getNumOfTries();
    }

    private void readyToRace(List<String> carNames) {
        this.cars = new ArrayList<>(carNames.size());
        carNames.forEach(it -> cars.add(new Car(it)));
    }

    private void displayCurrentMovingDistances() {
        this.resultView.showRaceState(cars);
    }

    private void tryMovingAllCars() {
        this.cars.forEach(it -> it.moveIf(() -> raceRoulette.spin() >= 4));
    }

    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing();
        carRacing.start();
    }

}
