package controller;

import model.GameParam;


public interface InputView {

    String CAR_NUMBER_ASK_QUESTION = "자동차 대수는 몇 대 인가요?";
    String TRY_NUMBER_ASK_QUESTION = "시도할 회수는 몇 회 인가요?";
    String RUN_RESULT_MSG = "실행 결과";
    String RUN_FAIL_MSG = "자동차 대수 , 시도할 회수는 숫자값이여만 합니다.";

    GameParam getInputFromUser();
}
