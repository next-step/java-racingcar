package com.rick.racing.ui;

import com.rick.racing.model.CarRecordHistory;
import com.rick.racing.model.RacingPlayData;
import com.rick.racing.model.RacingResult;

public class ResultView {

    public void showResult(RacingPlayData racingPlayData,
        RacingResult racingResult) {
        System.out.println("실행 결과");

        for (int tryIndex = 0; tryIndex < racingPlayData.getTryCount(); tryIndex++) {
            for (int carIndex = 0; carIndex < racingPlayData.getCarCount(); carIndex++) {
                CarRecordHistory record = racingResult.getRecord(carIndex);
                int carPosition = record.getPosition(tryIndex);

                for (int i = 0; i < carPosition; i++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
