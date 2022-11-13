package view;

import dto.CarDto;
import domain.Cars;
import domain.RacingResult;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String TRY_RESULT_MESSAGE = "실행 결과";

    private ResultView() {}

    public static void printResult(List<RacingResult> results) {
        System.out.println(TRY_RESULT_MESSAGE);
        for (RacingResult racingResult : results) {
            printResultString(racingResult.getResults());
        }
    }

    public static void printResultString(List<CarDto> results) {
        for (CarDto carDto : results) {
            System.out.println(carDto.getResultString());
        }
        System.out.println();
    }

    public static void printWinners(Cars racingCars) {
        String winners = racingCars.getWinners()
            .stream()
            .map(car -> car.getCarName())
            .map(carName -> carName.getName())
            .collect(Collectors.joining(", "));
        System.out.println(String.format("%s가 최종 우승했습니다.", winners));
    }
}
