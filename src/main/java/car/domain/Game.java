package car.domain;

import car.view.Input;
import car.view.Output;

import java.util.*;

public class Game {
    private static final int MINIMUM_CAR_AMOUNT = 2;
    private Input input = new Input();
    private Cut cut = new Cut();

    public void excute(List<Car> cars, String count) {
        Drive drive = new Drive(cars);
        RaceResults raceResults = drive.carRacing(Integer.valueOf(count));
        Output output = new Output(cars, raceResults);

        output.printRaceResult();
    }

    public List<Car> createCars(String[] carInputs) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carInputs) {
            cars.add(cut.getCar(carName));
        }

        return cars;
    }
}
