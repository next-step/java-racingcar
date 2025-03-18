package model;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private final List<Car> carList;
    private int remainTryCount;

    public Racing(int carCount, int tryCount) {
        this.validate(carCount, tryCount);
        this.remainTryCount = tryCount;

        carList = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
    }

    private void validate(int carCount, int tryCount) {
        if (carCount <= 0) {
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
