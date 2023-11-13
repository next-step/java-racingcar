package step5.view;



import step5.controller.RacingResultDto;
import step5.model.Car;

import java.util.List;

public class ResultView {

    public void printRacingResult(RacingResultDto racingResultDto) {
        System.out.println();
        System.out.println("실행 결과");

        for (List<Car> value : racingResultDto.racingResult.values()) {
            value.forEach(System.out::println);
            System.out.println();
        }
    }

    public void printChampionCars(Object object) {
        System.out.println(object);
    }
}
