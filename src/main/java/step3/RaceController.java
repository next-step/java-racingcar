package step3;

import java.util.List;

public class RaceController {
    private Race race;
    private static final ResultView RESULT_VIEW = ResultView.getInstance();
    private static final InputView INPUT_VIEW = InputView.getInstance();

    public RaceController() {
        setupRace();
    }

    private void setupRace() {
        race = new Race();

        Count carCount = INPUT_VIEW.registerCar();
        Count trialCount = INPUT_VIEW.registerTrialCount();

        race.ready(carCount, trialCount);
    }

    public void gameStart() {
        List<Record> records = race.start();

        RESULT_VIEW.renderResultMessage();
        RESULT_VIEW.renderRaceResult(records);
    }
}
