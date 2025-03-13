package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {

    int numberOfCars;
    int numberOfLaps;


    public void start() {
        inputRacingData();
        startRacing();
    }

    private void inputRacingData() {
        numberOfCars = InputView.getNumberOfCars();
        numberOfLaps = InputView.getNumberOfLaps();
    }

    private void startRacing() {
        Race r = new Race(numberOfCars, numberOfLaps);
        r.startRacing();
    }
}
