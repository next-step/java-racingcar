package racing;

import racing.view.input.InputView;
import racing.dto.RaceInfo;
import racing.domain.RaceResult;
import racing.domain.RaceTrack;
import racing.domain.RandomNumRaceRule;
import racing.view.result.ResultView;

public class RaceAssociation {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RaceInfo input = inputView.racingInput();

        RaceTrack track = new RaceTrack(input);
        track.race(new RandomNumRaceRule());
        RaceResult raceResult = track.getRaceResult();

        ResultView resultView = new ResultView();
        resultView.result(input.attemptNumber().getValue(), raceResult);
    }
}
