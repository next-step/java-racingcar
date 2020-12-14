package racingcar;

import racingcar.domain.CarNames;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameWithCarName;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.Scanner;

public class RacingCarGameMain {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        inputView.printQuestions("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        CarNames carNames = inputView.inputCarNames(new Scanner(System.in));
        inputView.printQuestions("시도할 회수는 몇 회 인가요?");
        int moveCount = inputView.inputMoveCount(new Scanner(System.in));
        System.out.println();

        RacingGame racingGame = new RacingGameWithCarName(carNames, moveCount);

        resultView.print();
        while (racingGame.hasTryCount()) {
            RacingCars cars = racingGame.start(carNames.size(), moveCount);
            resultView.printRacingCars(cars);
        }
        resultView.printWinners(racingGame.pickWinners());

    }

}