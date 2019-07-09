package homework.week1.racingcar.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

public class RacingCarGame {
    private static final String NUMBER_REGEX = "^[0-9]*$";
    private static final int MIN_RACING_VALUE = 1;
    private static final int RANDOM_NUM_RANGE = 10;
    private static final String SEPARATOR_STRING = ",";

    private List<Car> cars;
    private int numberOfRacing;

    public RacingCarGame(String carStrings, String numberOfRacing) {
        checkNumberString(numberOfRacing);
        int number = Integer.parseInt(numberOfRacing);
        checkInputPositiveNum(number);
        this.numberOfRacing = number;
        this.cars = initializeCars(carStrings);
    }

    private static List<Car> initializeCars(String carStrings) {
        checkEmptyOrNull(carStrings);
        List<Car> cars = new ArrayList<>();
        for (String carName : carStrings.split(SEPARATOR_STRING)) {
            checkEmptyOrNull(carName);
            cars.add(new Car(carName));
        }
        return cars;
    }

    private static void checkEmptyOrNull(String value) throws IllegalArgumentException {
        if (StringUtils.isBlank(value)) {
            throw new IllegalArgumentException("차이름은 빈 문자열이나 공백문자열이 올 수 없습니다.");
        }
    }

    private static void checkNumberString(String strValue) throws IllegalArgumentException {
        if (StringUtils.isBlank(strValue) || !Pattern.matches(NUMBER_REGEX, strValue)) {
            throw new IllegalArgumentException("숫자형태 문자열이 와야 할 자리에 다른형태 문자열이 있습니다.");
        }
    }

    private static void checkInputPositiveNum(int value) throws IllegalArgumentException {
        if (value < MIN_RACING_VALUE) {
            throw new IllegalArgumentException("반드시 1 이상의 숫자를 입력하세요!");
        }
    }

    public RacingCarGameResult tryRace() {
        startEachOfCar();
        return RacingCarGameResult.of(cars);
    }

    public boolean isFinishRace(int tryNumberOfRacing) {
        return this.numberOfRacing == tryNumberOfRacing;
    }

    private int randomNumber(int numberRange) {
        Random random = new Random();
        return random.nextInt(numberRange);
    }

    private void startEachOfCar() {
        for (Car car : cars) {
            car.move(car.movable(randomNumber(RANDOM_NUM_RANGE)));
        }
    }
}
