package step5.view;

import step5.domain.Car;
import step5.domain.Cars;
import step5.util.ConvertUtil;

import java.util.Set;

public class ResultView {

    public void printRaceStart() {
        System.out.println("실행 결과");
    }

    public void printEachRaceResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getCarName()
                    + " : "
                    + ConvertUtil.convertNumToDash(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(Set<String> winners) {
        System.out.println(ConvertUtil.joinStringByComma(winners) + "가 최종 우승했습니다.");
    }

}
