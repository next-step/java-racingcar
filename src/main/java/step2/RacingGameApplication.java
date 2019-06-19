package step2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import step2.game.domain.CarName;
import step2.game.dto.RacingGameInputModel;
import step2.game.dto.RacingGameResultModel;
import step2.game.service.RacingGame;
import step2.game.view.ResultView;

public class RacingGameApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputCarNames = scanner.nextLine();
        List<CarName> carNames = Arrays.stream(inputCarNames.split(","))
                                       .map(CarName::new)
                                       .collect(Collectors.toList());
        System.out.println("시도할 회수는 몇 회 인가요?");
        int times = scanner.nextInt();

        RacingGameInputModel racingGameInputModel = new RacingGameInputModel(carNames, times);
        RacingGame racingGame = new RacingGame(racingGameInputModel);
        RacingGameResultModel result = racingGame.start();

        System.out.println("\n실행 결과");
        ResultView resultView = new ResultView(result);
        resultView.printRacingGameResult();

    }

}
