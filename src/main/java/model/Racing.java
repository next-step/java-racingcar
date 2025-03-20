package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private final List<Car> carList;
    private int remainTryCount;

    public Racing(String[] carNameList, int tryCount) {
        this.validate(carNameList, tryCount);
        this.remainTryCount = tryCount;

        carList = new ArrayList<>();

        for (String s : carNameList) {
            carList.add(new Car(s, null));
        }
    }

    private void validate(String[] carNameList, int tryCount) {
        if (carNameList == null) {
            throw new RuntimeException("carNameList는 null일 수 없습니다.");
        }

        if (carNameList.length == 0) {
            throw new RuntimeException("자동차 대수는 0 이상을 입력해주세요. carNameList : " + carNameList.length);
        }

        if (tryCount <= 0) {
            throw new RuntimeException("회수는 0 이상을 입력해주세요. tryCount : " + tryCount);
        }
    }

    public void move() {
        for (Car car : carList) {
            car.tryMove();
        }

        remainTryCount--;
    }

    public boolean isRemainTry() {
        return this.remainTryCount > 0;
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public List<Car> getWinner() {
        List<Car> result = new ArrayList<>();

        int max = 0;
        for (Car car : carList) {
            if (max < car.getCurrentPosition()) {
                max = car.getCurrentPosition();
                result.clear();
                result.add(car);
            } else if (max == car.getCurrentPosition()) {
                result.add(car);
            }
        }

        return result;
    }

}
