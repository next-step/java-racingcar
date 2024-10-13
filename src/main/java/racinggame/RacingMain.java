package racinggame;

import racinggame.domain.CommaPatternNames;
import racinggame.dto.History;
import racinggame.random.DefaultRandomNumberGenerator;
import racinggame.view.OutPutView;
import racinggame.domain.RacingGame;
import racinggame.dto.InputDto;
import racinggame.view.InputView;

public class RacingMain {

    public static void main(String[] args) {
        InputDto read = InputView.readCount();
        RacingGame racingGame = new RacingGame(read.getRepeatCount(), new CommaPatternNames("test,test"));
        History snapShot = racingGame.start(new DefaultRandomNumberGenerator());
        OutPutView.render(snapShot);
    }

}
