package com.racing.domain;

import com.racing.utils.RacingHelper;
import com.racing.utils.RandomMover;

public class Car implements RandomMover {

    private int state = 0;

    // 기본 생성자
    public Car() {
        this(0); // 기본값 0으로 다른 생성자 호출
    }

    // 상태 지정 생성자
    public Car(int state) {
        this.state = state;
    }

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

    public String displayState() {
        return "-".repeat(state);
    }
}
