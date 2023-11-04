package study.carracing.domain;

import study.carracing.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList = new ArrayList<>();

    public void addCar(Car car) {
        carList.add(car);
    }

    public int getCarListSize() {
        return carList.size();
    }

    public void move(int tryCount) {
        ResultView.printTitle();
        for (int i = 0; i < tryCount; i++) {
            carList.forEach(Car::move);
            ResultView.printResult(carList);
        }
    }
}
