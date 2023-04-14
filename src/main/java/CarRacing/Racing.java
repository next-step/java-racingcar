package CarRacing;

import CarRacing.view.InputView;
import CarRacing.view.ResultView;

import java.util.*;

public class Racing {

    public static void start() {
        String[] nameOfCars = InputView.getCars();
        int numberOfTry = InputView.getNumberOfTry();

        Competition competition = new Competition();
        List<Car> cars = competition.entry(nameOfCars);

        for (int idxTry=0; idxTry < numberOfTry; idxTry++) {
            competition.moveCars(cars);
            ResultView.printCurrentDistance(cars);
        }

        ResultView.printWinners(competition.winners(cars));
    }


}

