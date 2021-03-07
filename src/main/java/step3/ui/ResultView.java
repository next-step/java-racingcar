package step3.ui;

import step3.domain.Record;

import java.util.List;
import java.util.stream.IntStream;

import static step3.util.Constants.START_IDX;

/**
 * 자동차 경주의 상태를 출력하기 위한 클래스
 */
public class ResultView {

    public static final String CAR_DISTANCE_MARKING = "-";

    // 응답 결과를 출력하는 기능
    public void responseResult(List<Record> records) {
        records.forEach(this::printRecordPerCar);
    }

    private void printRecordPerCar(Record record) {
        IntStream.range(START_IDX, record.getPosition())
                .forEach(i -> printDistancePerRecord());
        System.out.println();
    }

    private void printDistancePerRecord() {
        System.out.print(CAR_DISTANCE_MARKING);
    }
}
