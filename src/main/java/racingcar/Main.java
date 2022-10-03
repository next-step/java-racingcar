package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<RacingCar> cars = new ArrayList<>();
        Random random = new Random();

        int numOfCars = InputView.getNumOfCars();
        int tryingCount = InputView.getTryCount();

        for(int i=0 ; i<numOfCars ; i++) {
            cars.add(new RacingCar(random, tryingCount));
        }

        ResultView resultView = new ResultView(cars);
        resultView.printCars();

    }
}
