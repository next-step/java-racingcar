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
        InputDto read = InputView.readCount();
        GameController controller = new GameController();
        Result result = controller.play(read);
        OutPutView.render(result);
    }

}
