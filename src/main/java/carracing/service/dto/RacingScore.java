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

    private int carNumber;
    private int score;

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
