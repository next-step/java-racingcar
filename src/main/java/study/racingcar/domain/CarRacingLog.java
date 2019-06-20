package study.racingcar.domain;

/**
 * Created by wyparks2@gmail.com on 2019-06-18
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class CarRacingLog {
    private Car car;
    private int position;

    public CarRacingLog(Car car, int position) {
        this.car = car;
        this.position = position;
    }

    public Car getCar() {
        return car;
    }

    public int getPosition() {
        return position;
    }
}
