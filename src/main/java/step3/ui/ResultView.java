package step3.ui;

import step3.domain.Car;
import step3.domain.RacingResult;
import step3.domain.RacingRound;

import java.util.List;
import java.util.stream.IntStream;

import static java.lang.String.join;
import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;
import static step3.util.Constants.NUMBER_ZERO;

/**
 * 자동차 경주의 상태를 출력하기 위한 클래스
 */
public class ResultView {

    public static final String GUIDE_WINNER = "가 최종 우승했습니다.";
    public static final String CAR_DISTANCE_MARKING = "-";
    public static final String SPLIT_DELIMITER = ", ";
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
                .collect(joining(lineSeparator() + lineSeparator()));

        System.out.println(result + System.lineSeparator());
    }

    // 라운드당 자동차 기록 출력
    private String printRecordPerCar(final RacingRound round) {
        final List<Car> cars = round.getCars();
        return cars.stream()
                .map(this::printDistancePerRecord)
                .collect(joining(lineSeparator()));
    }

    // 자동차 별 거리 출력
    private String printDistancePerRecord(final Car car) {
        int position = car.getPosition().getPosition();
        String carDistance = IntStream.range(NUMBER_ZERO, position)
                .mapToObj(i -> hyphen)
                .reduce(EMPTY, (acc, cur) -> acc + cur);
        return String.format("%s : %s ", car.getName(), carDistance);
    }

    // 승자 출력 메서드
    public void printWinner(RacingResult racingResult) {
        final String[] winner = racingResult.findWinners();
        System.out.println(join(SPLIT_DELIMITER, winner) + GUIDE_WINNER);
    }
}
