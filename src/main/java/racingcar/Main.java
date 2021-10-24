package racingcar;

import racingcar.domains.Cars;
import racingcar.views.InputView;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        Map<String, String> racingInfoMap = inputView.getRacingInformation();

        RacingGame racingGame = new RacingGame(racingInfoMap);
        List<Cars> racingResult = racingGame.race();

        String winnerNames = racingGame.getWinners();

        //각 라운드별, 각 자동차의 위치 출력하기
        //우승자 출력하기
//        ResultView resultView = new ResultView();
//        resultView.printRacingResult(racingResult);
//        resultview.printRacingWinner(winnerNames);
    }
}
