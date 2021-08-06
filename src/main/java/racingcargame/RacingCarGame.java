package racingcargame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCarGame {
    private List<RacingCar> cars;
    private ResultView resultView = new ResultView();
    private int count;
    private String winners = "";

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

    public void showGameResult() {
        sortDistance(cars);
        for (int i = 0; i < cars.size(); i++) {
            selectTie(cars, i);
        }
        printWinner(winners);
    }

    private void sortDistance(List<RacingCar> cars) {
        Collections.sort(cars, Collections.reverseOrder());
    }

    private void selectTie(List<RacingCar> cars, int index) {
        if(cars.get(0).getDistance() == cars.get(index).getDistance()) {
            winners += cars.get(index).getCarName() + ", ";
        }
    }

    private void printWinner(String winners) {
        resultView.printWinner(winners);
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