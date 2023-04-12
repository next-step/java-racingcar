package CarRacing;

import CarRacing.view.InputView;
import CarRacing.view.ResultView;

import java.util.Random;
import java.util.*;

public class Racing {

    static InputView inputView = new InputView();
    static ResultView resultView = new ResultView();
    private final Random random = new Random();

    private static final int CONDITION_NUMBER = 4;
    private static final int DISTANCE_PER_TRY = 1;

    public void Competition(String inputCarNumber, String inputTryNumber) {

        int numberOfCar = inputView.getNumberOfCar(inputCarNumber);
        int numberOfTry = inputView.getNumberOfTry(inputTryNumber);

        List<Car> cars = new ArrayList<>(numberOfCar);
        for (int idxCar=0; idxCar < numberOfCar; idxCar++) {
            cars.add(new Car());
        }

        for (int idxTry=0; idxTry < numberOfTry; idxTry++) {
            for(int idxCar=0; idxCar < numberOfCar; idxCar++) {
                cars.get(idxCar).move(drive(random.nextInt(10)));
                resultView.printCurrentDistance(cars.get(idxCar));
            }
            System.out.println();
        }

    }

    public int drive(int number) {
        if (number >= CONDITION_NUMBER) {
            return DISTANCE_PER_TRY;
        }

        return 0;
    }
}

