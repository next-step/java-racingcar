package racingcargame;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private List<RacingCar> cars;
    private ResultView resultView = new ResultView();
    private int count;

    RacingCarGame(String nameOfCars, int count) {
        this.count = count;
        cars = createCars(nameOfCars);
    }

    private List<RacingCar> createCars(String nameOfCars) {
        List<RacingCar> cars = new ArrayList<>();
        String[] carsName = nameOfCars.split(",");
        for (String carName : carsName) {
            cars.add(new RacingCar(new RacingCarName(carName)));
        }
        return cars;
    }

    public void startGame(final RandomOption randomOption) {
        resultView.printResultMessage();
        for (int i = 0; i < count; i++) {
            round(randomOption);
            resultView.showResultView(cars);
        }
    }

    public void showWinner() {
        Winner winner = new Winner();
        resultView.printWinner(winner.findWinners(cars));
    }

    private void round(RandomOption randomOption) {
        for (RacingCar car : cars) {
            car.tryToMove(randomOption.randomValue());
        }
    }

    public List<RacingCar> getCars() {
        return cars;
    }
}