package racinggame.controller;

import racinggame.domain.Racing;

public class RacingGame {
    // 자동차 게임을 실제로 시작하는 행동
    public static Racing game(Racing racing) {

        racing.carForwardStatus();
        return racing;
    }
}
