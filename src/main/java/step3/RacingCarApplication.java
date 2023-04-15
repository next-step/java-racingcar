package step3;

import step3.domain.CarRacingType;
import step3.strategy.move.RandomMoveStrategy;
import step3.view.UsingNameCarInputView;

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
