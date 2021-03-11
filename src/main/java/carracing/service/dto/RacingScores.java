package carracing.service.dto;

import carracing.domain.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * RacingScores
 * description 경기 점수목록
 * version 0.0.1
 *
 * history
 *  0.0.1) 클래스 신규생성
 */
public class RacingScores {

    private List<RacingScore> racingScoreList = new ArrayList<>();

    public int getScoreCount() {
        return racingScoreList.size();
    }

    public List<RacingScore> getRacingScoreList() {
        return racingScoreList;
    }

    public void registerRacingScore(Car car) {
        racingScoreList.add(new RacingScore(car.getCarNumber(), car.getMileage()));
    }

    private boolean _isExists(Car car) {
        return racingScoreList.stream().anyMatch(score -> score.getCarNumber()==car.getCarNumber());
    }
}
