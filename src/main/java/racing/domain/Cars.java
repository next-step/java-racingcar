package racing.domain;

import racing.strategy.RandomMoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Cars {
    private List<Car> carList;

    private Cars(List<Car> carList) {
        this.carList = carList;
    }

    public static Cars from(int numberOfCars) {
        List<Car> tempCarList = new ArrayList<>();
        IntStream.range(0, numberOfCars)
                .forEach(value -> {
                    tempCarList.add(new Car());
                });
        return new Cars(tempCarList);
    }

    public void nextRound() {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).move(new RandomMoveStrategy());
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}
