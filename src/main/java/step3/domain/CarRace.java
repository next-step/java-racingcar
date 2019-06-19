package step3.domain;

import spark.utils.StringUtils;
import step3.utils.NumberGenerator;
import step3.utils.RandomNumberGenerator;

import java.util.regex.Pattern;

public class CarRace {

    private final static int MINIMUM_NUMBER_CAN_BE_INPUT = 1;
    private final static String CAR_NAME_SEPARATOR = ",";
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
        String[] carNameArray = inputCarNames.split(CAR_NAME_SEPARATOR);
        return CarNameList.makeCarNameList(carNameArray);
    }

    public Cars executeTrials() {
        return moveCars(numberGenerator);
    }

    private Cars moveCars(NumberGenerator numberGenerator) {
        for (Car car : cars.getCars()) {
            car.move(numberGenerator.getRandomNumber());
        }
        return cars;
    }

    public Winners pickWinners() {
        return Winners.pickWinners(cars);
    }


    private static void inputCarNamesValidation(String inputCarNames) {
        if (StringUtils.isEmpty(inputCarNames)) {
            throw new IllegalArgumentException("자동차 이름들을 입력해주세요.");
        }
        //TODO: 정규식으로 입력된 자동차이름들 검증
    }

    private static void numberOfTrialsValidation(int numberOfTrials) {
        if (numberOfTrials < MINIMUM_NUMBER_CAN_BE_INPUT) {
            throw new IllegalArgumentException("최소 1번의 시행 횟수가 필요합니다.");
        }
    }

}
