package racingcar.view;

import racingcar.domain.Race;

public class ResultView {
    private static final String NOTI_RACE_NOT_OVER_YET = "아직 경기가 끝나지 않았습니다.";
    private static final String NOTI_NO_WINNERS = "우승자 없음";
    private static final String NOTI_WINS = "우승!";

    public static void printCurrentState(Race race) {
        System.out.println("< Round " + race.getCurrentRoundString() + " >\n" + race.getCarsStateInString());
    }

    public static void printGameOver(Race race) {
        if (race.isRaceOver() == false) {
            System.out.println(NOTI_RACE_NOT_OVER_YET);
            return;
        }

        printWinners(race);
    }

    public static void printWinners(Race race) {
        String winnerNames = race.getWinnersName();
        if (winnerNames.isEmpty()) {
            System.out.println(NOTI_NO_WINNERS);
            return;
        }

        System.out.println(race.getWinnersName() + " " + NOTI_WINS);
    }
}
