package homework.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarGameEngine {

    private static final String SEPARATOR_STRING = ",";
    private static final int MIN_RACING_VALUE = 1;
    private static final int MIN_RUN_CONDITION_VALUE = 4;
    private static final int RANDOM_NUM_RANGE = 10;

    private int numberOfRacing;
    private List<Integer> carsRunCount;
    private List<Car> cars;

    public RacingCarGameEngine() {}

    public void initialize(String[] carNames, int numbersOfRacing) {
        List<Car> cars = getCarNameArrToCars(carNames);
        setCars(cars);
        setNumberOfRacing(numbersOfRacing);
        List<Integer> carsRunCount = new ArrayList<>();
        for(int index=0; index < cars.size(); index++) {
            carsRunCount.add(0);
        }
        setCarsRunCount(carsRunCount);
    }

    public List<Car> getCarNameArrToCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for(int position = 0; position < carNames.length; position++) {
            Car car = new Car(carNames[position], position);
            cars.add(car);
        }
        return cars;
    }
    public String[] splitInput(String value) {
        return value.split(SEPARATOR_STRING);
    }

    public List<Integer> move() throws NullPointerException {
        if (carsRunCount == null) {
            throw new NullPointerException("경주에 참여하는 자동차가 설정되지 않았습니다!");
        }
        Random randomNumber = new Random();
        for (int index=0; index < carsRunCount.size(); index++) {
            carsRunCount.add(getRunCount(checkRunCondition(randomNumber.nextInt(RANDOM_NUM_RANGE)),
                    carsRunCount.get(index)));
        }
        return carsRunCount;
    }

    void checkEmptyCarNames(String[] carNames) throws IllegalArgumentException {
        if (carNames.length == 0) {
            throw new IllegalArgumentException("차이름은 빈 문자열이나 공백문자열이 올 수 없습니다.");
        }
        for (String carName : carNames) {
            checkEmptyString(carName);
        }
    }

    void checkEmptyString(String value) throws IllegalArgumentException {
        if (value == null || value.isEmpty()) {
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
        return numberOfRacing;
    }

    private void setNumberOfRacing(int numbersOfRacing) {
        this.numberOfRacing = numbersOfRacing;
    }

    public List<Integer> getCarsRunCount() {
        return carsRunCount;
    }

    private void setCarsRunCount(List<Integer> carsRunCount) {
        this.carsRunCount = carsRunCount;
    }

    public List<Car> getCars() {
        return cars;
    }

    private void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
