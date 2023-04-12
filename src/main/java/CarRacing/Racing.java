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

    public void racing(int numberOfCar, int numberOfTry) {
        if (numberOfCar == 0) {
            numberOfCar = inputView.getNumberOfCar(null);
        }

        if (numberOfTry == 0) {
            numberOfTry = inputView.getNumberOfTry(null);
        }

        if ( numberOfCar < 0 || numberOfTry < 0 ) {
            requestReTypePositiveNumber();
            throw new IllegalArgumentException("negative number is not supported");
        }

        List<Car> cars = new ArrayList<Car>(numberOfCar);
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

    private static void requestReTypePositiveNumber() {
        System.out.println("양의 숫자만 입력해주세요!");
    }

}
