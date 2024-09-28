import java.util.ArrayList;
import java.util.List;

import race.Car;
import race.CarRace;
import race.CarRandomNumber;
import race.InputView;
import race.RaceInput;
import race.RandomNumber;

public class Main {

    private static final int RANDOM_RANGE = 10;

    public static void main(String[] args) {

        InputView inputView = new InputView();
        RaceInput raceInput = inputView.input();

        List<Car> cars = initCars(raceInput.getCarCount());

        CarRace carRace = new CarRace(raceInput.getCarCount(), raceInput.getTryCount(), cars);

        carRace.start();
    }

    private static List<Car> initCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        RandomNumber randomNumberGenerator = new CarRandomNumber(RANDOM_RANGE);

        for(int i = 0; i < carCount; i++) {
            cars.add(new Car(randomNumberGenerator));
        }

        return cars;
    }
}
