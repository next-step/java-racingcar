package study.racing;

import study.racing.domain.RaceAttempt;
import study.racing.domain.RaceInput;
import study.racing.view.InputView;
import study.racing.view.ResultView;

import static study.racing.view.InputView.*;

public class RaceMain {

    public static void main(String[] args) {
        RaceInput raceInput = race();

        RaceAttempt raceAttempt = new RaceAttempt(raceInput);

        // ResultView.result(raceInput, raceAttempt);
    }
}
