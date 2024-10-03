package racingcar.service;

import racingcar.model.Car;
import java.util.*;

public class CarRacing {

    private static Car[] carsStatus = null;

    public Car[] carRaceReady(int numberOfCars) {
        makeCarsStatusArr(numberOfCars);
        return getCarsStatus();
    }

    public void carRaceStart(int numberOfCars) {
        int[] randomNumbers = generateRandomNumberForMovingCar(numberOfCars);
        boolean[] carsMovingForwardStatus = isCarMovingForward(randomNumbers);
        saveCarsStatus(carsMovingForwardStatus);
    }

    public void makeCarsStatusArr(int numberOfCars) {
        carsStatus = new Car[numberOfCars];

        for(int i = 0; i < carsStatus.length; i++) {
            carsStatus[i] = new Car(i+1, "");
        }
    }

    public int[] generateRandomNumberForMovingCar(int numberOfCars) {
        Random random = new Random();

        int[] randomNumbers = new int[numberOfCars];

        for(int i = 0; i < numberOfCars; i++)
            randomNumbers[i] = random.nextInt(9) + 1;

        return randomNumbers;
    }

    public boolean[] isCarMovingForward(int[] randomNumbers) {
        boolean[] carsMovingForwardStatus = new boolean[randomNumbers.length];

        for(int i = 0; i < randomNumbers.length; i++) {
            if(randomNumbers[i] >= 4)
                carsMovingForwardStatus[i] = true;
        }

        return carsMovingForwardStatus;
    }

    public void saveCarsStatus(boolean[] carsMovingForwardStatus) {
        for(int i = 0; i < carsMovingForwardStatus.length; i++) {
            Car carStatus = carsStatus[i];

            if(carsMovingForwardStatus[i]) {
                carStatus.currentCarMovingStatus += "-";
            }
        }
    }

    public Car[] getCarsStatus() {
        return carsStatus;
    }
}

