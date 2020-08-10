package step5;


import step5.dto.Competition;
import step5.dto.Car;
import step5.util.JudgeRacingResult;
import step5.view.InputView;
import step5.view.ResultView;
import step5.view.WinnerView;

import java.util.ArrayList;
import java.util.List;

import static step5.TextConstant.RACE_RESULT_TEXT;


public class CarRacing {

    private int totalRound = 0;

    private List<Car> entryList = new ArrayList<>();

    private final int STARTING_POSITION = 0;

    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing();
        carRacing.race();
    }

    public void initCarRace() {
        InputView inputView = new InputView();
        Competition competition = inputView.eventStart();

        totalRound = competition.getRound();

        List<String> carNames = competition.getPaticipate();

        for(String carName : carNames) {
            Car racer = Car.participateRacing(carName.trim(), STARTING_POSITION);
            entryList.add(racer);
        }
    }

    public void race() {
        initCarRace();

        System.out.println(RACE_RESULT_TEXT);

        startRacing();

        List<Car> winnersCar = judgeRacing();

        showResult(winnersCar);
    }

    private void showResult(List<Car> winnersCar) {
        WinnerView winnerView = new WinnerView();
        winnerView.racingResult(winnersCar);
    }

    private List<Car> judgeRacing() {
        return JudgeRacingResult.getWinnerInRaceResult(entryList);
    }

    private void startRacing() {
        RacingRound round = new RacingRound();
        ResultView resultView = new ResultView();

        for(int i = 0; i < totalRound; i++){
            round.playRound(entryList);
            resultView.showCompeetitionPosition(entryList);
        }
    }

}
