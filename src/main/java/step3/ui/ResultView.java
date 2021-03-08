package step3.ui;

import step3.domain.RacingRound;
import step3.domain.Car;

import java.util.List;
import java.util.stream.IntStream;

import static step3.util.Constants.START_IDX;

/**
 * 자동차 경주의 상태를 출력하기 위한 클래스
 */
public class ResultView {

    public static final String CAR_DISTANCE_MARKING = "-";
    public static final String CARRIAGE_RETURN = "\n";

    // 응답 결과를 출력하는 기능
    public void responseResult(List<RacingRound> racingRound) {
        StringBuilder builder = new StringBuilder();

        racingRound.forEach(
                round -> builder.append(printRecordPerCar(round)).append(CARRIAGE_RETURN));

        System.out.println(builder.toString());
    }

    // 라운드당 자동차 기록 출력
    private String printRecordPerCar(RacingRound round) {
        StringBuilder builder = new StringBuilder();

        round.getCars()
                .forEach(car ->
                        builder.append(printDistancePerRecord(car))
                                .append(CARRIAGE_RETURN));

        return builder.toString();
    }

    // 자동차 별 거리 출력
    private String printDistancePerRecord(Car car) {
        StringBuilder builder = new StringBuilder();
        IntStream.range(START_IDX, car.getPosition())
                .forEach(i -> builder.append(CAR_DISTANCE_MARKING));

        return builder.toString();
    }

}
