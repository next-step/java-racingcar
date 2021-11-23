package com.sryoondev.racingcar.step3.view;

import com.sryoondev.racingcar.step3.GameRecord;
import com.sryoondev.racingcar.step3.Record;
import com.sryoondev.racingcar.step3.Records;

import java.util.Collections;
import java.util.stream.Collectors;

public class ResultView {
    public static void printGameRecord(GameRecord records) {
        System.out.println("실행 결과");
        records.getRecords().forEach(ResultView::printCircuitRecord);
        String winnerNames = records.findFinalWinners()
                .stream()
                .map(Record::getName)
                .collect(Collectors.joining(","));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
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
