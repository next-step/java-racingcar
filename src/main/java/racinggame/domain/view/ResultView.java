package racinggame.domain.view;

import racinggame.domain.car.Car;
import racinggame.domain.racing.Racing;
import racinggame.domain.racing.RoundResult;

import java.util.ArrayList;
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
    private Racing racing;

    public ResultView(Racing racing) {
        this.racing = racing;
    }

    private void drawCarMovingRange(String carName, int repeat) {
        StringBuffer sb = new StringBuffer();
        sb.append(carName + CAR_NAME_AND_MOVE_RANGE_DELIMITER);
        for (int i = 0; i < repeat; i++) {
            sb.append(MOVE_RANGE_MARK);
        }
        System.out.println(sb.toString());
    }

    private void drawOneRoundResult(RoundResult roundResult) {
        for (int i = 0; i < roundResult.getResult().size(); i++) {
            drawCarMovingRange(roundResult.getResult().get(i).getCarName(), roundResult.getResult().get(i).getMoveRange());
        }
        System.out.println();
    }

    public void drawAllRoundResult() {
        for (int i = 0; i < this.racing.getRoundResult().size(); i++) {
            drawOneRoundResult(this.racing.getRoundResult().get(i));
        }
    }

    public void drawWinners() {
        StringBuffer sb = new StringBuffer();
        List<Car> winner = this.racing.findWinner();
        List<String> winnerNames = new ArrayList<>();

        for (Car car : winner) {
            winnerNames.add(car.getCarName());
        }

        System.out.println(String.join(", ", winnerNames) + WINNER_ANNOUNCE);
    }
}
