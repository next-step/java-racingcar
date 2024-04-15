package step3_CarRacing.view;

import step3_CarRacing.Car;
import step3_CarRacing.Race;

import java.util.List;

public class ResultView {
    public void displayRaceResult(List<Car> cars){
        cars.forEach(car -> System.out.println("-".repeat(car.getDistance())));
        System.out.println();
    }
    public void printResultHeader() {
        System.out.printf("실행 결과\n");
    }
/*

    public void displayRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println("-".repeat(car.getDistance()));
        }
        System.out.println();
    }
*/

}
