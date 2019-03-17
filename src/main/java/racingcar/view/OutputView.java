package racingcar.view;

import com.google.common.base.Strings;
import racingcar.view.dto.CarsResponseDto;

import java.util.List;

public class OutputView {
    private static final String RESULT_MENT = "실행결과";
    private static final String PATH = "-";
    private static final String COLON = " : ";
    private static final String WINNER_MENT = "가 최종우승했습니다";

    public static void printIntroduction() {
        System.out.println(RESULT_MENT);
    }

    public static void printResult(List<CarsResponseDto> carsResponseDtos, List<String> winners) {
        carsResponseDtos.forEach(OutputView::showCarsStatus);
        showWinner(winners);
    }

    private static void showCarsStatus(CarsResponseDto cars) {
        cars.getCarResponseDtos()
                .forEach(car ->
                        System.out.println(car.getName() + COLON + Strings.repeat(PATH, car.getPosition())));
        System.out.println();
    }

    private static void showWinner(List<String> winners) {
        System.out.print(String.join(", ", winners));
        System.out.println(WINNER_MENT);
    }
}