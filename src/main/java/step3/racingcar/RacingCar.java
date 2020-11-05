package step3.racingcar;

public class RacingCar implements Car {
    private static final int NEED_POWER = 4;
    private Integer lane;
    private String place;

    protected RacingCar() {
    }

    public RacingCar(int lane) {
        this.lane = lane;
        this.place = "";
    }

    @Override
    public void axel(int power) {
        if (isEnough(power)) {
            place += "-";
        }
    }

    private boolean isEnough(int power) {
        return NEED_POWER <= power;
    }
}
