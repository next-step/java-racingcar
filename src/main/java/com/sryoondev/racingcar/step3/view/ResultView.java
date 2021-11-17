package com.sryoondev.racingcar.step3.view;

import com.sryoondev.racingcar.step3.GameRecord;
import com.sryoondev.racingcar.step3.Records;

import java.util.Collections;

public class ResultView {
    private static void printMovement(int movementCount) {
        System.out.println(String.join("", Collections.nCopies(movementCount, "-")));
    }

    private static void printCircuitRecord(Records records) {
        records.getRecords().forEach(ResultView::printMovement);
        System.out.println();
    }

    public static void printGameRecord(GameRecord records) {
        System.out.println("실행 결과");
        records.getRecords().forEach(ResultView::printCircuitRecord);
    }
}
