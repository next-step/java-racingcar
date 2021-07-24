package study.racing.controller;

import static study.racing.view.InsertView.inputCarsNameWithMessage;
import static study.racing.view.InsertView.inputValueWithMessage;

import study.racing.common.Message;
import study.racing.service.Racing;
import study.racing.view.DrawDisplay;

public class RacingController {

  public static void main(String[] args) {

    Racing racing = new Racing(
        inputCarsNameWithMessage(Message.MSG_ASK_CARS_NAME),
        inputValueWithMessage(Message.MSG_ASK_ROUND_COUNT));

    DrawDisplay drawDisplay = new DrawDisplay();
    drawDisplay.resultGame(racing.getWinnersName());
  }
}
