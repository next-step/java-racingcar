package study.racing.controller;

import static study.racing.common.Common.inputCarsNameWithMessage;
import static study.racing.common.Common.inputValueWithMessage;
import static study.racing.common.Common.splitCarsName;

import study.racing.common.Message;
import study.racing.service.Racing;

public class RacingController {

  public static void main(String[] args) {

    new Racing(
        splitCarsName(inputCarsNameWithMessage(Message.MSG_ASK_CARS_NAME)),
        inputValueWithMessage(Message.MSG_ASK_ROUND_COUNT));

  }
}
