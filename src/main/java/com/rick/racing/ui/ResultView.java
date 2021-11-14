package com.rick.racing.ui;

import com.rick.racing.model.RacingPlayData;
import com.rick.racing.model.RacingResult;

public class ResultView {

    public static final String MESSAGE_RUN_RESULT = "실행 결과";
    public static final String MESSAGE_PROGRESS_MARK = "-";

    private final RacingPlayData racingPlayData;
    private final RacingResult racingResult;

    public ResultView(RacingPlayData racingPlayData, RacingResult racingResult) {
        this.racingPlayData = racingPlayData;
        this.racingResult = racingResult;
    }

    public void showResult() {
        System.out.println(MESSAGE_RUN_RESULT);

        for (int tryIndex = 0; tryIndex < racingPlayData.tryCount(); tryIndex++) {
            drawRoundRecord(racingPlayData, racingResult, tryIndex);
            System.out.println();
        }
    }

    private void drawRoundRecord(RacingPlayData racingPlayData, RacingResult racingResult, int tryIndex) {
        for (int carIndex = 0; carIndex < racingPlayData.carCount(); carIndex++) {
            int carPosition = racingResult.recordPosition(carIndex, tryIndex);
            drawCarRecord(carPosition);
            System.out.println();
        }
    }

    private void drawCarRecord(int carPosition) {
        for (int i = 0; i < carPosition; i++) {
            System.out.print(MESSAGE_PROGRESS_MARK);
        }
    }
}
