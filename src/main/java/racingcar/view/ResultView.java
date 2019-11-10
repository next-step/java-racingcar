package racingcar.view;

import racingcar.domain.CarRecord;
import racingcar.domain.Records;

import java.util.List;

import static racingcar.domain.UserInput.DELIMITER;

public class ResultView {

    private static final int LAST_INDEX = -1;
    private List<Records> records;

    public ResultView(List<Records> records) {
        this.records = records;
    }

    public void printRace() {
        for (Records record : records) {
            printRecord(record);
        }
    }

    private void printRecord(Records record) {
        for (CarRecord carRecord : record.getCarRecords()) {
            System.out.println(carRecord.getPrintRecordFormat());
        }
        System.out.println();
    }

    public void printWinner() {

        List<String> winners = records.get(records.size() + LAST_INDEX).findWinners();
        System.out.println(String.format("%s가 최종 우승하였습니다.", String.join(DELIMITER, winners)));
    }

}
