package step5.view;

import step5.domain.Car;
import step5.domain.CarDto;
import step5.domain.Cars;
import step5.util.ConvertUtil;

import java.util.Set;
import java.util.stream.Collectors;

public class ResultView {

    public void printRaceStart() {
        System.out.println("실행 결과");
    }

    public void printEachRaceResult(Set<CarDto> cars) {
        for (CarDto car : cars) {
            System.out.println(car.getCarName()
                    + " : "
                    + ConvertUtil.convertNumToDash(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(Set<CarDto> winners) {
        Set<String> nameOfWinners = winners.stream()
                .map(CarDto::getCarName)
                .collect(Collectors.toSet());

        System.out.println(ConvertUtil.joinStringByComma(nameOfWinners) + "가 최종 우승했습니다.");
    }

}
