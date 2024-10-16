package racinggame;

import racinggame.controller.GameController;
import racinggame.domain.CommaPatternNames;
import racinggame.dto.Result;
import racinggame.random.DefaultRandomNumberGenerator;
import racinggame.view.OutPutView;
import racinggame.domain.RacingGame;
import racinggame.dto.InputDto;
import racinggame.view.InputView;

public class RacingMain {

    public static void main(String[] args) {
        String carNames = InputView.readCarNames();
        int repeatCount = InputView.readRepeatCount();
        GameController controller = new GameController();
        Result result = controller.play(new InputDto(carNames,repeatCount));
        OutPutView.render(result);
    }

}
