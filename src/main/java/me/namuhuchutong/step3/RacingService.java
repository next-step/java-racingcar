package me.namuhuchutong.step3;

public class RacingService {

    public RacingResult runRacing(UserInputInformation userInputInformation) {
        validateTimes(userInputInformation.getTimes());
        return new RacingResult();
    }

    private void validateTimes(int times) {
        if (times <= 0) {
            throw new IllegalArgumentException("자동차 경주 횟수는 음수이거나 0일 수 없습니다 - " + times);
        }
    }
}
