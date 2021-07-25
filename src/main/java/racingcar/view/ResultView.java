package racingcar.view;

import racingcar.domain.RaceHistory;

public class ResultView {

    public static final String INTRO = "\n실행 결과";
    public static final String NEWLINE = "\n";

    public static void printIntro() {
        System.out.println(INTRO);
    }

    public static void printRaceHistory(RaceHistory raceHistory) {
        System.out.println(raceHistory);
    }
}
