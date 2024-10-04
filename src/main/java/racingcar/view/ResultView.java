package racingcar.view;

import racingcar.model.CarRecord;
import racingcar.service.CarRacing;

import java.util.List;

public class ResultView {
    private CarRacing carRacing;

    public ResultView() {
        System.out.println("실행 결과");
    }

    public void printRacingResult(List<CarRecord> records) {

        for(CarRecord record : records) {
            System.out.println(record.getDashCharacterString());
        }

        System.out.println();
    }


}
