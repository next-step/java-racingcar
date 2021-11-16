package racingcar;

import racingcar.domain.RacingCar;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingGameMain {
    private static final int NUMBER_ZERO = 0;

    public static void main(String[] args)  {
        InputView inputView = new InputView();
        try {
            inputView.startRacingGame();
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.exit(NUMBER_ZERO);
        }

        // 레이싱 게임에 참가할 레이싱카 생성
        RacingGameService racingGameService = new RacingGameService(inputView.getCarNames(), inputView.getTryCount());
        List<RacingCar> racingCars = racingGameService.makeRacingCars();

        // 레이스 시작
        racingGameService.racing(racingCars);
        ResultView resultView = new ResultView();
        resultView.drawRacing(racingCars);

        // 우승자 선정
        List<RacingCar> winnerCars = racingGameService.getWinner(racingCars);
        resultView.drawWinner(winnerCars);
    }
}
