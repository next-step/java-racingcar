package study.racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {

    public int carCount;
    public int tryCount;

    List<RacingCar> racingCarsList = new ArrayList<>();

    public ResultView resultView = new ResultView();
    public InputView inputView = new InputView();

    public void race() {
        settingRace();
        settingCar();
        raceStart();
    }

    public void settingRace() {
        System.out.println(resultView.viewQuestionMessage("CAR"));
        carCount = inputView.scanNumber();
        System.out.println(resultView.viewQuestionMessage("TRY"));
        tryCount = inputView.scanNumber();
        System.out.println(resultView.viewQuestionMessage("PLAY_RESULT"));
    }

    public void settingCar() {
        for (int i = 0; i < carCount; i++) {
            racingCarsList.add(new RacingCar());
        }
    }

    public void raceStart() {
        for (int i = 0; i < tryCount; i++) {
            play();
        }
    }

    public void play() {
        for (int i = 0; i < carCount; i++) {
            forwardCar(racingCarsList.get(i));
            System.out.println(resultView.viewLocation(racingCarsList.get(i).forwardCount));
        }
        resultView.viewEmpty();
    }

    public void forwardCar(RacingCar racingCar) {
        if (inputView.forwardAndStop(inputView.randomNumber()).equals("FORWARD")) {
            racingCar.forward();
        }
    }


}
