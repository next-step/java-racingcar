package com.sryoondev.racingcar.step3.view;

import com.sryoondev.racingcar.step3.GameRecord;
import com.sryoondev.racingcar.step3.Record;
import com.sryoondev.racingcar.step3.Records;

import java.util.Collections;

public class ResultView {
    public static void printGameRecord(GameRecord records) {
        System.out.println("실행 결과");
        records.getRecords().forEach(ResultView::printCircuitRecord);
    }

    private static void printCircuitRecord(Records records) {
        records.getRecords().forEach(ResultView::printMovement);
        System.out.println();
    }

    private static void printMovement(Record record) {
        System.out.println(record.getName() + " : " +
                String.join("", Collections.nCopies(record.getDistance(), "-")));
    }
}
