package racing.application.controller;

import java.util.ArrayList;
import racing.application.view.InputView;
import racing.application.view.OutputView;
import racing.application.view.Score;
import racing.application.view.Winner;
import racing.domain.car.CarFactory;
import racing.domain.car.Labs;
import racing.domain.car.Track;
import racing.domain.score.History;

public class RacingController {

    private final InputView inputView;

    public RacingController(InputView inputView) {
        this.inputView = inputView;
    }

    public void play() {
        String inputNames = inputView.inputNames();
        int moveCount = inputView.moveCount();
        Track track = new Track(new History(new ArrayList<>()), new CarFactory(inputNames).createCar());
        Track racingTrack = track.racing(new Labs(moveCount));
        OutputView outputView = new OutputView(new Score(racingTrack.getHistory(), new Winner(racingTrack.winner())));
        outputView.print();
    }
}
