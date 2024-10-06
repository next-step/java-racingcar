package study.racing.strategy;

import study.utils.NumberUtils;

public class MoveUnderOneDigitStrategy implements RacingMoveStrategy{

    @Override
    public int move() {
        int randomNumber = NumberUtils.randomNumberUnder10();
        int forWord = 0;
        if(randomNumber >=4 ) {
            forWord++;
        }
        return forWord;
    }
}
