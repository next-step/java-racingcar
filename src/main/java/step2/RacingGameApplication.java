package step2;

import java.util.List;
import java.util.Scanner;

import step2.game.domain.Cars;
import step2.game.service.RacingGame;

public class RacingGameApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCar = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int times = scanner.nextInt();

        RacingGameInputModel racingGameInputModel = new RacingGameInputModel(numberOfCar, times);
        RacingGame racingGame = new RacingGame(racingGameInputModel);
        List<Cars> result = racingGame.start();

        System.out.println("\n실행 결과");
        RacingGameResultModel resultModel = new RacingGameResultModel(result);
        ResultView resultView = new ResultView(resultModel);
        resultView.printRacingGameResult();

    }

}
