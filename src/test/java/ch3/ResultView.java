package ch3;

import java.util.List;

public class ResultView {

    private static final String SYMBOL = "-";

    public void showResultCarRacing(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(SYMBOL.repeat(car.getPosition()));
        }
        System.out.println();
    }
}
