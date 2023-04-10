package racingcar;

import java.util.ArrayList;

public class RacingService {
    public ArrayList<Car> makeCarList (int numOfCars) {
        return new ArrayList<>(numOfCars);
    }

    public RacingInfo makeRacingInfo(UserInput userInput) {
        RacingInfo racingInfo = new RacingInfo();
        racingInfo.setNumOfCars(Integer.parseInt(userInput.getNumOfCars()));
        racingInfo.setNumOfTries(Integer.parseInt(userInput.getNumOfTries()));
        racingInfo.setCars(makeCarList(Integer.parseInt(userInput.getNumOfCars())));
        return racingInfo;
    }
}
