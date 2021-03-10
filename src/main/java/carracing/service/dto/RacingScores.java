package carracing.service.dto;

import carracing.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<RacingScore> getRacingScoreList() {
        return racingScoreList;
    }

    public void registerRacingScore(Car car) {
        if(_isExists(car)) {
            this.modifyRacingScore(car);
            return;
        }
        RacingScore racingScore = new RacingScore();
        racingScore.setCarNumber(car.getCarNumber());
        racingScore.setScore(car.getMileage());
        racingScoreList.add(racingScore);
    }

    private boolean _isExists(Car car) {
        return racingScoreList.stream().anyMatch(score -> score.getCarNumber()==car.getCarNumber());
    }

    private void modifyRacingScore(Car car) {
        if(_isExists(car)) {
            Optional<RacingScore> racingScore = racingScoreList.stream()
                    .filter(score -> score.getCarNumber() == car.getCarNumber())
                    .findFirst();
            racingScore.ifPresent(score -> score.setScore(car.getMileage()));
            return;
        }
        throw new IllegalArgumentException("점수 정보가 존재하지 않습니다.");
    }
}
