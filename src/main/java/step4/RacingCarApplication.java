package step4;

import step4.domain.CarRacingType;
import step4.strategy.move.RandomMoveStrategy;
import step4.view.UsingNameCarInputView;

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
