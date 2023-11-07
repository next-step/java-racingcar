package ch3;

import java.util.List;

public class ResultView {

    private static final String SYMBOL = "-";

    public void showResultComment(String text) {
        System.out.println("\n" + text);
    }

    public void showResultCarRacing(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(SYMBOL.repeat(car.getPosition()));
        }
        System.out.println();
    }
}
