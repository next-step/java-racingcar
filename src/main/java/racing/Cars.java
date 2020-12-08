package racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private static final int CAN_RUN_MIN_VALUE = 4;
    private static final String NAME_SEPARATOR = ",";
    private static final String EMPTY_STRING = "";
    private static final int MAX_NAME_LENGTH = 5;
    private List<Car> cars = new ArrayList<>();

    public Cars() {
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars run(RandomNumberGenerator randomNumGenerator) {
        for(Car car: cars) {
            decideRun(randomNumGenerator, car);
        }
        return this;
    }

    private void decideRun(RandomNumberGenerator randomNumGenerator, Car car) {
        int randomNum = randomNumGenerator.getRandomNum();
        if(randomNum >= CAN_RUN_MIN_VALUE) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public Cars generate(int number) {
        for(int i = 0; i < number; i ++){
            cars.add(new Car());
        }
        return this;
    }

    public Cars generateCarsWithName(String names) {
        validateEmpty(names);
        String[] carNames = names.split(NAME_SEPARATOR);
        for(String name: carNames) {
            validateNameLength(name);
            cars.add(new Car(name));
        }
        return this;
    }

    private void validateEmpty(String names) {
        if(names == null || EMPTY_STRING.equals(names)) {
            throw new IllegalArgumentException("이름을 입력 하세요");
        }
    }

    private void validateNameLength(String name) {
        if(name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름 다섯자 초과");
        }
    }
}
