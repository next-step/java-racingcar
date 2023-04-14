package CarRacing;

import CarRacing.view.InputView;
import CarRacing.view.ResultView;
import CarRacing.Competition;

import java.util.*;

public class Racing {

    public static void start() {

        String[] nameOfCars = InputView.getCars();
        int numberOfCar = nameOfCars.length;
        int numberOfTry = InputView.getNumberOfTry();

        List<Car> cars = new ArrayList<>(numberOfCar);
        for (String nameOfCar : nameOfCars) {
            cars.add(new Car(nameOfCar));
        }

        for (int idxTry=0; idxTry < numberOfTry; idxTry++) {
            Competition.moveCars(cars);
            ResultView.printCurrentDistance(cars);
        }

        ResultView.printWinners(Competition.winners(cars));
    }


}

