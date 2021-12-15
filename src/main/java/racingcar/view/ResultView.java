package racingcar.view;

import racingcar.domain.RacingCars;
import racingcar.domain.RacingResult;
import racingcar.domain.Record;

public class ResultView {

    public void show(RacingResult result) {
        System.out.println("실행 결과");
        result.getRecords().forEach(this::printRecord);

        RacingCars winners = result.getWinners();
        System.out.println(winners.toString() + "가 최종 우승했습니다.");
    }

    private void printRecord(Record record) {
        record.getRacingCars().forEach(racingCar ->
                System.out.println(racingCar.getName() + " : " + racingCar.getPosition())
        );
        System.out.println();
    }

}
