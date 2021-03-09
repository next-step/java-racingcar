package step3.ui;

import step3.domain.RacingResult;
import step3.domain.RacingRound;
import step3.domain.Car;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static step3.util.Constants.START_IDX;

/**
 * 자동차 경주의 상태를 출력하기 위한 클래스
 */
public class ResultView {

    public static final String CAR_DISTANCE_MARKING = "-";
    public static final String CARRIAGE_RETURN = "\n";
    public static final String EMPTY = "";

    private final String hyphen;

    public ResultView() {
        this.hyphen = CAR_DISTANCE_MARKING;
    }

    // 응답 결과를 출력하는 기능
    public void responseResult(final RacingResult racingRound) {
        final List<RacingRound> racingRounds = racingRound.getRacingRounds();

        final String result = racingRounds.stream()
                .map(this::printRecordPerCar)
                .collect(joining(CARRIAGE_RETURN + CARRIAGE_RETURN));

        System.out.println(result);
    }

    // 라운드당 자동차 기록 출력
    private String printRecordPerCar(final RacingRound round) {
        final List<Car> cars = round.getCars();
        return cars.stream()
                .map(this::printDistancePerRecord)
                .collect(joining(CARRIAGE_RETURN));

    }

    // 자동차 별 거리 출력
    private String printDistancePerRecord(final Car car) {
        return IntStream.range(START_IDX, car.getPosition())
                .mapToObj(i -> hyphen)
                .reduce(EMPTY, (acc, cur) -> acc + cur);
    }

}
