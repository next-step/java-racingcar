package racingGame.view;

import racingGame.domain.Cars;

public class ResultView {
    private static final String TIRE_MARK = "-";
    private static final String WINNING_SENTENCE = "가 최종 우승했습니다.";
    private static final String EMPTY = " ";
    private static final String SEPARATOR = ":";
    private static final StringBuilder sb = new StringBuilder();

    public static void printRacingResult(Cars cars) {
        printTitle();
        System.out.println(combineResult(cars));
        System.out.println(joinWinners(cars));
    }

    private static String joinWinners(Cars cars) {
        return String.join(", ", cars.findCoWinner()).concat(WINNING_SENTENCE);
    }

    private static StringBuilder combineResult(Cars cars) {
        int carsNum = cars.getCars().size();
        for (int i = 0; i < carsNum; i++) {
            sb.append(joinFinalRound(cars, i));
        }
        return sb;
    }

    private static String joinFinalRound(Cars cars, int i) {
        return String.format("%s%s%s%s%s\n",
                cars.getCars().get(i).getCarName(),
                EMPTY, SEPARATOR, EMPTY,
                cars.getCars().get(i).createTrace(TIRE_MARK));
    }

    private static void printTitle() {
        System.out.println("살행결과");
    }

}
