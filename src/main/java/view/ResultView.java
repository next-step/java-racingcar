package view;

import core.Car;

import java.util.List;

public class ResultView {

    private ResultView() {};

    public static void printOutputValue(List<Car> carList) {
        carList.stream().forEach(car -> System.out.println(getStringFromPosition(car)));
        System.out.println();
    }

    public static String getStringFromPosition(Car car) {
        String string = "";
        for(int i=0 ; i < car.position ; i++) {
            string = string.concat("-");
        }
        return string;
    }

}
