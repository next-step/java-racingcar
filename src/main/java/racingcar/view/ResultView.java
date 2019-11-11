package racingcar.view;

import racingcar.domain.CarRecord;
import racingcar.domain.GameResult;
import racingcar.domain.Records;

import java.util.List;

import static racingcar.domain.UserInput.DELIMITER;

public class ResultView {

    private GameResult gameResult;

    public ResultView(GameResult gameResult) {
        this.gameResult = gameResult;
    }

    public void printRace() {
        for (Records record : gameResult.getRecords()) {
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

        List<String> winners = gameResult.findWinners();
        System.out.println(String.format("%s가 최종 우승하였습니다.", String.join(DELIMITER, winners)));
    }

}
