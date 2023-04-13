package CarRacing;

import CarRacing.view.InputView;
import CarRacing.view.ResultView;

import java.util.Random;
import java.util.*;

public class Racing {

    private static final int CONDITION_NUMBER = 4;
    private static final int DISTANCE_PER_TRY = 1;

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();
    private static final Random random = new Random();


    public void Competition() {

        int numberOfCar = inputView.getNumberOfCar();
        int numberOfTry = inputView.getNumberOfTry();

        List<Car> cars = new ArrayList<>(numberOfCar);
        for (int idxCar=0; idxCar < numberOfCar; idxCar++) {
            cars.add(new Car());
        }

        for (int idxTry=0; idxTry < numberOfTry; idxTry++) {
            for(int idxCar=0; idxCar < numberOfCar; idxCar++) {
                cars.get(idxCar).move(drive(random.nextInt(10)));
            }

            resultView.printCurrentDistance(cars);
        }
    }

    public int drive(int number) {
        if (number >= CONDITION_NUMBER) {
            return DISTANCE_PER_TRY;
        }

        return 0;
    }
}

