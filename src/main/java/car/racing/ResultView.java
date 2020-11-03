package car.racing;

import java.util.List;

public class ResultView {

    public void resultTitle() {
        System.out.println("\n실행 결과");
    }

    public void newLine() {
        System.out.println();
    }

    public void forward(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.forwardResult()));
    }
}