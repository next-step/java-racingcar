package racingcar.utils;

import racingcar.dto.Record;
import racingcar.dto.StageRecord;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static final char MOVE_STRING = '-';
    public static final String WINNER_NAME_DELIMITER = ",";

    public static void outputWinners(List<Record> winnerRecords) {
        String winnerNames = winnerRecords.stream()
                .map(Record::getCarName)
                .collect(Collectors.joining(WINNER_NAME_DELIMITER));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

    public static void outputStageRecords(List<StageRecord> stageRecords) {
        System.out.println("실행 결과");
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
