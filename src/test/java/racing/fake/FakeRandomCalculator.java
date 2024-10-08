package racing.fake;

import racing.domain.game.Calculator;

public class FakeRandomCalculator implements Calculator {

    @Override
    public int getRandomNumber() {
        return 5;
    }
}
