package study.racing.controller;

import study.racing.common.Message;
import study.racing.service.Racing;

import static study.racing.common.Common.inputValueWithMessage;

public class RacingController {
    public static void main(String[] args) {

        Racing racing = new Racing();

        racing.setGameCount(
                //자동차 대수는 몇대 인가요?
                inputValueWithMessage(Message.MSG_ASK_CARS_COUNT),
                //시도할 회수는 몇 회 인가요?
                inputValueWithMessage(Message.MSG_ASK_ROUND_COUNT)
        );
    }
}
