package racingcar;

import racingcar.views.InputView;

import java.util.Map;

public class Main {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        Map<String, String> racingInfoMap = inputView.getRacingInformation();

        RacingGame racingGame = new RacingGame(racingInfoMap);
        racingGame.race();

        //우승자 뽑기

//        ResultView resultView = new ResultView();
//        resultView.printRacingResult();
    }
}
