package com.jaenyeong.mission2.racingcar.view;

import com.jaenyeong.mission2.racingcar.dto.RacingHistoryDto;

public interface Output {
    String HOW_MANY_USE_CARS = "자동차 대수는 몇 대 인가요?";
    String HOW_MANY_TRY_TIMES = "시도할 횟수는 몇 대 인가요?";
    String NAMES_OF_CARS_TO_BE_RACED = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    String EXECUTION_RESULT = "실행 결과";
    String ERR_INVALID_INPUT_DATA_TYPE = "입력 데이터의 타입이 유효하지 않습니다.";
    String DASH = "-";
    String FINALLY_WINNER = "가 최종 우승했습니다.";

    void printHowManyUseCars();

    void printHowManyTryTimes();

    void printNamesOfTheCarsToBeRaced();

    void printErrWhenInvalidDataTypeInput();

    void printExecutionResult();

    void printAllRacingHistoriesResult(RacingHistoryDto cars);

    void printWinner(RacingHistoryDto historyDto);
}
