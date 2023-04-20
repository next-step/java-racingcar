package step4.view;

import step4.model.Record;
import step4.model.RecordGroup;

import java.util.List;

public class ResultView {
    private static final String OUTPUT_TEXT = "실행 결과";
    private static final String COLON_TEXT = " : ";
    private static final String DISTANCE_TEXT = "-";

    private static final String WINNER_SUFFIX = "가 최종 우승했습니다.";

    public void printDistanceOfPlayers(List<List<Record>> allRecords) {
        System.out.println(OUTPUT_TEXT);
        allRecords.forEach(records -> System.out.println(getRecords(records)));
    }

    public StringBuilder getRecords(List<Record> records) {
        StringBuilder stringBuilder = new StringBuilder();
        records.forEach(record -> stringBuilder.append(record.getPlayer())
                .append(COLON_TEXT)
                .append(DISTANCE_TEXT.repeat(record.getDistance()))
                .append(System.lineSeparator()));
        return stringBuilder;
    }

    public void printFinalWinner(RecordGroup recordGroup) {
        System.out.println(recordGroup.getWinners() + WINNER_SUFFIX);
    }

}
