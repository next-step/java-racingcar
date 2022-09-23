import controller.InputView;
import controller.impl.ConsoleInputView;
import model.GameParam;
import model.GameResult;
import service.impl.RandomStrategy;


public class RacingGameApp {

    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        GameParam param = inputView.getInputFromUser();
        RacingGame game = new RacingGame(new RandomStrategy(), param.getCarNum());
        for (int i = 0; i < param.getTryNum(); i++) {
            GameResult result = game.play();
            result.show();
        }
    }
}