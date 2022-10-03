package racingcar;

import racingcar.ui.ResultView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    private final List<Car> carList;
    private final int tryCount;

    public RacingCarGame(int carCount, int tryCount) {
        this.carList = createCars(carCount);
        this.tryCount = tryCount;
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(this.carList);
    }

    private List<Car> createCars(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
        return carList;
    }

    public void play() {
        ResultView.printResultStartMessage();
        for (int i = 0; i < tryCount; i++) {
            List<Integer> roundResult = carList.stream()
                    .map(Car::tryMove)
                    .collect(Collectors.toList());
            ResultView.printRoundResult(roundResult);
        }
    }
}
