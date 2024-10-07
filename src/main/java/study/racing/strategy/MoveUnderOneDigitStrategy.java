package study.racing.strategy;

import study.utils.NumberUtils;

public class MoveUnderOneDigitStrategy implements RacingMoveStrategy{

    @Override
    public int move() {
        int randomNumber = NumberUtils.randomNumberUnder10();
        if(randomNumber >= 4 ) {
            return 1;
        }
        return 0;
    }
}
