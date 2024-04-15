package step3_CarRacing.view;

import step3_CarRacing.Car;

import java.util.List;

public class ResultView {
    public void displayRaceResult(List<Car> cars) {
        cars.forEach(car -> System.out.println("-".repeat(car.getDistance())));
        System.out.println();
    }

    public void printResultHeader() {
        System.out.print("실행 결과\n");
    }
}
