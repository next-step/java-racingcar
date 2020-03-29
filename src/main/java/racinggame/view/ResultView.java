package racinggame.view;

import racinggame.domain.car.Car;
import racinggame.domain.racing.Racing;
import racinggame.domain.racing.RacingCars;
import racinggame.domain.racing.RacingRoundResults;

import java.util.List;

/**
 * 1. "-" 상수
 * 1. 입력 크기 만큼 '-' 표기
 * 1. 한 라운드의 이동 거리 표기
 * 1. 전체 라운드의 이동거리 표기
 * 1. 우승자 표기
 */
public class ResultView {
    private static final char MOVE_RANGE_MARK = '-';
    private static final String CAR_NAME_AND_MOVE_RANGE_DELIMITER = " : ";
    private static final String WINNER_ANNOUNCE = "가 최종 우승했습니다.";

    public ResultView() {
    }

    private void drawCarMovingRange(String carName, int repeat) {
        StringBuffer sb = new StringBuffer();
        sb.append(carName).append(CAR_NAME_AND_MOVE_RANGE_DELIMITER);

        for (int i = 0; i < repeat; i++) {
            sb.append(MOVE_RANGE_MARK);
        }

        System.out.println(sb.toString());
    }

    private void drawOneRoundResult(RacingCars cars) {
        for (Car car : cars.getCars()) {
            drawCarMovingRange(car.getCarName(), car.getMoveRange());
        }

        System.out.println();
    }

    private void drawAllRoundResult(RacingRoundResults racingRoundResults) {
        for (RacingCars cars : racingRoundResults.getResults()) {
            drawOneRoundResult(cars);
        }
    }

    private void drawWinners(Racing racing) {
        StringBuffer sb = new StringBuffer();
        List<String> winner = racing.findWinner();

        System.out.println(String.join(", ", winner) + WINNER_ANNOUNCE);
    }

    public void drawResult(RacingRoundResults racingRoundResults, Racing racing) {
        drawAllRoundResult(racingRoundResults);
        drawWinners(racing);
    }
}
