package laststep.ui;

import laststep.domain.Car;
import laststep.domain.Cars;

public class OutputView {
    private static final String WINNER_SEPARATOR_COMMA = ", ";
    private static final String HYPHEN = "-";

    public static void match(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.printName() + " : " + makeForwardDistance(car.printPosition()));
        }
        System.out.println();
    }

    public static void raceResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void winner(Cars cars) {
        Cars winners = cars.findWinners();
        String winnerNames = winners.printWinners(WINNER_SEPARATOR_COMMA);
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

    private static String makeForwardDistance(String position) {
        return HYPHEN.repeat(Math.max(0, Integer.parseInt(position)));
    }

    private OutputView() {}
}
