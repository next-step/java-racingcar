package step3;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();

    private List<Car> cars;

    private RaceRoulette raceRoulette = RaceRoulette.simple(9);

    public void start() {
        int numOfCars = getNumOfCars();
        int totalTries = getNumOfTries();

        readyToRace(numOfCars);

        int currentTry = 1;
        System.out.println("실행 결과");

        while (currentTry <= totalTries) {
            tryMovingAllCars();
            displayCurrentMovingDistances();
            currentTry++;
        }
    }

    private int getNumOfCars() {
        return inputView.getNumOfCars();
    }

    private int getNumOfTries() {
        return inputView.getNumOfTries();
    }

    private void readyToRace(int numOfCars) {
        this.cars = new ArrayList<>(numOfCars);
        int number = 1;
        while (number <= numOfCars) {
            cars.add(new Car(number++));
        }
    }

    private void displayCurrentMovingDistances() {
        this.resultView.showRaceState(cars);
    }

    private void tryMovingAllCars() {
        this.cars.forEach(car -> car.move(raceRoulette));
    }

    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing();
        carRacing.start();
    }
}
