package racing;

import racing.io.InputView;
import racing.model.CarFactory;
import racing.model.RacingGame;

public class RacingApplication {

    public static void main(String[] args) {
        RacingGame.of(CarFactory.createByCount(InputView.getCarCount()), InputView.getRaceCount()).run();
    }
}
