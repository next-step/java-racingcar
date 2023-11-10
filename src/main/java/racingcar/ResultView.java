package racingcar;

import java.util.List;

public class ResultView {
    public static final String COLON = " : ";
    public static final String HYPHEN = "-";

    public static void output(String msg){
        System.out.println(msg);
    }

    public static void resultOutput(Cars cars) {
        List<Car> carList = cars.getCars();
        for (Car car : carList) {
            System.out.println(car.name() + COLON + HYPHEN.repeat(car.distance()));
        }
    }
}
