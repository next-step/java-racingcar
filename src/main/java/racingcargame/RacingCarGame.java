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
        String[] separateCars = nameOfCars.split(",");
        for (int i = 0; i < separateCars.length; i++) {
            cars.add(new RacingCar(separateCars[i]));
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
        resultView.printWinner(findWinners());
    }

    private String findWinners() {
        cars.sort(Collections.reverseOrder());

        int winnerDistance = cars.get(0).getDistance();
        String winners = cars.get(0).getCarName();
        for (int i = 1; i < cars.size(); i++) {
            winners += selectTie(cars.get(i), winnerDistance);
        }
        return winners;
    }

    private String selectTie(RacingCar car, int winnerDistance) {
        String tie = "";
        if(car.isWinner(winnerDistance)) {
            tie = ", " + car.getCarName();
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