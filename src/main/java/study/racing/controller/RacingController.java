package study.racing.controller;

import study.racing.common.Message;
import study.racing.service.Racing;

import static study.racing.common.Common.inputValueWithMessage;

public class RacingController {
    public static void main(String[] args) {

        new Racing(inputValueWithMessage(Message.MSG_ASK_CARS_COUNT),
                inputValueWithMessage(Message.MSG_ASK_ROUND_COUNT));

    }
}
