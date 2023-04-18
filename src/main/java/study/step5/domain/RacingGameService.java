package study.step5.domain;

import study.step5.domain.model.Track;
import study.step5.view.ResultView;

public class RacingGameService {

    public Track gameStart(final String carNames, final int attemptCount) {
        Track track = new Track(carNames, attemptCount);
        while (!track.isRaceEnd()) {
            track.startRacing();
            ResultView.outPut(track);
        }
        return track;
    }

}
