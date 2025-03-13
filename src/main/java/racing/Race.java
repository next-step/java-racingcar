package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {

    public static final int MOVE_POWER_BOUND = 10;
    public static final int DEFAULT_CAR_MOVE_POWER_CONDITION = 4;

    private int numberOfLaps;
    private List<Car> cars;


    public Race(int numberOfCars, int numberOfLaps) {
        this.cars = createRacingCars(numberOfCars, DEFAULT_CAR_MOVE_POWER_CONDITION);
        this.numberOfLaps = numberOfLaps;
    }

    public Race(int numberOfCars, int numberOfLaps, int carMovePowerCondition) {
        this.cars = createRacingCars(numberOfCars, carMovePowerCondition);
        this.numberOfLaps = numberOfLaps;
    }

    private List<Car> createRacingCars(int numberOfCars, int carMovePowerCondition) {
        List<Car> cars = new ArrayList<>();

        for(int i = 0; i < numberOfCars; i++) {
            cars.add(new Car(carMovePowerCondition));
        }
        return cars;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public int getNumberOfLaps() {
        return this.numberOfLaps;
    }

    public void startRacing() {
        ResultView.displayRaceStart();

        for(int i = 0; i < getNumberOfLaps(); i++) {
            ResultView.displayCar(getCars());
            performLap();
        }

        ResultView.displayRaceFinish();
    }

    private void performLap() {
        Random random = new Random();
        for(Car car: cars) {
            int r = random.nextInt(MOVE_POWER_BOUND);
            car.move(r);
        }
    }
}
