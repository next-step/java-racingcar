package racing;

import racing.input.InputView;
import racing.input.RaceInput;
import racing.race.RaceRecord;
import racing.race.RaceResult;
import racing.race.RaceTrack;
import racing.race.RandomNumRaceRule;
import racing.result.ResultView;

import java.util.List;

public class RaceAssociation {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RaceInput input = inputView.racingInput();

        RaceTrack track = new RaceTrack(input);
        track.race(new RandomNumRaceRule());
        RaceResult raceResult = track.getRaceResult();

        ResultView resultView = new ResultView();
        resultView.result(input.attemptNumber().getValue(), raceResult);
    }
}
