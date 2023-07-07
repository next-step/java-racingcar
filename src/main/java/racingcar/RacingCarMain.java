package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.CarName;
import racingcar.domain.Game;
import racingcar.domain.TryCount;
import racingcar.view.InputView;

import java.util.List;
import java.util.function.Supplier;

public class RacingCarMain {

    public static void main(String[] args) {
        Game game = processInput();

        RacingCarController racingCarController = new RacingCarController(game);
        racingCarController.printResult();
    }

    private static <T> T retryIfException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return retryIfException(supplier);
        }
    }

    private static Game processInput() {
        List<CarName> carNames = retryIfException(InputView::readCarNames);
        TryCount tryCount = retryIfException(InputView::readTryCount);
        return new Game(carNames, tryCount);
    }
}
