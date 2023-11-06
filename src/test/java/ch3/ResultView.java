package ch3;

import java.util.List;

public class ResultView {

    public void showResultCarRacing(List<Car> carList) {
        for (Car car : carList) {
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
