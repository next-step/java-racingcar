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
        int totalTurns = getNumOfTry();

        readyToRace(numOfCars);

        int currentTurn = 1;
        System.out.println("실행 결과");

        while (currentTurn <= totalTurns) {
            tryMovingAllCars();
            displayCurrentMovingDistances();
            currentTurn++;
        }
    }

    private int getNumOfCars() {
        return inputView.getNumberFromStdin("자동차 대수는 몇 대 인가요?");
    }

    private int getNumOfTry() {
        return inputView.getNumberFromStdin("시도할 회수는 몇 회 인가요?");
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
