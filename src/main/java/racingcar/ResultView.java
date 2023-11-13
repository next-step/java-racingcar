package racingcar;

import java.util.List;

public class ResultView {
    private static final String START_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    public static void printRoundResult(RacingGame game) {
        startPrint(game);

        for (RacingCar car : game.getCars()) {
            printLocationOfCar(car);
        }
        System.out.println();
    }

    private static void startPrint(RacingGame game) {
        if (game.checkFirstRound()) {
            System.out.println();
            System.out.println(START_MESSAGE);
        }
    }

    private static void printLocationOfCar(RacingCar car) {
        String result = car.getName() + " : " + car.getLocationMark();
        System.out.println(result);
    }

    public static void printWinners(List<RacingCar> winners) {
        String[] winnersName = new String[winners.size()];
        for (int i=0; i<winners.size(); i++) {
            winnersName[i] = winners.get(i).getName();
        }
        String result = String.join(", ", winnersName);
        result += WINNER_MESSAGE;
        System.out.println(result);
    }
}
