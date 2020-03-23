package carRacing;

import carRacing.view.ResultView;
import java.util.ArrayList;

public class RacingGame {

    int numberOfCar;
    int time;

    ArrayList<Car> cars;
    ArrayList<Integer> carPositions;
    ResultView resultView = new ResultView();

    public RacingGame(int numberOfCar, int time) {
        this.numberOfCar = numberOfCar;
        this.time = time;
        setCars();
        resultView.showResult();
    }

    public void setCars() {
        cars = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new Car());
        }
        checkCarPositions();
    }

    public void move() {
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
