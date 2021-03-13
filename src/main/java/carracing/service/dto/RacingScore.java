package carracing.service.dto;

/**
 * RacingScore
 * description 차량별 점수
 * version 0.0.1
 *
 * history
 *  0.0.1) 클래스 신규생성
 */
public class RacingScore {

    private final int carNumber;
    private final int score;

    public RacingScore(int carNumber, int score) {
        this.carNumber = carNumber;
        this.score = score;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public int getScore() {
        return score;
    }
}
