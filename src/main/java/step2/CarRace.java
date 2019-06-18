package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRace {

    private List<Car> cars;
    private int numberOfTrials;

    public CarRace(int numberOfCars, int numberOfTrials) {
        this.cars = makeCars(numberOfCars);
        this.numberOfTrials = numberOfTrials;
    }

    private List<Car> makeCars(int numberOfCars) {
        List<Car> cars = new ArrayList<>();
        for(int i=0; i<numberOfCars; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    private void executeTrials() {
        for(int i=0; i<numberOfTrials; i++) {
            moveCars();
        }
    }

    private OutputView moveCars() {
        for(Car car : this.cars) {
            decideMoveOrNot(car);
        }
        return new OutputView(this.cars);
    }

    private void decideMoveOrNot(Car car) {
        if(canMove()) {
            car.move();
        }
    }

    private boolean canMove() {
        if(getRandomNumber() >= 4) {
            return true;
        }
        return false;
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public void raceStart() {
        System.out.println("실행 결과");
        executeTrials();
    }
}
