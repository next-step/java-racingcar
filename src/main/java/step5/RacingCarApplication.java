package step5;

import step5.domain.CarRacingType;
import step5.strategy.move.RandomMoveStrategy;
import step5.view.UsingNameCarInputView;

public class RacingCarApplication {
    public static void main(String[] args) {

      AbstractRacingCarGame abstractRacingCarGame = AbstractRacingCarGame.of(
              CarRacingType.USING_NAME_CAR,
              UsingNameCarInputView.getInstance(),
              RandomMoveStrategy.getInstance()
      );

      abstractRacingCarGame.execute();
    }

}
