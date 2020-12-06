package com.jaenyeong.mission2.racingcar.view;

import com.jaenyeong.mission2.racingcar.dto.RacingHistoryDto;

public interface Output {
    String HOW_MANY_USE_CARS = "자동차 대수는 몇 대 인가요?";
    String HOW_MANY_TRY_TIMES = "시도할 횟수는 몇 대 인가요?";
    String EXECUTION_RESULT = "실행 결과";
    String ERR_INVALID_INPUT_DATA_TYPE = "입력 데이터의 타입이 유효하지 않습니다.";

    void printHowManyUseCars();

    void printHowManyTryTimes();

    void printErrWhenInvalidDataTypeInput();

    void printExecutionResult();

    void printRacingResult(RacingHistoryDto cars);
}
