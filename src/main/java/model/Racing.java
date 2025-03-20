package model;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private final List<Car> carList;
    private int remainTryCount;

    public Racing(String[] carNameList, int tryCount) {
        this.validate(carNameList, tryCount);
        this.remainTryCount = tryCount;

        carList = new ArrayList<>();

        for (int i = 0; i < carNameList.length; i++) {
            carList.add(new Car());
        }
    }

    private void validate(String[] carNameList, int tryCount) {
        if (carNameList == null || carNameList.length <= 0) {
            throw new RuntimeException("자동차 대수는 0 이상을 입력해주세요.");
        }

        if (tryCount <= 0) {
            throw new RuntimeException("회수는 0 이상을 입력해주세요.");
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

    public void print() {
        for (Car car : carList) {
            car.print();
        }
        System.out.print("\n");
    }

}
