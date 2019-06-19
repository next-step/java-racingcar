package step3.domain;

import step3.utils.NumberGenerator;
import step3.utils.RandomNumberGenerator;

public class CarRace {

    private final static int MINIMUM_NUMBER_CAN_BE_INPUT = 1;
    private Cars cars;
    private NumberGenerator numberGenerator;

    private CarRace(Cars cars) {
        this.cars = cars;
        numberGenerator = new RandomNumberGenerator();
    }

    public static CarRace raceStart(String inputCarNames, int numberOfTrials) {
        inputCarNamesValidation(inputCarNames);
        numberOfTrialsValidation(numberOfTrials);

        CarNameList carNameList = convertCarNames(inputCarNames);
        return new CarRace(Cars.makeCars(carNameList));
    }

    private static CarNameList convertCarNames(String inputCarNames) {
         String[] carNameArray = inputCarNames.split(",");
         return CarNameList.makeCarNameList(carNameArray);
    }

    public Cars executeTrials() {
        return moveCars(numberGenerator);
    }

    public Cars moveCars(NumberGenerator numberGenerator) {
        for (Car car : cars.getCars()) {
            car.move(numberGenerator.getRandomNumber());
        }
        return cars;
    }

    private static void inputCarNamesValidation(String inputCarNames) {
        // TODO: 입력값 유효성 체크 로직 작성
    }

    private static void numberOfCarsValidation(int numberOfCars) {
        if (numberOfCars < MINIMUM_NUMBER_CAN_BE_INPUT) {
            throw new IllegalArgumentException("최소 1대의 자동차가 필요합니다.");
        }
    }

    private static void numberOfTrialsValidation(int numberOfTrials) {
        if (numberOfTrials < MINIMUM_NUMBER_CAN_BE_INPUT) {
            throw new IllegalArgumentException("최소 1번의 시행 횟수가 필요합니다.");
        }
    }

}
