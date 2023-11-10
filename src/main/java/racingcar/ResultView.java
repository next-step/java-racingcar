package racingcar;

import java.util.List;

public class ResultView {
    public static void output(String msg){
        System.out.println(msg);
    }

    public static void resultOutput(Cars cars) {
        List<Car> carList = cars.getCars();
        for (Car car : carList) {
            System.out.println("-".repeat(car.distance()));
        }
    }
}
