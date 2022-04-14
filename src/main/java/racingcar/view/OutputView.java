package racingcar.view;

import racingcar.model.Cars;

public class OutputView {
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    private OutputView() throws InstantiationException {
        throw new InstantiationException();
    }

    public static void outputStatus(Cars cars) {
        cars.getStatus().forEach(System.out::println);
        outputEmptyLine();
    }

    private static void outputEmptyLine() {
        System.out.println();
    }

    public static void outputWinners(Cars winnerCars) {
        System.out.println(winnerCars + WINNER_MESSAGE);
    }
}
