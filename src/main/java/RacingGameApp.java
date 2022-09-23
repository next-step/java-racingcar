import controller.InputView;
import controller.impl.ConsoleInputView;
import model.GameParam;

/**
 * Created by P-161 at : 2022-09-23
 *
 * 여기에 GameApp 클래스에 대한 설명을 기술해주세요
 *
 * @author P-161
 * @version 1.0
 * @since 1.0
 */
public class RacingGameApp {

    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        GameParam param = inputView.getInputFromUser();
    }
}