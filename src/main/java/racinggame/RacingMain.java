package racinggame;

import racinggame.controller.GameController;
import racinggame.dto.Result;
import racinggame.view.OutPutView;
import racinggame.dto.InputDto;
import racinggame.view.InputView;

public class RacingMain {

    public static void main(String[] args) {
        String carNames = InputView.readCarNames();
        int repeatCount = InputView.readRepeatCount();
        GameController controller = new GameController();
        Result result = controller.play(new InputDto(carNames, repeatCount));
        OutPutView.render(result);
    }

}
