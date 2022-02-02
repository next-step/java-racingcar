package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.controller.ResultDto;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.PlayerName;

public class OutputView {

    private static final String CAR_WINNER_DELIMITER = ", ";

    private OutputView() {}

    public static void printDistance(final List<ResultDto> result, int size) {
        for (ResultDto resultDto: result) {
            System.out.println(resultDto.currentStatus());
            if (result.indexOf(resultDto) % size == size - 1) {
                System.out.println();
            }
        }
    }

    public static void printWhoIsWinner(final Cars cars) {
        String winners = winners(cars);

        System.out.print("최종 우승자 : " + winners);
        System.out.println();
    }

    public static void printTurnResult() {
        System.out.println("실행 결과");
    }

    private static String winners(final Cars cars) {
        return cars.getWinnerList().stream()
            .map(Car::name)
            .map(PlayerName::get)
            .collect(Collectors.joining(CAR_WINNER_DELIMITER));
    }
}
