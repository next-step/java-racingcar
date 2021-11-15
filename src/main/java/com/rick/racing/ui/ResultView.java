package com.rick.racing.ui;

import com.rick.racing.model.RacingPlayData;
import com.rick.racing.model.RacingResult;

public class ResultView {

    private static final String MESSAGE_RUN_RESULT = "실행 결과";
    private static final String MESSAGE_PROGRESS_MARK = "-";

    public static void showResult(RacingPlayData racingPlayData, RacingResult racingResult) {
        System.out.println(MESSAGE_RUN_RESULT);

        for (int tryIndex = 0; tryIndex < racingPlayData.tryCount(); tryIndex++) {
            drawRoundRecord(racingPlayData, racingResult, tryIndex);
            System.out.println();
        }
    }

    private static void drawRoundRecord(RacingPlayData racingPlayData, RacingResult racingResult, int tryIndex) {
        for (int carIndex = 0; carIndex < racingPlayData.carCount(); carIndex++) {
            int carPosition = racingResult.recordPosition(carIndex, tryIndex);
            drawCarRecord(carPosition);
            System.out.println();
        }
    }

    private static void drawCarRecord(int carPosition) {
        for (int i = 0; i < carPosition; i++) {
            System.out.print(MESSAGE_PROGRESS_MARK);
        }
    }
}
