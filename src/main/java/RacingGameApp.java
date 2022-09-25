import controller.InputView;
import controller.OutputView;
import controller.impl.ConsoleInputView;
import controller.impl.ConsoleOutputView;
import model.GameParam;
import service.impl.MultipleWinnerStrategy;
import service.impl.RandomNumberPicker;
import service.impl.RandomStrategy;

import java.util.stream.IntStream;


public class RacingGameApp {

    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        GameParam param = inputView.getInputFromUser();
        OutputView outputView = new ConsoleOutputView();
        RacingGame game = initGameWithParam(param);
        outputView.printResultMsg();
        IntStream.range(0, param.getTryNum()).forEach((idx) -> outputView.printResult(game.play()));
        outputView.printWinner(game.getWinners());
    }

    private static RacingGame initGameWithParam(GameParam param) {
        return new RacingGame(new RandomStrategy(new RandomNumberPicker()), new MultipleWinnerStrategy(), param.getCarNames());
    }
}
