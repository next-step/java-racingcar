package step3.domain;

public class RacingCarLocation {
    private final RacingCar car;
    private Integer location;

    public RacingCarLocation(final RacingCar car, final Integer location) {
        this.car = car;
        this.location = location;
    }
    
    public RacingCarLocation clone() {
        return new RacingCarLocation(car, location);
    }

    public RacingCar getCar() {
        return car;
    }

    public Integer getLocation() {
        return location;
    }
    
    public void move(final int unitOfForward) {
        this.location += unitOfForward;
    }
}
