package racingcar.utils;

import racingcar.dto.Record;
import racingcar.dto.StageRecord;

import java.util.List;

public class OutputView {

    public static final char MOVE_STRING = '-';

    public static void outputText(String text) {
        System.out.println(text);
    }

    public static void outputStageRecords(List<StageRecord> stageRecords) {

        for (StageRecord stageRecord : stageRecords) {
            System.out.println(stageRecord.getStage() + "회차");
            outputStageRecord(stageRecord);
        }
    }

    private static void outputStageRecord(StageRecord stageRecord) {
        List<Record> records = stageRecord.getRecords();
        for (Record record: records) {
            System.out.println(record.getCarName() + " : " + outputMove(record.getMoveCount()));
        }
        System.out.println();
    }

    private static String outputMove(int value) {
        return String.valueOf(MOVE_STRING).repeat(value);
    }
}
