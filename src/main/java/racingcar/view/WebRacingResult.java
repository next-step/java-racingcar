package racingcar.view;

import racingcar.domain.Car;

public class WebRacingResult {
    private Car car;
    private String spaceString;

    public WebRacingResult(Car car, String spaceString) {
        this.car = car;
        this.spaceString = spaceString;
    }

    public Car getCar() {
        return car;
    }

    public String getSpaceString() {
        return spaceString;
    }
}
