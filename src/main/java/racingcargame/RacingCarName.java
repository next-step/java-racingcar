package racingcargame;

public class RacingCarName {
    private String name;

    RacingCarName(RacingCar racingCar) {
        this.name = racingCar.showCarName();
    }

    RacingCarName(String name) {
        this.name = name;
    }

    public String showWinnerName(RacingCar racingCar) {
        return name;
    }

    public String getName() {
        return name;
    }
}
