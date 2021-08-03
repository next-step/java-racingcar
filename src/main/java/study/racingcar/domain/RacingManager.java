package study.racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingManager {

    private List<Car> ragingCarList = new ArrayList<>();


    /**
     * 생성시점에 레이싱 카 리스트 생성
     */
    public RacingManager(int numberOfCar) {
        makeRacingCar(numberOfCar);
    }

    public RacingManager(String nameOfCars) {
        String[] carNameList = nameOfCars.split(",");
        checkAllCarNameLength(carNameList);
        makeRacingCar(carNameList);
    }

    private void checkAllCarNameLength(String[] carNameList) {
        for (String carName : carNameList) {
            validateCarNameLength(carName);
        }
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 넘을 수 없습니다");
        }
    }

    public void startRacing() {
        for (Car car : ragingCarList) {
            moveRacingCar(car);
        }
    }

    private void moveRacingCar(Car car) {
        car.moveCar(new RandomMovingStrategy());
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

    private void makeRacingCar(String[] carNameList) {
        for (String carName : carNameList) {
            ragingCarList.add(new Car(carName));
        }
        ragingCarList = Collections.unmodifiableList(ragingCarList);
    }


    public List<Car> getCarList() {
        return this.ragingCarList;
    }

    public List<Car> getRacingWinners() {
        int maxPosition = ragingCarList.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .get().getPosition();

        return ragingCarList.stream()
                .filter(car -> car.getPosition() == maxPosition).collect(Collectors.toList());
    }
}
