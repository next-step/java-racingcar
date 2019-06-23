package homework.week1;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameEngine {

    private static final String SEPARATOR_STRING = ",";
    private static final int MIN_RACING_VALUE = 1;
    private static final int MIN_RUN_CONDITION_VALUE = 4;
    private static final int RANDOM_NUM_RANGE = 10;

    private int numOfRacing;
    private List<Car> cars;

    public RacingCarGameEngine(String carStrings, int numOfRacing) {
        checkEmptyString(carStrings);
        initializeCars(carStrings);
        checkInputPositiveNum(numOfRacing);
        this.numOfRacing = numOfRacing;
    }

    private void initializeCars(String carStrings) {
        cars = new ArrayList<>();
        for (String carName : splitInput(carStrings)) {
            checkEmptyString(carName);
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    public String[] splitInput(String value) {
        return value.split(SEPARATOR_STRING);
    }

    void checkEmptyString(String value) throws IllegalArgumentException {
        if (value == null) {
            throw new IllegalArgumentException("차 이름을 반드시 입력하세요");
        }
        value = value.trim();
        if (value.isEmpty()) {
            throw new IllegalArgumentException("차이름은 빈 문자열이나 공백문자열이 올 수 없습니다.");
        }
    }

    void checkInputPositiveNum(int value) throws IllegalArgumentException {
        if (value < MIN_RACING_VALUE) {
            throw new IllegalArgumentException("반드시 1 이상의 숫자를 입력하세요!");
        }
    }

    boolean checkRunCondition(int value) {
        if (value < MIN_RUN_CONDITION_VALUE) {
            return false;
        }
        return true;
    }

    int getRunCount(boolean isRun, int runCount) {
        if (isRun) {
            return ++runCount;
        }
        return runCount;
    }


    public int getNumberOfRacing() {
        return numOfRacing;
    }


    public List<Car> getCars() {
        return cars;
    }

}
