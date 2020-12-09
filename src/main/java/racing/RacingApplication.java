package racing;

import racing.domain.Cars;
import racing.domain.Racing;
import racing.domain.condition.RandomCondition;
import racing.view.RacingInputView;

public class RacingApplication {
    public static void main(String[] args) {
        Cars cars = new Cars(RacingInputView.carNamesMessage(), new RandomCondition());
        Racing racing = new Racing(RacingInputView.tryTimes(), cars);
        racing.start();
        racing.end();
    }
}
