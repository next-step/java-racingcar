package racinggame;

import racinggame.domain.Cars;
import racinggame.domain.RaceRecorder;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class RacingGamePack {

    private Cars cars;
    private RaceRecorder recorder;

    public RacingGamePack() {
        this.cars = initializeCars();
        this.recorder = new RaceRecorder();
    }

    private Cars initializeCars() {
        return new Cars(InputView.retryableInputCarsNames());
    }

    public void startGame() {
        cars.raceStart(InputView.retryableInputRaceCount(), recorder);
        ResultView.display(recorder.getRecords());
    }


}
