import controller.InputView;
import controller.impl.ConsoleInputView;
import model.GameParam;


public class RacingGameApp {

    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        GameParam param = inputView.getInputFromUser();
    }
}