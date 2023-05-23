package study.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Race {
    public static final int CAR_NAME_LIMIT = 5;
    public static final String CAR_NAME_SPLIT_MARK = ",";


    private int tryCount;

    private RacingCars racingCars = new RacingCars();


    public ResultView resultView = new ResultView();
    public InputView inputView = new InputView();

    public void race() {
        settingRace();
        raceStart();
        winnerRevealed();
        raceResult();
    }

    public void settingRace() {
        System.out.println(resultView.viewQuestionMessage("CAR"));
        racingCars.settingRacingCars(inputView.splitString(inputView.scanString()));
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
            System.out.println(resultView.viewCarStatus(racingCar));
        }
        resultView.viewEmpty();
    }

    public void forwardCar(RacingCar racingCar) {
        racingCar.forwardAndStop(inputView.randomNumber());
    }

    public void winnerRevealed() {
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            racingCars.settingMaxLocationCount(racingCar);
        }
        racingCars.settingWinner();
    }

    public void raceResult() {
        String winnersStr = "";
        for (RacingCar racingCar : racingCars.getWinners()) {
            winnersStr = resultView.concatString(winnersStr, racingCar.getCarName());
        }
        System.out.println(winnersStr+resultView.viewQuestionMessage("RACE_RESULT"));
    }

}
