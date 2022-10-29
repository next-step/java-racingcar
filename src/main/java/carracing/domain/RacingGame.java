package carracing.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static List<Car> carList;
    private static final List<String> winnerList = new ArrayList<>();

    private int tryCount;

    public RacingGame(List<Car> carList, int tryCount) {
        this.carList = carList;
        this.tryCount = tryCount;
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public static List<String> getWinnerList() {
        return winnerList;
    }

    public boolean remainTryCount() {
        return this.tryCount > 0;
    }

    public void racing() {
        final NumberGenerator numberGenerator = new RandomNumberGenerator();
        carList.forEach(car -> car.move(numberGenerator));
        reduceTryCount();
    }

    public void reduceTryCount() {
        tryCount--;
    }

    private int getMaxPosition() {
        return carList.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
    }

    public void getWinners() {
        int maxPosition = getMaxPosition();
        carList.forEach(car -> {
            if (car.getPosition() == maxPosition)
                winnerList.add(car.getName());
        });
    }

}
