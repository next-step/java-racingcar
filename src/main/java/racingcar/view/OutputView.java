package racingcar.view;

import racingcar.model.Cars;
import racingcar.view.dto.RacingResult;

public class OutputView {
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String NO_WINNER_RESULT_MESSAGE = "우승 결과가 없습니다.";

    private OutputView() throws InstantiationException {
        throw new InstantiationException();
    }

    private static void outputEmptyLine() {
        System.out.println();
    }

    public static void outputWinners(RacingResult racingResult) {
        if (racingResult == null) {
            System.out.println(NO_WINNER_RESULT_MESSAGE);
            return;
        }

        Cars cars = racingResult.getCars();
        Cars winnerCars = cars.findWinners();
        System.out.println(winnerCars + WINNER_MESSAGE);
    }

    public static void outputStatus(RacingResult racingResult) {
        Cars cars = racingResult.getCars();
        cars.getStatus().forEach(System.out::println);
        outputEmptyLine();
    }
}
