package step5_racingCarWithWinner.view;

import step5_racingCarWithWinner.domain.Car;
import step5_racingCarWithWinner.domain.Response;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class RacingGameResultView {



    public void printResult(Response response) {
        response.eachStageInfo().forEach((stageInfo)->{
            for(String info: stageInfo){
                System.out.println(info);
            }
            System.out.println();
        });

        OptionalInt max = response.carList().stream().mapToInt(car -> car.carDistance().length()).max();
        String winnersNames = response.carList().stream().filter(car -> car.carDistance().length() == max.getAsInt()).map(Car::carName).collect(Collectors.joining(","));
        System.out.println(winnersNames+"가 최종 우승했습니다.");
    }


}
