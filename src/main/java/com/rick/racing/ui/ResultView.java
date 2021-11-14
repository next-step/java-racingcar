package com.rick.racing.ui;

import com.rick.racing.model.CarRecordHistory;
import com.rick.racing.model.RacingPlayData;
import com.rick.racing.model.RacingResult;

public class ResultView {

    public static final String MESSAGE_RUN_RESULT = "실행 결과";
    public static final String MESSAGE_PROGRESS_MARK = "-";

    public void showResult(RacingPlayData racingPlayData,
        RacingResult racingResult) {
        System.out.println(MESSAGE_RUN_RESULT);

        for (int tryIndex = 0; tryIndex < racingPlayData.getTryCount(); tryIndex++) {
            showRoundRecord(racingPlayData, racingResult, tryIndex);
            System.out.println();
        }
    }

    private void showRoundRecord(RacingPlayData racingPlayData, RacingResult racingResult, int tryIndex) {
        for (int carIndex = 0; carIndex < racingPlayData.getCarCount(); carIndex++) {
            CarRecordHistory record = racingResult.getRecord(carIndex);
            int carPosition = record.getPosition(tryIndex);

            for (int i = 0; i < carPosition; i++) {
                System.out.print(MESSAGE_PROGRESS_MARK);
            }
            System.out.println();
        }
    }
}
