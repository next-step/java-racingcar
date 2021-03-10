package carracing.service;

import carracing.constants.CarRacingConstant;

public class CarRacingValidator {

    public void validateCarRegisterCount(int racingCarCount) {
        if(racingCarCount < CarRacingConstant.MIN_CAR_REGISTER_COUNT) {
            throw new IllegalArgumentException("자동차 등록수는 최소 한 대 이상이어야 합니다.");
        }
    }

    public void validateRoundCount(int roundCount) {
        if(roundCount < CarRacingConstant.MIN_ROUND_COUNT) {
            throw new IllegalArgumentException("경기 횟수는 최소 1회 이상이어야 합니다.");
        }
    }
}
