package carracing.service.dto;

/**
 * RacingScore
 * description 차량별 점수
 * version 0.0.2
 *
 * history
 *  0.0.1) 클래스 신규생성
 *  0.0.2) carName 필드 신규추가
 */
public class RacingScore {

    private final String carName;
    private final int score;

    public RacingScore(String carName, int score) {
        this.carName = carName;
        this.score = score;
    }

    public String getCarName() {
        return carName;
    }

    public int getScore() {
        return score;
    }
}
