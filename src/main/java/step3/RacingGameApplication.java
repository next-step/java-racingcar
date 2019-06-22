package step3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import step3.game.domain.CarName;
import step3.game.dto.RacingGameInputModel;
import step3.game.dto.RacingGameResultModel;
import step3.game.service.RacingGame;
import step3.game.view.InputView;
import step3.game.view.ResultView;

public class RacingGameApplication {

    public static void main(String[] args) {
        RacingGameInputModel inputModel = InputView.inputModel();

        RacingGame racingGame = new RacingGame(inputModel);
        RacingGameResultModel result = racingGame.start();

        ResultView resultView = new ResultView(result);
        resultView.printRacingGameResult();

    }

}
