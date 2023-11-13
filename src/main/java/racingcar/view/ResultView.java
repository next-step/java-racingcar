package racingcar.view;

import racingcar.model.RacingCar;
import racingcar.model.RacingGame;

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
        if (game.getRound() == 1) {
            System.out.println();
            System.out.println(START_MESSAGE);
        }
    }

    private static void printLocationOfCar(RacingCar car) {
        String result = car.getName() + " : " + getLocationMark(car.getPosition());
        System.out.println(result);
    }

    private static String getLocationMark(int location) {
        String locationMark = "";
        for (int i = 0; i<location; i++) {
            locationMark += "-";
        }
        return locationMark;
    }


    public static void printWinners(RacingGame game) {
        List<RacingCar> winners = game.getWinners();

        String[] winnersName = new String[winners.size()];
        for (int i=0; i<winners.size(); i++) {
            winnersName[i] = winners.get(i).getName();
        }
        String result = String.join(", ", winnersName);

        result += WINNER_MESSAGE;
        System.out.println(result);
    }
}
