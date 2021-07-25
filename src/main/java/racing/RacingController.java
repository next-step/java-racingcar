package racing;

import racing.domain.game.entity.RacingGame;
import racing.exception.DuplicateKeyException;
import racing.exception.EmptyCarException;
import racing.exception.InvalidInputException;
import racing.view.DosInputView;
import racing.view.DosResultView;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingController {
    public static void main(String[] args) {
        RacingController solution = new RacingController(
                new DosInputView(),
                new DosResultView()
        );
        solution.run();
    }

    private InputView inputView;
    private ResultView resultView;
    public RacingController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        try {
            RacingGame game = inputView.inputRacingGame();
            game.racingAll();
            resultView.printResult(game);
        } catch (EmptyCarException | InvalidInputException e) {
            resultView.printException(e);
        } catch (IllegalStateException e) {
            resultView.printException(
                    new DuplicateKeyException("중복된 자동차 이름이 존재 합니다.")
            );
        }
    }
}
