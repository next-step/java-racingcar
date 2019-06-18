package study.racingcar.model;

/**
 * Created by wyparks2@gmail.com on 2019-06-17
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class RacingGameInfo {
    private int countOfRacingCar;
    private int moveCarTryLimit;

    public RacingGameInfo(int countOfRacingCar, int moveCarTryLimit) {
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
