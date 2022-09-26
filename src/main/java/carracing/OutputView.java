package carracing;

import java.util.List;

public class OutputView {

    public void printStart() {
        System.out.println("실행 결과");
    }

    public void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.trail());
        }
        System.out.println("");
    }
}
