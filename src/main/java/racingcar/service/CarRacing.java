package racingcar.service;

import racingcar.model.Car;
import java.util.*;

public class CarRacing {

    private List<Car> carsStatus;

    public CarRacing() {}

    public CarRacing(int numberOfCars) {
        carRaceReady(numberOfCars);
    }

    private void carRaceReady(int numberOfCars) {
        makeCarsStatusList(numberOfCars);
    }

    public void carRaceStart() {
        int[] randomNumbers = generateRandomNumberForMovingCar(carsStatus.size());

        boolean[] carsMovingForwardStatus = isCarMovingForward(randomNumbers);

        for(int i = 0; i < carsMovingForwardStatus.length; i++) {
            Car car = carsStatus.get(i);
            boolean isCarMovingForward = carsMovingForwardStatus[i];
            car.move(isCarMovingForward);
        }
    }

    public void makeCarsStatusList(int numberOfCars) {
        carsStatus = new ArrayList<Car>();

        for(int i = 0; i < numberOfCars; i++) {
            carsStatus.add(new Car(i+1, 0));
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

    public List<Car> getCarsStatus() {
        return carsStatus;
    }
}

