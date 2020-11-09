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
        try {
            return inputView.getNumOfCars();
        } catch (InvalidPropertyValueException e){
            System.err.println("자동차 댓수는 1이상 정수 만 입력 가능합니다.");
            throw e;
        }
    }

    private int getNumOfTries() {
        try {
            return inputView.getNumOfTries();
        } catch (InvalidPropertyValueException e){
            System.err.println("시도할 횟수는 1이상 정수 만 입력 가능합니다.");
            throw e;
        }
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
        this.cars.forEach(it -> it.moveIf( () -> raceRoulette.spin() >= 4 ));
    }

    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing();
        carRacing.start();
    }
}
