package carracing.domain;

import carracing.constants.CarRacingConstant;
import carracing.service.dto.RacingScore;
import common.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Cars
 * description 경기에 참가한 차량 리스트
 * version 0.0.4
 *
 * history
 *  0.0.1) 클래스 신규생성
 *  0.0.2) 클래스명 변경 Players -> Cars
 *  0.0.3) driveAll, inquiryRacingScores 메소드 추가
 *  0.0.4) carNames 기반 인스턴스 초기화 구조로 리팩토링
 *  0.0.5) Winners 클래스 생성로직 추가
 */
public class Cars {

    private static final String CAR_NAMES_DELIMITER = ",";

    private final List<Car> carList = new ArrayList<>();

    public Cars(String carNames) {
        validateCarNames(carNames);
        validateCarNameArray(carNames.split(CAR_NAMES_DELIMITER));
        registerCarList(carNames.split(CAR_NAMES_DELIMITER));
    }

    private void validateCarNames(String carNames) {
        if(StringUtils.isEmpty(carNames)) {
            throw new IllegalArgumentException("경주에 참가할 자동차 명을 입력해 주세요.");
        }
    }

    private void validateCarNameArray(String[] carNames) {
        if(carNames.length < CarRacingConstant.MIN_CAR_REGISTER_COUNT) {
            throw new IllegalArgumentException("자동차 등록수는 최소 한 대 이상이어야 합니다.");
        }
    }

    private void registerCarList(String[] carNames) {
        for (String carName : carNames) {
            this.carList.add(new Car(carName));
        }
    }

    public void driveAll() {
        for (Car car : carList) {
            car.drive(new Engine());
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<RacingScore> racingScoreList() {
        List<RacingScore> racingScoreList = new ArrayList<>();
        for (Car car : carList) {
            racingScoreList.add(car.inquiryRacingScore());
        }
        return racingScoreList;
    }

    public int maxScore() {
        int maxScore = 0;
        for (Car car : carList) {
            maxScore = car.calculateWinnerScore(maxScore);
        }
        return maxScore;
    }

    public List<Car> chooseWinners() {
        List<Car> winnerList = new ArrayList<>();
        for (Car car : carList) {
            addWinner(car, winnerList);
        }
        return winnerList;
    }

    private void addWinner(Car car, List<Car> winnerList) {
        if (car.isWinner(maxScore())) {
            winnerList.add(car);
        }
    }
}
