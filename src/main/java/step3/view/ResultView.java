package step3.view;

import step3.model.Race;

public class ResultView {

    private static final String RESULT = "실행결과";

    private final Race race;

    public ResultView(Race race) {
        this.race = race;
    }
    public void showRace() {
        System.out.println(RESULT);
        race.race();
    }
}
