package race;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        RaceInput raceInput = InputView.input();

        CarRace carRace = new CarRace(raceInput.getCarCount(), raceInput.getTryCount(), new CarRandomNumber());

        ResultView.output(carRace.getCars());
        carRace.start();
    }

}
