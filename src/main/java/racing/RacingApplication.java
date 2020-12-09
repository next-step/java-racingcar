package racing;

import racing.domain.Cars;
import racing.view.InputView;
import racing.domain.Racing;
import racing.domain.condition.RandomCondition;

public class RacingApplication {
    public static void main(String[] args) {
        Cars cars = new Cars(InputView.carNames(), new RandomCondition());
        Racing racing = new Racing(InputView.tryTimes(), cars);
        racing.start();
        racing.end();
    }
}
