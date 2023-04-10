package racingcar;

import java.util.ArrayList;
import java.util.Random;

public class RacingService {
    public ArrayList<CarInfo> makeCarList(int numOfCars) {
        return new ArrayList<>(numOfCars);
    }

    public RacingInfo makeRacingInfo(UserInput userInput) {
        RacingInfo racingInfo = new RacingInfo();
        racingInfo.setNumOfCars(Integer.parseInt(userInput.getNumOfCars()));
        racingInfo.setNumOfTries(Integer.parseInt(userInput.getNumOfTries()));
        racingInfo.setCarInfos(makeCarList(Integer.parseInt(userInput.getNumOfCars())));
        return racingInfo;
    }

    public void moveFoward(int numToTry, ArrayList<CarInfo> carInfos) {
        for (int i = 0; i < numToTry; i++) {
            carInfos.stream()
                    .map(carInfo -> {
                        carInfo.setResultOfRand(getRand(10));
                        return carInfo;
                    })
                    .filter(carInfo -> carInfo.getResultOfRand() > 4)
                    .forEach(CarInfo::moveFoward);
        }
    }

    private int getRand(int bound) {
        int rand = new Random().nextInt(bound);
        return rand;
    }
}
