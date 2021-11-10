package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.StringJoiner;

public class ResultView {
    public void show(List<List<Car>> record, List<Car> winners) {
        racePart(record);
        winnerPart(winners);
    }

    private void racePart(List<List<Car>> record) {
        System.out.println("실행결과");
        for (int i = 0; i < record.size(); i++) {
            for (Car car : record.get(i)) {
                System.out.println(car.statusWithNameAndPosition());
            }
            System.out.println();
        }
    }

    private void winnerPart(List<Car> winners) {
        StringJoiner sj = new StringJoiner(",");
        for (Car winner : winners) {
            sj = sj.add(winner.statusWithName());
        }
        System.out.println(sj + "가 최종 우승했습니다.");
    }
}
