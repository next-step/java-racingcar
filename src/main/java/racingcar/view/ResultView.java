package racingcar.view;

import racingcar.domain.RacingResult;
import racingcar.domain.Record;

public class ResultView {

    public void show(RacingResult result) {
        System.out.println("실행 결과");
        result.getRecords().forEach(this::printRecord);
    }

    private void printRecord(Record record) {
        record.getRacingCars().forEach(racingCar ->
                System.out.println(racingCar.getPosition())
        );
        System.out.println();
    }

}
