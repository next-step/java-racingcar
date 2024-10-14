package com.racing.domain;

import com.racing.utils.RacingHelper;

public class Car {

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
        RacingHelper racingHelper = new RacingHelper();
        
        if (racingHelper.shouldMove()) {
            state++;
        }
    }

    public String displayState() {
        return "-".repeat(state);
    }
}
