package study.controller;

import study.service.Racing;

import static study.common.Common.inputValueWithMessage;

public class RacingController {
    public static void main(String[] args) {

        Racing racing = new Racing();

        racing.setGameCount(
                inputValueWithMessage("자동차 대수는 몇대 인가요?."),
                inputValueWithMessage("시도할 회수는 몇 회 인가요?")
        );
    }
}
