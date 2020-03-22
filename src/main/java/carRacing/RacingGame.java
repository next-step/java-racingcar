package carRacing;

import java.util.ArrayList;

public class RacingGame {

    int numberOfCar;
    int time;

    ArrayList<Car> cars;
    ArrayList<Integer> carPositions;

    public RacingGame(int numberOfCar, int time) {
        this.numberOfCar = numberOfCar;
        this.time = time;
        setCars();
    }

    public void setCars() {
        cars = new ArrayList<>();
        for(int i=0; i<numberOfCar; i++) {
            cars.add(new Car());
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
