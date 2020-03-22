package racinggame.domain.expression;

import racinggame.domain.racing.Racing;
import racinggame.domain.racing.RoundResult;

/**
 * 1. "-" 상수
 * 1. 입력 크기 만큼 '-' 표기
 * 1. 한 라운드의 Car의 이동 거리 만큼 '-' 표기
 */
public class ResultView {
    private static final char MOVE_RANGE_MARK = '-';
    private Racing racing;

    public ResultView(Racing racing) {
        this.racing = racing;
    }

    private void drawCarMovingRange(int repeat) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < repeat; i++) {
            sb.append(MOVE_RANGE_MARK);
        }
        System.out.println(sb.toString());
    }

    private void drawOneRoundResult(RoundResult roundResult) {
        for (int i = 0; i < roundResult.getResult().size(); i++) {
            drawCarMovingRange(roundResult.getResult().get(i).getMoveRange());
        }
        System.out.println("\n");
    }

    public void drawAllRoundResult() {
        for (int i = 0; i < this.racing.getRoundResult().size(); i++) {
            drawOneRoundResult(this.racing.getRoundResult().get(i));
        }
    }
}
