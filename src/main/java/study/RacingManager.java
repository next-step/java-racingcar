package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RacingManager {

    private List<Car> ragingCarList = new ArrayList<>();

    private static final int LOWER_LIMIT_TO_MOVE_CAR = 4;
    private static final int UPPER_LIMIT_TO_MOVE_CAR = 10;

    private Random random = new Random();


    /**
     * 생성시점에 레이싱 카 리스트 생성
     */
    public RacingManager(int numberOfCar) {
        makeRacingCar(numberOfCar);
    }

    public void startRacing() {
        for (Car car : ragingCarList) {
            moveRacingCar(car);
        }
    }

    private void moveRacingCar(Car car) {
        if (canMoveCar(getRandomNumber())) {
            car.moveCar();
        }
    }

    /**
     * 레이싱 카 리스트의 결과 출력을 위해서 도메인 밖에서 getter 를 통해서 오브젝트를 가져가는데, 그 부분에서 데이터 수정이 될 수 도 있음
     * 따라서, 최초 생성 이후 수정이 되지 않도록 unmodifiableList 로 변경
     */
    private void makeRacingCar(int numberOfCar) {
        for (int i = 0; i < numberOfCar; i++) {
            ragingCarList.add(new Car());
        }
        ragingCarList = Collections.unmodifiableList(ragingCarList);
    }

    public boolean canMoveCar(int randomNumber) {
        if (randomNumber >= LOWER_LIMIT_TO_MOVE_CAR) {
            return true;
        }
        return false;
    }

    public int getRandomNumber() {
        return random.nextInt(UPPER_LIMIT_TO_MOVE_CAR);
    }

    public List<Car> getCarList() {
        return this.ragingCarList;
    }
}
