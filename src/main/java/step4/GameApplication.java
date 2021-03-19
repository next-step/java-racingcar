package step4;

import step4.controller.GameController;
import step4.view.InputView;
import step4.vo.GameRequestVO;

public class GameApplication {
    public static void main(String[] args) {
        GameRequestVO requestVO = InputView.inputGameInfo();
        GameController controller = new GameController(requestVO);
        controller.run();
    }
}
