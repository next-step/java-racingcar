package com.racing.domain;

import com.racing.utils.IRandomMove;
import com.racing.utils.RacingHelper;

public class Car implements IRandomMove {

    private int state = 0;

    public void move() {
        if (shouldMove()) {
            state++;
        }
    }

    @Override
    public boolean shouldMove() {
        int randNum = RacingHelper.getRandomNumber();
        return RacingHelper.isForward(randNum);
    }
}
