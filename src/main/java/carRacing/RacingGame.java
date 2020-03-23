package carRacing;

import carRacing.view.ResultView;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    int numberOfCar;
    int time;

    List<Car> cars;
    List<Integer> carPositions;
    ResultView resultView = new ResultView();

    public RacingGame(int numberOfCar, int time) {
        this.numberOfCar = numberOfCar;
        this.time = time;
        cars = setCars();
        checkCarPositions();
        resultView.showResult();
    }

    public List<Car> setCars() {
        List<Car> prepareCars = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            prepareCars.add(new Car());
        }
        return prepareCars;
    }

    public void start() {
        move();
    }

    private void move() {
        for(int i=0; i<time; i++) {
            rotate();
            resultView.showGameState(carPositions);
        }
    }

    private void rotate() {
        for(Car car : cars) {
            car.move();
        }
        checkCarPositions();
    }

    private void checkCarPositions() {
        carPositions = new ArrayList<>();
        int i=carPositions.size();
        for(Car car : cars) {
            carPositions.add(i++, car.inquiryPosition());
        }
    }

}
