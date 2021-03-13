package carracing.service.dto;

import carracing.domain.Car;
import carracing.domain.Cars;

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

    private final List<RacingScore> racingScoreList = new ArrayList<>();

    public List<RacingScore> getRacingScoreList() {
        return racingScoreList;
    }

    public RacingScores(Cars cars) {
        for (Car car : cars.getCarList()) {
            racingScoreList.add(car.inquiryRacingScore());
        }
    }

}
