package step3.domain;

import spark.utils.StringUtils;
import step3.utils.NumberGenerator;
import step3.utils.RandomNumberGenerator;

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
        validationInputCarNames(inputCarNames);
        validationNumberOfTrials(numberOfTrials);
        CarNames carNames = convertCarNames(inputCarNames);

        return new CarRace(Cars.makeCars(carNames));
    }

    private static CarNames convertCarNames(String inputCarNames) {
        String[] carNameArray = inputCarNames.split(CAR_NAME_SEPARATOR);
        return CarNames.makeCarNames(carNameArray);
    }

    public Cars executeTrials() {
        return moveCars(numberGenerator);
    }

    private Cars moveCars(NumberGenerator numberGenerator) {
        return cars.move(numberGenerator);
    }

    public Winners pickWinners() {
        return Winners.pickWinners(cars);
    }


    private static void validationInputCarNames(String inputCarNames) {
        if (StringUtils.isEmpty(inputCarNames)) {
            throw new IllegalArgumentException("자동차 이름들을 입력해주세요.");
        }
        //TODO: 정규식으로 입력된 자동차이름들 검증 추가하기
    }

    private static void validationNumberOfTrials(int numberOfTrials) {
        if (numberOfTrials < MINIMUM_NUMBER_CAN_BE_INPUT) {
            throw new IllegalArgumentException("최소 1번의 시행 횟수가 필요합니다.");
        }
    }

}
