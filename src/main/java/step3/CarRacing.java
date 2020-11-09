package step3;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();

    private List<Car> cars;

    private RaceRoulette raceRoulette = RaceRoulette.simple(10);

    public void start() {
        displayInputView();

        int totalTurns = inputView.getInputData().getNumOfTry();

        readyToRace(inputView.getInputData().getNumOfCars());

        int currentTurn = 1;
        System.out.println("실행 결과");

        while (currentTurn <= totalTurns) {
            tryMovingAllCars();
            displayCurrentMovingDistances();
            currentTurn++;
        }
    }

    private void readyToRace(int numOfCars) {
        this.cars = new ArrayList<>(numOfCars);
        int number = 1;
        while (number <= numOfCars) {
            cars.add(new Car(number++));
        }
    }

    private void displayInputView() {
        inputView.draw();
    }

    private void displayCurrentMovingDistances() {
        this.resultView.showRaceState(cars);
    }

    /**
     * race 에 참여한 모든 car 들이 이동을 시도한다
     */
    private void tryMovingAllCars() {
        this.cars.forEach(car -> car.move(raceRoulette));
    }

    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing();
        carRacing.start();
    }
}
