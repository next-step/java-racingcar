package step4.view;

import step4.domain.Car;
import step4.domain.Cars;
import step4.util.ConvertUtil;

import java.util.Set;

public class ResultView {

    public void printRaceStart() {
        System.out.println("실행 결과");
    }

    public void printEachRaceResult(Cars cars) {
        for (Car car : cars.getCarSet()) {
            System.out.println(car.getCarProperty().getName()
                    + " : "
                    + ConvertUtil.convertNumToDash(car.getCarProperty().getStep()));
        }
        System.out.println();
    }

    public void printWinners(Set<String> winners) {
        System.out.println(ConvertUtil.joinStringByComma(winners) + "가 최종 우승했습니다.");
    }

}
