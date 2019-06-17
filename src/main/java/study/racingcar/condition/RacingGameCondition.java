package study.racingcar.condition;

/**
 * Created by wyparks2@gmail.com on 2019-06-17
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class RacingGameCondition {
    private int countOfRacingCar; // 경주하는 자동차 댓수

    private int moveCarTryLimit; // 자동차 이동 시도 횟수 제한

    public RacingGameCondition(int countOfRacingCar, int moveCarTryLimit) {
        this.countOfRacingCar = countOfRacingCar;
        this.moveCarTryLimit = moveCarTryLimit;
    }

    public int getCountOfRacingCar() {
        return countOfRacingCar;
    }

    public int getMoveCarTryLimit() {
        return moveCarTryLimit;
    }
}
