package view;

import domain.Car;

import java.util.Set;

public class ResultView {

    public void printEndOfRace() {
        System.out.println("실행 결과");
    }

    public void printRaceResult(Set<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getSteps());
        }
        System.out.println();
    }
}
