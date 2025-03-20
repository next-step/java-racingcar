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
            carList.add(new Car(s));
        }
    }

    private void validate(String[] carNameList, int tryCount) {
        if (carNameList == null || carNameList.length == 0) {
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

    public void printWinner() {
        if (remainTryCount > 0) {
            throw new RuntimeException("아직 시도할 횟수가 남아 있습니다. remainTryCount : " + remainTryCount);
        }

        List<Car> winnerList = this.getWinner();
        String result = winnerList.stream()
            .map(Car::getName)
            .collect(Collectors.joining(","));

        System.out.println(result + "가 최종 우승했습니다.");
    }

    private List<Car> getWinner() {
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
