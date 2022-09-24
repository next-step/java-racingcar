import controller.InputView;
import controller.OutputView;
import controller.impl.ConsoleInputView;
import controller.impl.ConsoleOutputView;
import model.GameParam;
import service.impl.RandomNumberPicker;
import service.impl.RandomStrategy;


public class RacingGameApp {

    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        GameParam param = inputView.getInputFromUser();
        OutputView outputView = new ConsoleOutputView();
        RacingGame game = new RacingGame(new RandomStrategy(new RandomNumberPicker()), param.getCarNames());
        for (int i = 0; i < param.getTryNum(); i++) {
            outputView.printResult(game.play());
        }
    }
}
