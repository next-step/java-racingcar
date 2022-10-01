package step3.view;

import step3.domain.Car;
import step3.util.ConvertUtil;

import java.util.Set;

public class ResultView {

    public void printRaceStart() {
        System.out.println("실행 결과");
    }

    public void printEachRaceResult(Set<Car> cars) {
        for (Car car : cars) {
            System.out.println(ConvertUtil.convertNumToDash(car.getSteps()));
        }
        System.out.println();
    }

}
