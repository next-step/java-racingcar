package racing;

import java.util.List;

public class ResultView {

    public void print(List<Car> cars) {
        for (Car car : cars) {
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }

}
