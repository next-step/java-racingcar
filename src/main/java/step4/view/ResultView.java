package step4.view;

import step4.model.Race;

public class ResultView {

    private static final String MOVE = "-";

    public void show(Race race) {
        race.race(MOVE);
        System.out.printf("%s가 최종 우승했습니다.%n", race.getWinnerNames());
    }
}
