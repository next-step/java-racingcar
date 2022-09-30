package step3;

import java.util.List;

public class RaceOutput {

    private final List<Car> cars;

    private static final String INDICATOR = "-";

    public RaceOutput(List<Car> cars) {
        this.cars = cars;
        System.out.println("실행 결과");
    }

    public void print() {
        for (Car car : cars) {
            System.out.println(INDICATOR.repeat(car.location()));
        }
        System.out.println();
    }
}
