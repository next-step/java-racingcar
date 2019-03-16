package racingcar.view.web;

import racingcar.domain.RacingCar;

public class RacingCarDto {
    private String name;
    private String positionText;

    public RacingCarDto(RacingCar car) {
        this.name = car.getName();
        this.positionText = car.getPositionAsText("&nbsp;");
    }

    public RacingCarDto(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPositionText() {
        return positionText;
    }
}
