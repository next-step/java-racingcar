package carracing.domain;

import carracing.constants.CarRacingConstant;
import carracing.service.dto.RacingScores;

import java.util.ArrayList;
import java.util.List;

/**
 * Cars
 * description 경기에 참가한 차량 리스트
 * version 0.0.3
 *
 * history
 *  0.0.1) 클래스 신규생성
 *  0.0.2) 클래스명 변경 Players -> Cars
 *  0.0.3) driveAll, inquiryRacingScores 메소드 추가
 */
public class Cars {

    private static final int FIRST_CAR_NUMBER = 1;

    private final List<Car> carList = new ArrayList<>();

    public List<Car> getCarList() {
        return carList;
    }

    public Cars(int racingCarCount) {
        validate(racingCarCount);
        registerCarList(racingCarCount);
    }

    private void validate(int racingCarCount) {
        if(racingCarCount < CarRacingConstant.MIN_CAR_REGISTER_COUNT) {
            throw new IllegalArgumentException("자동차 등록수는 최소 한 대 이상이어야 합니다.");
        }
    }

    private void registerCarList(int racingCarCount) {
        for (int i = FIRST_CAR_NUMBER; i <= racingCarCount; i++) {
            this.carList.add(new Car(i));
        }
    }

    public void driveAll() {
        for (Car car : carList) {
            car.drive();
        }
    }

    public RacingScores inquiryRacingScores() {
        return new RacingScores(this);
    }
}
