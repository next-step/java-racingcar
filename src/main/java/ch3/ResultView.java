package ch3;

import java.util.LinkedList;
import java.util.List;

public class ResultView {

    private static final String SYMBOL = "-";

    public void showResultComment(String text) {
        System.out.println("\n" + text);
    }

    public void showCarRacing(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.name() + " : ");
            System.out.println(SYMBOL.repeat(car.position()));
        }
        System.out.println();
    }

    public void showResultCarRacing(List<Car> cars) {
        System.out.println(getCarNames(cars) + "가 최종 우승했습니다.");
    }

    private String getCarNames(List<Car> cars) {
        List<String> names = new LinkedList<>();
        for (Car car : cars) {
            names.add(car.name());
        }
        return String.join(",", names);
    }
}
