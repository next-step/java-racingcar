package controller;

import model.GameParam;


public interface InputView {

    String CAR_NAME_ASK_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    String TRY_NUMBER_ASK_QUESTION = "시도할 회수는 몇 회 인가요?";
    String RUN_RESULT_MSG = "실행 결과";
    String RUN_FAIL_MSG = "시도할 회수는 숫자값이여만 합니다.";
    String INVALID_CAR_NAME_MSG = "자동차 이름이 유효하지 않습니다.";

    GameParam getInputFromUser();
}
