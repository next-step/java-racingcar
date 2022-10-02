package step4.view;

import step4.domain.Car;
import step4.util.ConvertUtil;

import java.util.Set;

public class ResultView {

    public void printRaceStart() {
        System.out.println("실행 결과");
    }

    public void printEachRaceResult(Set<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + ConvertUtil.convertNumToDash(car.getSteps()));
        }
        System.out.println();
    }

    public void printWinners(String winnerNames) {
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

}
