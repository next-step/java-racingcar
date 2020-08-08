package racingcar.domain;

import racingcar.utils.RandomValueGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 경주에 참여하는 자동차들의 정보를 담당
 * Car를 바탕으로 경주에 참여하는 그룹을 만든다.
 * 각 자동차들은 랜덤값을 받아 현재 위치를 List 형태로 저장하게 된다.
 */
public class Cars {
    private static final int MIN_INPUT_CAR_NUMBER = 1;

    private List<Car> cars;

    public Cars(int inputCarCount) {
        validate(inputCarCount);
        createCars(inputCarCount);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void createCars(int inputCarCount) {
        cars = new ArrayList<>();
        for (int i = 0; i< inputCarCount; i++) {
            cars.add(new Car());
        }
    }

    public void moveCars(RandomValueGenerator randomValue) {
        for (Car car : cars) {
            car.moveCount(randomValue.createRandomValue());
        }
    }

    public void validate(int inputCarCount) {
        if (inputCarCount < MIN_INPUT_CAR_NUMBER) {
            throw new IllegalArgumentException("자동차는 1대 이상 입력되어야 합니다.");
        }
    }
}
