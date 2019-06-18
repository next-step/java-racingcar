package carRacing;

import carRacing.model.RacingCarFactory;
import carRacing.model.RacingCarGroup;
import carRacing.model.RacingGame;
import carRacing.model.RandomGamePoint;
import carRacing.view.InputView;
import carRacing.view.ResultView;

public class RaceGameApplication {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String[] inputRaceCars = inputView.inputRaceCars();
        System.out.println("시도핧 회수는 몇 회 인가요?");
        int numberOfRaceLaps= inputView.inputNumberOfLaps();

        RacingCarFactory racingCarFactory = new RacingCarFactory(inputRaceCars);
        RacingGame racingGame = new RacingGame(racingCarFactory.manufacture(), new RandomGamePoint());

        for (int lap = 0; lap < numberOfRaceLaps; lap++) {
            RacingCarGroup racingCars = racingGame.race();
            ResultView.printRacingMiddleResult(racingCars);
        }
        RacingCarGroup racingWinners = racingGame.gameResult();
        ResultView.printWinners(racingWinners);

    }
}
