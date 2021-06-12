package car.domain;

import car.view.Output;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Cut cut = new Cut();

    public void excute(Cars cars, String count) {
        Drive drive = new Drive(cars);
        RaceResults raceResults = drive.carRacing(Integer.valueOf(count));
        Output output = new Output(raceResults);

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
