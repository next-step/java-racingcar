package study.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Race {

    private int tryCount;

    private RacingCars racingCars;

    public ResultView resultView = new ResultView();
    public InputView inputView = new InputView();

    public void race() {
        settingRace();
        raceStart();
    }

    public void settingRace() {
        System.out.println(resultView.viewQuestionMessage("CAR"));
        this.racingCars = new RacingCars(Stream.generate(RacingCar::new).limit(inputView.scanNumber()).collect(Collectors.toList()));
        System.out.println(resultView.viewQuestionMessage("TRY"));
        tryCount = inputView.scanNumber();
        System.out.println(resultView.viewQuestionMessage("PLAY_RESULT"));
    }

    public void raceStart() {
        for (int i = 0; i < tryCount; i++) {
            play();
        }
    }

    public void play() {
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            forwardCar(racingCar);
            System.out.println(resultView.viewLocation(racingCar.forwardCount));
        }
        resultView.viewEmpty();
    }

    public void forwardCar(RacingCar racingCar) {
        racingCar.forwardAndStop(inputView.randomNumber());
    }


}
