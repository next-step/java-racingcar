package racingcargame;

import java.util.ArrayList;
import java.util.Collections;
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
        resultView.printWinner(findWinners(cars));
    }

    public String findWinners(List<RacingCar> cars) {
        cars.sort(Collections.reverseOrder());

        RacingCar winner = cars.get(0);
        int winnerDistance = winner.showDistance();
        String winnerName = winner.showCarName();

        for (int i = 1; i < cars.size(); i++) {
            winnerName += selectTie(cars.get(i), winnerDistance);
        }
        return winnerName;
    }

    private String selectTie(RacingCar car, int winnerDistance) {
        String tie = "";
        if(car.isWinner(winnerDistance)) {
            tie = ", " + car.showCarName();
        }
        return tie;
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