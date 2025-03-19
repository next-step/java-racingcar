package racing;

import java.util.List;

public class RacingCarService {

    private int numberOfCars;
    private int numberOfLaps;


    public void start() {
        inputRacingData();
        startRacing();
    }

    private void inputRacingData() {
        numberOfCars = InputView.getNumberOfCars();
        numberOfLaps = InputView.getNumberOfLaps();
    }

    private void startRacing() {
        List<Car> cars = CarFactory.createRacingCars(numberOfCars);
        Race race = new Race(cars, numberOfLaps);
        race.startRacing();
    }
}
